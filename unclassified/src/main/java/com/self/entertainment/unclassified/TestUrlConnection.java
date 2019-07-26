package com.self.entertainment.unclassified;

import org.apache.commons.io.IOUtils;

import javax.imageio.ImageIO;
import java.awt.image.BufferedImage;
import java.io.IOException;
import java.io.InputStream;
import java.net.MalformedURLException;
import java.net.URL;
import java.nio.charset.StandardCharsets;

/**
 * @author AmazingZ
 * @date 2019/7/13 13:37
 */
public class TestUrlConnection {

    public static void main(String[] args) {

//        URL url = null;
//        try {
////            url = new URL("http://10.33.29.154:9521/storageServices/v1/datas/5FA687C3-72A0-4906-9A2E-ADEF0D1E6F1D?noJson&token=d070bcfed393512563hRZIHrYS2yEDW59GRsf8uqBUDFtAFYpt24ATGi2b0W6xpS265qcMeXzuK8ncX88Sk=&componentId=PIC&serviceType=PICwebapp");
////            InputStream in = url.openStream();
////            byte[] bytes = new byte[154];
//            BufferedImage bu = ImageIO.read(new URL("https://blog.csdn.net/Cricket_7/article/details/89496896"));
////            IOUtils.read(in, bytes);
////            String x = new String(bytes, StandardCharsets.UTF_8);
//
//            System.out.println();
//        } catch (MalformedURLException e) {
//            e.printStackTrace();
//        } catch (IOException e) {
//            e.printStackTrace();
//        }
//        System.out.println();
        Thread thread = new Thread(() -> {
            while (!Thread.currentThread().isInterrupted()) {
//                try {
//                    Thread.sleep(2000);
//                } catch (InterruptedException e) {
//                    e.printStackTrace();
//                }
                System.out.println("hello");
            }
        });
        thread.start();
        try {
            Thread.sleep(1000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        thread.interrupt();

    }
}
