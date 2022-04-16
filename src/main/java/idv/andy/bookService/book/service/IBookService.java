package idv.andy.bookService.book.service;

import idv.andy.bookService.book.service.bean.QueryAllBooksOutput;

public interface IBookService {
    /**
     * @Description 查出所有書籍
     *
     * @return
     */
    public QueryAllBooksOutput queryAllBooks();
}
