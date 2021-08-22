package com.assessment.dice.entity;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;

 
/**
 * The Class DiceSimulationDetails.
 * @author vikram.chauhan
 */
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "Dice_Simulation_Details")
public class DiceSimulationDetails {
	
	/** The id. */
	@Id
	@GeneratedValue
	private int id;
	
	/** The simulation id. */
	private int simulationId;
	
	/** The dice id. */
	private int diceId;
	
	/** The face val. */
	private int faceVal;
	
	/** The roll num. */
	private int rollNum;
	
	/**
	 * Gets the id.
	 *
	 * @return the id
	 */
	public int getId() {
		return id;
	}
	
	/**
	 * Sets the id.
	 *
	 * @param id the id to set
	 */
	public void setId(int id) {
		this.id = id;
	}
	
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
	 * Gets the dice id.
	 *
	 * @return the diceId
	 */
	public int getDiceId() {
		return diceId;
	}
	
	/**
	 * Sets the dice id.
	 *
	 * @param diceId the diceId to set
	 */
	public void setDiceId(int diceId) {
		this.diceId = diceId;
	}
	
	/**
	 * Gets the face val.
	 *
	 * @return the faceVal
	 */
	public int getFaceVal() {
		return faceVal;
	}
	
	/**
	 * Sets the face val.
	 *
	 * @param faceVal the faceVal to set
	 */
	public void setFaceVal(int faceVal) {
		this.faceVal = faceVal;
	}
	
	/**
	 * Gets the roll num.
	 *
	 * @return the rollNum
	 */
	public int getRollNum() {
		return rollNum;
	}
	
	/**
	 * Sets the roll num.
	 *
	 * @param rollNum the rollNum to set
	 */
	public void setRollNum(int rollNum) {
		this.rollNum = rollNum;
	}	

}
