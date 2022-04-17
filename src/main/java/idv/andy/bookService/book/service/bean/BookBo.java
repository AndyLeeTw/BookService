package idv.andy.bookService.book.service.bean;

import java.util.Date;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class BookBo {
    private String isbn;
    private String name;
    private String author;
    private String translator;
    private String publisher;
    private Date publishDate;
    private double price;
}
