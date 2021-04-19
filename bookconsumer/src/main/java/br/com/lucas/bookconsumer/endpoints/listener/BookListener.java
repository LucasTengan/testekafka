package br.com.lucas.bookconsumer.endpoints.listener;

import br.com.lucas.bookconsumer.domain.model.Book;
import lombok.extern.slf4j.Slf4j;
import org.springframework.cloud.stream.annotation.StreamListener;


@Slf4j
public class BookListener {

    @StreamListener("input")
    public void consumeMessage(Book book) {
        log.info("Consume payload: " + book);
    }
}
