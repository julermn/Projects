#include <iostream>

int main()
{
    // Processing user input
    std::cout << "Enter a number for Fibonacci sequence:" << std::endl;
    int n = 0;
    std::cin >> n;
    while (n > 92)
    {
        // Program will generate a Fibonacci sequence to number n
        // If n is greater than 92, that program will fail, because "long long" will overflow
        std::cout << "The number should be less or equals 92! Try again:" << std::endl;
        std::cin >> n;
    }

    // I didn't choose a program's variant with recurcive fibonacci function,
    // because this realization is longer, of course, but is really faster,
    // especially for maximum values of "n" (~90, for example)
    if (n == 0)
    {
        std::cout << 0 << std::endl;
        return 0;
    }
    if (n >= 1)
    {
        std::cout << 1 << std::endl;
    }
    int count = n - 1;
    long long buf = 0;
    long long f1 = 0;
    long long f2 = 1;
    while (count > 0)
    {
        buf = f2;
        f2 += f1;
        std::cout << f2 << std::endl;
        f1 = buf;
        --count;
    }

    return 0;
}
