package io.project.app.news.repositories;

import io.project.app.news.domain.News;
import org.springframework.data.mongodb.repository.ReactiveMongoRepository;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;
import reactor.core.publisher.Flux;

/**
 *
 * @author armena
 */
@Component
@Repository
@Transactional
public interface NewsRepository extends ReactiveMongoRepository<News, String> {

    Flux<News> findTop10ByOrderByIdDesc();
}
