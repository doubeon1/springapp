package cz.doubeon.cars.controller;

import java.math.BigInteger;
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
import cz.doubeon.cars.dao.RefuelingsDao;
import cz.doubeon.cars.model.Car;
import cz.doubeon.cars.model.Refueling;

@Controller
@RequestMapping("/refueling")
public class RefuelingController {

	static final Logger LOGGER = LoggerFactory.getLogger(RefuelingController.class);

	@Autowired
	private RefuelingsDao refuelingsDao;

	@Autowired
	private CarsDao carsDao;

	@RequestMapping(value = "/{id}", method = RequestMethod.GET)
	public ModelAndView show(@PathVariable("id") BigInteger id) {

		final List<Refueling> refuelings = refuelingsDao.getByCar(id);
		final Car car = carsDao.get(id);

		final ModelAndView modelAndView = new ModelAndView("refueling-list");

		modelAndView.getModel().put("refuelings", refuelings);
		modelAndView.getModel().put("car", car);

		return modelAndView;
	}

}
