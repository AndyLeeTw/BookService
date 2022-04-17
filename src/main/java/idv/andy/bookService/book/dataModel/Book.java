package idv.andy.bookService.book.dataModel;

import java.sql.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Entity
public class Book {
    @Id
    private String isbn;
    @Column(nullable = false)
    private String name;
    @Column(nullable = false)
    private String author;
    private String translator;
    @Column(nullable = false)
    private String publisher;
    @Column(nullable = false)
    private Date publishDate;
    @Column(nullable = false)
    private Double price;
}
