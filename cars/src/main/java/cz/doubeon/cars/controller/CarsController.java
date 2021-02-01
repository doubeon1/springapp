package cz.doubeon.cars.controller;

import java.math.BigInteger;
import java.util.Date;
import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import cz.doubeon.cars.dao.CarsDao;
import cz.doubeon.cars.model.Car;

@Controller
@RequestMapping("/cars")
public class CarsController {
	static final Logger LOGGER = LoggerFactory.getLogger(CarsController.class);

	@Autowired
	private CarsDao carsDao;

	@RequestMapping(method = RequestMethod.GET)
	public ModelAndView list() {
		final List<Car> cars = carsDao.getAll();

		final ModelAndView modelAndView = new ModelAndView("car-list");

		modelAndView.getModel().put("cars", cars);

		return modelAndView;
	}

	@RequestMapping(value = "/{id}", method = RequestMethod.GET)
	public ModelAndView show(@PathVariable("id") BigInteger id) {
		final Car car = carsDao.get(id);

		final ModelAndView modelAndView = new ModelAndView("car-detail");

		modelAndView.getModel().put("car", car);

		return modelAndView;
	}

	@RequestMapping(value = "/{id}", params = "form", method = RequestMethod.GET)
	public ModelAndView updateForm(@PathVariable("id") BigInteger id) {
		final Car car = carsDao.get(id);

		final ModelAndView modelAndView = new ModelAndView("car-form");

		modelAndView.getModel().put("car", car);

		return modelAndView;
	}

	@RequestMapping(params = "form", method = RequestMethod.GET)
	public ModelAndView createForm() {
		final ModelAndView modelAndView = new ModelAndView("car-form");

		final Car car = new Car();
		car.setPurchased(new Date());

		modelAndView.getModel().put("car", car);

		return modelAndView;
	}

	@RequestMapping(value = "/delete/{id}", method = RequestMethod.GET)
	public ModelAndView create(@PathVariable("id") BigInteger id) {
		carsDao.delete(id);

		return list();
	}


}