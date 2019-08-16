package com.self.entertainment.lucene;

import lombok.extern.slf4j.Slf4j;
import org.apache.commons.io.FileUtils;
import org.apache.lucene.analysis.Analyzer;
import org.apache.lucene.analysis.standard.StandardAnalyzer;
import org.apache.lucene.document.Document;
import org.apache.lucene.document.Field;
import org.apache.lucene.document.StringField;
import org.apache.lucene.document.TextField;
import org.apache.lucene.index.*;
import org.apache.lucene.queryparser.classic.ParseException;
import org.apache.lucene.queryparser.classic.QueryParser;
import org.apache.lucene.search.*;
import org.apache.lucene.store.Directory;
import org.apache.lucene.store.FSDirectory;
import org.junit.Test;

import java.io.File;
import java.io.IOException;
import java.nio.file.Paths;
import java.util.Arrays;
import java.util.Collection;

/**
 * @author AmazingZ
 * @date 2019/8/9 14:15
 */
public class LuceneFirst {
    @Test
    public void createIndex() throws IOException {
        /**
         * 1.指定索引写入的文件目录
         */
        Directory directory = FSDirectory.open(Paths.get("E:\\lucene"));
        IndexWriter indexWriter=new IndexWriter(directory,new IndexWriterConfig());
//        Collection<File> files = FileUtils.listFiles(new File("F:\\新架构各种文档\\资料接口文档"), null, true);
//        for (File file : files) {
//
//        }
        /**
         * 2.创建文档
         */
        Document document=new Document();
        document.add(new StringField("id","1", Field.Store.YES));
        document.add(new StringField("title","nmsl", Field.Store.YES));
        document.add(new TextField("content","Apache ActiveMQ™ is the most popular open source, multi-protocol, " +

                ".Net, and more is available. Integrate your multi-platform applications using the ubiquitous AMQP " +
                "protocol. Exchange messages between your web applications using STOMP over websockets. Manage your IoT" +
                " devices using MQTT. Support your existing JMS infrastructure and beyond. ActiveMQ offers the power" +
                " and flexibility to support any messaging use-case.", Field.Store.YES));

        Document document1=new Document();
        document.add(new StringField("id","2", Field.Store.YES));
        document.add(new StringField("title","dcqs", Field.Store.YES));
        document.add(new TextField("content","The lucene-VERSION.zip or .tar.gz (where VERSION is applications the version number of the release, e.g. 3.0.1) file contains the lucene-core jar file, html documentation, a demo application (see the \"Getting Started\" section) and various jar files containing contributed code. The lucene-VERSION-src.zip or .tar.gz contains the full source code for that version.", Field.Store.YES));

        indexWriter.addDocuments(Arrays.asList(document,document1));
        /**
         * 自动根据分词创建索引
         */
        indexWriter.commit();
        indexWriter.close();
        System.out.println();
    }

    @Test
    public void searchIndex() throws IOException, ParseException {
        /**
         * 1.打开索引目录创建索引reader
         */
        Directory directory=FSDirectory.open(Paths.get("E:\\lucene"));
        IndexReader indexReader= DirectoryReader.open(directory);
        /**
         * 2.根据索引创建索引搜索器
         */
        IndexSearcher indexSearcher=new IndexSearcher(indexReader);
        /**
         * 3.创建查询解析器 ，即构建查询条件
         * @see org.apache.lucene.queryparser.classic.MultiFieldQueryParser  根据多个字段查询
         */
        QueryParser parser=new QueryParser("content",new StandardAnalyzer());
        Query query=parser.parse("applications");
        /**
         * 创建模糊查询，允许用户输出出错, term译为词条
         */
        Query query1=new FuzzyQuery(new Term("content","applicbtions"),0);
        /**
         * 4. 根据结果返回分页,根据需要过滤
         */
        TopDocs topDocs=indexSearcher.search(query1,10);
        for(ScoreDoc scoreDoc:topDocs.scoreDocs){
            int docId=scoreDoc.doc;
            Document doc=indexReader.document(docId);

        }

    }
}
