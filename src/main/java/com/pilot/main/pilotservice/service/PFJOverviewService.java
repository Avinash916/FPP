package com.pilot.main.pilotservice.service;

import java.math.BigDecimal;
import java.math.RoundingMode;
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
import com.pilot.main.pilotservice.pojo.PFJOverviewDetail;
import com.pilot.main.pilotservice.pojo.Funded;
import com.pilot.main.pilotservice.pojo.GrossProfitDollars;
import com.pilot.main.pilotservice.pojo.Margin;
import com.pilot.main.pilotservice.pojo.MixPercentage;
import com.pilot.main.pilotservice.pojo.PFJTotal;
import com.pilot.main.pilotservice.pojo.RetailMinus;
import com.pilot.main.pilotservice.pojo.TotalRetail;
import com.pilot.main.pilotservice.pojo.Volume;

@Service
public class PFJOverviewService {

	private static final Logger logger = LoggerFactory.getLogger(PFJOverviewService.class);

	@Autowired
	FctDmCompanyLevelActualVsTargetRepo fctDmCompanyLevelActualVsTargetRepo;

	public List<PFJOverviewDetail> fetchPFJOverviewDetails() {
		logger.info("---in Customer Pricing Service ---");

		/*
		 * UI data generation for MTD filter
		 */
		List<FctDmCompanyLevelActualVsTargetEntity> mtdEntities = findEntitiesByTemporalPeriod("MTD");
		logger.info("Found MTD type rows ---> " + mtdEntities.size());
		PFJOverviewDetail PFJOverviewDetailMTD = populatePFJOverviewDetail(mtdEntities);
		PFJOverviewDetailMTD.setTemporalPeriod("MTD");
		PFJOverviewDetailMTD.setDimPlPeriodDateId(mtdEntities.get(0).getDimPlPeriodDateId());

		/*
		 * UI data generation for LCM filter
		 */
		List<FctDmCompanyLevelActualVsTargetEntity> lcmEntities = findEntitiesByTemporalPeriod("LCM");
		logger.info("Found LCM type rows ---> " + lcmEntities.size());
		PFJOverviewDetail PFJOverviewDetailLCM = populatePFJOverviewDetail(lcmEntities);
		PFJOverviewDetailLCM.setTemporalPeriod("LCM");
		PFJOverviewDetailLCM.setDimPlPeriodDateId(lcmEntities.get(0).getDimPlPeriodDateId());

		/*
		 * UI data generation for LCYTD filter
		 */
		List<FctDmCompanyLevelActualVsTargetEntity> lcytdEntities = findEntitiesByTemporalPeriod("LCYTD");
		logger.info("Found LCYTD type rows ---> " + lcytdEntities.size());
		PFJOverviewDetail PFJOverviewDetailLCYTD = populatePFJOverviewDetail(lcytdEntities);
		PFJOverviewDetailLCYTD.setTemporalPeriod("LCYTD");
		PFJOverviewDetailLCYTD.setDimPlPeriodDateId(lcytdEntities.get(0).getDimPlPeriodDateId());

		List<PFJOverviewDetail> PFJOverviewDetails = new ArrayList<PFJOverviewDetail>();
		PFJOverviewDetails.add(PFJOverviewDetailMTD);
		PFJOverviewDetails.add(PFJOverviewDetailLCM);
		PFJOverviewDetails.add(PFJOverviewDetailLCYTD);

		return PFJOverviewDetails;
	}

	private PFJOverviewDetail populatePFJOverviewDetail(List<FctDmCompanyLevelActualVsTargetEntity> fctDmCompanyLevelActualVsTargetEntities) {
		PFJOverviewDetail PFJOverviewDetail = new PFJOverviewDetail();
		
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
		populatePFJTotal(PFJOverviewDetail, pfjTotalEntity);
		
		/*
		 * Populate BetterOf
		 */
		populateBetterOf(PFJOverviewDetail, betterOfEntity, pfjTotalEntity);
		
		/*
		 * Populate TotalRetail
		 */
		populateTotalRetail(PFJOverviewDetail, totalRetailEntity, pfjTotalEntity);
		
		/*
		 * Populate RetailMinus
		 */
		populateRetailMinus(PFJOverviewDetail, retailMinusEntity, pfjTotalEntity);
		
		/*
		 * Populate Funded
		 */
		populateFunded(PFJOverviewDetail, fundedEntity, pfjTotalEntity);
		
		/*
		 * Populate CCC
		 */
		populateCCC(PFJOverviewDetail, cccEntity, pfjTotalEntity);
		
		return PFJOverviewDetail;
	}

