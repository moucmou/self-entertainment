package com.self.entertainment.unclassified;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.io.File;
import java.io.IOException;
import java.nio.ByteBuffer;
import java.nio.channels.FileChannel;
import java.nio.charset.StandardCharsets;
import java.nio.file.Path;
import java.nio.file.Paths;
/**
 * @author AmazingZ
 * @date 2019/5/21 16:30
 */
public class JavaNioTest {
    private static final Logger logger= LoggerFactory.getLogger(JavaNioTest.class);
    public static void main(String[] args) throws IOException {
        try( FileChannel fileChannel=FileChannel.open(Paths.get("C:\\Users\\zhutao14\\Desktop\\springboot-shiro笔记.txt"));){
            ByteBuffer byteBuffer=ByteBuffer.allocate(1024);
            while (fileChannel.read(byteBuffer)!=-1){
                fileChannel.read(byteBuffer);
                System.out.println(byteBuffer.toString());
                byteBuffer.flip();
                System.out.println(byteBuffer.toString());
                System.out.println(new String(byteBuffer.array()));
            }
        }catch (Exception e){
            logger.error("打开文件失败",e);
        }

    }
}
