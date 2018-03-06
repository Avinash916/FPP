package com.pilot.main.pilotservice.service;

import java.math.BigDecimal;
import java.math.RoundingMode;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.pilot.main.pilotrepo.entity.FctDmCompanyLevelActualVsTargetEntity;
import com.pilot.main.pilotrepo.entity.QFctDmCompanyLevelActualVsTargetEntity;
import com.pilot.main.pilotrepo.repo.FctDmCompanyLevelActualVsTargetRepo;
import com.pilot.main.pilotservice.pojo.BetterOf;
import com.pilot.main.pilotservice.pojo.CCC;
import com.pilot.main.pilotservice.pojo.Funded;
import com.pilot.main.pilotservice.pojo.GrossProfitDollars;
import com.pilot.main.pilotservice.pojo.Margin;
import com.pilot.main.pilotservice.pojo.MixPercentage;
import com.pilot.main.pilotservice.pojo.PFJOverview;
import com.pilot.main.pilotservice.pojo.PFJTotal;
import com.pilot.main.pilotservice.pojo.RetailMinus;
import com.pilot.main.pilotservice.pojo.TotalRetail;
import com.pilot.main.pilotservice.pojo.Volume;

@Service
public class PFJOverviewService {

	private static final Logger logger = LoggerFactory.getLogger(PFJOverviewService.class);

	@Autowired
	FctDmCompanyLevelActualVsTargetRepo fctDmCompanyLevelActualVsTargetRepo;

	public List<PFJOverview> fetchPFJOverviewDetails() {
		logger.info("---in Customer Pricing Service ---");

		/*
		 * UI data generation for MTD filter
		 */
		List<FctDmCompanyLevelActualVsTargetEntity> mtdEntities = findEntitiesByTemporalPeriod("MTD");
		logger.info("Found MTD type rows ---> " + mtdEntities.size());
		PFJOverview pfjOverviewDetailsMTD = populatePFJOverviewDetail(mtdEntities);
		pfjOverviewDetailsMTD.setTemporalPeriod("MTD");

		String datestr = String.valueOf(mtdEntities.get(0).getDimPlPeriodDateId());
		DateTimeFormatter inputformat = DateTimeFormatter.ofPattern("yyyyMMdd");
		LocalDate dateTime = LocalDate.parse(datestr, inputformat);
		
		DateTimeFormatter outputformat = DateTimeFormatter.ofPattern("MMMM yyyy");
		
		pfjOverviewDetailsMTD.setDimPlPeriodDateId(dateTime.format(outputformat));
		logger.info("MTD UI POJO Value  ---> " + pfjOverviewDetailsMTD);

		/*
		 * UI data generation for LCM filter
		 */
		List<FctDmCompanyLevelActualVsTargetEntity> lcmEntities = findEntitiesByTemporalPeriod("LCM");
		logger.info("Found LCM type rows ---> " + lcmEntities.size());
		PFJOverview pfjOverviewDetailsLCM = populatePFJOverviewDetail(lcmEntities);
		pfjOverviewDetailsLCM.setTemporalPeriod("LCM");
		pfjOverviewDetailsLCM.setDimPlPeriodDateId(dateTime.format(outputformat));
		logger.info("LCM UI POJO Value  ---> " + pfjOverviewDetailsLCM);

		/*
		 * UI data generation for LCYTD filter
		 */
		List<FctDmCompanyLevelActualVsTargetEntity> lcytdEntities = findEntitiesByTemporalPeriod("LCYTD");
		logger.info("Found LCYTD type rows ---> " + lcytdEntities.size());
		PFJOverview pfjOverviewDetailsLCYTD = populatePFJOverviewDetail(lcytdEntities);
		pfjOverviewDetailsLCYTD.setTemporalPeriod("LCYTD");
		pfjOverviewDetailsLCYTD.setDimPlPeriodDateId(dateTime.format(outputformat));
		logger.info("LCYTD UI POJO Value  ---> " + pfjOverviewDetailsLCYTD);

		List<PFJOverview> pfjOverviewDetailss = new ArrayList<PFJOverview>();
		pfjOverviewDetailss.add(pfjOverviewDetailsMTD);
		pfjOverviewDetailss.add(pfjOverviewDetailsLCM);
		pfjOverviewDetailss.add(pfjOverviewDetailsLCYTD);

		return pfjOverviewDetailss;
	}

