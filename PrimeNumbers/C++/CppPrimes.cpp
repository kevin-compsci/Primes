//Kevin Nguyen
//Basic C++ (Cpp) program that outputs primes up to a given number.

/*
How to run (linux):
	1.) open command line and cd into directory folder of where this code is
	2.) type in "g++ *.cpp" to compile c++ files
	3.) type in "a.out" to run out file
*/

//include statements
#include <cstdlib>
#include <iostream>
#include <vector>
using namespace std;

//Global Declarations
vector<int> primeList;

//function definitions
void getAllPrimes(int, int[], int);
void printVector();

//main driver
int main(int argc, char** argv) {
	//local declarations
	int listOfTestVal[10] = {1, 2, 3, 4, 5, 6, 7, 8, 9, 10};
	int targetValue = 100; //<--- target value

	//call functions to collect prime numbers and then print them out
	getAllPrimes(targetValue, listOfTestVal, 10);
	printVector();
}

//Functions implementations goes below
void getAllPrimes(int tgtValue, int listOfTestValues[], int testListSize) {
	//local declarations
	int i = 2, i2 = 0, tmp = 0, isPrime = 1;
	
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
				isPrime = 0;
				break; //get out of loop due to failure
			}
			i2++;
		}
		//if prime then it passed all cases; insert it to vector list!
		if(isPrime == 1) {
			primeList.push_back(i);
		}
		//reset trigger values
		isPrime = true; //reset conditional
		i2 = 0; //reset inner loop
		i++; //increment
	}
}

//this function prints out all elements within a vector
void printVector() {
	//local declarations
	int i = 0, length = primeList.size();

	//loop and print the values of vector (primeList)
	while(i < length) {
		cout << primeList[i];
		i++;
		if(i < length) {
			cout << ", ";
		}
	}
	cout << endl;
}