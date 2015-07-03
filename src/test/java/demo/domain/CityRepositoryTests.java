package demo.domain;

import demo.Application;
import demo.domain.City;
import demo.domain.CityRepository;
import junit.framework.Assert;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.SpringApplicationConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import java.util.List;

@RunWith(SpringJUnit4ClassRunner.class)
@SpringApplicationConfiguration(classes = Application.class)
public class CityRepositoryTests {

	@Autowired
	private CityRepository cityRepository;

	private final String TEXAS_NAME = "Texas";
	private final String TX_STATE = "TX";

	private final String NEW_YORK_NAME = "New York";
	private final String NY_STATE = "NY";
	private final String NEW_YORK_NAME_SMALL_CASE = "new york";
	private final String NY_STATE_SMALL_CASE = "ny";
	private final City NEW_YORK_CITY = new City(NEW_YORK_NAME, NY_STATE);

	@Test
	public void testFindAll(){
		List<City> cities = cityRepository.findAll();
		Assert.assertEquals(2, cities.size());
	}

	@Test
	public void testFindOneNY(){
		City city = cityRepository.findByNameAndStateAllIgnoringCase(NEW_YORK_NAME, NY_STATE);
		Assert.assertNotNull(city);
		Assert.assertEquals(NEW_YORK_CITY, city);
	}

	@Test
	public void testFindNone(){
		City city = cityRepository.findByNameAndStateAllIgnoringCase(TEXAS_NAME, TX_STATE);
		Assert.assertNull(city);

		city = cityRepository.findByNameAndStateAllIgnoringCase(NEW_YORK_NAME, TX_STATE);
		Assert.assertNull(city);

		city = cityRepository.findByNameAndStateAllIgnoringCase(TEXAS_NAME, NY_STATE);
		Assert.assertNull(city);
	}

	@Test
	public void testIgnoreCase(){
		City city = cityRepository.findByNameAndStateAllIgnoringCase(NEW_YORK_NAME_SMALL_CASE, NY_STATE_SMALL_CASE);
		Assert.assertNotNull(city);
		Assert.assertEquals(NEW_YORK_CITY, city);

		city = cityRepository.findByNameAndStateAllIgnoringCase(NEW_YORK_NAME, NY_STATE_SMALL_CASE);
		Assert.assertNotNull(city);
		Assert.assertEquals(NEW_YORK_CITY, city);

		city = cityRepository.findByNameAndStateAllIgnoringCase(NEW_YORK_NAME_SMALL_CASE, NY_STATE);
		Assert.assertNotNull(city);
		Assert.assertEquals(NEW_YORK_CITY, city);
	}
}