	private void populatePFJTotal(PFJOverviewDetail PFJOverviewDetail, FctDmCompanyLevelActualVsTargetEntity pfjTotalEntity) {
		GrossProfitDollars grossProfitDollars = new GrossProfitDollars();
		grossProfitDollars.setHeader(pfjTotalEntity.getActualProfitNetOfDiscounts());
		grossProfitDollars.setVsTgLeft(pfjTotalEntity.getActualProfitNetOfDiscounts().subtract(pfjTotalEntity.getTargetProfitNetOfDiscounts()));
		grossProfitDollars.setVsTgLeftPositive(grossProfitDollars.getVsTgLeft().signum() > 0);
		// grossProfitDollars.setVsTgLeft(grossProfitDollars.getVsTgLeft().abs());
		grossProfitDollars.setVsTgRight(pfjTotalEntity.getTargetProfitNetOfDiscounts());
		grossProfitDollars.setVsLyLeft(pfjTotalEntity.getActualProfitNetOfDiscounts().subtract(pfjTotalEntity.getActualProfitNetOfDiscountsLy()));
		grossProfitDollars.setVsLyLeftPositive(grossProfitDollars.getVsLyLeft().signum() > 0);
		// grossProfitDollars.setVsLyLeft(grossProfitDollars.getVsLyLeft().abs());
		grossProfitDollars.setVsLyRight(pfjTotalEntity.getActualProfitNetOfDiscountsLy());

		Volume volume = new Volume();
		volume.setHeader(pfjTotalEntity.getActualVolume());
		volume.setVsTgLeft(pfjTotalEntity.getActualVolume().subtract(pfjTotalEntity.getTargetVolume()));
		volume.setVsTgLeftPositive(volume.getVsTgLeft().signum() > 0);
		// volume.setVsTgLeft(volume.getVsTgLeft().abs());
		volume.setVsTgRight(pfjTotalEntity.getActualVolume().subtract(pfjTotalEntity.getTargetVolume()).divide(pfjTotalEntity.getTargetVolume(), 3, RoundingMode.HALF_UP).multiply(BigDecimal.valueOf(100)));
		volume.setVsLyLeft(pfjTotalEntity.getActualVolume().subtract(pfjTotalEntity.getActualVolumeLy()));
		volume.setVsLyLeftPositive(volume.getVsLyLeft().signum() > 0);
		// volume.setVsLyLeft(volume.getVsLyLeft().abs());
		volume.setVsLyRight(pfjTotalEntity.getActualVolume().subtract(pfjTotalEntity.getActualVolumeLy()).divide(pfjTotalEntity.getActualVolumeLy(), 3, RoundingMode.HALF_UP).multiply(BigDecimal.valueOf(100)));
		
		Margin margin = new Margin();
		margin.setHeader(pfjTotalEntity.getActualMarginNetOfDiscounts());
		margin.setVsTgLeft(pfjTotalEntity.getActualMarginNetOfDiscounts().subtract(pfjTotalEntity.getTargetMarginNetOfDiscounts()));
		margin.setVsTgLeftPositive(margin.getVsTgLeft().signum() > 0);
		// margin.setVsTgLeft(margin.getVsTgLeft().abs());
		margin.setVsTgRight(pfjTotalEntity.getTargetMarginNetOfDiscounts());
		margin.setVsLyLeft(pfjTotalEntity.getActualMarginNetOfDiscounts().subtract(pfjTotalEntity.getActualMarginNetOfDiscountsLy()));
		margin.setVsLyLeftPositive(margin.getVsLyLeft().signum() > 0);
		// margin.setVsLyLeft(margin.getVsLyLeft().abs());
		margin.setVsLyRight(pfjTotalEntity.getActualMarginNetOfDiscountsLy());
		
		PFJTotal pfjTotal = new PFJTotal();
		pfjTotal.setGrossProfitDollars(grossProfitDollars);
		pfjTotal.setVolume(volume);
		pfjTotal.setMargin(margin);
		pfjTotal.setTotalGAL(pfjTotalEntity.getActualVolumeLy());
		pfjTotal.setTotalTarget(pfjTotalEntity.getTargetVolume());
		
		PFJOverviewDetail.setpFJTotal(pfjTotal);
	}

