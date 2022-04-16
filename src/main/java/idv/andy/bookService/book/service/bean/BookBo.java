package idv.andy.bookService.book.service.bean;

import java.util.Date;

import lombok.Data;

@Data
public class BookBo {
    private String isbn;
    private String name;
    private String author;
    private String translator;
    private String publisher;
    private Date publishDate;
    private String price;
}
