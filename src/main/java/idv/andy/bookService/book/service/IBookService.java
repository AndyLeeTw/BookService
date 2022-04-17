package idv.andy.bookService.book.service;

import idv.andy.bookService.book.service.bean.AddBookInput;
import idv.andy.bookService.book.service.bean.AddBookOutput;
import idv.andy.bookService.book.service.bean.DeleteBookInput;
import idv.andy.bookService.book.service.bean.DeleteBookOutput;
import idv.andy.bookService.book.service.bean.QueryAllBooksOutput;
import idv.andy.bookService.book.service.bean.UpdateBookInput;
import idv.andy.bookService.book.service.bean.UpdateBookOutput;

public interface IBookService {
    /**
     * @Description 查出所有書籍
     *
     * @return
     */
    public QueryAllBooksOutput queryAllBooks();
    
    /**
     * @Description 新增書籍
     *
     * @param input
     * @return
     */
    public AddBookOutput addBook(AddBookInput input);
    
    /**
     * @Description 更新書籍
     *
     * @param input
     * @return
     */
    public UpdateBookOutput updateBook(UpdateBookInput input);
    
    /**
     * @Description 刪除書籍
     *
     * @param input
     * @return
     */
    public DeleteBookOutput deleteBook(DeleteBookInput input);
}
