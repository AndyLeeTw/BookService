package idv.andy.bookService.book.action;

import javax.annotation.Resource;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import idv.andy.bookService.book.action.view.QueryAllBooksResult;
import idv.andy.bookService.book.service.IBookService;
import idv.andy.bookService.book.service.bean.QueryAllBooksOutput;

@RestController
public class BookController {
    @Resource
    private IBookService bookService;
    
    @GetMapping("/books")
    public ResponseEntity<QueryAllBooksResult> queryAllBooks() {
        QueryAllBooksResult result = new QueryAllBooksResult();
        boolean goNext = true;
        
        QueryAllBooksOutput queryAllBooksOutput = bookService.queryAllBooks();
        if (queryAllBooksOutput.isSuccess()) {
            result.setBooks(queryAllBooksOutput.getBookBos());
        } else {
            goNext = false;
            result.setMessage(queryAllBooksOutput.getMessage());
        }
        
        ResponseEntity<QueryAllBooksResult> responseEntity = null;
        if (goNext) {
            responseEntity = new ResponseEntity<QueryAllBooksResult>(result, HttpStatus.OK);
        } else {
            responseEntity = new ResponseEntity<QueryAllBooksResult>(result, HttpStatus.INTERNAL_SERVER_ERROR);
        }
        
        return responseEntity;
    }
}
