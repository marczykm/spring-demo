package demo.web;

import demo.domain.City;
import demo.domain.CityRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * Created by MMARCZYK on 2015-07-02.
 */
@Controller
public class HelloController {

    @Autowired
    CityRepository cityRepository;

    @RequestMapping("/")
    public String home() {
        return "home";
    }

    @RequestMapping("/city/{name}/{state}")
    public String city(@PathVariable("name") String name, @PathVariable("state") String state, Model model){
        City city = cityRepository.findByNameAndStateAllIgnoringCase(name, state);

        if (city != null){
            model.addAttribute("city", city);
        }
        return "city";
    }
}
