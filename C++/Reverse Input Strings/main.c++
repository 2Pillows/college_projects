/*
------------------------------------------------------------------------
 Program Name: CTA 2
 Author: Henry Smith
 Date: 1/29/2023
------------------------------------------------------------------------
 Pseudocode: Collects 3 strings of unqiue length from user. For each inputted string, print out reversed string.
------------------------------------------------------------------------
 Program Inputs: 3 strings of unique length
 Program Outputs: Reversed version of each inputted string
------------------------------------------------------------------------
*/
// Include required libraries
#include <iostream>
#include <string>
#include <algorithm>

// Standard namespace declaration
using namespace std;

// Main function
int main()
{
    // Int array to remember previous lengths
    int historySize = 2;
    int lenHistory[historySize];

    // Repeat 3 times using for loop
    int inputCount = 3;
    for (int i = 0; i < inputCount; i++)
    {
        string userStr;          // User's input
        bool validInput = false; // Flag for valid length
        // Input validation for unqiue length
        while (!validInput)
        {
            // Prompt user for length and collect string and string size
            cout << "Enter string with unique length: " << endl;
            getline(cin, userStr);
            int strLen = userStr.length();

            // Avoid checking first string input
            if (i == 0)
            {
                break;
            }

            // Check array of previous lengths
            for (int a = 0; a < i; a++)
            {
                // If current length = past length then deny input
                if (lenHistory[a] == strLen)
                {
                    cout
                        << "String length not unique \n"
                        << endl;
                    break;
                }
                // Passed all past lengths, set flag to true
                if (a == i - 1)
                {
                    validInput = true;
                }
            }
        }

        // Add validated string length to history array
        lenHistory[i] = userStr.length();

        // Reverse the string
        string revStr = userStr;
        reverse(begin(revStr), end(revStr));

        // Print new string
        cout << "Reversed String = " << revStr << userStr << "\n"
             << endl;
    }
}