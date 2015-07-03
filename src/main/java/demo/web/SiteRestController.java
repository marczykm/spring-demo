package demo.web;

import demo.domain.City;
import demo.domain.CityRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * Created by MMARCZYK on 2015-07-03.
 */
@RestController
@RequestMapping("/rest")
public class SiteRestController {
    @Autowired
    CityRepository cityRepository;

    @RequestMapping("/city/{name}/{state}")
    public City city(@PathVariable("name") String name, @PathVariable("state") String state){
        return cityRepository.findByNameAndStateAllIgnoringCase(name, state);
    }
}
