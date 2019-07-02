package com.self.entertainment.rediscache;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cache.annotation.EnableCaching;
import org.springframework.cloud.client.circuitbreaker.EnableCircuitBreaker;
import org.springframework.cloud.netflix.hystrix.EnableHystrix;
import org.springframework.data.redis.core.*;

import java.util.*;
import java.util.concurrent.TimeUnit;

@SpringBootApplication
@EnableCircuitBreaker
@EnableCaching
public class RedisCacheApplication implements CommandLineRunner {
    public static void main(String[] args) {
        SpringApplication.run(RedisCacheApplication.class, args);
    }

    @Autowired
    RedisTemplate<String, Object> redisTemplate;

    @Override
    public void run(String... args) throws Exception {
//        redisTemplate.opsForHash().put("IpAndPort", "asw-asw", "");
//        for (Object set : redisTemplate.opsForHash().keys("IpAndPort")) {
//            redisTemplate.opsForHash().get("IpAndPort", set);
//        }
//        redisTemplate.opsForHash().put("IpAndPort", "asw-asw", new SvrResultDTO("ctm01ca", "1.0.0", "ctm01ca", "123456"));
//        redisTemplate.opsForHash().put("IpAndPort", "spfd-spfd", new User());
//        redisTemplate.opsForHash().delete("IpAndPort", "spfd-spfd");
//        Map<String, String> map = new HashMap<>();
//        map.put("123123", "123123");
//        Map<String, String> map1 = new HashMap<>();
//        map1.put("123123", "123123");
//        redisTemplate.opsForHash().put("Device", "eventSource", map);
//        redisTemplate.opsForHash().put("Device", "ExternalCode", map1);
//        redisTemplate.expire("IpAndPort", 1, TimeUnit.DAYS);
//        redisTemplate.delete("Device");
//
//
////    (;
//        SvrResultDTO svrResultDTO = (SvrResultDTO) redisTemplate.opsForHash().get("IpAndPort", "asw-asw");
//        User suer = (User) redisTemplate.opsForHash().get("IpAndPort", "spfd-spfd");
//
//        redisTemplate.opsForHash().put("Device", "camera", new HashMap<>());
//        System.out.println();
    }

    private void string() {
        //保存Strkey，注意设置过期时间
        redisTemplate.opsForValue().set("Strkey", "abc",1, TimeUnit.HOURS);
        //批量保存，每个key都要单独设置过期时间
        Map<String, String> maps = new HashMap<>();
        maps.put("Strkey1", "StrValue1");
        maps.put("Strkey2", "StrValue2");
        maps.put("Strkey3", "StrValue3");
        redisTemplate.opsForValue().multiSet(maps);
        redisTemplate.expire("Strkey1", 60, TimeUnit.SECONDS);
        redisTemplate.expire("Strkey2", 60, TimeUnit.SECONDS);
        redisTemplate.expire("Strkey3", 60, TimeUnit.SECONDS);
        //查询
        String Strkey = (String) redisTemplate.opsForValue().get("Strkey");
        System.out.println(Strkey);
        //批量查询
        List<String> strlist = new ArrayList<>();
        strlist.add("Strkey1");
        strlist.add("Strkey2");
        strlist.add("Strkey3");
        List result = redisTemplate.opsForValue().multiGet(strlist);
        System.out.println(result);
        //删除
        redisTemplate.delete("Strkey");

    }
    private void list(){
        //模拟list数据
        List<String> list = new ArrayList<>();
        list.add("listvalue1");
        list.add("listvalue2");
        list.add("listvalue3");
        //保存
        redisTemplate.delete("listkey");//清空
        redisTemplate.opsForList().leftPushAll("listkey",list);//按list顺序依次左插入
        redisTemplate.expire("listkey", 1, TimeUnit.HOURS);
        //绑定对象,多次操作时推荐
        BoundListOperations<String,Object> ops=redisTemplate.boundListOps("listkey");
        //插入元素
        ops.leftPush("listvalue4");//返回列表长度 4 3 2 1
        ops.rightPush("listvalue5");//4 3 2 1 5
        ops.leftPushAll("listvalue6", "listvalue7");
        ops.rightPushAll("listvalue8", "listvalue9");
        //截取下标区间
        List range = ops.range(0, -1);//负数表示截取整个队列7 6 4 3 2 1 5 8 9
        ops.range(0, ops.size() - 2);//截取并不删除原数据
        //删除指定value  l>0,从头到尾第一个匹配项,l<0相反,l=0删除所有匹配项
        ops.remove(1, "listvalue1");
        //左删除、右删除
        ops.leftPop();
        ops.rightPop();
        //完成操作以后更新过期时间
        ops.expire(1, TimeUnit.HOURS);

    }

