package com.bookhub.domain.book.controller;

import com.bookhub.domain.book.dto.SearchBookRequestDto;
import com.bookhub.domain.book.service.BookService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.ModelAndView;

@RestController
@RequiredArgsConstructor
@RequestMapping("/books")
public class BookController {

    private final BookService bookService;

    @GetMapping("/search")
    public ModelAndView searchBook(@ModelAttribute SearchBookRequestDto requestDto) {
        ModelAndView mv = new ModelAndView("test");

        mv.addObject("search", bookService.searchBook(requestDto));

        return mv;
    }
}
