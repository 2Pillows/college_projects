/*
------------------------------------------------------------------------
 Program Name: CTA 3
 Author: Henry Smith
 Date: 2/5/2023
------------------------------------------------------------------------
 Pseudocode: Collects 3 integers from user. Using those integers, create pointers to dynamic memory. Display the content and pointers for each variable. Delete any variables to manage memory.
------------------------------------------------------------------------
 Program Inputs: 3 integers
 Program Outputs: 3 integers as well as their pointer
------------------------------------------------------------------------
*/
// Include required libraries
#include <iostream>
#include <vector>

// Standard namespace declaration
using namespace std;

int main()
{
    // 3 Integer Variables
    int *a = new int;
    int *b = new int;
    int *c = new int;

    // Prompt User to Enter 3 Integers
    // If not integer, remind user to enter integers
    cout << "Please enter 3 integers:" << '\n';
    vector<int> inputs;
    for (int i = 0; i < 3; ++i)
    {
        int input;
        cin >> input;
        if (cin.fail())
        {
            cout << "Enter integer:" << endl;
        }
        while (cin.fail())
        {
            cin.clear();
            cin.ignore();
            cin >> input;
        }
        inputs.push_back(input);
    }

    // Store pointers of integer inputs
    *a = inputs[0];
    *b = inputs[1];
    *c = inputs[2];

    // Options to free up memory
    // inputs.clear();
    // inputs.shrink_to_fit();
    vector<int>().swap(inputs);

    // Display contents and pointers of 3 integers
    cout
        << "Contents: " << *a << ", " << *b << ", " << *c << endl;
    cout
        << "Pointers: " << a << ", " << b << ", " << c << endl;

    // Delete integer variales
    delete a;
    delete b;
    delete c;

    return 0;
}