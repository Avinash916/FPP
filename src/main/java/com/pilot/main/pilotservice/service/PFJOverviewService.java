package com.pilot.main.pilotservice.service;

import java.math.BigDecimal;
import java.math.RoundingMode;
<<<<<<< HEAD
=======
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
>>>>>>> ssointegration
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
<<<<<<< HEAD
import com.pilot.main.pilotservice.pojo.PFJOverviewDetail;
=======
>>>>>>> ssointegration
import com.pilot.main.pilotservice.pojo.Funded;
import com.pilot.main.pilotservice.pojo.GrossProfitDollars;
import com.pilot.main.pilotservice.pojo.Margin;
import com.pilot.main.pilotservice.pojo.MixPercentage;
<<<<<<< HEAD
=======
import com.pilot.main.pilotservice.pojo.PFJOverview;
>>>>>>> ssointegration
import com.pilot.main.pilotservice.pojo.PFJTotal;
import com.pilot.main.pilotservice.pojo.RetailMinus;
import com.pilot.main.pilotservice.pojo.TotalRetail;
import com.pilot.main.pilotservice.pojo.Volume;
<<<<<<< HEAD
=======
import com.pilot.main.pilotservice.util.PFJOverviewUtil;
>>>>>>> ssointegration

@Service
public class PFJOverviewService {

	private static final Logger logger = LoggerFactory.getLogger(PFJOverviewService.class);

