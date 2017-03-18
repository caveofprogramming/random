//============================================================================
// Name        : Testing.cpp
// Author      : 
// Version     :
// Copyright   : Your copyright notice
// Description : Hello World in C++, Ansi-style
//============================================================================

#include <iostream>
#include <string>
using namespace std;


int main() {

	const int WIDTH=3;
	const int HEIGHT=3;

	int *pNumbers = new int[WIDTH*HEIGHT];

	// Fill in some numbers -- could be whatever you like
	for(int i=0; i < WIDTH*HEIGHT; i++) {
		pNumbers[i] = (i+1) * 10;
	}

	// Display them, pretending we're dealing with a
	// table of numbers.
	for(int row=0; row<WIDTH; row++) {
		for(int col=0; col<HEIGHT; col++) {
			cout << pNumbers[row * WIDTH + col] << "\t";
			// "\t" outputs a tab.
		}

		cout << endl;
	}

	// Note, array form of delete with [] brackets
	delete [] pNumbers;

	return 0;
}
