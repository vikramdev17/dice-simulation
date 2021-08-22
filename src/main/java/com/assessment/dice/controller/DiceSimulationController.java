/**
 * 
 */
package com.assessment.dice.controller;

import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;

import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.assessment.dice.model.BaseResponse;
import com.assessment.dice.model.DiceRelativeDistributionDto;
import com.assessment.dice.model.DiceSimulationResponse;
import com.assessment.dice.service.DiceSimulationService;

import lombok.extern.slf4j.Slf4j;

 
/**
 * The Class DiceSimulationController.
 * @author vikram.chauhan
 */
@RestController
@Slf4j
@RequestMapping(value = "/dice")
public class DiceSimulationController {
	
	/** The dice simulation service. */
	@Autowired
	private DiceSimulationService diceSimulationService;
	
	/** The Constant log. */
	private static final org.slf4j.Logger log =  org.slf4j.LoggerFactory.getLogger(DiceSimulationController.class);
	
	/**
	 * Dice simulation.
	 *
	 * @param numberOfDice the number of dice
	 * @param diceSides the dice sides
	 * @param totNumRolls the tot num rolls
	 * @param httpServletRequest the http servlet request
	 * @return the response entity
	 */
	@GetMapping("/simulation")
	 @ResponseBody
	public ResponseEntity<Object> diceSimulation(@RequestParam Integer numberOfDice,
			@RequestParam Integer diceSides, @RequestParam Integer totNumRolls,
	      HttpServletRequest httpServletRequest) {
		try {
			log.info("User inputs numberOfDice : " + numberOfDice + ",\t diceSides : " + diceSides + ",\t totNumRolls : " + totNumRolls); 
			StringBuilder errMsg = validateRequestParams(numberOfDice, diceSides, totNumRolls);
			log.warn("Validation failed. errMsg : " + errMsg);
			if (StringUtils.isNotEmpty(errMsg.toString())) {
				BaseResponse response = new BaseResponse();
				response.setErrorDescription(errMsg.toString());
				return new ResponseEntity<>(response, HttpStatus.BAD_REQUEST);
			}
			
			List<Map<Integer, Integer>> totalRollCount = diceSimulationService.executeDiceDistribution(numberOfDice, diceSides, totNumRolls);
			
			DiceSimulationResponse response = new DiceSimulationResponse();
			response.setResponseList(totalRollCount);
			return new ResponseEntity<>(response, HttpStatus.OK);
		} catch (Exception e) {
			e.printStackTrace();
			log.error(e.getMessage());
			BaseResponse response = new BaseResponse();
			response.setErrorDescription(e.getMessage());
			return new ResponseEntity<>(response, HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}

	/**
	 * Dice simulation.
	 *
	 * @param httpServletRequest the http servlet request
	 * @return the string
	 */
	@GetMapping("/index")
	public String diceSimulation(HttpServletRequest httpServletRequest) {
		return "Welcome to dice simulation demo";
		
	}
	
	/**
	 * Validate request params.
	 *
	 * @param numberOfDice the number of dice
	 * @param diceSides the dice sides
	 * @param totNumRolls the tot num rolls
	 * @return the string builder
	 */
	private StringBuilder validateRequestParams(Integer numberOfDice, Integer diceSides, Integer totNumRolls) {
		StringBuilder errMsg = new StringBuilder();
		if(numberOfDice == null || numberOfDice<1) {
			errMsg.append("The number of dice must be at least 1.").append(System.lineSeparator());
		}
		if(diceSides == null || diceSides<4) {
			errMsg.append("The sides of a dice must be at least 4.").append(System.lineSeparator());
		}
		if(totNumRolls == null || totNumRolls<1) {
			errMsg.append("The total number of rolls must be at least 1.");
		}
		return errMsg;
	}

	@GetMapping("/simulation-distribution")
	@ResponseBody
	public ResponseEntity<Object> getTotSimulationDistribution(HttpServletRequest httpServletRequest) {
		try {
			List<Map<Integer, Integer>> simulationDistribution = diceSimulationService.getTotSimulationDistribution();
			
			DiceSimulationResponse response = new DiceSimulationResponse();
			response.setResponseList(simulationDistribution);
			return new ResponseEntity<>(response, HttpStatus.OK);
		} catch (Exception e) {
			e.printStackTrace();
			log.error(e.getMessage());
			BaseResponse response = new BaseResponse();
			response.setErrorDescription(e.getMessage());
			return new ResponseEntity<>(response, HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}
	
	@GetMapping("/relative-distribution")
	@ResponseBody
	public ResponseEntity<Object> getRelativeDistribution(HttpServletRequest httpServletRequest) {
		try {
			List<DiceRelativeDistributionDto> diceRelativeDistributionDtoList = diceSimulationService.getRelativeDistribution();
			
			return new ResponseEntity<>(diceRelativeDistributionDtoList, HttpStatus.OK);
		} catch (Exception e) {
			e.printStackTrace();
			log.error(e.getMessage());
			BaseResponse response = new BaseResponse();
			response.setErrorDescription(e.getMessage());
			return new ResponseEntity<>(response, HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}
	
}
