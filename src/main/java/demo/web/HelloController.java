package demo.web;

import demo.domain.City;
import demo.domain.CityRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

/**
 * Created by MMARCZYK on 2015-07-02.
 */
@RestController
public class HelloController {

    @Autowired
    CityRepository cityRepository;

    @RequestMapping("/")
    public String home() {
        City city = cityRepository.findByNameAndStateAllIgnoringCase("new york", "ny");
        List<City> cities = cityRepository.findAll();
        return "found: " + cities.size()+"<br/>" + (city != null ? city.toString() : null);
    }
}
