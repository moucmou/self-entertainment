package com.self.entertainment.elasticsearch;

import com.self.entertainment.entity.Library;
import org.elasticsearch.index.query.QueryBuilder;
import org.elasticsearch.index.query.QueryStringQueryBuilder;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * @author AmazingZ
 * @date 2019/8/27 20:17
 */

@RunWith(SpringRunner.class)
@SpringBootTest
public class LibraryRepositoryTest {

    @Autowired
    LibraryRepository libraryRepository;




    @Test
    public void testInsert() {
        Library library = new Library();
        library.setBook_id(213123);
        libraryRepository.save(library);
        System.out.println();
//        libraryRepository.search()

    }
}