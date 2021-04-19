package br.com.tengan.bookpublisher.endpoint.controller;

import br.com.tengan.bookpublisher.domain.model.Book;
import lombok.RequiredArgsConstructor;
import org.springframework.messaging.MessageChannel;
import org.springframework.messaging.support.MessageBuilder;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/book")
@RequiredArgsConstructor
public class BookController {

    private final MessageChannel output;

    @PostMapping("/publish")
    public Book publishAndSaveEvent(@RequestBody Book book) {
        output.send(MessageBuilder.withPayload(book).build());

        return book;
    }
}
