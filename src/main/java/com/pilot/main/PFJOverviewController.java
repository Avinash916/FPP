package com.pilot.main;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.pilot.main.pilotservice.pojo.PFJOverviewDetail;
import com.pilot.main.pilotservice.service.PFJOverviewService;

@RestController
@CrossOrigin
@RequestMapping("/pfjoverview")
public class PFJOverviewController {

	private static final Logger logger = LoggerFactory.getLogger(PFJOverviewController.class);

	@Autowired
	PFJOverviewService pfjOverviewService;

	/**
	 * Get details for Customer Pricing screen
	 * 
	 * @return
	 */
	@GetMapping(path = "/getdashboard")
	public List<PFJOverviewDetail> getPFJOVerviewDashboard() {
		logger.info("---in Customer Pricing Controller ---");
		return pfjOverviewService.fetchPFJOverviewDetails();
	}
}