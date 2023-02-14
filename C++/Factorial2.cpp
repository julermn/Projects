#include <iostream>

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
    long long f = 1;
    for (int i = 1; i <= n; ++i)
    {
        f *= i;
    }
    std::cout << f << std::endl;

    return 0;
}
