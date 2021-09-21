package aldente.springboot.swagger.controller;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.io.IOException;
import java.util.concurrent.ExecutionException;

/**
 * @author fputra on 21/09/21
 */
@RestController
public class HelloController extends BaseController {

    @GetMapping("/")
    public ResponseEntity<?> index() {
        return getCallBack("HELLO", HttpStatus.OK);
    }
}
