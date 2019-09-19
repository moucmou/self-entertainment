package com.self.entertainment.elasticsearch;

import com.self.entertainment.entity.Library;
import org.springframework.data.elasticsearch.repository.ElasticsearchRepository;

/**
 * @author AmazingZ
 * @date 2019/8/27 20:16
 */
public interface LibraryRepository extends ElasticsearchRepository<Library, Long> {
}
