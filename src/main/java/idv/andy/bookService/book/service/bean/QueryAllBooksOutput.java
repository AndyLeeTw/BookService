package idv.andy.bookService.book.service.bean;

import java.util.List;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class QueryAllBooksOutput extends CommonOutput {
    private List<BookBo> bookBos;
}
