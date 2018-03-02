/*
Kevin Nguyen
A small naive program to output primes up to a specific value

How to run (linux):
	1.) open command line and cd into directory folder of where this code is
	2.) type in "javac *.java" to compile java files
	3.) type in "java Primes #" where # is some integer value you want the program output up to
*/

//imports
import java.io.*;
import java.util.*;

//class
class Primes {
	//Global Declarations
	List<Integer> listOfPrimes = new ArrayList<Integer>();

	//main driver
	public static void main(String[] args) {
		//local Declarations
		int[] listOfTestValues = {1, 2, 3, 4, 5, 6, 7, 8, 9, 10};

		//conditionals for argument length --> must need only 1 value to check over, too many/few are failures
		if(args.length == 1) {
			System.out.println("VALUE: " + args[0]);
			Primes my = new Primes(); //avoid static issues, though it is optional depending on structure; however, we don't care about it for this project
			my.getAllPrimes(Integer.parseInt(args[0]), listOfTestValues, 10); //update global variable by calling this function
			System.out.println(Arrays.toString(my.listOfPrimes.toArray())); //print all values in list
		}
		else if(args.length > 1) { //too many args
			System.err.println("Too many arguments!");
			System.exit(0);
		} 
		else { //too few args
			System.err.println("Too few arguments!");
			System.exit(0);			
		}
	}

	//Retrieves all primes up a number (tgtValue) and returns a list
	public void getAllPrimes(int tgtValue, int[] listOfTestValues, int testListSize) {
		//local declaration
		int i = 2, i2 = 0, tmp = 0;
		boolean isPrime = true;
		
		//loop through all values and determine primes and insert to list if it is
		while(i < tgtValue) {
			//inner loop and loop over test values; checks for failures
			while(i2 < testListSize) {
				tmp = listOfTestValues[i2]; //set to local variable	
				//Extra case: 1 and ith value are already excluded; they are factors for prime	
				if(tmp == 1 || tmp == i) {
					i2++; //increment
					continue; //continues logic
				}
				//conditional to check ith value against prime test values
				if (((i % tmp) == 0)) {
					isPrime = false;
					break; //get out of loop due to failure
				}
				i2++;
			}
			//if prime then it passed all cases; insert it to list!
			if(isPrime) {
				listOfPrimes.add(i);
			}
			//reset trigger values
			isPrime = true; //reset conditional
			i2 = 0; //reset inner loop
			i++; //increment
		}
	}
}