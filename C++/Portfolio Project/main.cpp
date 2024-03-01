/*
------------------------------------------------------------------------
 Pseudocode: Two threads are created to count up to 20 and down to 20. Threads are managed using mutex to prevent parallel execution
------------------------------------------------------------------------
 Program Inputs: N/A
------------------------------------------------------------------------
*/
// Include required libraries
#include <iostream>
#include <mutex>
#include <thread>

// Alternative methods of locking using wait()
// #include <condition_variable>

// Standard namespace declaration
using namespace std;

mutex mtx; // Mutex variable for manage threads

// Function to count up
void countUp(int &count)
{
    mtx.lock(); // Lock thread using mutex
    cout << "\nStarting Thread1: " << endl;

    // Loop for counting up
    while (count <= 20)
    {
        cout << "Counter: " << count << endl;
        if (count == 20)
            break;
        count++;
    }

    cout << "Ending Thread1." << endl;
    mtx.unlock(); // Release mutex lock
}

// Function to count down
void countDown(int &count)
{
    mtx.lock(); // Lock thread using mutex
    cout << "\nStarting Thread2." << endl;

    // Loop for counting down
    while (count >= 0)
    {
        cout << "Counter: " << count << endl;
        if (count == 0)
            break;
        count--;
    }

    cout << "Ending Thread2."
         << endl;
    mtx.unlock(); // Release mutex lock
}

int main()
{
    int count = 0; // Counter variable

    // Create two threads for counting and pass count by reference
    cout << "Creating Threads 1 and 2." << endl;
    thread t1(countUp, ref(count));
    thread t2(countDown, ref(count));

    // Wait for threads to finish
    t1.join();
    t2.join();

    return 0;
}