package io.project.app.news.services;

import io.project.app.news.domain.News;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;
import io.project.app.news.repositories.NewsRepository;

/**
 *
 * @author armena
 */
@Service
@Component
public class NewsService {

    private final NewsRepository newsRepository;

    public NewsService(NewsRepository newsRepository) {
        this.newsRepository = newsRepository;
    }

    public Mono<News> save(News news) {
        return newsRepository.save(news);
    }
    
    public Mono<News> findById(String id) {
        return newsRepository.findById(id);
    }

    public Flux<News> findAll() {
        return newsRepository.findAll();

    }

}
