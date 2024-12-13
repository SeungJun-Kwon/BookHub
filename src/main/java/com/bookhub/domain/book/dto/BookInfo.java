package com.bookhub.domain.book.dto;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class BookInfo {

    private String title;
    private String link;
    private String image;
    private String author;
    private String discount;
    private String publisher;
    private String isbn;
    private String description;

    @Override
    public String toString() {
        return
            "[title=" + title
            + "\nlink=" + link
            + "\nimage=" + image
            + "\nauthor=" + author
            + "\ndiscount=" + discount
            + "\npublisher=" + publisher
            + "\nisbn=" + isbn
            + "\ndescription=" + description
            + "]";
    }
}