	private void populateBetterOf(PFJOverviewDetail PFJOverviewDetail, 
			FctDmCompanyLevelActualVsTargetEntity betterOfEntity, FctDmCompanyLevelActualVsTargetEntity pfjTotalEntity) {
		GrossProfitDollars grossProfitDollars = new GrossProfitDollars();
		grossProfitDollars.setHeader(betterOfEntity.getActualProfitNetOfDiscounts());
		grossProfitDollars.setVsTgLeft(betterOfEntity.getActualProfitNetOfDiscounts().subtract(betterOfEntity.getTargetProfitNetOfDiscounts()));
		grossProfitDollars.setVsTgLeftPositive(grossProfitDollars.getVsTgLeft().signum() > 0);
		// grossProfitDollars.setVsTgLeft(grossProfitDollars.getVsTgLeft().abs());
		grossProfitDollars.setVsTgRight(betterOfEntity.getTargetProfitNetOfDiscounts());
		grossProfitDollars.setVsLyLeft(betterOfEntity.getActualProfitNetOfDiscounts().subtract(betterOfEntity.getActualProfitNetOfDiscountsLy()));
		grossProfitDollars.setVsLyLeftPositive(grossProfitDollars.getVsLyLeft().signum() > 0);
		// grossProfitDollars.setVsLyLeft(grossProfitDollars.getVsLyLeft().abs());
		grossProfitDollars.setVsLyRight(betterOfEntity.getActualProfitNetOfDiscountsLy());
		
		Volume volume = new Volume();
		volume.setHeader(betterOfEntity.getActualVolume());
		volume.setVsTgLeft(betterOfEntity.getActualVolume().subtract(betterOfEntity.getTargetVolume()));
		volume.setVsTgLeftPositive(volume.getVsTgLeft().signum() > 0);
		// volume.setVsTgLeft(volume.getVsTgLeft().abs());
		volume.setVsTgRight(betterOfEntity.getActualVolume().subtract(betterOfEntity.getTargetVolume()).divide(betterOfEntity.getTargetVolume(), 3, RoundingMode.HALF_UP).multiply(BigDecimal.valueOf(100)));
		volume.setVsLyLeft(betterOfEntity.getActualVolume().subtract(betterOfEntity.getActualVolumeLy()));
		volume.setVsLyLeftPositive(volume.getVsLyLeft().signum() > 0);
		// volume.setVsLyLeft(volume.getVsLyLeft().abs());
		volume.setVsLyRight(betterOfEntity.getActualVolume().subtract(betterOfEntity.getActualVolumeLy()).divide(betterOfEntity.getActualVolumeLy(), 3, RoundingMode.HALF_UP).multiply(BigDecimal.valueOf(100)));
		
		Margin margin = new Margin();
		margin.setHeader(betterOfEntity.getActualMarginNetOfDiscounts());
		margin.setVsTgLeft(betterOfEntity.getActualMarginNetOfDiscounts().subtract(betterOfEntity.getTargetMarginNetOfDiscounts()));
		margin.setVsTgLeftPositive(margin.getVsTgLeft().signum() > 0);
		// margin.setVsTgLeft(margin.getVsTgLeft().abs());
		margin.setVsTgRight(betterOfEntity.getTargetMarginNetOfDiscounts());
		margin.setVsLyLeft(betterOfEntity.getActualMarginNetOfDiscounts().subtract(betterOfEntity.getActualMarginNetOfDiscountsLy()));
		margin.setVsLyLeftPositive(margin.getVsLyLeft().signum() > 0);
		// margin.setVsLyLeft(margin.getVsLyLeft().abs());
		margin.setVsLyRight(betterOfEntity.getActualMarginNetOfDiscountsLy());
		
		MixPercentage mixPercentage = new MixPercentage();
		mixPercentage.setMixActual(betterOfEntity.getActualVolume().divide(pfjTotalEntity.getActualVolume(), 3, RoundingMode.HALF_UP).multiply(BigDecimal.valueOf(100)));
		mixPercentage.setMixTarget(betterOfEntity.getTargetVolume().divide(pfjTotalEntity.getTargetVolume(), 3, RoundingMode.HALF_UP).multiply(BigDecimal.valueOf(100)));
		mixPercentage.setMixVsLy((betterOfEntity.getActualVolume().divide(pfjTotalEntity.getActualVolume(), 3, RoundingMode.HALF_UP))
									.subtract(betterOfEntity.getActualVolumeLy().divide(pfjTotalEntity.getActualVolumeLy(), 3, RoundingMode.HALF_UP))
									.divide(betterOfEntity.getActualVolumeLy().divide(pfjTotalEntity.getActualVolumeLy(), 3, RoundingMode.HALF_UP), 3, RoundingMode.HALF_UP)
									.multiply(BigDecimal.valueOf(100)));
		mixPercentage.setMixVsLyPositive(mixPercentage.getMixVsLy().signum() > 0);
		// mixPercentage.setMixVsLy(mixPercentage.getMixVsLy().abs());
		
		BetterOf betterOf = new BetterOf();
		betterOf.setGrossProfitDollars(grossProfitDollars);
		betterOf.setVolume(volume);
		betterOf.setMargin(margin);
		betterOf.setMixPercentage(mixPercentage);
		betterOf.setBuyingPerfActual(betterOfEntity.getActualBuyingPerformance());
		betterOf.setBuyingPerfTarget(betterOfEntity.getTargetBuyingPerformance());
		betterOf.setEffPumpFeeActual(betterOfEntity.getActualEffectivePumpFee());
		betterOf.setEffPumpFeeTarget(betterOfEntity.getTargetEffectivePumpFee());
		
		PFJOverviewDetail.setBetterOf(betterOf);
	}

