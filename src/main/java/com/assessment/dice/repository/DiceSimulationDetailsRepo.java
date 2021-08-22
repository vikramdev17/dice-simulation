package com.assessment.dice.repository;

import java.util.List;
import java.util.Map;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.assessment.dice.entity.DiceSimulationDetails;

 
/**
 * The Interface DiceSimulationDetailsRepo.
 * @author vikram.chauhan
 */
public interface DiceSimulationDetailsRepo extends JpaRepository<DiceSimulationDetails, Integer>{
	
	/**
	 * Find total roll count.
	 *
	 * @param simulationId the simulation id
	 * @return the list
	 */
	@Query(value = "select total diceTotal,count(1) rollCount from (select sum(face_val) total,roll_num from "
			+ " DICE_SIMULATION_DETAILS where  simulation_id=:simulationId group by roll_num) a group by total", nativeQuery = true)
	List<Map<Integer, Integer>> findTotalRollCount(@Param("simulationId") Integer simulationId);


}
