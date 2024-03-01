/*
------------------------------------------------------------------------
 Program Name: CTA 1 Option #1
 Author: Henry Smith
 Date: 1/22/2023
------------------------------------------------------------------------
 Pseudocode: Prints first name, last name, street address, city, and zip code
 of a finctional person.
------------------------------------------------------------------------
 Program Inputs: N/A
 Program Outputs: First name, last name, street address, city, and zip code of
 a fictional person.
------------------------------------------------------------------------
*/
// Include required libraries
#include <iostream>
#include <conio.h>
#include <string>

// Standard declarations
using std::string;
using namespace std;

// Main function
int main()
{
    // Variables for fictional person's information
    string firstName = "Joe";
    string lastName = "Biden";
    string streetAdress = "1600 Pennsylvania Ave NW";
    string city = "Washington, DC";
    string zipCode = "20500-0003";

    // Print finctional person's information
    cout << "First Name: " << firstName << endl;
    cout << "Last Name: " << lastName << endl;
    cout << "Street Address: " << streetAdress << endl;
    cout << "City: " << city << endl;
    cout << "Zip Code: " << zipCode << endl;

    // Wait For output sdcreen
    cout << "Press any key to exit" << endl;
    getch();

    // Main function return statement
    return 0;
}