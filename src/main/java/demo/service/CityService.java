package demo.service;

import demo.domain.City;
import demo.domain.CityRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.Assert;

import java.util.List;

/**
 * Created by MMARCZYK on 2015-07-03.
 */
@Service
public class CityService {
    @Autowired
    private CityRepository cityRepository;

    public List<City> findAll(){
        List<City> cities = cityRepository.findAll();
        return cities;
    }

    public City findOneByNameAndStateIgnoreCase(String name, String state){
        Assert.notNull(name, "Name cannot be null");
        Assert.notNull(state, "State cannot be null");
        City city = cityRepository.findByNameAndStateAllIgnoringCase(name, state);
        return city;
    }
}
