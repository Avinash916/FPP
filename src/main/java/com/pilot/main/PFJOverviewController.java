package com.pilot.main;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

<<<<<<< HEAD
<<<<<<< HEAD
import com.pilot.main.pilotservice.pojo.PFJOverviewDetail;
=======
import com.pilot.main.pilotservice.pojo.PFJOverview;
>>>>>>> ssointegration
=======
import com.pilot.main.pilotservice.pojo.PFJOverview;
>>>>>>> c23f1a2dac02f9465e3f80b3c9688dce9ef023f1
import com.pilot.main.pilotservice.service.PFJOverviewService;

@RestController
@CrossOrigin
@RequestMapping("/pfjoverview")
public class PFJOverviewController {

	private static final Logger logger = LoggerFactory.getLogger(PFJOverviewController.class);

	@Autowired
<<<<<<< HEAD
<<<<<<< HEAD
	PFJOverviewService customerPricingService;

	/**
	 * Get details for Customer Pricing screen
=======
=======
>>>>>>> c23f1a2dac02f9465e3f80b3c9688dce9ef023f1
	PFJOverviewService pfjOverviewService;

	/**
	 * Get PFJ Overview Dashboard
<<<<<<< HEAD
>>>>>>> ssointegration
=======
>>>>>>> c23f1a2dac02f9465e3f80b3c9688dce9ef023f1
	 * 
	 * @return
	 */
	@GetMapping(path = "/getdashboard")
<<<<<<< HEAD
<<<<<<< HEAD
	public List<PFJOverviewDetail> getAllNotes() {
		logger.info("---in Customer Pricing Controller ---");
		return customerPricingService.fetchPFJOverviewDetails();
=======
	public List<PFJOverview> getPFJOVerviewDashboard() {
		logger.info("---in Customer Pricing Controller ---");
		return pfjOverviewService.fetchPFJOverviewDetails();
>>>>>>> ssointegration
=======
	public List<PFJOverview> getPFJOVerviewDashboard() {
		logger.info("---in Customer Pricing Controller ---");
		return pfjOverviewService.fetchPFJOverviewDetails();
>>>>>>> c23f1a2dac02f9465e3f80b3c9688dce9ef023f1
	}
}