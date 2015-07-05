package demo.web;

import demo.domain.City;
import demo.service.CityService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

/**
 * Created by MMARCZYK on 2015-07-03.
 */
@RestController
@RequestMapping("/rest")
public class CityRestController {
    @Autowired
    private CityService cityService;

    @RequestMapping("/city")
    public List<City> citiesAll(){
        return cityService.findAll();
    }

    @RequestMapping("/city/{name}/{state}")
    public City cityDetails(@PathVariable("name") String name, @PathVariable("state") String state){
        return cityService.findOneByNameAndStateIgnoreCase(name, state);
    }
}
