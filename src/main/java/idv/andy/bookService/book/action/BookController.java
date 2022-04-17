package idv.andy.bookService.book.action;

import javax.annotation.Resource;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.util.StringUtils;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import idv.andy.bookService.book.action.view.AddBookResult;
import idv.andy.bookService.book.action.view.BookInputBean;
import idv.andy.bookService.book.action.view.QueryAllBooksResult;
import idv.andy.bookService.book.config.BookConfig;
import idv.andy.bookService.book.service.IBookService;
import idv.andy.bookService.book.service.bean.AddBookInput;
import idv.andy.bookService.book.service.bean.AddBookOutput;
import idv.andy.bookService.book.service.bean.BookBo;
import idv.andy.bookService.book.service.bean.QueryAllBooksOutput;
import idv.andy.bookService.book.service.mapper.BookMapper;

@RestController
public class BookController {
    @Resource
    private IBookService bookService;
    @Resource
    private BookMapper bookMapper;
    
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
    
    @PostMapping("/books")
    public ResponseEntity<AddBookResult> addBook(@RequestBody BookInputBean inputBean) {
        AddBookResult result = new AddBookResult();
        
        boolean goNext = true;
        String message = null;
        
        StringBuilder sb = new StringBuilder();
        if (!validateIsbn(inputBean.getIsbn())) {
            sb.append("isbn 不符合格式\n");
        }
        
        if (!StringUtils.hasText(inputBean.getName())) {
            sb.append("書名不得為空\n");
        }
        
        if (!StringUtils.hasText(inputBean.getAuthor())) {
            sb.append("作者不得為空\n");
        }
        
        if (!StringUtils.hasText(inputBean.getPublisher())) {
            sb.append("出版商不得為空\n");
        }
        
        if (inputBean.getPublishDate() == null) {
            sb.append("出版日期不得為空\n");
        }
        
        if (inputBean.getPrice() == null) {
            sb.append("價格不得為空");
        }
        
        if (!sb.isEmpty()) {
            goNext = false;
            message = sb.toString();
        }
        
        BookBo bookBo = null;
        if (goNext) {
            AddBookInput addBookInput = new AddBookInput();
            addBookInput.setBookBo(bookMapper.bookInputBeanToBookBo(inputBean));
            
            AddBookOutput addBookOutput = bookService.addBook(addBookInput);
            if (addBookOutput.isSuccess()) {
                bookBo = addBookOutput.getBookBo();
            } else {
                goNext = false;
                message = addBookOutput.getMessage();
            }
        }
        
        ResponseEntity<AddBookResult> responseEntity = null;
        if (goNext) {
            result.setBook(bookBo);
            responseEntity = new ResponseEntity<AddBookResult>(result, HttpStatus.OK);
        } else {
            result.setMessage(message);
            responseEntity = new ResponseEntity<AddBookResult>(result, HttpStatus.BAD_REQUEST);
        }
        
        return responseEntity;
    }
    
    private boolean validateIsbn(String isbn) {
        boolean isPass = true;
        
        
        if (isbn == null || !isbn.matches(BookConfig.Regex.ISBN)) {
            isPass = false;
        } else {
            // 計算前面數字校驗結果與校驗碼是否相符
            int checkLength = BookConfig.ISBN_LENGTH - BookConfig.ISBN_CHECK_NUM_DIGIT;
            String checkStr = isbn.replaceAll(BookConfig.ISBN_SPLIT, "")
                                  .substring(0, checkLength);
            
            int checkSum = 0;
            for (int i = 0; i < checkLength; i++) {
                boolean isOdd = i % 2 == 1;
                if (isOdd) {
                    checkSum += Character.getNumericValue(checkStr.charAt(i)) * 3;
                } else {
                    checkSum += Character.getNumericValue(checkStr.charAt(i));
                }
            }
            
            checkSum %= 10;
            
            if (checkSum != Integer.parseInt(isbn.substring(isbn.length() - BookConfig.ISBN_CHECK_NUM_DIGIT))) {
                isPass = false;
            }
        }
        
        return isPass;
    }
}
