package com.assessment.dice.repository;

import java.util.List;
import java.util.Map;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.assessment.dice.entity.DiceSimulation;

 
/**
 * The Interface DiceSimulationRepo.
 * @author vikram.chauhan
 */
public interface DiceSimulationRepo extends JpaRepository<DiceSimulation, Integer>{
	
	/**
	 * Find tot simulation roll count.
	 *
	 * @return the list
	 */
	@Query(value = "select count(1) totalSimulation, sum(Total_Num_Rolls) totalRolls from Dice_Simulation group by number_Of_Dice,Dice_Sides",
			nativeQuery = true)
	List<Map<Integer, Integer>> findTotSimulationRollCount();

}
