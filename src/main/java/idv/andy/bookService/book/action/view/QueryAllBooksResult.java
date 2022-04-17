package idv.andy.bookService.book.action.view;

import java.util.List;

import lombok.Getter;
import lombok.Setter;

@Setter
@Getter
public class QueryAllBooksResult extends CommonResult {
    private List<BookView> books;
}
