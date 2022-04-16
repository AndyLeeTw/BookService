package idv.andy.bookService.book.dataModel;

import java.sql.Date;

import javax.persistence.Entity;
import javax.persistence.Id;

import lombok.Data;

@Data
@Entity
public class Book {
    @Id
    private String isbn;
    private String name;
    private String author;
    private String translator;
    private String publisher;
    private Date publishDate;
    private String price;
}
