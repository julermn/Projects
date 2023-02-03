// This realization of fibonacci sequence with recursive function is not recomended,
// because is slower than other variants (F1.cpp, for example).
// This is here only for learning
#include <iostream>

namespace fib
{
    long long fibonacci(long long f)
    {
        return f <= 2 ? 1 : fibonacci(f - 1) + fibonacci(f - 2);
    }
}

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

    for (int i = 1; i <= n; ++i)
    {
        std::cout << fib::fibonacci(i) << std::endl;
    }

    return 0;
}
