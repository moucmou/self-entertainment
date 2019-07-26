package com.self.entertainment.mybatis.sharding;

import io.shardingsphere.api.algorithm.sharding.ListShardingValue;
import io.shardingsphere.api.algorithm.sharding.ShardingValue;
import io.shardingsphere.api.algorithm.sharding.complex.ComplexKeysShardingAlgorithm;
import lombok.extern.slf4j.Slf4j;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.Collection;
import java.util.LinkedList;

/**
 * @author AmazingZ
 * @date 2019/7/25 20:41
 */
@Slf4j
public class MyComplexShardingTable implements ComplexKeysShardingAlgorithm {

    @Override
    public Collection<String> doSharding(Collection<String> availableTargetNames, Collection<ShardingValue> shardingValues) {
        Collection<String> collection = new ArrayList<>();
        ShardingValue shardingValue = shardingValues.iterator().next();
        LocalDateTime index = (LocalDateTime) ((LinkedList) ((ListShardingValue) shardingValue).getValues()).get(0);
        for (String availableTargetName : availableTargetNames) {
            String name = index.format(DateTimeFormatter.ofPattern("yyyyMM"));
            if (availableTargetName.endsWith("_" + name)) {
                collection.add(availableTargetName);
                break;
            }
        }
        return collection;
    }
}
