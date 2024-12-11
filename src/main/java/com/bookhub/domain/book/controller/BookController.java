package com.bookhub.domain.book.controller;

import com.bookhub.domain.book.dto.SearchBookRequestDto;
import com.bookhub.domain.book.service.BookService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequiredArgsConstructor
@RequestMapping("/books")
public class BookController {

    private final BookService bookService;

    @GetMapping("/search")
    public void searchBook(@ModelAttribute SearchBookRequestDto requestDto) {
        bookService.searchBook(requestDto);
    }
}
