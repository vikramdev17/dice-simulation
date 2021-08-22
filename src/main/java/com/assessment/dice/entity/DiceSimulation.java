package com.assessment.dice.entity;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;

/**
 * The Class DiceSimulation.
 * @author vikram.chauhan
 */
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "Dice_Simulation")
public class DiceSimulation {
	
	/** The simulation id. */
	@Id
	@GeneratedValue
	private int simulationId;
	
	/** The number of dice. */
	private int numberOfDice;
	
	/** The dice sides. */
	private int diceSides;
	
	/** The total num rolls. */
	private int totalNumRolls;
	
	/**
	 * Gets the simulation id.
	 *
	 * @return the simulationId
	 */
	public int getSimulationId() {
		return simulationId;
	}
	
	/**
	 * Sets the simulation id.
	 *
	 * @param simulationId the simulationId to set
	 */
	public void setSimulationId(int simulationId) {
		this.simulationId = simulationId;
	}

	/**
	 * Gets the number of dice.
	 *
	 * @return the numberOfDice
	 */
	public int getNumberOfDice() {
		return numberOfDice;
	}
	
	/**
	 * Sets the number of dice.
	 *
	 * @param numberOfDice the numberOfDice to set
	 */
	public void setNumberOfDice(int numberOfDice) {
		this.numberOfDice = numberOfDice;
	}
	
	/**
	 * Gets the dice sides.
	 *
	 * @return the diceSides
	 */
	public int getDiceSides() {
		return diceSides;
	}
	
	/**
	 * Sets the dice sides.
	 *
	 * @param diceSides the diceSides to set
	 */
	public void setDiceSides(int diceSides) {
		this.diceSides = diceSides;
	}

	/**
	 * @return the totalNumRolls
	 */
	public int getTotalNumRolls() {
		return totalNumRolls;
	}

	/**
	 * @param totalNumRolls the totalNumRolls to set
	 */
	public void setTotalNumRolls(int totalNumRolls) {
		this.totalNumRolls = totalNumRolls;
	}
}
