package idv.andy.bookService.book.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import idv.andy.bookService.book.dataModel.Book;

@Repository
public interface IBookDao extends JpaRepository<Book, String> {

}
