package com.bookhub.domain.book.dto;

import java.util.ArrayList;
import java.util.List;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
public class SearchBookResponseDto {

    private int total;
    private int start;
    private int display;
    List<BookInfo> items = new ArrayList<>();

    @Override
    public String toString() {
        StringBuilder result =
            new StringBuilder("[total=" + total
                + "\n,start=" + start
                + "\n,display=" + display
                + "\n,items=[");

        for (int i = 0; i < items.size(); i++) {
            /*
            private String title;
            private String link;
            private String image;
            private String author;
            private String discount;
            private String publisher;
            private String isbn;
            private String description;
             */
            if(i < items.size() - 1)
                result.append(items.get(i)).append(",\n");
            else
                result.append(items.get(i));
        }

        result.append("]");

        return result.toString();
    }
}