	@Autowired
	FctDmCompanyLevelActualVsTargetRepo fctDmCompanyLevelActualVsTargetRepo;

<<<<<<< HEAD
	public List<PFJOverviewDetail> fetchPFJOverviewDetails() {
=======
	@Autowired
	PFJOverviewUtil pfjOverviewUtil;

	public List<PFJOverview> fetchPFJOverviewDetails() {
>>>>>>> ssointegration
		logger.info("---in Customer Pricing Service ---");

		/*
		 * UI data generation for MTD filter
		 */
		List<FctDmCompanyLevelActualVsTargetEntity> mtdEntities = findEntitiesByTemporalPeriod("MTD");
		logger.info("Found MTD type rows ---> " + mtdEntities.size());
<<<<<<< HEAD
		PFJOverviewDetail PFJOverviewDetailMTD = populatePFJOverviewDetail(mtdEntities);
		PFJOverviewDetailMTD.setTemporalPeriod("MTD");
		PFJOverviewDetailMTD.setDimPlPeriodDateId(mtdEntities.get(0).getDimPlPeriodDateId());
=======
		PFJOverview pfjOverviewDetailsMTD = populatePFJOverviewDetail(mtdEntities);
		pfjOverviewDetailsMTD.setTemporalPeriod("MTD");

		String datestr = String.valueOf(mtdEntities.get(0).getDimPlPeriodDateId());
		DateTimeFormatter inputformat = DateTimeFormatter.ofPattern("yyyyMMdd");
		LocalDate dateTime = LocalDate.parse(datestr, inputformat);
		
		DateTimeFormatter outputformat = DateTimeFormatter.ofPattern("MMMM yyyy");
		
		pfjOverviewDetailsMTD.setDimPlPeriodDateId(dateTime.format(outputformat));
>>>>>>> ssointegration

		/*
		 * UI data generation for LCM filter
		 */
		List<FctDmCompanyLevelActualVsTargetEntity> lcmEntities = findEntitiesByTemporalPeriod("LCM");
		logger.info("Found LCM type rows ---> " + lcmEntities.size());
<<<<<<< HEAD
		PFJOverviewDetail PFJOverviewDetailLCM = populatePFJOverviewDetail(lcmEntities);
		PFJOverviewDetailLCM.setTemporalPeriod("LCM");
		PFJOverviewDetailLCM.setDimPlPeriodDateId(lcmEntities.get(0).getDimPlPeriodDateId());
=======
		PFJOverview pfjOverviewDetailsLCM = populatePFJOverviewDetail(lcmEntities);
		pfjOverviewDetailsLCM.setTemporalPeriod("LCM");
		pfjOverviewDetailsLCM.setDimPlPeriodDateId(dateTime.format(outputformat));
>>>>>>> ssointegration

		/*
		 * UI data generation for LCYTD filter
		 */
		List<FctDmCompanyLevelActualVsTargetEntity> lcytdEntities = findEntitiesByTemporalPeriod("LCYTD");
		logger.info("Found LCYTD type rows ---> " + lcytdEntities.size());
<<<<<<< HEAD
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
=======
		PFJOverview pfjOverviewDetailsLCYTD = populatePFJOverviewDetail(lcytdEntities);
		pfjOverviewDetailsLCYTD.setTemporalPeriod("LCYTD");
		pfjOverviewDetailsLCYTD.setDimPlPeriodDateId(dateTime.format(outputformat));

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
>>>>>>> ssointegration
		
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
<<<<<<< HEAD
			
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
		
=======

			if (fctDmCompanyLevelActualVsTargetEntity.getFctDmCompanyLevelActualVsTargetId().getMixOfBusiness().equalsIgnoreCase("TOTAL")) {
				pfjTotalEntity = fctDmCompanyLevelActualVsTargetEntity;
				logger.debug("PFJ Total Entity ---> " + pfjTotalEntity);
			} else if (fctDmCompanyLevelActualVsTargetEntity.getFctDmCompanyLevelActualVsTargetId().getMixOfBusiness().equalsIgnoreCase("BETTER OF")) {
				betterOfEntity = fctDmCompanyLevelActualVsTargetEntity;
				logger.debug("PFJ Total Entity ---> " + betterOfEntity);
			} else if (fctDmCompanyLevelActualVsTargetEntity.getFctDmCompanyLevelActualVsTargetId().getMixOfBusiness().equalsIgnoreCase("TOTAL RETAIL")) {
				totalRetailEntity = fctDmCompanyLevelActualVsTargetEntity;
				logger.debug("PFJ Total Entity ---> " + totalRetailEntity);
			} else if (fctDmCompanyLevelActualVsTargetEntity.getFctDmCompanyLevelActualVsTargetId().getMixOfBusiness().equalsIgnoreCase("RETAIL MINUS")) {
				retailMinusEntity = fctDmCompanyLevelActualVsTargetEntity;
				logger.debug("PFJ Total Entity ---> " + retailMinusEntity);
			} else if (fctDmCompanyLevelActualVsTargetEntity.getFctDmCompanyLevelActualVsTargetId().getMixOfBusiness().equalsIgnoreCase("FUNDED")) {
				fundedEntity = fctDmCompanyLevelActualVsTargetEntity;
				logger.debug("PFJ Total Entity ---> " + fundedEntity);
			} else if (fctDmCompanyLevelActualVsTargetEntity.getFctDmCompanyLevelActualVsTargetId().getMixOfBusiness().equalsIgnoreCase("CCC")) {
				cccEntity = fctDmCompanyLevelActualVsTargetEntity;
				logger.debug("PFJ Total Entity ---> " + cccEntity);
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

>>>>>>> ssointegration
		PFJTotal pfjTotal = new PFJTotal();
		pfjTotal.setGrossProfitDollars(grossProfitDollars);
		pfjTotal.setVolume(volume);
		pfjTotal.setMargin(margin);
<<<<<<< HEAD
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
		
=======
		pfjTotal.setTotalGAL(PFJOverviewUtil.formatWithMillion(pfjTotalEntity.getActualVolume()));
		pfjTotal.setTotalTarget(PFJOverviewUtil.formatWithMillion(pfjTotalEntity.getTargetVolume()));

		pfjOverviewDetails.setpFJTotal(pfjTotal);
	}

	private void populateBetterOf(PFJOverview pfjOverviewDetails, FctDmCompanyLevelActualVsTargetEntity betterOfEntity,
			FctDmCompanyLevelActualVsTargetEntity pfjTotalEntity) {
		GrossProfitDollars grossProfitDollars = populateGP$Tile(betterOfEntity);
		Volume volume = populateVolumeTile(betterOfEntity);
		Margin margin = populateMarginTile(betterOfEntity);
		MixPercentage mixPercentage = populateMixPercentageTile(betterOfEntity, pfjTotalEntity);

>>>>>>> ssointegration
		BetterOf betterOf = new BetterOf();
		betterOf.setGrossProfitDollars(grossProfitDollars);
		betterOf.setVolume(volume);
		betterOf.setMargin(margin);
		betterOf.setMixPercentage(mixPercentage);
<<<<<<< HEAD
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
		
=======
		betterOf.setBuyingPerfActual(PFJOverviewUtil.formatWithoutMillion(betterOfEntity.getActualBuyingPerformance()));
		betterOf.setBuyingPerfTarget(PFJOverviewUtil.formatWithoutMillion(betterOfEntity.getTargetBuyingPerformance()));
		betterOf.setEffPumpFeeActual(PFJOverviewUtil.formatWithoutMillion(betterOfEntity.getActualEffectivePumpFee()));
		betterOf.setEffPumpFeeTarget(PFJOverviewUtil.formatWithoutMillion(betterOfEntity.getTargetEffectivePumpFee()));

		pfjOverviewDetails.setBetterOf(betterOf);
	}

	private void populateTotalRetail(PFJOverview pfjOverviewDetails, FctDmCompanyLevelActualVsTargetEntity totalRetailEntity,
			FctDmCompanyLevelActualVsTargetEntity pfjTotalEntity) {
		GrossProfitDollars grossProfitDollars = populateGP$Tile(totalRetailEntity);
		Volume volume = populateVolumeTile(totalRetailEntity);
		Margin margin = populateMarginTile(totalRetailEntity);
		MixPercentage mixPercentage = populateMixPercentageTile(totalRetailEntity, pfjTotalEntity);

>>>>>>> ssointegration
		TotalRetail totalRetail = new TotalRetail();
		totalRetail.setGrossProfitDollars(grossProfitDollars);
		totalRetail.setVolume(volume);
		totalRetail.setMargin(margin);
		totalRetail.setMixPercentage(mixPercentage);
<<<<<<< HEAD
		
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
		
=======

		pfjOverviewDetails.setTotalRetail(totalRetail);
	}

	private void populateRetailMinus(PFJOverview pfjOverviewDetails, FctDmCompanyLevelActualVsTargetEntity retailMinusEntity,
			FctDmCompanyLevelActualVsTargetEntity pfjTotalEntity) {
		GrossProfitDollars grossProfitDollars = populateGP$Tile(retailMinusEntity);
		Volume volume = populateVolumeTile(retailMinusEntity);
		Margin margin = populateMarginTile(retailMinusEntity);
		MixPercentage mixPercentage = populateMixPercentageTile(retailMinusEntity, pfjTotalEntity);

>>>>>>> ssointegration
		RetailMinus retailMinus = new RetailMinus();
		retailMinus.setGrossProfitDollars(grossProfitDollars);
		retailMinus.setVolume(volume);
		retailMinus.setMargin(margin);
		retailMinus.setMixPercentage(mixPercentage);
<<<<<<< HEAD
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
		
=======
		retailMinus.setRmDiscountActual(PFJOverviewUtil.formatWithoutMillion(retailMinusEntity.getActualEffectiveRetailMinusRate()));
		retailMinus.setRmDiscountTarget(PFJOverviewUtil.formatWithoutMillion(retailMinusEntity.getTargetEffectiveRetailMinusRate()));

		pfjOverviewDetails.setRetailMinus(retailMinus);
	}

	private void populateFunded(PFJOverview pfjOverviewDetails, FctDmCompanyLevelActualVsTargetEntity fundedEntity,
			FctDmCompanyLevelActualVsTargetEntity pfjTotalEntity) {
		GrossProfitDollars grossProfitDollars = populateGP$Tile(fundedEntity);
		Volume volume = populateVolumeTile(fundedEntity);
		Margin margin = populateMarginTile(fundedEntity);
		MixPercentage mixPercentage = populateMixPercentageTile(fundedEntity, pfjTotalEntity);

>>>>>>> ssointegration
		Funded funded = new Funded();
		funded.setGrossProfitDollars(grossProfitDollars);
		funded.setVolume(volume);
		funded.setMargin(margin);
		funded.setMixPercentage(mixPercentage);
<<<<<<< HEAD
		
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
		
=======

		pfjOverviewDetails.setFunded(funded);
	}

	private void populateCCC(PFJOverview pfjOverviewDetails, FctDmCompanyLevelActualVsTargetEntity cccEntity,
			FctDmCompanyLevelActualVsTargetEntity pfjTotalEntity) {
		GrossProfitDollars grossProfitDollars = populateGP$Tile(cccEntity);
		Volume volume = populateVolumeTile(cccEntity);
		Margin margin = populateMarginTile(cccEntity);
		MixPercentage mixPercentage = populateMixPercentageTile(cccEntity, pfjTotalEntity);

>>>>>>> ssointegration
		CCC ccc = new CCC();
		ccc.setGrossProfitDollars(grossProfitDollars);
		ccc.setVolume(volume);
		ccc.setMargin(margin);
		ccc.setMixPercentage(mixPercentage);
<<<<<<< HEAD
		
		PFJOverviewDetail.setCcc(ccc);
	}

	private List<FctDmCompanyLevelActualVsTargetEntity> findEntitiesByTemporalPeriod(String temporalPeriod) {
		return (List<FctDmCompanyLevelActualVsTargetEntity>) fctDmCompanyLevelActualVsTargetRepo
				.findAll(QFctDmCompanyLevelActualVsTargetEntity.fctDmCompanyLevelActualVsTargetEntity.fctDmCompanyLevelActualVsTargetId.temporalPeriod.eq(temporalPeriod));
=======

		pfjOverviewDetails.setCcc(ccc);
	}

	private GrossProfitDollars populateGP$Tile(FctDmCompanyLevelActualVsTargetEntity pfjOverviewEntity) {
		GrossProfitDollars grossProfitDollars = new GrossProfitDollars();

		grossProfitDollars.setHeader(PFJOverviewUtil.formatWithMillion(pfjOverviewEntity.getActualProfitNetOfDiscounts()));

		BigDecimal vsTgLeft = pfjOverviewEntity.getActualProfitNetOfDiscounts().subtract(pfjOverviewEntity.getTargetProfitNetOfDiscounts());
		grossProfitDollars.setVsTgLeft(PFJOverviewUtil.formatWithMillion(vsTgLeft.abs()));
		grossProfitDollars.setVsTgLeftPositive(vsTgLeft.signum() > 0);
		grossProfitDollars.setVsTgRight(PFJOverviewUtil.formatWithMillion(pfjOverviewEntity.getTargetProfitNetOfDiscounts()));

		BigDecimal vsLyLeft = pfjOverviewEntity.getActualProfitNetOfDiscounts().subtract(pfjOverviewEntity.getActualProfitNetOfDiscountsLy());
		grossProfitDollars.setVsLyLeft(PFJOverviewUtil.formatWithMillion(vsLyLeft.abs()));
		grossProfitDollars.setVsLyLeftPositive(vsLyLeft.signum() > 0);
		grossProfitDollars.setVsLyRight(PFJOverviewUtil.formatWithMillion(pfjOverviewEntity.getActualProfitNetOfDiscountsLy()));

		return grossProfitDollars;
	}

	private Volume populateVolumeTile(FctDmCompanyLevelActualVsTargetEntity pfjOverviewEntity) {
		Volume volume = new Volume();

		volume.setHeader(PFJOverviewUtil.formatWithMillion(pfjOverviewEntity.getActualVolume()));

		BigDecimal vsTgLeft = pfjOverviewEntity.getActualVolume().subtract(pfjOverviewEntity.getTargetVolume());
		volume.setVsTgLeft(PFJOverviewUtil.formatWithMillion(vsTgLeft.abs()));
		volume.setVsTgLeftPositive(vsTgLeft.signum() > 0);
		BigDecimal vsTgRight = pfjOverviewEntity.getActualVolume().subtract(pfjOverviewEntity.getTargetVolume())
								.divide(pfjOverviewEntity.getTargetVolume(), 6, RoundingMode.HALF_UP)
								.multiply(BigDecimal.valueOf(100))
								.setScale(1, RoundingMode.HALF_UP);
		volume.setVsTgRight(vsTgRight.toString());

		BigDecimal vsLyLeft = pfjOverviewEntity.getActualVolume().subtract(pfjOverviewEntity.getActualVolumeLy());
		volume.setVsLyLeft(PFJOverviewUtil.formatWithMillion(vsLyLeft.abs()));
		volume.setVsLyLeftPositive(vsLyLeft.signum() > 0);
		BigDecimal vsLyRight = pfjOverviewEntity.getActualVolume().subtract(pfjOverviewEntity.getActualVolumeLy())
								.divide(pfjOverviewEntity.getActualVolumeLy(), 6, RoundingMode.HALF_UP)
								.multiply(BigDecimal.valueOf(100))
								.setScale(1, RoundingMode.HALF_UP);
		volume.setVsLyRight(vsLyRight.toString());

		return volume;
	}

	private Margin populateMarginTile(FctDmCompanyLevelActualVsTargetEntity pfjOverviewEntity) {
		Margin margin = new Margin();
		margin.setHeader(PFJOverviewUtil.formatWithoutMillion(pfjOverviewEntity.getActualMarginNetOfDiscounts()));

		BigDecimal vsTgLeft = pfjOverviewEntity.getActualMarginNetOfDiscounts().subtract(pfjOverviewEntity.getTargetMarginNetOfDiscounts());
		margin.setVsTgLeft(PFJOverviewUtil.formatWithoutMillion(vsTgLeft.abs()));
		margin.setVsTgLeftPositive(vsTgLeft.signum() > 0);
		margin.setVsTgRight(PFJOverviewUtil.formatWithoutMillion(pfjOverviewEntity.getTargetMarginNetOfDiscounts()));

		BigDecimal vsLyLeft = pfjOverviewEntity.getActualMarginNetOfDiscounts().subtract(pfjOverviewEntity.getActualMarginNetOfDiscountsLy());
		margin.setVsLyLeft(PFJOverviewUtil.formatWithoutMillion(vsLyLeft.abs()));
		margin.setVsLyLeftPositive(vsLyLeft.signum() > 0);
		margin.setVsLyRight(PFJOverviewUtil.formatWithoutMillion(pfjOverviewEntity.getActualMarginNetOfDiscountsLy()));

		return margin;
	}

	private MixPercentage populateMixPercentageTile(FctDmCompanyLevelActualVsTargetEntity pfjOverviewEntity,
			FctDmCompanyLevelActualVsTargetEntity pfjTotalEntity) {
		MixPercentage mixPercentage = new MixPercentage();

		BigDecimal mixActual = pfjOverviewEntity.getActualVolume()
								.divide(pfjTotalEntity.getActualVolume(), 3, RoundingMode.HALF_UP)
								.multiply(BigDecimal.valueOf(100))
								.setScale(1, RoundingMode.HALF_UP);
		mixPercentage.setMixActual(mixActual.toString());

		BigDecimal mixTarget = pfjOverviewEntity.getTargetVolume()
								.divide(pfjTotalEntity.getTargetVolume(), 3, RoundingMode.HALF_UP)
								.multiply(BigDecimal.valueOf(100))
								.setScale(1, RoundingMode.HALF_UP);
		mixPercentage.setMixTarget(mixTarget.toString());

		BigDecimal mixVsLy = (pfjOverviewEntity.getActualVolume().divide(pfjTotalEntity.getActualVolume(), 6, RoundingMode.HALF_UP))
								.subtract(pfjOverviewEntity.getActualVolumeLy().divide(pfjTotalEntity.getActualVolumeLy(), 6, RoundingMode.HALF_UP))
								.divide(pfjOverviewEntity.getActualVolumeLy().divide(pfjTotalEntity.getActualVolumeLy(), 6, RoundingMode.HALF_UP), 3, RoundingMode.HALF_UP)
								.multiply(BigDecimal.valueOf(100))
								.setScale(1, RoundingMode.HALF_UP);
		mixPercentage.setMixVsLy(mixVsLy.abs().toString());
		mixPercentage.setMixVsLyPositive(mixVsLy.signum() > 0);

		return mixPercentage;
>>>>>>> ssointegration
	}
}