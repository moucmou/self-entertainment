package com.self.entertainment.course.dao;

import com.self.entertainment.course.dao.entity.Test;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

/**
 * @author AmazingZ
 * @date 2019/7/3 9:59
 */
public interface TestRepository extends JpaRepository<Test, Long> {
}
