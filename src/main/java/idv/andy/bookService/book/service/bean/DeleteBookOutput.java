package idv.andy.bookService.book.service.bean;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class DeleteBookOutput extends CommonOutput {
    private boolean isExist;
}
