package idv.andy.bookService.book.service.impl;

import java.util.stream.Collectors;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import idv.andy.bookService.book.dao.IBookDao;
import idv.andy.bookService.book.service.IBookService;
import idv.andy.bookService.book.service.bean.QueryAllBooksOutput;
import idv.andy.bookService.book.service.mapper.BookMapper;

@Service
public class BookServiceImpl implements IBookService {
    @Resource
    private IBookDao bookDao;
    @Resource
    private BookMapper bookMapper;
    
    /**
     * @see idv.andy.bookService.book.service.IBookService#queryAllBooks()
     */
    @Override
    public QueryAllBooksOutput queryAllBooks() {
        QueryAllBooksOutput output = new QueryAllBooksOutput();
        
        try {
            var bookBos = bookDao.findAll()
                                 .stream()
                                 .map(bookMapper::bookToBookBo)
                                 .collect(Collectors.toList());
            
            output.setBookBos(bookBos);
            output.setSuccess(true);
        } catch (Exception e) {
            output.setMessage(e.getMessage());
        }
        
        return output;
    }
}
