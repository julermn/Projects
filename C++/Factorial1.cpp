#include <iostream>

namespace Factorial
{
    long long factorial(long n)
    {
        if (n <= 1)
        {
            return 1;
        }
        return factorial(n - 1) * n;
    }
}
int main()
{
    // Processing user input
    std::cout << "Enter a number for factorial:" << std::endl;
    int n = 0;
    std::cin >> n;
    while (n > 20)
    {
        // Program will generate a Factorial for number n
        // If n is greater than 20, that program will fail, because "long long" will overflow
        std::cout << "The number should be less or equals 20! Try again:" << std::endl;
        std::cin >> n;
    }
    std::cout << Factorial::factorial(n) << std::endl;

    return 0;
}
