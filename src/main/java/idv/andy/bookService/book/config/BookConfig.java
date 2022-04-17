package idv.andy.bookService.book.config;

public class BookConfig {
    public final static class Regex {
        public final static String ISBN = "^(?=.{16}$)\\d{3}-\\d+-\\d+-\\d{1}$";
    }
    
    public final static String ISBN_SPLIT = "-";
    public final static int ISBN_LENGTH = 13;
    public final static int ISBN_CHECK_NUM_DIGIT = 1;
}
