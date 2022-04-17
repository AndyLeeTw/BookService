package idv.andy.bookService.book.action.view;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class UpdateBookResult {
    private BookView book;
    private String message;
}
