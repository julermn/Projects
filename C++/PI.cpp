#define _USE_MATH_DEFINES // For M_PI
#include <cmath>          //For round()
#include <iostream>       //For std::cin and std::cout
#include <iomanip>        //For setprecision()

int main()
{
    // Processing user input
    std::cout << "Enter a precision for PI:" << std::endl;
    int arg = 0;
    std::cin >> arg;
    while (arg > 15)
    {
        // There is rounding to the 15 decimal place
        // If rounding is greater than 15, double's precision work unstably
        std::cout << "The precision should be less or equals 15! Try again:" << std::endl;
        std::cin >> arg;
    }
    if (arg == 0)
    {
        std::cout << "Your precision is 0. Default PI: 3.14" << std::endl;
        return 0;
    }

    // Generating PI
    // dec is long long, because program need a big integer (ten's power),
    // which contains a large number of places (up to 15)
    long long dec = 1;
    for (int i = 0; i < arg; ++i)
    {
        dec *= 10LL;
    }
    // I could write a program, which just output user PI with setprecision(),
    // but I would like that program is able to send anyone data to other program for using this
    // So this program create a param with user's PI to using this in other calculations
    double PI = round(M_PI * dec) / dec;
    // Output user PI
    // It is use setprecision(), because default output round to the 5 decimal place
    std::cout << "PI: " << std::setprecision(arg + 1) << PI << std::endl;
    return 0;
}
