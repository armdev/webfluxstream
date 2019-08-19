package io.project.app.news.recources;

import io.project.app.news.domain.News;
import io.project.app.news.services.NewsService;
import java.time.Duration;

import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

@RestController
@RequestMapping("/api/v2/news")
@Slf4j
public class NewsResource {

    @Autowired
    private NewsService service;
  

    @GetMapping(produces = MediaType.TEXT_EVENT_STREAM_VALUE, value = "/news")
    @ResponseBody
    public Flux<News> stream() {
        log.info("stream called");
        return Flux.from(service.findAll()).delayElements(Duration.ofSeconds(3)).repeat();

    }

    @PostMapping(produces = MediaType.APPLICATION_JSON_VALUE, value = "/top/news")
    @ResponseBody
    public Mono<News> post(@RequestBody News news) {
        return service.save(news);
    }

}
