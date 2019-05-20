package com.self.entertainment.unclassified;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.core.JsonParseException;
import com.fasterxml.jackson.databind.JsonMappingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.apache.commons.collections4.CollectionUtils;
import org.apache.curator.RetryPolicy;
import org.apache.curator.framework.CuratorFramework;
import org.apache.curator.framework.CuratorFrameworkFactory;
import org.apache.curator.retry.ExponentialBackoffRetry;

import java.io.IOException;
import java.io.Serializable;
import java.nio.charset.StandardCharsets;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;

/**
 * @author AmazingZ
 * @date 2019/5/16 18:10
 */
public class KafkaTest {

    public static void main(String[] args)  {
        RetryPolicy retryPolicy = new ExponentialBackoffRetry(1000, 3);
       try(CuratorFramework client =
                   CuratorFrameworkFactory.builder()
                           .connectString("10.20.84.150:2181")
                           .sessionTimeoutMs(5000)
                           .connectionTimeoutMs(5000)
                           .retryPolicy(retryPolicy)
                           .build()){

           client.start();
           ;
           ObjectMapper objectMapper=new ObjectMapper();
           Test test= objectMapper.readValue(new String(client.getData().forPath("/brokers/ids/0"), StandardCharsets.UTF_8) ,Test.class);
       } catch (Exception e) {
           e.printStackTrace();
       }
        ;


//        System.out.println(getNode(client, "/"));

    }
    @JsonIgnoreProperties(ignoreUnknown = true)
    public static class Test implements Serializable {
        private static final long serialVersionUID = 4800242250194288475L;
        private Integer port;

        public Integer getPort() {
            return port;
        }

        public void setPort(Integer port) {
            this.port = port;
        }
    }
    public static List<String> res = new ArrayList<>();

    public static List<String> getNode(CuratorFramework client, String parentNode) throws Exception {
            List<String> tmpList = client.getChildren().forPath(parentNode);
            for (String tmp : tmpList) {
                String childNode = parentNode.equals("/") ? parentNode + tmp : parentNode + "/" + tmp;
                res.add(childNode);
                getNode(client, childNode);
            }
            return res;
    }


}
