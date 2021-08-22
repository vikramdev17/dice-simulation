package com.assessment.dice.entity;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;

 
/**
 * The Class DiceRelativeDistribution.
 * @author vikram.chauhan
 */
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "Dice_Relative_Distribution")
public class DiceRelativeDistribution {
	
	/** The id. */
	@Id
	@GeneratedValue(strategy=GenerationType.SEQUENCE)
	private int id;
	
	private int rollSum;
	
	/** The roll num. */
	private int rollNum;
	
	/** The number of dice. */
	private int numberOfDice;
	
	/** The dice sides. */
	private int diceSides;	
	
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
	 * @return the rollSum
	 */
	public int getRollSum() {
		return rollSum;
	}

	/**
	 * @param rollSum the rollSum to set
	 */
	public void setRollSum(int rollSum) {
		this.rollSum = rollSum;
	}

}
