package com.assessment.dice.model;

 
/**
 * The Class DiceRelativeDistributionDto.
 * @author vikram.chauhan
 */
public class DiceRelativeDistributionDto {
	
	/** The roll sum. */
	private int rollSum;
	
	/** The number of dice. */
	private int numberOfDice;
	
	/** The dice sides. */
	private int diceSides;	
    
    /** The tot roll count. */
    private int totRollCount;
    
    /** The percentage. */
    private String percentage;

	
	/**
	 * Gets the roll sum.
	 *
	 * @return the rollSum
	 */
	public int getRollSum() {
		return rollSum;
	}

	/**
	 * Sets the roll sum.
	 *
	 * @param rollSum the rollSum to set
	 */
	public void setRollSum(int rollSum) {
		this.rollSum = rollSum;
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
	 * Gets the tot roll count.
	 *
	 * @return the totRollCount
	 */
	public int getTotRollCount() {
		return totRollCount;
	}
	
	/**
	 * Sets the tot roll count.
	 *
	 * @param totRollCount the totRollCount to set
	 */
	public void setTotRollCount(int totRollCount) {
		this.totRollCount = totRollCount;
	}
	
	/**
	 * Gets the percentage.
	 *
	 * @return the percentage
	 */
	public String getPercentage() {
		return percentage;
	}
	
	/**
	 * Sets the percentage.
	 *
	 * @param percentage the percentage to set
	 */
	public void setPercentage(String percentage) {
		this.percentage = percentage;
	}


}
