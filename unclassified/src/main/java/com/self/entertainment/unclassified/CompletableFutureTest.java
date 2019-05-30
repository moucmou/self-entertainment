package com.self.entertainment.unclassified;

import lombok.extern.slf4j.Slf4j;
import org.apache.commons.io.IOUtils;

import java.io.*;
import java.nio.charset.Charset;
import java.util.HashMap;
import java.util.Map;
import java.util.SortedMap;
import java.util.concurrent.CompletableFuture;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.function.BiConsumer;
import java.util.function.Function;
import java.util.function.Supplier;

/**
 * @author AmazingZ
 * @date 2019/5/29 13:52
 */
@Slf4j
public class CompletableFutureTest {

    public static void main(String[] args) throws IOException {

        SortedMap<String,Charset>  map=Charset.availableCharsets() ;
        log.error("");
        FileWriter fileWriter=new FileWriter("");
        ExecutorService executorService = Executors.newFixedThreadPool(4);
        CompletableFuture<String> futureA = CompletableFuture.supplyAsync(() -> {
            try {
                Thread.sleep(5000);
            } catch (InterruptedException e) {
                log.info("", e);
            }
            return "hello";
        }, executorService);

        CompletableFuture<String> futureB = CompletableFuture.supplyAsync(() -> "任务B"
                , executorService);
        futureB.whenComplete((s, throwable) -> log.info(s));
        futureA.thenApply((Function<String, String>) s -> {
            log.info(s+"fuck");
            return null;
        });

        log.info("i'm done");
    }
}
