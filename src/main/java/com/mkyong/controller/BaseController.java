package com.mkyong.controller;

import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import java.lang.management.ManagementFactory;

@Controller
public class BaseController {

	private static Counter counter = new Counter(0);
	private static final String VIEW_INDEX = "index";
	private final static org.slf4j.Logger logger = LoggerFactory.getLogger(BaseController.class);

	@RequestMapping(value = "/", method = RequestMethod.GET)
	public String welcome(ModelMap model) {
		counter.increase();
		model.addAttribute("message", Counter.TEST);
		model.addAttribute("counter", counter.getCounter());
		logger.debug("[welcome] counter : {}", counter.getCounter());
		Thread myThread = new Thread(new MyThread());
		myThread.start();
		// Spring uses InternalResourceViewResolver and return back index.jsp
		return VIEW_INDEX;

	}

	@RequestMapping(value = "/{name}", method = RequestMethod.GET)
	public String welcomeName(@PathVariable String name, ModelMap model) {
		counter.increase();
		model.addAttribute("message", "Welcome " + name);
		model.addAttribute("counter", counter.getCounter());
		logger.debug("[welcomeName] counter : {}", counter.getCounter());
		return VIEW_INDEX;

	}

}