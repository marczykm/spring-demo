package demo.web;

import org.springframework.stereotype.Controller;

/**
 * Created by MMARCZYK on 2015-07-02.
 */
@Controller
public class SiteController {

    public String index() {
        return "index";
    }
}
