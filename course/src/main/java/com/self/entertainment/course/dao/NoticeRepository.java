package com.self.entertainment.course.dao;

import com.self.entertainment.course.dao.entity.Notice;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;

/**
 * @author AmazingZ
 * @date 2019/6/3 21:59
 */
public interface NoticeRepository extends JpaRepository<Notice, Long>, JpaSpecificationExecutor<Notice> {
}
