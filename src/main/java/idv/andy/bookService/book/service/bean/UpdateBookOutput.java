package idv.andy.bookService.book.service.bean;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class UpdateBookOutput extends CommonOutput {
    private BookBo bookBo;
}
