package com.assessment.dice.model;

import java.util.List;
import java.util.Map;

 
/**
 * The Class DiceSimulation.
 * @author vikram.chauhan
 */
public class DiceSimulationResponse extends BaseResponse {
	
	/** The Constant serialVersionUID. */
	private static final long serialVersionUID = 3927139244198073736L;
	
	/** The tot roll count. */
	private List<Map<Integer, Integer>> responseList;

	/**
	 * @return the responseList
	 */
	public List<Map<Integer, Integer>> getResponseList() {
		return responseList;
	}

	/**
	 * @param responseList the responseList to set
	 */
	public void setResponseList(List<Map<Integer, Integer>> responseList) {
		this.responseList = responseList;
	}

	/**
	 * @return the serialversionuid
	 */
	public static long getSerialversionuid() {
		return serialVersionUID;
	}
	

}
