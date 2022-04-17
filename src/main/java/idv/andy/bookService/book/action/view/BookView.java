package idv.andy.bookService.book.action.view;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class BookView {
    private String isbn;
    private String name;
    private String author;
    private String translator;
    private String publisher;
    private String publishDate;
    private double price;
}
