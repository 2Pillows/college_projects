/*
------------------------------------------------------------------------
 Pseudocode: Gets input from user and appends to existing text file. Then reads the said file, reverses the characters for each line and writes to a new file.
------------------------------------------------------------------------
 Program Inputs: User input
------------------------------------------------------------------------
*/
// Include required libraries
#include <iostream>
#include <fstream>
#include <vector>
#include <string>
#include <algorithm>
#include <iterator>

// Standard namespace declaration
using namespace std;

// Method that prints reversed characters for each line
// of existing file
void reverseFile(string fileName)
{
    // Get existing information from file
    ifstream inputFile;
    inputFile.open(fileName, ifstream::in);
    vector<string> fileLines;
    string curLine;
    while (getline(inputFile, curLine))
    {
        // Reverses each line retrieved from file
        reverse(curLine.begin(), curLine.end());
        // Adds reversed line to vector
        fileLines.push_back(curLine);
    }

    // Writes to new reverse file
    string revName = "CSC450-mod5-reverse.txt";
    ofstream outRevFile(revName, ofstream::out);
    // Iterator to write entire vector
    ostream_iterator<string> outItr(outRevFile, "\n");
    copy(fileLines.begin(), fileLines.end(), outItr);
    // Success statement
    cout << "Written to Reverse File" << endl;
    // Close inputFile
    inputFile.close();
}

// Main method that appends user input to text file
int main()
{
    // Target output file
    string fileName = "CSC450_CT5_mod5.txt";
    string userInput;
    // Prompt user for input and store input
    cout << "Enter text to add to file: " << endl;
    getline(cin, userInput);

    // Append to output file
    ofstream outFile;
    // Specifly ofstream::app for append
    outFile.open(fileName, ofstream::app);
    outFile << userInput << endl;
    // Success statement
    cout << "Written to File" << endl;
    // Close existing ofstream
    outFile.close();

    // Call method to print reversed characters to new file
    reverseFile(fileName);

    return 0;
}