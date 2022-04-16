package idv.andy.bookService.book.action.view;

import java.util.List;

import idv.andy.bookService.book.service.bean.BookBo;
import lombok.Getter;
import lombok.Setter;

@Setter
@Getter
public class QueryAllBooksResult {
    private List<BookBo> books;
    private String message;
}