	private void populateTotalRetail(PFJOverviewDetail PFJOverviewDetail, FctDmCompanyLevelActualVsTargetEntity totalRetailEntity, FctDmCompanyLevelActualVsTargetEntity pfjTotalEntity) {
		GrossProfitDollars grossProfitDollars = new GrossProfitDollars();
		grossProfitDollars.setHeader(totalRetailEntity.getActualProfitNetOfDiscounts());
		grossProfitDollars.setVsTgLeft(totalRetailEntity.getActualProfitNetOfDiscounts().subtract(totalRetailEntity.getTargetProfitNetOfDiscounts()));
		grossProfitDollars.setVsTgLeftPositive(grossProfitDollars.getVsTgLeft().signum() > 0);
		// grossProfitDollars.setVsTgLeft(grossProfitDollars.getVsTgLeft().abs());
		grossProfitDollars.setVsTgRight(totalRetailEntity.getTargetProfitNetOfDiscounts());
		grossProfitDollars.setVsLyLeft(totalRetailEntity.getActualProfitNetOfDiscounts().subtract(totalRetailEntity.getActualProfitNetOfDiscountsLy()));
		grossProfitDollars.setVsLyLeftPositive(grossProfitDollars.getVsLyLeft().signum() > 0);
		// grossProfitDollars.setVsLyLeft(grossProfitDollars.getVsLyLeft().abs());
		grossProfitDollars.setVsLyRight(totalRetailEntity.getActualProfitNetOfDiscountsLy());
		
		Volume volume = new Volume();
		volume.setHeader(totalRetailEntity.getActualVolume());
		volume.setVsTgLeft(totalRetailEntity.getActualVolume().subtract(totalRetailEntity.getTargetVolume()));
		volume.setVsTgLeftPositive(volume.getVsTgLeft().signum() > 0);
		// volume.setVsTgLeft(volume.getVsTgLeft().abs());
		volume.setVsTgRight(totalRetailEntity.getActualVolume().subtract(totalRetailEntity.getTargetVolume()).divide(totalRetailEntity.getTargetVolume(), 3, RoundingMode.HALF_UP).multiply(BigDecimal.valueOf(100)));
		volume.setVsLyLeft(totalRetailEntity.getActualVolume().subtract(totalRetailEntity.getActualVolumeLy()));
		volume.setVsLyLeftPositive(volume.getVsLyLeft().signum() > 0);
		// volume.setVsLyLeft(volume.getVsLyLeft().abs());
		volume.setVsLyRight(totalRetailEntity.getActualVolume().subtract(totalRetailEntity.getActualVolumeLy()).divide(totalRetailEntity.getActualVolumeLy(), 3, RoundingMode.HALF_UP).multiply(BigDecimal.valueOf(100)));
		
		// TODO Margin data population review
		Margin margin = new Margin();
		margin.setHeader(totalRetailEntity.getActualMarginNetOfDiscounts());
		margin.setVsTgLeft(totalRetailEntity.getActualMarginNetOfDiscounts().subtract(totalRetailEntity.getTargetMarginNetOfDiscounts()));
		margin.setVsTgLeftPositive(margin.getVsTgLeft().signum() > 0);
		// margin.setVsTgLeft(margin.getVsTgLeft().abs());
		margin.setVsTgRight(totalRetailEntity.getTargetMarginNetOfDiscounts());
		margin.setVsLyLeft(totalRetailEntity.getActualMarginNetOfDiscounts().subtract(totalRetailEntity.getActualMarginNetOfDiscountsLy()));
		margin.setVsLyLeftPositive(margin.getVsLyLeft().signum() > 0);
		// margin.setVsLyLeft(margin.getVsLyLeft().abs());
		margin.setVsLyRight(totalRetailEntity.getActualMarginNetOfDiscountsLy());
		
		MixPercentage mixPercentage = new MixPercentage();
		mixPercentage.setMixActual(totalRetailEntity.getActualVolume().divide(pfjTotalEntity.getActualVolume(), 3, RoundingMode.HALF_UP).multiply(BigDecimal.valueOf(100)));
		mixPercentage.setMixTarget(totalRetailEntity.getTargetVolume().divide(pfjTotalEntity.getTargetVolume(), 3, RoundingMode.HALF_UP).multiply(BigDecimal.valueOf(100)));
		mixPercentage.setMixVsLy((totalRetailEntity.getActualVolume().divide(pfjTotalEntity.getActualVolume(), 3, RoundingMode.HALF_UP))
									.subtract(totalRetailEntity.getActualVolumeLy().divide(pfjTotalEntity.getActualVolumeLy(), 3, RoundingMode.HALF_UP))
									.divide(totalRetailEntity.getActualVolumeLy().divide(pfjTotalEntity.getActualVolumeLy(), 3, RoundingMode.HALF_UP), 3, RoundingMode.HALF_UP)
									.multiply(BigDecimal.valueOf(100)));
		mixPercentage.setMixVsLyPositive(mixPercentage.getMixVsLy().signum() > 0);
		// mixPercentage.setMixVsLy(mixPercentage.getMixVsLy().abs());
		
		TotalRetail totalRetail = new TotalRetail();
		totalRetail.setGrossProfitDollars(grossProfitDollars);
		totalRetail.setVolume(volume);
		totalRetail.setMargin(margin);
		totalRetail.setMixPercentage(mixPercentage);
		
		PFJOverviewDetail.setTotalRetail(totalRetail);
	}

