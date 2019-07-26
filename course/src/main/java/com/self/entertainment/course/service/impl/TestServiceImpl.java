package com.self.entertainment.course.service.impl;

import com.self.entertainment.course.dao.TestRepository;
import com.self.entertainment.course.dao.entity.Test;
import com.self.entertainment.course.service.TestService;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.PlatformTransactionManager;
import org.springframework.transaction.annotation.Isolation;
import org.springframework.transaction.annotation.Transactional;

import javax.persistence.EntityManager;
import java.util.List;


/**
 * @author AmazingZ
 * @date 2019/7/3 10:18
 */
@Service
public class TestServiceImpl implements TestService {

    @Autowired
    TestRepository testRepository;
    @Autowired
    EntityManager entityManager;

    @Transactional(isolation = Isolation.READ_COMMITTED)
    @Override
    public void save() {
        List<Test> list = testRepository.findAll();
        Test test = new Test();
        test.setTest("test");
        testRepository.save(test);
        Session session = entityManager.unwrap(org.hibernate.Session.class);
        System.out.println();
        List<Test> list1 = testRepository.findAll();
//        test.setId(900L);
        System.out.println();
    }
}
