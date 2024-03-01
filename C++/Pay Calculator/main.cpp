/*
------------------------------------------------------------------------
 Pseudocode: Collects 3 doubles from user for their standard and overtime hours as well as rate of pay. Using the rate of pay, the standard and overtime pay is calcultaed. After, all of the 5 variables in the program are displayed with their content and pointers. These variables are destoryed and the program ends.
------------------------------------------------------------------------
 Program Inputs: Standard Hours, Rate of Pay, Overtime Hours
 Program Outputs: Formatted content and pointers for standard hours, rate of pay, overtime hours, standard pay, and overtime pay
------------------------------------------------------------------------
*/
// Include required libraries
#include <sstream>
#include <iostream>
#include <iomanip>

// Standard namespace declaration
using namespace std;

int main()
{
    // 3 double variables
    double *standardHours = new double;
    double *rateOfPay = new double;
    double *overtimeHours = new double;

    double *standardPay = new double;
    double *overtimePay = new double;

    // Prompt user to enter standard hours worked, rate of pay, overtime hours if applicable
    // If not double, remind user to enter double
    double *input = new double;
    cout << "Please enter standard hours, rate of pay, and overtime hours (0 if not applicable) as doubles:" << '\n';
    cin >> *input;
    if (cin.fail())
    {
        cout << "Enter double for standard hours:" << endl;
    }
    while (cin.fail())
    {
        cin.clear();
        cin.ignore();
        cin >> *input;
    }
    *standardHours = *input;

    cin >> *input;
    if (cin.fail())
    {
        cout << "Enter double for rate of pay:" << endl;
    }
    while (cin.fail())
    {
        cin.clear();
        cin.ignore();
        cin >> *input;
    }
    *rateOfPay = *input;

    cin >> *input;
    if (cin.fail())
    {
        cout << "Enter double for overtime hours:" << endl;
    }
    while (cin.fail())
    {
        cin.clear();
        cin.ignore();
        cin >> *input;
    }
    *overtimeHours = *input;

    // Options to free up memory
    // inputs.clear();
    // inputs.shrink_to_fit();
    // vector<double>().swap(inputs);

    // Calculate standard and overtime (1.5 standard)
    *standardPay = *standardHours * *rateOfPay;
    *overtimePay = *overtimeHours * *rateOfPay * 1.5;

    // Formatted outputs: setw() and setprecision()
    cout << setprecision(2) << fixed;
    cout
        << "Standard Hours: " << setw(10) << right << *standardHours << " (" << standardHours << ")" << endl;
    cout
        << "Rate of Pay:    " << setw(10) << right << *rateOfPay << " (" << rateOfPay << ")" << endl;
    cout
        << "Overtime Hours: " << setw(10) << right << *overtimeHours << " (" << overtimeHours << ")" << endl;
    cout
        << "Standard Pay:   " << setw(10) << right << *standardPay << " (" << standardPay << ")" << endl;
    cout
        << "Overtime Pay:   " << setw(10) << right << *overtimePay << " (" << overtimePay << ")" << endl;

    // Delete variales
    delete input;
    delete standardHours;
    delete rateOfPay;
    delete overtimeHours;
    delete standardPay;
    delete overtimePay;

    return 0;
}