	private List<FctDmCompanyLevelActualVsTargetEntity> findEntitiesByTemporalPeriod(String temporalPeriod) {
		return (List<FctDmCompanyLevelActualVsTargetEntity>) fctDmCompanyLevelActualVsTargetRepo
				.findAll(QFctDmCompanyLevelActualVsTargetEntity.fctDmCompanyLevelActualVsTargetEntity.fctDmCompanyLevelActualVsTargetId.temporalPeriod.eq(temporalPeriod));
	}

	private PFJOverview populatePFJOverviewDetail(List<FctDmCompanyLevelActualVsTargetEntity> fctDmCompanyLevelActualVsTargetEntities) {
		PFJOverview pfjOverviewDetails = new PFJOverview();
		
		/*
		 * MIX_OF_BUSINESS entities
		 */
		FctDmCompanyLevelActualVsTargetEntity pfjTotalEntity = null;
		FctDmCompanyLevelActualVsTargetEntity betterOfEntity = null;
		FctDmCompanyLevelActualVsTargetEntity totalRetailEntity = null;
		FctDmCompanyLevelActualVsTargetEntity retailMinusEntity = null;
		FctDmCompanyLevelActualVsTargetEntity fundedEntity = null;
		FctDmCompanyLevelActualVsTargetEntity cccEntity = null;
		
		for (FctDmCompanyLevelActualVsTargetEntity fctDmCompanyLevelActualVsTargetEntity : fctDmCompanyLevelActualVsTargetEntities) {
			
			if (fctDmCompanyLevelActualVsTargetEntity.getFctDmCompanyLevelActualVsTargetId().getMixOfBusiness().equalsIgnoreCase("TOTAL")) {
				pfjTotalEntity = fctDmCompanyLevelActualVsTargetEntity;
			} else if (fctDmCompanyLevelActualVsTargetEntity.getFctDmCompanyLevelActualVsTargetId().getMixOfBusiness().equalsIgnoreCase("BETTER OF")) {
				betterOfEntity = fctDmCompanyLevelActualVsTargetEntity;
			} else if (fctDmCompanyLevelActualVsTargetEntity.getFctDmCompanyLevelActualVsTargetId().getMixOfBusiness().equalsIgnoreCase("TOTAL RETAIL")) {
				totalRetailEntity = fctDmCompanyLevelActualVsTargetEntity;
			} else if (fctDmCompanyLevelActualVsTargetEntity.getFctDmCompanyLevelActualVsTargetId().getMixOfBusiness().equalsIgnoreCase("RETAIL MINUS")) {
				retailMinusEntity = fctDmCompanyLevelActualVsTargetEntity;
			} else if (fctDmCompanyLevelActualVsTargetEntity.getFctDmCompanyLevelActualVsTargetId().getMixOfBusiness().equalsIgnoreCase("FUNDED")) {
				fundedEntity = fctDmCompanyLevelActualVsTargetEntity;
			} else if (fctDmCompanyLevelActualVsTargetEntity.getFctDmCompanyLevelActualVsTargetId().getMixOfBusiness().equalsIgnoreCase("CCC")) {
				cccEntity = fctDmCompanyLevelActualVsTargetEntity;
			}
		}
		
		/*
		 * Populate PFJTotal
		 */
		populatePFJTotal(pfjOverviewDetails, pfjTotalEntity);
		
		/*
		 * Populate BetterOf
		 */
		populateBetterOf(pfjOverviewDetails, betterOfEntity, pfjTotalEntity);
		
		/*
		 * Populate TotalRetail
		 */
		populateTotalRetail(pfjOverviewDetails, totalRetailEntity, pfjTotalEntity);
		
		/*
		 * Populate RetailMinus
		 */
		populateRetailMinus(pfjOverviewDetails, retailMinusEntity, pfjTotalEntity);
		
		/*
		 * Populate Funded
		 */
		populateFunded(pfjOverviewDetails, fundedEntity, pfjTotalEntity);
		
		/*
		 * Populate CCC
		 */
		populateCCC(pfjOverviewDetails, cccEntity, pfjTotalEntity);
		
		return pfjOverviewDetails;
	}

