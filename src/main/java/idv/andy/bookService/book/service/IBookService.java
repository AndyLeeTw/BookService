package idv.andy.bookService.book.service;

import idv.andy.bookService.book.service.bean.AddBookInput;
import idv.andy.bookService.book.service.bean.AddBookOutput;
import idv.andy.bookService.book.service.bean.QueryAllBooksOutput;

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
}
