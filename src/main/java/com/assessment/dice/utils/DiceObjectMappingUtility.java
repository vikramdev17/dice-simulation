package com.assessment.dice.utils;

import org.apache.commons.lang3.StringUtils;
import org.springframework.stereotype.Service;

import com.assessment.dice.model.DiceRelativeDistributionDto;

 
/**
 * The Class DiceObjectMappingUtility.
 * @author vikram.chauhan
 */
@Service("diceObjectMappingUtility")
public class DiceObjectMappingUtility {


	/**
	 * Convert object to dice relative distribution dto.
	 *
	 * @param record the record
	 * @return the dice relative distribution dto
	 */
	public DiceRelativeDistributionDto convertObjectToDiceRelativeDistributionDto(Object[] record) {
		DiceRelativeDistributionDto dto = new DiceRelativeDistributionDto();
		
        if (record[0] != null && StringUtils.isNotEmpty(record[0].toString())) {
        	dto.setNumberOfDice(Integer.parseInt(record[0].toString()));
        }
        if (record[1] != null && StringUtils.isNotEmpty(record[1].toString())) {
        	dto.setDiceSides(Integer.parseInt(record[1].toString()));
        }
        if (record[2] != null && StringUtils.isNotEmpty(record[2].toString())) {
        	dto.setRollSum(Integer.parseInt(record[2].toString()));
        }
        if (record[3] != null && StringUtils.isNotEmpty(record[3].toString())) {
        	dto.setTotRollCount(Integer.parseInt(record[3].toString()));
        }
        if (record[4] != null && StringUtils.isNotEmpty(record[4].toString())) {
        	dto.setPercentage(String.format("%.2f",Float.parseFloat(record[4].toString()))+"%");
        }

		return dto;
	}
}