	private void populatePFJTotal(PFJOverview pfjOverviewDetails, FctDmCompanyLevelActualVsTargetEntity pfjTotalEntity) {
		GrossProfitDollars grossProfitDollars = populateGP$Tile(pfjTotalEntity);
		Volume volume = populateVolumeTile(pfjTotalEntity);
		Margin margin = populateMarginTile(pfjTotalEntity);

		PFJTotal pfjTotal = new PFJTotal();
		pfjTotal.setGrossProfitDollars(grossProfitDollars);
		pfjTotal.setVolume(volume);
		pfjTotal.setMargin(margin);
		pfjTotal.setTotalGAL(pfjTotalEntity.getActualVolumeLy());
		pfjTotal.setTotalTarget(pfjTotalEntity.getTargetVolume());
		
		pfjOverviewDetails.setpFJTotal(pfjTotal);
	}

	private void populateBetterOf(PFJOverview pfjOverviewDetails, FctDmCompanyLevelActualVsTargetEntity betterOfEntity, FctDmCompanyLevelActualVsTargetEntity pfjTotalEntity) {
		GrossProfitDollars grossProfitDollars = populateGP$Tile(betterOfEntity);
		Volume volume = populateVolumeTile(betterOfEntity);
		Margin margin = populateMarginTile(betterOfEntity);
		MixPercentage mixPercentage = populateMixPercentageTile(betterOfEntity, pfjTotalEntity);
		
		BetterOf betterOf = new BetterOf();
		betterOf.setGrossProfitDollars(grossProfitDollars);
		betterOf.setVolume(volume);
		betterOf.setMargin(margin);
		betterOf.setMixPercentage(mixPercentage);
		betterOf.setBuyingPerfActual(betterOfEntity.getActualBuyingPerformance());
		betterOf.setBuyingPerfTarget(betterOfEntity.getTargetBuyingPerformance());
		betterOf.setEffPumpFeeActual(betterOfEntity.getActualEffectivePumpFee());
		betterOf.setEffPumpFeeTarget(betterOfEntity.getTargetEffectivePumpFee());
		
		pfjOverviewDetails.setBetterOf(betterOf);
	}

	private void populateTotalRetail(PFJOverview pfjOverviewDetails, FctDmCompanyLevelActualVsTargetEntity totalRetailEntity, FctDmCompanyLevelActualVsTargetEntity pfjTotalEntity) {
		GrossProfitDollars grossProfitDollars = populateGP$Tile(totalRetailEntity);
		Volume volume = populateVolumeTile(totalRetailEntity);
		Margin margin = populateMarginTile(totalRetailEntity);
		MixPercentage mixPercentage = populateMixPercentageTile(totalRetailEntity, pfjTotalEntity);
		
		TotalRetail totalRetail = new TotalRetail();
		totalRetail.setGrossProfitDollars(grossProfitDollars);
		totalRetail.setVolume(volume);
		totalRetail.setMargin(margin);
		totalRetail.setMixPercentage(mixPercentage);
		
		pfjOverviewDetails.setTotalRetail(totalRetail);
	}

