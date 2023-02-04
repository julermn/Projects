#include <iostream> //For std::cin and std::cout
#include <set>      //For set
#include <cmath>    //For sqrt()

namespace Primes
{
    std::set<int> primes{1, 2, 3, 7, 11, 13, 17, 19, 23, 29, 31};
    bool isPrime(int &p)
    {
        if (p <= 3)
        {
            return true;
        }

        int s = (int)std::sqrt(p);

        for (int i = 2; i <= s; ++i)
        {
            if (!primes.count(i))
            {
                if (!isPrime(i))
                {
                    continue;
                }
            }
            if (p % i == 0)
            {
                return false;
            }
        }

        primes.insert(p);
        return true;
    }
}
int main()
{
    // Processing user input
    std::cout << "Enter N:" << std::endl;
    int n = 0;
    std::cin >> n;

    while (n > 2147483647)
    {
        // Program will generate prime factorization for number n
        // If n is greater than 2147483647, that program will fail, because "int" will overflow
        std::cout << "The number should be less or equals 2147483647! Try again:" << std::endl;
        std::cin >> n;
    }

    // Output user prime factorizations for n
    std::cout << "Prime factorizations for " << n << ":" << std::endl;

    if (n == 0)
    {
        std::cout << 0 << std::endl;
        return 0;
    }

    int s = (int)std::sqrt(n);

    for (int i = 1; i <= s; ++i)
    {
        if (Primes::isPrime(i) && n % i == 0)
        {
            std::cout << i << std::endl;
        }
    }
    
    return 0;
}
