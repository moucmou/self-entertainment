package com.self.entertainment.course.common;

import java.io.File;
import java.util.Objects;

/**
 * @author AmazingZ
 * @date 2019/1/28 13:55
 */
public class TempFile {


    private File file;

    private TempFile() {
        ClassLoader loader = TempFile.class.getClassLoader();
        if (loader != null && null != loader.getResource("")) {
            String path = (Objects.requireNonNull(loader.getResource("")).getFile()).substring(1);
            File fileTemp = new File(path).getParentFile();
            file = new File(fileTemp, "temp/");
            if (file.exists() && file.canExecute()) {
                boolean result = file.delete();
            }
            boolean result = file.mkdirs();
        }
    }

    public File getFile() {
        return file;
    }

    public static TempFile getInstance() {
        return TempFileHolder.tempFile;
    }

    private static class TempFileHolder {
        private static final TempFile tempFile = new TempFile();
    }


}