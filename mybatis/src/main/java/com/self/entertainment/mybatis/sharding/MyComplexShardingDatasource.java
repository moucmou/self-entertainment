package com.self.entertainment.mybatis.sharding;

import com.alibaba.fastjson.JSON;
import com.google.common.base.Preconditions;
import com.self.entertainment.mybatis.pojo.Site;
import io.shardingsphere.api.algorithm.sharding.ListShardingValue;
import io.shardingsphere.api.algorithm.sharding.ShardingValue;
import io.shardingsphere.api.algorithm.sharding.complex.ComplexKeysShardingAlgorithm;
import lombok.extern.slf4j.Slf4j;

import java.util.Collection;
import java.util.Collections;
import java.util.LinkedList;

/**
 * @author AmazingZ
 * @date 2019/7/25 20:14
 * https://github.com/TaXueWWL/snowalker-shardingjdbc-demo/blob/master/src/main/java/com/snowalker/shardingjdbc/snowalker/demo/complex/sharding/strategy/SnoWalkerComplexShardingDB.java
 * http://wuwenliang.net/2019/03/26/%E8%B7%9F%E6%88%91%E5%AD%A6shardingjdbc%E4%B9%8B%E8%87%AA%E5%AE%9A%E4%B9%89%E5%88%86%E5%BA%93%E5%88%86%E8%A1%A8%E7%AD%96%E7%95%A5-%E5%A4%8D%E5%90%88%E5%88%86%E7%89%87%E7%AE%97%E6%B3%95%E8%87%AA%E5%AE%9A%E4%B9%89%E5%AE%9E%E7%8E%B0/
 */
@Slf4j
public class MyComplexShardingDatasource implements ComplexKeysShardingAlgorithm {

    @Override
    public Collection<String> doSharding(Collection<String> availableTargetNames, Collection<ShardingValue> shardingValues) {

        ShardingValue shardingValue = shardingValues.iterator().next();
        Preconditions.checkState(shardingValue instanceof ListShardingValue, "Inline strategy cannot support range sharding.");
        Collection<String> collection = Collections.emptyList();
        log.info("shardingValue:" + JSON.toJSONString(shardingValue));
        //根据列名获取索引规则，得到索引值
        String dateBaseName = (String) ((LinkedList) ((ListShardingValue) shardingValue).getValues()).get(0);
        Integer index = Site.getValueByname(dateBaseName);

        //循环匹配数据源
        for (String name : availableTargetNames) {
            //获取逻辑数据源索引后缀
            Integer nameSuffix = Integer.valueOf(name.substring(name.length() - 1));
            if (nameSuffix.equals(index)) {
                collection = Collections.singleton(name);
                break;
            }
        }
        return collection;
    }


}
