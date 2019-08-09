package com.self.entertainment.lucene;

import org.apache.commons.io.FileUtils;
import org.apache.lucene.analysis.Analyzer;
import org.apache.lucene.index.IndexWriter;
import org.apache.lucene.index.IndexWriterConfig;
import org.apache.lucene.store.Directory;
import org.apache.lucene.store.FSDirectory;
import org.junit.Test;

import java.io.File;
import java.io.IOException;
import java.nio.file.Paths;
import java.util.Collection;

/**
 * @author AmazingZ
 * @date 2019/8/9 14:15
 */
public class LuceneFirst {
    @Test
    public void createIndex() throws IOException {

        Directory directory = FSDirectory.open(Paths.get("E:\\lucene"));
        Analyzer analyzer=null;
        IndexWriter indexWriter=new IndexWriter(directory,new IndexWriterConfig());
        Collection<File> files = FileUtils.listFiles(new File("F:\\新架构各种文档\\资料接口文档"), null, true);
        for (File file : files) {

        }
    }
}
