package com.self.entertainment.unclassified;

import org.apache.commons.io.FileUtils;
import org.apache.commons.io.IOUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.lang.reflect.Proxy;
import java.nio.ByteBuffer;
import java.nio.channels.FileChannel;
import java.nio.file.Paths;
import java.nio.file.StandardOpenOption;

/**
 * @author AmazingZ
 * @date 2019/5/21 16:30
 */
public class JavaNioTest {
    private static final Logger logger = LoggerFactory.getLogger(JavaNioTest.class);

    public static void main(String[] args) throws IOException {

        try (FileChannel fileChannel = FileChannel.open(Paths.get("C:\\Users\\zhutao14\\Desktop\\springboot-shiro笔记.txt"));
             FileChannel dst = FileChannel.open(Paths.get("C:\\Users\\zhutao14\\Desktop\\socket\\sourceDst.txt"), StandardOpenOption.APPEND);
//             FileOutputStream fileOutputStream= FileUtils.openOutputStream(new File("C:\\Users\\zhutao14\\Desktop\\socket\\sourceDst.txt"),true);
//             FileChannel dst = fileOutputStream.getChannel();
        ) {
            ByteBuffer byteBuffer = ByteBuffer.allocate(1024);
            while (fileChannel.read(byteBuffer) > 0) {
                fileChannel.read(byteBuffer);
                byteBuffer.flip();
                dst.write(byteBuffer);
            }
        } catch (Exception e) {
            logger.error("打开文件失败", e);
        }

    }
}