	private void populateRetailMinus(PFJOverview pfjOverviewDetails, FctDmCompanyLevelActualVsTargetEntity retailMinusEntity, FctDmCompanyLevelActualVsTargetEntity pfjTotalEntity) {
		GrossProfitDollars grossProfitDollars = populateGP$Tile(retailMinusEntity);
		Volume volume = populateVolumeTile(retailMinusEntity);
		Margin margin = populateMarginTile(retailMinusEntity);
		MixPercentage mixPercentage = populateMixPercentageTile(retailMinusEntity, pfjTotalEntity);
		
		RetailMinus retailMinus = new RetailMinus();
		retailMinus.setGrossProfitDollars(grossProfitDollars);
		retailMinus.setVolume(volume);
		retailMinus.setMargin(margin);
		retailMinus.setMixPercentage(mixPercentage);
		retailMinus.setRmDiscountActual(retailMinusEntity.getActualEffectiveRetailMinusRate());
		retailMinus.setRmDiscountTarget(retailMinusEntity.getTargetEffectiveRetailMinusRate());
		
		pfjOverviewDetails.setRetailMinus(retailMinus);
	}

	private void populateFunded(PFJOverview pfjOverviewDetails, FctDmCompanyLevelActualVsTargetEntity fundedEntity, FctDmCompanyLevelActualVsTargetEntity pfjTotalEntity) {
		GrossProfitDollars grossProfitDollars = populateGP$Tile(fundedEntity);
		Volume volume = populateVolumeTile(fundedEntity);
		Margin margin = populateMarginTile(fundedEntity);
		MixPercentage mixPercentage = populateMixPercentageTile(fundedEntity, pfjTotalEntity);
		
		Funded funded = new Funded();
		funded.setGrossProfitDollars(grossProfitDollars);
		funded.setVolume(volume);
		funded.setMargin(margin);
		funded.setMixPercentage(mixPercentage);
		
		pfjOverviewDetails.setFunded(funded);
	}

	private void populateCCC(PFJOverview pfjOverviewDetails, FctDmCompanyLevelActualVsTargetEntity cccEntity, FctDmCompanyLevelActualVsTargetEntity pfjTotalEntity) {
		GrossProfitDollars grossProfitDollars = populateGP$Tile(cccEntity);
		Volume volume = populateVolumeTile(cccEntity);
		Margin margin = populateMarginTile(cccEntity);
		MixPercentage mixPercentage = populateMixPercentageTile(cccEntity, pfjTotalEntity);
		
		CCC ccc = new CCC();
		ccc.setGrossProfitDollars(grossProfitDollars);
		ccc.setVolume(volume);
		ccc.setMargin(margin);
		ccc.setMixPercentage(mixPercentage);
		
		pfjOverviewDetails.setCcc(ccc);
	}

	private GrossProfitDollars populateGP$Tile(FctDmCompanyLevelActualVsTargetEntity pfjOverviewEntity) {
		GrossProfitDollars grossProfitDollars = new GrossProfitDollars();
		grossProfitDollars.setHeader(pfjOverviewEntity.getActualProfitNetOfDiscounts());
		grossProfitDollars.setVsTgLeft(pfjOverviewEntity.getActualProfitNetOfDiscounts().subtract(pfjOverviewEntity.getTargetProfitNetOfDiscounts()));
		grossProfitDollars.setVsTgLeftPositive(grossProfitDollars.getVsTgLeft().signum() > 0);
		grossProfitDollars.setVsTgRight(pfjOverviewEntity.getTargetProfitNetOfDiscounts());
		grossProfitDollars.setVsLyLeft(pfjOverviewEntity.getActualProfitNetOfDiscounts().subtract(pfjOverviewEntity.getActualProfitNetOfDiscountsLy()));
		grossProfitDollars.setVsLyLeftPositive(grossProfitDollars.getVsLyLeft().signum() > 0);
		grossProfitDollars.setVsLyRight(pfjOverviewEntity.getActualProfitNetOfDiscountsLy());
		return grossProfitDollars;
	}

