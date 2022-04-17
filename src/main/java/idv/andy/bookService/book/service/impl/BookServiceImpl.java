package idv.andy.bookService.book.service.impl;

import java.util.stream.Collectors;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import idv.andy.bookService.book.dao.IBookDao;
import idv.andy.bookService.book.service.IBookService;
import idv.andy.bookService.book.service.bean.AddBookInput;
import idv.andy.bookService.book.service.bean.AddBookOutput;
import idv.andy.bookService.book.service.bean.BookBo;
import idv.andy.bookService.book.service.bean.DeleteBookInput;
import idv.andy.bookService.book.service.bean.DeleteBookOutput;
import idv.andy.bookService.book.service.bean.QueryAllBooksOutput;
import idv.andy.bookService.book.service.bean.UpdateBookInput;
import idv.andy.bookService.book.service.bean.UpdateBookOutput;
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

    /**
     * @see idv.andy.bookService.book.service.IBookService#addBook(idv.andy.bookService.book.service.bean.AddBookInput)
     */
    @Override
    public AddBookOutput addBook(AddBookInput input) {
        AddBookOutput output = new AddBookOutput();
        
        try {
            BookBo bookBo = input.getBookBo();
            
            boolean isExist = bookDao.existsById(bookBo.getIsbn());
            if (!isExist) {
                bookDao.save(bookMapper.bookBoToBook(bookBo));
                output.setSuccess(true);
                output.setBookBo(bookBo);
            } else {
                output.setMessage("the book is exist");
            }
        } catch (Exception e) {
            output.setMessage(e.getMessage());
        }
        
        return output;
    }

    /**
     * @see idv.andy.bookService.book.service.IBookService#updateBook(idv.andy.bookService.book.service.bean.UpdateBookInput)
     */
    @Override
    public UpdateBookOutput updateBook(UpdateBookInput input) {
        UpdateBookOutput output = new UpdateBookOutput();
        
        try {
            BookBo bookBo = input.getBookBo();
            
            boolean isExist = bookDao.existsById(bookBo.getIsbn());
            output.setExist(isExist);
            if (isExist) {
                bookDao.save(bookMapper.bookBoToBook(bookBo));
                output.setSuccess(true);
                output.setBookBo(bookBo);
            } else {
                output.setMessage("the book is not exist");
            }
        } catch (Exception e) {
            output.setMessage(e.getMessage());
        }
        
        return output;
    }

    /**
     * @see idv.andy.bookService.book.service.IBookService#deleteBook(idv.andy.bookService.book.service.bean.DeleteBookInput)
     */
    @Override
    public DeleteBookOutput deleteBook(DeleteBookInput input) {
        DeleteBookOutput output = new DeleteBookOutput();
        
        try {
            String isbn = input.getIsbn();
            boolean isExist = bookDao.existsById(isbn);
            output.setExist(isExist);
            if (isExist) {
                bookDao.deleteById(isbn);
                output.setSuccess(true);
            } else {
                output.setMessage("the book is not exist");
            }
        } catch (Exception e) {
            output.setMessage(e.getMessage());
        }
        
        return output;
    }
}
