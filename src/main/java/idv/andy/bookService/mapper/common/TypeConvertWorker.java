package idv.andy.bookService.mapper.common;

import org.mapstruct.Named;
import org.springframework.stereotype.Component;

@Component
@Named("TypeConvertWorker")
public class TypeConvertWorker {
    @Named("trim")
    public String trim(String str) {
        if (str != null) {
            str = str.trim();
        }
        
        return str;
    }
}