	private void populateRetailMinus(PFJOverviewDetail PFJOverviewDetail, FctDmCompanyLevelActualVsTargetEntity retailMinusEntity, FctDmCompanyLevelActualVsTargetEntity pfjTotalEntity) {
		GrossProfitDollars grossProfitDollars = new GrossProfitDollars();
		grossProfitDollars.setHeader(retailMinusEntity.getActualProfitNetOfDiscounts());
		grossProfitDollars.setVsTgLeft(retailMinusEntity.getActualProfitNetOfDiscounts().subtract(retailMinusEntity.getTargetProfitNetOfDiscounts()));
		grossProfitDollars.setVsTgLeftPositive(grossProfitDollars.getVsTgLeft().signum() > 0);
		// grossProfitDollars.setVsTgLeft(grossProfitDollars.getVsTgLeft().abs());
		grossProfitDollars.setVsTgRight(retailMinusEntity.getTargetProfitNetOfDiscounts());
		grossProfitDollars.setVsLyLeft(retailMinusEntity.getActualProfitNetOfDiscounts().subtract(retailMinusEntity.getActualProfitNetOfDiscountsLy()));
		grossProfitDollars.setVsLyLeftPositive(grossProfitDollars.getVsLyLeft().signum() > 0);
		// grossProfitDollars.setVsLyLeft(grossProfitDollars.getVsLyLeft().abs());
		grossProfitDollars.setVsLyRight(retailMinusEntity.getActualProfitNetOfDiscountsLy());
		
		Volume volume = new Volume();
		volume.setHeader(retailMinusEntity.getActualVolume());
		volume.setVsTgLeft(retailMinusEntity.getActualVolume().subtract(retailMinusEntity.getTargetVolume()));
		volume.setVsTgLeftPositive(volume.getVsTgLeft().signum() > 0);
		// volume.setVsTgLeft(volume.getVsTgLeft().abs());
		volume.setVsTgRight(retailMinusEntity.getActualVolume().subtract(retailMinusEntity.getTargetVolume()).divide(retailMinusEntity.getTargetVolume(), 3, RoundingMode.HALF_UP).multiply(BigDecimal.valueOf(100)));
		volume.setVsLyLeft(retailMinusEntity.getActualVolume().subtract(retailMinusEntity.getActualVolumeLy()));
		volume.setVsLyLeftPositive(volume.getVsLyLeft().signum() > 0);
		// volume.setVsLyLeft(volume.getVsLyLeft().abs());
		volume.setVsLyRight(retailMinusEntity.getActualVolume().subtract(retailMinusEntity.getActualVolumeLy()).divide(retailMinusEntity.getActualVolumeLy(), 3, RoundingMode.HALF_UP).multiply(BigDecimal.valueOf(100)));
		
		Margin margin = new Margin();
		margin.setHeader(retailMinusEntity.getActualMarginNetOfDiscounts());
		margin.setVsTgLeft(retailMinusEntity.getActualMarginNetOfDiscounts().subtract(retailMinusEntity.getTargetMarginNetOfDiscounts()));
		margin.setVsTgLeftPositive(margin.getVsTgLeft().signum() > 0);
		// margin.setVsTgLeft(margin.getVsTgLeft().abs());
		margin.setVsTgRight(retailMinusEntity.getTargetMarginNetOfDiscounts());
		margin.setVsLyLeft(retailMinusEntity.getActualMarginNetOfDiscounts().subtract(retailMinusEntity.getActualMarginNetOfDiscountsLy()));
		margin.setVsLyLeftPositive(margin.getVsLyLeft().signum() > 0);
		// margin.setVsLyLeft(margin.getVsLyLeft().abs());
		margin.setVsLyRight(retailMinusEntity.getActualMarginNetOfDiscountsLy());
		
		MixPercentage mixPercentage = new MixPercentage();
		mixPercentage.setMixActual(retailMinusEntity.getActualVolume().divide(pfjTotalEntity.getActualVolume(), 3, RoundingMode.HALF_UP).multiply(BigDecimal.valueOf(100)));
		mixPercentage.setMixTarget(retailMinusEntity.getTargetVolume().divide(pfjTotalEntity.getTargetVolume(), 3, RoundingMode.HALF_UP).multiply(BigDecimal.valueOf(100)));
		mixPercentage.setMixVsLy((retailMinusEntity.getActualVolume().divide(pfjTotalEntity.getActualVolume(), 3, RoundingMode.HALF_UP))
									.subtract(retailMinusEntity.getActualVolumeLy().divide(pfjTotalEntity.getActualVolumeLy(), 3, RoundingMode.HALF_UP))
									.divide(retailMinusEntity.getActualVolumeLy().divide(pfjTotalEntity.getActualVolumeLy(), 3, RoundingMode.HALF_UP), 3, RoundingMode.HALF_UP)
									.multiply(BigDecimal.valueOf(100)));
		mixPercentage.setMixVsLyPositive(mixPercentage.getMixVsLy().signum() > 0);
		// mixPercentage.setMixVsLy(mixPercentage.getMixVsLy().abs());
		
		RetailMinus retailMinus = new RetailMinus();
		retailMinus.setGrossProfitDollars(grossProfitDollars);
		retailMinus.setVolume(volume);
		retailMinus.setMargin(margin);
		retailMinus.setMixPercentage(mixPercentage);
		retailMinus.setRmDiscountActual(retailMinusEntity.getActualEffectiveRetailMinusRate());
		retailMinus.setRmDiscountTarget(retailMinusEntity.getTargetEffectiveRetailMinusRate());
		
		PFJOverviewDetail.setRetailMinus(retailMinus);
	}

