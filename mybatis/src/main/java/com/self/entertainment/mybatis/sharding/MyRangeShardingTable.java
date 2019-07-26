package com.self.entertainment.mybatis.sharding;

import com.google.common.collect.Range;
import io.shardingsphere.api.algorithm.sharding.PreciseShardingValue;
import io.shardingsphere.api.algorithm.sharding.RangeShardingValue;
import io.shardingsphere.api.algorithm.sharding.standard.PreciseShardingAlgorithm;
import io.shardingsphere.api.algorithm.sharding.standard.RangeShardingAlgorithm;
import io.shardingsphere.core.routing.strategy.ShardingStrategy;
import lombok.extern.slf4j.Slf4j;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.*;

/**
 * @author AmazingZ
 * @date 2019/7/26 14:31
 */

/**
 * @see ShardingStrategy
 * 接口实现各种扩展
 */
@Slf4j
public class MyRangeShardingTable implements RangeShardingAlgorithm, PreciseShardingAlgorithm {
    /**
     * 重写between and 分片规则
     *
     * @param availableTargetNames
     * @param shardingValue
     * @return
     */
    @SuppressWarnings("unchecked")
    @Override
    public Collection<String> doSharding(Collection availableTargetNames, RangeShardingValue shardingValue) {
        Set<String> set = new HashSet<>();
        Range<?> range = shardingValue.getValueRange();
        String startTime = range.lowerEndpoint().toString();
        String endTime = range.upperEndpoint().toString();
        Iterator<String> iterator = availableTargetNames.iterator();
        Map<String, String> map = new HashMap<>();
        while (iterator.hasNext()) {
            String tableName = iterator.next();
            map.putIfAbsent(tableName.substring(tableName.lastIndexOf("_") + 1), tableName);
        }
        LocalDateTime start = LocalDateTime.parse(startTime, DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss.SSS"));
        LocalDateTime end = LocalDateTime.parse(endTime, DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss.SSS"));
        List<String> monthList = new ArrayList<>();

        for (LocalDate i = start.toLocalDate(); i.isBefore(end.toLocalDate()) || i.equals(end.toLocalDate()); i = i.plusMonths(1)) {
            monthList.add(i.format(DateTimeFormatter.ofPattern("yyyyMMdd")).substring(0, 6));
        }
        for (Map.Entry<String, String> entry : map.entrySet()) {
            for (String month : monthList) {
                if (month.equals(entry.getKey())) {
                    set.add(entry.getValue());
                }
            }
        }
        return set;
    }

    @Override
    public String doSharding(Collection availableTargetNames, PreciseShardingValue shardingValue) {
        return null;
    }
}
