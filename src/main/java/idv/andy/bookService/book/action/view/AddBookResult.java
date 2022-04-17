package idv.andy.bookService.book.action.view;

import idv.andy.bookService.book.service.bean.BookBo;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class AddBookResult {
    private BookBo book;
    private String message;
}
