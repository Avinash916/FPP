package com.pilot.main;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.pilot.main.pilotservice.pojo.CustomerPricingDetail;
import com.pilot.main.pilotservice.service.CustomerPricingService;

@RestController
@CrossOrigin
@RequestMapping("/pfjoverview")
public class PFJOverviewController {

	private static final Logger logger = LoggerFactory.getLogger(PFJOverviewController.class);

	@Autowired
	CustomerPricingService customerPricingService;

	/**
	 * Get details for Customer Pricing screen
	 * 
	 * @return
	 */
	@GetMapping(path = "/getdashboard")
	public List<CustomerPricingDetail> getAllNotes() {
		logger.info("---in Customer Pricing Controller ---");
		return customerPricingService.fetchCustomerPricingDetails();
	}
}