	private void populateFunded(PFJOverviewDetail PFJOverviewDetail, FctDmCompanyLevelActualVsTargetEntity fundedEntity, FctDmCompanyLevelActualVsTargetEntity pfjTotalEntity) {
		GrossProfitDollars grossProfitDollars = new GrossProfitDollars();
		grossProfitDollars.setHeader(fundedEntity.getActualProfitNetOfDiscounts());
		grossProfitDollars.setVsTgLeft(fundedEntity.getActualProfitNetOfDiscounts().subtract(fundedEntity.getTargetProfitNetOfDiscounts()));
		grossProfitDollars.setVsTgLeftPositive(grossProfitDollars.getVsTgLeft().signum() > 0);
		// grossProfitDollars.setVsTgLeft(grossProfitDollars.getVsTgLeft().abs());
		grossProfitDollars.setVsTgRight(fundedEntity.getTargetProfitNetOfDiscounts());
		grossProfitDollars.setVsLyLeft(fundedEntity.getActualProfitNetOfDiscounts().subtract(fundedEntity.getActualProfitNetOfDiscountsLy()));
		grossProfitDollars.setVsLyLeftPositive(grossProfitDollars.getVsLyLeft().signum() > 0);
		// grossProfitDollars.setVsLyLeft(grossProfitDollars.getVsLyLeft().abs());
		grossProfitDollars.setVsLyRight(fundedEntity.getActualProfitNetOfDiscountsLy());
		
		Volume volume = new Volume();
		volume.setHeader(fundedEntity.getActualVolume());
		volume.setVsTgLeft(fundedEntity.getActualVolume().subtract(fundedEntity.getTargetVolume()));
		volume.setVsTgLeftPositive(volume.getVsTgLeft().signum() > 0);
		// volume.setVsTgLeft(volume.getVsTgLeft().abs());
		volume.setVsTgRight(fundedEntity.getActualVolume().subtract(fundedEntity.getTargetVolume()).divide(fundedEntity.getTargetVolume(), 3, RoundingMode.HALF_UP).multiply(BigDecimal.valueOf(100)));
		volume.setVsLyLeft(fundedEntity.getActualVolume().subtract(fundedEntity.getActualVolumeLy()));
		volume.setVsLyLeftPositive(volume.getVsLyLeft().signum() > 0);
		// volume.setVsLyLeft(volume.getVsLyLeft().abs());
		volume.setVsLyRight(fundedEntity.getActualVolume().subtract(fundedEntity.getActualVolumeLy()).divide(fundedEntity.getActualVolumeLy(), 3, RoundingMode.HALF_UP).multiply(BigDecimal.valueOf(100)));
		
		// TODO Margin data population review
		Margin margin = new Margin();
		margin.setHeader(fundedEntity.getActualMarginNetOfDiscounts());
		margin.setVsTgLeft(fundedEntity.getActualMarginNetOfDiscounts().subtract(fundedEntity.getTargetMarginNetOfDiscounts()));
		margin.setVsTgLeftPositive(margin.getVsTgLeft().signum() > 0);
		// margin.setVsTgLeft(margin.getVsTgLeft().abs());
		margin.setVsTgRight(fundedEntity.getTargetMarginNetOfDiscounts());
		margin.setVsLyLeft(fundedEntity.getActualMarginNetOfDiscounts().subtract(fundedEntity.getActualMarginNetOfDiscountsLy()));
		margin.setVsLyLeftPositive(margin.getVsLyLeft().signum() > 0);
		// margin.setVsLyLeft(margin.getVsLyLeft().abs());
		margin.setVsLyRight(fundedEntity.getActualMarginNetOfDiscountsLy());
		
		MixPercentage mixPercentage = new MixPercentage();
		mixPercentage.setMixActual(fundedEntity.getActualVolume().divide(pfjTotalEntity.getActualVolume(), 3, RoundingMode.HALF_UP).multiply(BigDecimal.valueOf(100)));
		mixPercentage.setMixTarget(fundedEntity.getTargetVolume().divide(pfjTotalEntity.getTargetVolume(), 3, RoundingMode.HALF_UP).multiply(BigDecimal.valueOf(100)));
		mixPercentage.setMixVsLy((fundedEntity.getActualVolume().divide(pfjTotalEntity.getActualVolume(), 3, RoundingMode.HALF_UP))
									.subtract(fundedEntity.getActualVolumeLy().divide(pfjTotalEntity.getActualVolumeLy(), 3, RoundingMode.HALF_UP))
									.divide(fundedEntity.getActualVolumeLy().divide(pfjTotalEntity.getActualVolumeLy(), 3, RoundingMode.HALF_UP), 3, RoundingMode.HALF_UP)
									.multiply(BigDecimal.valueOf(100)));
		mixPercentage.setMixVsLyPositive(mixPercentage.getMixVsLy().signum() > 0);
		// mixPercentage.setMixVsLy(mixPercentage.getMixVsLy().abs());
		
		Funded funded = new Funded();
		funded.setGrossProfitDollars(grossProfitDollars);
		funded.setVolume(volume);
		funded.setMargin(margin);
		funded.setMixPercentage(mixPercentage);
		
		PFJOverviewDetail.setFunded(funded);
	}

