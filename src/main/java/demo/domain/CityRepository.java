package demo.domain;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.repository.Repository;

import java.util.List;

/**
 * Created by MMARCZYK on 2015-07-02.
 */
public interface CityRepository extends Repository<City, Long> {

    List<City> findAll();

    City findByNameAndStateAllIgnoringCase(String name, String state);
}
