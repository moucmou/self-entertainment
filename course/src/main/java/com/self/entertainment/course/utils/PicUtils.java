package com.self.entertainment.course.utils;

import lombok.extern.slf4j.Slf4j;
import org.apache.commons.io.FileUtils;
import org.apache.commons.io.IOUtils;

import javax.servlet.ServletOutputStream;
import javax.servlet.http.HttpServletResponse;
import java.io.*;
import java.nio.charset.Charset;

@Slf4j
public class PicUtils {
    private PicUtils() {
    }

    public static void getPic(String picId, HttpServletResponse httpServletResponse) {
        File file = new File(TempFile.getInstance().getFile(), picId);
        try (
                FileInputStream fileInputStream = FileUtils.openInputStream(file);
                ServletOutputStream servletOutputStream = httpServletResponse.getOutputStream();
        ) {
            IOUtils.copy(fileInputStream, servletOutputStream);
        } catch (IOException e) {
            log.error("获取图片流失败", e);
        }
    }

    public static void deletePic(String picId) {
        File file = new File(TempFile.getInstance().getFile(), picId);
        FileUtils.deleteQuietly(file);
    }

    public static final String NOTE = "note";

    public static void addNote(String notice) {
        File file = new File(TempFile.getInstance().getFile(), NOTE);
        try {
            FileUtils.write(file, notice, Charset.forName("UTF-8"), false);
        } catch (IOException e) {
            log.error("存公告失败", e);
        }
    }

    public static String readNote( ) {
        File file = new File(TempFile.getInstance().getFile(), NOTE);
        String temp = null;
        try {
            temp= FileUtils.readFileToString(file, Charset.forName("UTF-8"));
        } catch (IOException e) {
            log.error("存公告失败", e);
        }
        return temp;
    }
}
