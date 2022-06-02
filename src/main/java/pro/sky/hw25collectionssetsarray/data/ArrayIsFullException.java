package pro.sky.hw25collectionssetsarray.data;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(code = HttpStatus.BAD_REQUEST)
public class ArrayIsFullException extends RuntimeException{

    public ArrayIsFullException(String message) {
        super(message);
    }

}
