#
#Kevin Nguyen
#A small naive program to output primes up to a specific value. Performance is atleast O(M*N) where M is a constant from 1 - 10 and N is the input size.
#
#How to run (linux):
#	1.) open command line and cd into directory folder of where this code is
#	2.) type in "python Primes.py #" where # is some value that the program will output primes up to
#

#import cases
import sys;
import array;

#function getAllprimes will retrive all primes up to a specified target value (tgtValue)
def getAllPrimes(tgtValue):
	#local declaration
	tmp = 0; isPrime = 1; testListSize = 10;
	listOfTestValues = [1,2,3,4,5,6,7,8,9,10];
	listOfPrimes = [];

	#loop through all values and determine primes and insert to list if it is
	for i in range(2, tgtValue) :
		#inner loop and loop over test values; checks for failures
		for i2 in range(0, testListSize) :
			tmp = listOfTestValues[i2]; #set to local variable
			#Extra case: 1 and ith value are already excluded; they are factors for prime	
			if(tmp in {1,i}) :
				i2=i2+1; #increment
				continue; #continues logic
			#conditional to check ith value against prime test values
			if (((i % tmp) is 0)) :
				isPrime = 0;
				break; #get out of loop due to failure
			i2=i2+1;
		#if prime then it passed all cases; insert it to list!
		if(isPrime is 1) :
			listOfPrimes.append(i);
		#reset trigger values
		isPrime = 1; #reset conditional
		i2 = 0; #reset inner loop
		i=i+1; #increment
	return listOfPrimes;

##############################################################################


#Main driver
#conditional for error checking argument length
if(len(sys.argv) is not 1) :
	print 'Error: number of args must be 1!'
else :
	result = getAllPrimes(int(sys.argv[1]));
	print result;
