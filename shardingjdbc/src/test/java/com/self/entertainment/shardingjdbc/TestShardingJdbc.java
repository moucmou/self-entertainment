package com.self.entertainment.shardingjdbc;

/**
 * TestShardingJdbc  读分表分库文章有感   https://mp.weixin.qq.com/s/4S_BhPtIMikefPJLo5498Q
 * 
 * @author zhutao
 * @date 2021/5/11 4:28 下午
 */
public class TestShardingJdbc {

    /**
     * 场景 比如现在有两张逻辑表  一个表被分为12份数据  一个表被分为12份数据   如果简单按hash 取模分表分库
     * a表   table  id%12 db id%12/6  12张表被分为2个库
     * b表  table id%4 db id%4/2  4张表被分为两个库  但比如同一个id 3 会进入到 db0和db1 导致跨库 虽然分布式事务解决方案一堆 但还是怎么简单怎么来
     *     最简单的无非是 让这些路由的id落在同一个库里面  比如id为3的这条数据能都在一个库里面 就不会跨数据库了
     *      感觉有点搞，都先按 %2取余  再按12取余分表就是了
     * @param args
     */
    public static void main(String                                                                                                                                                       [] args) {

        // 要做的数据
        long shopId = 3;
        // 目标数据库
        int dbs = 2;
        // 12张表
        int tables = 12;
        // 单裤表数量
        int oneDbTables = 6;
        // 目标映射表的总表数量
        int partitionSize = 4;
        // 目标映射表的单库表数量
        int blockSize = 2;
        int sharding = (int) (shopId % tables);
// 目标分库
        int dbIndex = (int) (shopId % partitionSize % dbs);
// 目标分表
        int tableIndex = sharding % blockSize + sharding % partitionSize / blockSize * oneDbTables
                + sharding / partitionSize * blockSize;
        // 感觉有点搞  每太明白 记录一下
    }
}
