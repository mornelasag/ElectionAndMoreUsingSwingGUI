//
// MyUtilityClass
//
// the purpose of this class is to hold the general utility methods
//
// Author:	Marco E. Ornelas
// Date:	12/04/17
//
package anElectionAndMore;

import java.util.Scanner;

public class MyUtilityClass
{	
	//
	//	fillRandomArray
	//
	//	the purpose of this method is to fill an array of integers with
	//	random values between the minimum and maximum values inclusively.
	//
	//	Input:	array		the array of integers
	//			minVal		the minimum random value
	//			maxVal		the maximum random value
	//	Return:	none
	//
	public static void fillRandomArray(int[] array, int minVal, int maxVal)
	{
		int cntr;

		// check to make sure that minVal is less than maxVal
		if (minVal <= maxVal)
		{
		
			for (cntr = 0; cntr < array.length;++cntr)
			{
				array[cntr] = genRandom(minVal, maxVal);
			}// end for each random value
		}
		else
		{
			System.out.println("Array cannot be filled because " + minVal + " is not less than " +  maxVal);
		}
	}// end fillRandomArray


	//
	//	printArray
	//
	//	the purpose of this method is to print out the values stored in the array.
	//	The values should be printed showing the index in one column and the
	//	corresponding values in the next column.  A title should be included at 
	//	the top of each column.
	//
	//	Input:		array		the array of integers
	//	Return:		none
	//
	public static void printArray(int[] array)
	{
		int cntr;
		
		System.out.println("Index\t\tValue");

		// print each element of the array
		for (cntr = 0; cntr < array.length; cntr++)
		{
			System.out.println(cntr + "\t\t" + array[cntr]);
		}
	} // end printArray
	
	
	//
	//	inputString
	//
	//	the purpose of this method is to input a string from the keyboard
	//
	//	Input:	prompt			the prompt message for the dialog box
	//	Return:	inputStr			the string that was entered at the keyboard
	//
	public static String inputString(String prompt)
	{
		@SuppressWarnings("resource")
		Scanner input = new Scanner(System.in);
		
		// declare variable
		String inputStr;	// input string
		
		// initialize variable
		inputStr = "none";
		
		// prompt to enter the string
		System.out.print(prompt);
		
		// read in value as string from keyboard
		inputStr = input.nextLine();
				
		// return input string
		return(inputStr);
	}// end inputString

	
	//
	//	inputInteger
	//
	//	the purpose of this method is to input an integer value from the keyboard
	//
	//	Input:		prompt		prompt message for the user
	//	Return:		num			integer entered at the keyboard
	//
	public static int inputInteger(String prompt)
	{
		@SuppressWarnings("resource")
		Scanner input = new Scanner(System.in);
		
		// declare variable
		@SuppressWarnings("unused")
		String cleanUpStr;	// string to clean up keyboard buffer
		int num;				// number
		
		// initialize variable
		num = 0;
		cleanUpStr = "no string yet";
		
		// prompt to enter integer
		System.out.print(prompt);
		// reads number
		num = input.nextInt();
		// string to clean up keyboard buffer
		cleanUpStr = input.nextLine();
		
		// return number
		return(num);
	}// end inputInteger

	
	//
	//	inputDouble
	//
	//	the purpose of this method is to input a double value from the keyboard
	//
	//	Input:		prompt		prompt message for the user
	//	Return:		num			double value entered at the keyboard
	//
	public static double inputDouble(String prompt)
	{
		@SuppressWarnings("resource")
		Scanner input = new Scanner(System.in);
		
		// declare variable
		@SuppressWarnings("unused")
		String cleanUpStr;	// string to clean up keyboard buffer
		double num;			// number 
		
		// initialize variable
		num = 0.0;
		cleanUpStr = "no string yet";
		
		// prompts for double 
		System.out.print(prompt);
		// reads number
		num = input.nextDouble();
		// string to clean up keyboard buffer
		cleanUpStr = input.nextLine();
		
		// return number
		return(num);
	}// end inputDouble

	
	//
	//	genRandom
	//
	//	the purpose of this method is to generate a random number
	//	between the minimum and maximum values specified inclusively
	//
	//	Input:	min		minimum value in the range of numbers
	//			max		maximum value in the range of numbers
	//	Return:	num		 random number in the given range
	public static int genRandom(int min, int max)
	{
		// declare variable
		double rNum;		// the original random number generated
		double range;	// the range of random numbers allowed
		int num;

		// initialize variable
		rNum = 0.0;
		range = 0.0;
		num = 0;

		// validate the input
		if ((min >=0) && (min <= max))
		{
			// the input arguments are actually valid so we can generate a random number
	        
	    		// generate a random number 0.0 <= rNum < 1.0
	   		rNum = Math.random();
	        
	   		// determine the range
	    		range = (double)max - (double)min + 1.0;
	        
	    		// scale the number between min and max inclusively
	   		rNum = rNum * range;       
	    		rNum = rNum + (double)min;
	        
	    		// convert back to integer value
	    		num = (int)rNum;
		}
		else
		{
			System.out.println("Invalid input arguments of " + min + " and " + max);
			System.out.println("Random number cannot be generate");
		} //end if/else input validation
	    
	    // return the integer
	    return num;      		
	}// end genRandom

} // end MyUtilityClass
