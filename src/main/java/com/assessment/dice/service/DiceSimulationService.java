package com.assessment.dice.service;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.assessment.dice.entity.DiceRelativeDistribution;
import com.assessment.dice.entity.DiceSimulation;
import com.assessment.dice.entity.DiceSimulationDetails;
import com.assessment.dice.model.DiceRelativeDistributionDto;
import com.assessment.dice.repository.DiceRelativeDistributionRepo;
import com.assessment.dice.repository.DiceSimulationDetailsRepo;
import com.assessment.dice.repository.DiceSimulationRepo;
import com.assessment.dice.utils.DiceObjectMappingUtility;

 
/**
 * The Class DiceSimulationService.
 * @author vikram.chauhan
 */
@Service
public class DiceSimulationService {
	
	/** The dice simulation repo. */
	@Autowired
	private DiceSimulationRepo diceSimulationRepo;

	/** The dice simulation details repo. */
	@Autowired
	private DiceSimulationDetailsRepo diceSimulationDetailsRepo;

	/** The dice relative distribution repo. */
	@Autowired
	private DiceRelativeDistributionRepo diceRelativeDistributionRepo;
	
	/** The dice object mapping utility. */
	@Autowired
	private DiceObjectMappingUtility diceObjectMappingUtility;
	
	/** The Constant log. */
	private static final org.slf4j.Logger log =  org.slf4j.LoggerFactory.getLogger(DiceSimulationService.class);
	/**
	 * Execute dice distribution.
	 *
	 * @param numberOfDice the number of dice
	 * @param diceSides the dice sides
	 * @param totNumRolls the tot num rolls
	 * @return the list
	 */
	public List<Map<Integer, Integer>> executeDiceDistribution(Integer numberOfDice, Integer diceSides, Integer totNumRolls) {
		int simulationId = saveDiceSimulationInput(numberOfDice, diceSides, totNumRolls);
		log.info("simulationId : " + simulationId);
		//Roll dice for total Number Rolls times
		for (int rollNum = 1; rollNum <= totNumRolls; rollNum++) {
			rollDice(simulationId, numberOfDice, diceSides, rollNum);
		}
		List<Map<Integer, Integer>> totalRollCount = diceSimulationDetailsRepo.findTotalRollCount(simulationId);
		return totalRollCount;
	}

	/**
	 * Save dice simulation input.
	 *
	 * @param numberOfDice the number of dice
	 * @param diceSides the dice sides
	 * @param totNumRolls the tot num rolls
	 * @return the int
	 */
	private int saveDiceSimulationInput(Integer numberOfDice, Integer diceSides, Integer totNumRolls) {
		DiceSimulation diceSimulation = new DiceSimulation();
		diceSimulation.setNumberOfDice(numberOfDice);
		diceSimulation.setDiceSides(diceSides);
		diceSimulation.setTotalNumRolls(totNumRolls);
		diceSimulation = diceSimulationRepo.save(diceSimulation);
		return diceSimulation.getSimulationId();
	}

	/**
	 * Roll dice.
	 *
	 * @param simulationId the simulation id
	 * @param numberOfDice the number of dice
	 * @param diceSides the dice sides
	 * @param rollNum the roll num
	 */
	private void rollDice(Integer simulationId, Integer numberOfDice, Integer diceSides, int rollNum) {
		int total = 0;
		for (int diceId = 1; diceId <= numberOfDice; diceId++) {
			int faceVal = roll(diceSides);
			total+=faceVal;
			saveDiceSimulationDetails(simulationId, diceId, rollNum, faceVal);
		}
		//save Relative Distribution for each roll
		saveDiceRelativeDistribution(numberOfDice, diceSides, rollNum, total);
	}

	/**
	 * Save dice relative distribution.
	 *
	 * @param numberOfDice the number of dice
	 * @param diceSides the dice sides
	 * @param rollNum the roll num
	 * @param total the total
	 */
	private void saveDiceRelativeDistribution(Integer numberOfDice, Integer diceSides, int rollNum, int total) {
		DiceRelativeDistribution diceRelativeDistribution = new DiceRelativeDistribution();
		diceRelativeDistribution.setNumberOfDice(numberOfDice);
		diceRelativeDistribution.setDiceSides(diceSides);
		diceRelativeDistribution.setRollNum(rollNum);
		diceRelativeDistribution.setRollSum(total);
		diceRelativeDistributionRepo.save(diceRelativeDistribution);
	}

	/**
	 * Roll.
	 *
	 * @param diceSides the dice sides
	 * @return the int
	 */
	private int roll(Integer diceSides) {
		int faceVal= (int)(Math.random()*diceSides) + 1;	
		return faceVal;
	}

	/**
	 * Save dice simulation details.
	 *
	 * @param simulationId the simulation id
	 * @param diceId the dice id
	 * @param rollNum the roll num
	 * @param faceVal the face val
	 */
	private void saveDiceSimulationDetails(Integer simulationId, Integer diceId, Integer rollNum, int faceVal) {
		DiceSimulationDetails diceSimulationDetails = new DiceSimulationDetails();
		diceSimulationDetails.setSimulationId(simulationId);
		diceSimulationDetails.setRollNum(rollNum);
		diceSimulationDetails.setDiceId(diceId);
		diceSimulationDetails.setFaceVal(faceVal);
		diceSimulationDetailsRepo.save(diceSimulationDetails);
	}

	/**
	 * Gets the tot simulation distribution.
	 *
	 * @return the tot simulation distribution
	 */
	public List<Map<Integer, Integer>> getTotSimulationDistribution() {
		List<Map<Integer, Integer>> totSimulationRollCount = diceSimulationRepo.findTotSimulationRollCount();
		return totSimulationRollCount;
	}

	/**
	 * Gets the relative distribution.
	 *
	 * @return the relative distribution
	 */
	public List<DiceRelativeDistributionDto> getRelativeDistribution() {
		List<Object[]> records = diceRelativeDistributionRepo.getRelativeDistribution();
		List<DiceRelativeDistributionDto> diceRelativeDistributionDtoList = new ArrayList<DiceRelativeDistributionDto>();
		DiceRelativeDistributionDto dto;
		
		for (Object[] record : records) {
			dto = diceObjectMappingUtility.convertObjectToDiceRelativeDistributionDto(record);
			diceRelativeDistributionDtoList.add(dto);
		}
		
		return diceRelativeDistributionDtoList;
	}
	
}
