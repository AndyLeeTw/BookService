package idv.andy.bookService.book.action.view;

import java.util.Date;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class BookInputBean {
    private String name;
    private String author;
    private String translator;
    private String publisher;
    private Date publishDate;
    private Double price;
}
