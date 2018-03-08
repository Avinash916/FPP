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
import com.pilot.main.pilotservice.util.PFJOverviewUtil;

@Service
public class PFJOverviewService {

	private static final Logger logger = LoggerFactory.getLogger(PFJOverviewService.class);

	@Autowired
	FctDmCompanyLevelActualVsTargetRepo fctDmCompanyLevelActualVsTargetRepo;

	@Autowired
	PFJOverviewUtil pfjOverviewUtil;

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

		/*
		 * UI data generation for LCM filter
		 */
		List<FctDmCompanyLevelActualVsTargetEntity> lcmEntities = findEntitiesByTemporalPeriod("LCM");
		logger.info("Found LCM type rows ---> " + lcmEntities.size());
		PFJOverview pfjOverviewDetailsLCM = populatePFJOverviewDetail(lcmEntities);
		pfjOverviewDetailsLCM.setTemporalPeriod("LCM");
		pfjOverviewDetailsLCM.setDimPlPeriodDateId(dateTime.format(outputformat));

		/*
		 * UI data generation for LCYTD filter
		 */
		List<FctDmCompanyLevelActualVsTargetEntity> lcytdEntities = findEntitiesByTemporalPeriod("LCYTD");
		logger.info("Found LCYTD type rows ---> " + lcytdEntities.size());
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

		PFJTotal pfjTotal = new PFJTotal();
		pfjTotal.setGrossProfitDollars(grossProfitDollars);
		pfjTotal.setVolume(volume);
		pfjTotal.setMargin(margin);
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

		BetterOf betterOf = new BetterOf();
		betterOf.setGrossProfitDollars(grossProfitDollars);
		betterOf.setVolume(volume);
		betterOf.setMargin(margin);
		betterOf.setMixPercentage(mixPercentage);
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

		TotalRetail totalRetail = new TotalRetail();
		totalRetail.setGrossProfitDollars(grossProfitDollars);
		totalRetail.setVolume(volume);
		totalRetail.setMargin(margin);
		totalRetail.setMixPercentage(mixPercentage);

		pfjOverviewDetails.setTotalRetail(totalRetail);
	}

	private void populateRetailMinus(PFJOverview pfjOverviewDetails, FctDmCompanyLevelActualVsTargetEntity retailMinusEntity,
			FctDmCompanyLevelActualVsTargetEntity pfjTotalEntity) {
		GrossProfitDollars grossProfitDollars = populateGP$Tile(retailMinusEntity);
		Volume volume = populateVolumeTile(retailMinusEntity);
		Margin margin = populateMarginTile(retailMinusEntity);
		MixPercentage mixPercentage = populateMixPercentageTile(retailMinusEntity, pfjTotalEntity);

		RetailMinus retailMinus = new RetailMinus();
		retailMinus.setGrossProfitDollars(grossProfitDollars);
		retailMinus.setVolume(volume);
		retailMinus.setMargin(margin);
		retailMinus.setMixPercentage(mixPercentage);
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

		Funded funded = new Funded();
		funded.setGrossProfitDollars(grossProfitDollars);
		funded.setVolume(volume);
		funded.setMargin(margin);
		funded.setMixPercentage(mixPercentage);

		pfjOverviewDetails.setFunded(funded);
	}

	private void populateCCC(PFJOverview pfjOverviewDetails, FctDmCompanyLevelActualVsTargetEntity cccEntity,
			FctDmCompanyLevelActualVsTargetEntity pfjTotalEntity) {
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
		volume.setVsTgRight(PFJOverviewUtil.formatWithoutMillion(
				pfjOverviewEntity.getActualVolume().subtract(pfjOverviewEntity.getTargetVolume())
						.divide(pfjOverviewEntity.getTargetVolume(), 6, RoundingMode.HALF_UP)
						.multiply(BigDecimal.valueOf(100))));

		BigDecimal vsLyLeft = pfjOverviewEntity.getActualVolume().subtract(pfjOverviewEntity.getActualVolumeLy());
		volume.setVsLyLeft(PFJOverviewUtil.formatWithMillion(vsLyLeft.abs()));
		volume.setVsLyLeftPositive(vsLyLeft.signum() > 0);
		volume.setVsLyRight(PFJOverviewUtil.formatWithoutMillion(
				pfjOverviewEntity.getActualVolume().subtract(pfjOverviewEntity.getActualVolumeLy())
						.divide(pfjOverviewEntity.getActualVolumeLy(), 6, RoundingMode.HALF_UP)
						.multiply(BigDecimal.valueOf(100))));

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
	}
}