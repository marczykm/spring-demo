package demo.web;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * Created by MMARCZYK on 2015-07-02.
 */
@RestController
public class HelloController {
    @RequestMapping("/")
    public String home() {
        return "Hello World";
    }
}