	private Volume populateVolumeTile(FctDmCompanyLevelActualVsTargetEntity pfjOverviewEntity) {
		Volume volume = new Volume();
		volume.setHeader(pfjOverviewEntity.getActualVolume());
		volume.setVsTgLeft(pfjOverviewEntity.getActualVolume().subtract(pfjOverviewEntity.getTargetVolume()));
		volume.setVsTgLeftPositive(volume.getVsTgLeft().signum() > 0);
		volume.setVsTgRight(pfjOverviewEntity.getActualVolume().subtract(pfjOverviewEntity.getTargetVolume()).divide(pfjOverviewEntity.getTargetVolume(), 3, RoundingMode.HALF_UP).multiply(BigDecimal.valueOf(100)));
		volume.setVsLyLeft(pfjOverviewEntity.getActualVolume().subtract(pfjOverviewEntity.getActualVolumeLy()));
		volume.setVsLyLeftPositive(volume.getVsLyLeft().signum() > 0);
		volume.setVsLyRight(pfjOverviewEntity.getActualVolume().subtract(pfjOverviewEntity.getActualVolumeLy()).divide(pfjOverviewEntity.getActualVolumeLy(), 3, RoundingMode.HALF_UP).multiply(BigDecimal.valueOf(100)));
		return volume;
	}

	private Margin populateMarginTile(FctDmCompanyLevelActualVsTargetEntity pfjOverviewEntity) {
		Margin margin = new Margin();
		margin.setHeader(pfjOverviewEntity.getActualMarginNetOfDiscounts());
		margin.setVsTgLeft(pfjOverviewEntity.getActualMarginNetOfDiscounts().subtract(pfjOverviewEntity.getTargetMarginNetOfDiscounts()));
		margin.setVsTgLeftPositive(margin.getVsTgLeft().signum() > 0);
		margin.setVsTgRight(pfjOverviewEntity.getTargetMarginNetOfDiscounts());
		margin.setVsLyLeft(pfjOverviewEntity.getActualMarginNetOfDiscounts().subtract(pfjOverviewEntity.getActualMarginNetOfDiscountsLy()));
		margin.setVsLyLeftPositive(margin.getVsLyLeft().signum() > 0);
		margin.setVsLyRight(pfjOverviewEntity.getActualMarginNetOfDiscountsLy());
		return margin;
	}
	
	private MixPercentage populateMixPercentageTile(FctDmCompanyLevelActualVsTargetEntity pfjOverviewEntity, FctDmCompanyLevelActualVsTargetEntity pfjTotalEntity) {
		MixPercentage mixPercentage = new MixPercentage();
		mixPercentage.setMixActual(pfjOverviewEntity.getActualVolume().divide(pfjTotalEntity.getActualVolume(), 3, RoundingMode.HALF_UP).multiply(BigDecimal.valueOf(100)));
		mixPercentage.setMixTarget(pfjOverviewEntity.getTargetVolume().divide(pfjTotalEntity.getTargetVolume(), 3, RoundingMode.HALF_UP).multiply(BigDecimal.valueOf(100)));
		mixPercentage.setMixVsLy((pfjOverviewEntity.getActualVolume().divide(pfjTotalEntity.getActualVolume(), 3, RoundingMode.HALF_UP))
									.subtract(pfjOverviewEntity.getActualVolumeLy().divide(pfjTotalEntity.getActualVolumeLy(), 3, RoundingMode.HALF_UP))
									.divide(pfjOverviewEntity.getActualVolumeLy().divide(pfjTotalEntity.getActualVolumeLy(), 3, RoundingMode.HALF_UP), 3, RoundingMode.HALF_UP)
									.multiply(BigDecimal.valueOf(100)));
		mixPercentage.setMixVsLyPositive(mixPercentage.getMixVsLy().signum() > 0);
		return mixPercentage;
	}
}