CONTENTS OF THIS FILE
---------------------

 * Introduction
 * Requirements
 * Assumption
 * Design
 
# Introduction
Dice simulation use case that need to be implemented in Sprint Boot and provide REST end points to user to perform different actions.
 
Developed a Sprint boot application named "dice" covering all use cases as per requirement.
URL: http://localhost:8080/dice/index
Added a separate file "Resquest-Response.txt" contains all requests and responses. 

# Requirements
Assignment 1: Create a Spring Boot application
Create a REST endpoint to execute a dice distribution simulation:
	1. Roll 3 pieces of 6-sided dice a total of 100 times.
		a. For every roll sum the rolled number from the dice (the result will be between 3 and 18).
		b. Count how many times each total has been rolled.
		c. Return this as a JSON structure.
	2. Make the number of dice, the sides of the dice and the total number of rolls configurable through query parameters.
	3. Add input validation:
		a. The number of dice and the total number of rolls must be at least 1.
		b. The sides of a dice must be at least 4.

Assignment 2: Store the result of the simulation from Assignment 1 in a database
Create a REST endpoint that can query the stored data:
	1. Return the total number of simulations and total rolls made, grouped by all existing dice number–dice side combinations.
		a. Eg. if there were two calls to the REST endpoint for 3 pieces of 6 sided dice, once with a total number of rolls of 100 and once with a total number of rolls of 200, then there were a total of 2 simulations, with a total of 300 rolls for this combination.
	2. For a given dice number–dice side combination, return the relative distribution, compared to the total rolls, for all the simulations.
		a. In case of a total of 300 rolls, if the sum „3” was rolled 4 times, that would be 1.33%.
		b. If the sum „4” was rolled 3 times, that would be 1%.
		c. If the total „5” was rolled 11 times, that would be 3.66%. Etc...

# Assumption
1. User can provide different combination of input value. 
	e.g. Simulation 1: number of dice =3, sides of a dice=6 and total number of rolls=100
		Simulation 2: number of dice =2, sides of a dice=4 and total number of rolls=200
		 
# Design
1. Created 3 below tables to store information that would serve all REST end points
	Table1: To store user input for each simulation since it is configurable through query parameters.
		Name: DICE_SIMULATION 
		Columns: 
			simulation_Id : Primary key
			number_Of_Dice : the number of dice
			dice_Sides :  the sides of the dice
			total_Num_Rolls : the total number of rolls
		
	Table2: To save the details of each roll for every dice.
		Name: Dice_Simulation_Details 
		Columns: 
			id : Primary key
			simulation_Id : Reference Id
			dice_Id : Dice Id/Number e.g. if number_Of_Dice=3 then dice_Id = 1,2,3 
			face_Val : value got on rolling dice
			roll_Num : roll number e.g. if total_Num_Rolls=4 then roll_Num = 1,2,3,4
		
	Table3: To store data for relative distribution
		Name: Dice_Relative_Distribution 
		Columns: 
			id : Primary key
			roll_Sum : the total sum of each roll 
			roll_Num : roll number e.g. if total_Num_Rolls=4 then roll_Num = 1,2,3,4 
			number_Of_Dice : the number of dice
			dice_Sides : the sides of the dice

Spring Boot Application
	Main Class: DiceApplication.java
	Controller: DiceSimulationController.java	
				Request Mapping : "/dice"
	Database:	H2 database
				Configuration done in "application.properties"
				URL: http://localhost:8080/h2
	Testing :	Separate file "Resquest-Response.txt" contains 5 test caes with requests and responses 	
				Unit Test Case is not covered

REST End Points
1. Count how many times each total has been rolled
	URL: http://localhost:8080/dice/simulation?numberOfDice=3&diceSides=6&totNumRolls=4
	Logic: 	
		1. It performs validation on input params provided by user in query param.
		2. Save user input in table DICE_SIMULATION
		3. For each roll, find out each dice face value depend on number of dice and then calculate roll sum.
		4. Save all these data in DICE_SIMULATION and Dice_Relative_Distribution
		5. Using custom native SQL, get roll/total sum and its count from Dice_Simulation_Details using subquery and group by clause.
		
2. Return the total number of simulations and total rolls made, grouped by all existing dice number–dice side combinations
	URL: http://localhost:8080/dice/simulation-distribution
	Logic: 	
		1. Using custom native SQL, get total number of Simulation and total rolls from Dice_Simulation using group by clause on number_Of_Dice and Dice_Sides.	
		2. As per requirement, number_Of_Dice and Dice_Sides is not the part of response.
		3. For each dice number–dice side combination, it give total number of Simulation and total rolls.
			
3. For a given dice number–dice side combination, return the relative distribution, compared to the total rolls, for all the simulations
	URL: http://localhost:8080/dice/relative-distribution
	Logic: 	
		1. Using custom native SQL, return the relative distribution from Dice_Relative_Distribution using subquery and group by clause on number_Of_Dice, Dice_Sides and roll_Sum.	
		2. It would generate separate data element response for same roll sum if either number of dice or side of dice is different.