    private void hash(){
        //模拟需要存入redis的hash数据
        Map<String, Object> hash = new HashMap<>();
        hash.put("field1", "value1");
        hash.put("field2", "value2");
        //批量保存
        redisTemplate.delete("hashKey");
        redisTemplate.opsForHash().putAll("hashKey",hash);
        redisTemplate.expire("hashKey", 1, TimeUnit.HOURS);//过期时间
        //对已经保存的hash单独插入key
        redisTemplate.opsForHash().put("hashKey", "field3", "value3");

        //为多个键分别取出它们的值
        List<Object> keys = new ArrayList<>();
        keys.add("field2");
        keys.add("field3");
        List hashValue = redisTemplate.opsForHash().multiGet("hashKey", keys);
        System.out.println(hashValue);
        //查询简单数据
        Map<Object, Object> hashFromRedis = redisTemplate.opsForHash().entries("hashKey");

        //绑定key
        BoundHashOperations<String,String,Object> ops = redisTemplate.boundHashOps("hashKey");
        //获取hash所有key
        ops.keys();
        //增删hash数据
        ops.delete("field1", "field2");
        ops.put("field4", "value4");
        Map entries = ops.entries();

        //scan  游标cursor实现迭代
        String pattern = "*";//匹配规则
        Long count= 100l;
        Cursor cursor = redisTemplate.opsForHash().scan("hashKey", ScanOptions.scanOptions().match(pattern).count(count).build());
        while(cursor.hasNext()){
            Map.Entry<Object, Object> entry = (Map.Entry<Object, Object>) cursor.next();
            System.out.println(entry.getKey()+":"+entry.getValue());
            //实际操作...
        }

    }

    private void set(){
        //清空原始数据
        redisTemplate.delete("setKey");
        redisTemplate.delete("setKey1");
        //模拟set数据
        String[] setKey = new String[]{"setvalue1","setvalue2"};
        //插入
        redisTemplate.opsForSet().add("setKey",setKey);
        redisTemplate.expire("setKey",1,TimeUnit.HOURS);
        redisTemplate.opsForSet().add("setKey1",Arrays.asList("setvalue1","setvalue2","setvalue3"));
        redisTemplate.expire("setKey1",1,TimeUnit.HOURS);

        //绑定
        BoundSetOperations ops = redisTemplate.boundSetOps("setKey");
        Set members = ops.members();
        System.out.println(members);
        //插入一个或多个
        ops.add("setvalue3", "setvalue4","setvalue5");
        System.out.println(ops.members());
        //删除一个或多个
        ops.remove("setvalue5","setvalue4");
        System.out.println(ops.members());
        //删除随机一个
        Object pop = ops.pop();
        System.out.println("pop的值："+pop);
        //scan  游标cursor实现迭代
        String pattern = "*";//匹配规则
        Long count= 100l;
        Cursor cursor = ops.scan(ScanOptions.scanOptions().match(pattern).count(count).build());
        while(cursor.hasNext()){
            String s= (String) cursor.next();
            System.out.println(s);
            //实际操作...
        }
        //与其他set求交集(一个或多个)
        members=ops.intersect("setKey1");
        System.out.println(members);
        ops.intersect(Arrays.asList("setKey1", "setKey2"));
        ops.intersectAndStore("setKey1","destSet");//保存交集
        ops.intersectAndStore(Arrays.asList("setKey1", "setKey2"),"destSet");
        //求并集
        ops.union("setKey1");
        //求差集
        ops.diff("setKey1");

    }



    public static class User {
        private String componentId;

        public String getComponentId() {
            return componentId;
        }

        public void setComponentId(String componentId) {
            this.componentId = componentId;
        }
    }

    public static class SvrResultDTO {

        private String componentId;
        private String componentVersion;
        private String serviceType;
        private String serviceNodeCode;

        public SvrResultDTO(String componentId, String componentVersion, String serviceType, String serviceNodeCode) {
            this.componentId = componentId;
            this.componentVersion = componentVersion;
            this.serviceType = serviceType;
            this.serviceNodeCode = serviceNodeCode;
        }

        public SvrResultDTO() {
        }

        public String getComponentId() {
            return componentId;
        }

        public void setComponentId(String componentId) {
            this.componentId = componentId;
        }

        public String getComponentVersion() {
            return componentVersion;
        }

        public void setComponentVersion(String componentVersion) {
            this.componentVersion = componentVersion;
        }

        public String getServiceType() {
            return serviceType;
        }

        public void setServiceType(String serviceType) {
            this.serviceType = serviceType;
        }

        public String getServiceNodeCode() {
            return serviceNodeCode;
        }

        public void setServiceNodeCode(String serviceNodeCode) {
            this.serviceNodeCode = serviceNodeCode;
        }

    }
}
