package com.assessment.dice.model;

import java.io.Serializable;

 
/**
 * The Class BaseResponse.
 * @author vikram.chauhan
 */
public class BaseResponse implements Serializable {
  
  /** The Constant serialVersionUID. */
  private static final long serialVersionUID = 1L;
  
  /** The error description. */
  private String errorDescription;

	/**
	 * Gets the error description.
	 *
	 * @return the errorDescription
	 */
	public String getErrorDescription() {
		return errorDescription;
	}
	
	/**
	 * Sets the error description.
	 *
	 * @param errorDescription the errorDescription to set
	 */
	public void setErrorDescription(String errorDescription) {
		this.errorDescription = errorDescription;
	}
	  
}
