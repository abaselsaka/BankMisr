package banquemisr.challenge05.banquemisr.exception;

import lombok.AllArgsConstructor;
import lombok.Getter;
import org.springframework.http.HttpStatus;
@Getter
@AllArgsConstructor
public class CustomerAPIException extends RuntimeException{
    private HttpStatus status;
    private String message;
}
