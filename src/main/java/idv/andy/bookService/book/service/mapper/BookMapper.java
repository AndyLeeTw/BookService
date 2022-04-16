package idv.andy.bookService.book.service.mapper;

import org.mapstruct.Mapper;

import idv.andy.bookService.book.dataModel.Book;
import idv.andy.bookService.book.service.bean.BookBo;

@Mapper(componentModel = "spring")
public interface BookMapper {
    BookBo bookToBookBo(Book book);
}
