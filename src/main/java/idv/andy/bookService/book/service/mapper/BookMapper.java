package idv.andy.bookService.book.service.mapper;

import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

import idv.andy.bookService.book.action.view.BookInputBean;
import idv.andy.bookService.book.action.view.BookView;
import idv.andy.bookService.book.dataModel.Book;
import idv.andy.bookService.book.service.bean.BookBo;
import idv.andy.bookService.mapper.common.TypeConvertWorker;

@Mapper(componentModel = "spring", uses = {TypeConvertWorker.class})
public interface BookMapper {
    @Mapping(target = "publishDate", dateFormat = "yyyy-MM-dd")
    BookView bookBoToBookView(BookBo bookBo);
    
    @Mapping(target = "name", qualifiedByName = "trim")
    @Mapping(target = "author", qualifiedByName = "trim")
    @Mapping(target = "translator", qualifiedByName = "trim")
    @Mapping(target = "publisher", qualifiedByName = "trim")
    BookBo bookInputBeanToBookBo(BookInputBean inputBean);
    
    BookBo bookToBookBo(Book book);
    
    Book bookBoToBook(BookBo bookBo);
}
