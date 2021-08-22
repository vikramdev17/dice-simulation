package com.assessment.dice.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.assessment.dice.entity.DiceRelativeDistribution;

 
/**
 * The Interface DiceRelativeDistributionRepo.
 * @author vikram.chauhan
 */
public interface DiceRelativeDistributionRepo extends JpaRepository<DiceRelativeDistribution, Integer>{
	
	/**
	 * Gets the relative distribution.
	 *
	 * @return the relative distribution
	 */
	@Query(value = "select number_Of_Dice,Dice_Sides, total, totRollCount, (totRollCount*1.0/totrow*1.0)*100.0 percentage from( " + 
			"select number_Of_Dice,Dice_Sides,roll_sum total,count(1) totRollCount, (select count(1) from DICE_RELATIVE_DISTRIBUTION) totrow " + 
			"  from  DICE_RELATIVE_DISTRIBUTION group by number_Of_Dice,Dice_Sides,roll_sum)",
			nativeQuery = true)
	List<Object[]> getRelativeDistribution();

}