	private void populateCCC(PFJOverviewDetail PFJOverviewDetail, FctDmCompanyLevelActualVsTargetEntity cccEntity, FctDmCompanyLevelActualVsTargetEntity pfjTotalEntity) {
		GrossProfitDollars grossProfitDollars = new GrossProfitDollars();
		grossProfitDollars.setHeader(cccEntity.getActualProfitNetOfDiscounts());
		grossProfitDollars.setVsTgLeft(cccEntity.getActualProfitNetOfDiscounts().subtract(cccEntity.getTargetProfitNetOfDiscounts()));
		grossProfitDollars.setVsTgLeftPositive(grossProfitDollars.getVsTgLeft().signum() > 0);
		// grossProfitDollars.setVsTgLeft(grossProfitDollars.getVsTgLeft().abs());
		grossProfitDollars.setVsTgRight(cccEntity.getTargetProfitNetOfDiscounts());
		grossProfitDollars.setVsLyLeft(cccEntity.getActualProfitNetOfDiscounts().subtract(cccEntity.getActualProfitNetOfDiscountsLy()));
		grossProfitDollars.setVsLyLeftPositive(grossProfitDollars.getVsLyLeft().signum() > 0);
		// grossProfitDollars.setVsLyLeft(grossProfitDollars.getVsLyLeft().abs());
		grossProfitDollars.setVsLyRight(cccEntity.getActualProfitNetOfDiscountsLy());
		
		Volume volume = new Volume();
		volume.setHeader(cccEntity.getActualVolume());
		volume.setVsTgLeft(cccEntity.getActualVolume().subtract(cccEntity.getTargetVolume()));
		volume.setVsTgLeftPositive(volume.getVsTgLeft().signum() > 0);
		// volume.setVsTgLeft(volume.getVsTgLeft().abs());
		volume.setVsTgRight(cccEntity.getActualVolume().subtract(cccEntity.getTargetVolume()).divide(cccEntity.getTargetVolume(), 3, RoundingMode.HALF_UP).multiply(BigDecimal.valueOf(100)));
		volume.setVsLyLeft(cccEntity.getActualVolume().subtract(cccEntity.getActualVolumeLy()));
		volume.setVsLyLeftPositive(volume.getVsLyLeft().signum() > 0);
		// volume.setVsLyLeft(volume.getVsLyLeft().abs());
		volume.setVsLyRight(cccEntity.getActualVolume().subtract(cccEntity.getActualVolumeLy()).divide(cccEntity.getActualVolumeLy(), 3, RoundingMode.HALF_UP).multiply(BigDecimal.valueOf(100)));
		
		// TODO Margin data population review
		Margin margin = new Margin();
		margin.setHeader(cccEntity.getActualMarginNetOfDiscounts());
		margin.setVsTgLeft(cccEntity.getActualMarginNetOfDiscounts().subtract(cccEntity.getTargetMarginNetOfDiscounts()));
		margin.setVsTgLeftPositive(margin.getVsTgLeft().signum() > 0);
		// margin.setVsTgLeft(margin.getVsTgLeft().abs());
		margin.setVsTgRight(cccEntity.getTargetMarginNetOfDiscounts());
		margin.setVsLyLeft(cccEntity.getActualMarginNetOfDiscounts().subtract(cccEntity.getActualMarginNetOfDiscountsLy()));
		margin.setVsLyLeftPositive(margin.getVsLyLeft().signum() > 0);
		// margin.setVsLyLeft(margin.getVsLyLeft().abs());
		margin.setVsLyRight(cccEntity.getActualMarginNetOfDiscountsLy());
		
		MixPercentage mixPercentage = new MixPercentage();
		mixPercentage.setMixActual(cccEntity.getActualVolume().divide(pfjTotalEntity.getActualVolume(), 3, RoundingMode.HALF_UP).multiply(BigDecimal.valueOf(100)));
		mixPercentage.setMixTarget(cccEntity.getTargetVolume().divide(pfjTotalEntity.getTargetVolume(), 3, RoundingMode.HALF_UP).multiply(BigDecimal.valueOf(100)));
		mixPercentage.setMixVsLy((cccEntity.getActualVolume().divide(pfjTotalEntity.getActualVolume(), 3, RoundingMode.HALF_UP))
									.subtract(cccEntity.getActualVolumeLy().divide(pfjTotalEntity.getActualVolumeLy(), 3, RoundingMode.HALF_UP))
									.divide(cccEntity.getActualVolumeLy().divide(pfjTotalEntity.getActualVolumeLy(), 3, RoundingMode.HALF_UP), 3, RoundingMode.HALF_UP)
									.multiply(BigDecimal.valueOf(100)));
		mixPercentage.setMixVsLyPositive(mixPercentage.getMixVsLy().signum() > 0);
		// mixPercentage.setMixVsLy(mixPercentage.getMixVsLy().abs());
		
		CCC ccc = new CCC();
		ccc.setGrossProfitDollars(grossProfitDollars);
		ccc.setVolume(volume);
		ccc.setMargin(margin);
		ccc.setMixPercentage(mixPercentage);
		
		PFJOverviewDetail.setCcc(ccc);
	}

	private List<FctDmCompanyLevelActualVsTargetEntity> findEntitiesByTemporalPeriod(String temporalPeriod) {
		return (List<FctDmCompanyLevelActualVsTargetEntity>) fctDmCompanyLevelActualVsTargetRepo
				.findAll(QFctDmCompanyLevelActualVsTargetEntity.fctDmCompanyLevelActualVsTargetEntity.fctDmCompanyLevelActualVsTargetId.temporalPeriod.eq(temporalPeriod));
	}
}