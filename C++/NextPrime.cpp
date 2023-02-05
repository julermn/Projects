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
    char c;
    int nextPrime = 1;
    std::cout << "Do you want to get next prime number?[Y/N]:" << std::endl;
    std::cin >> c;
    c = tolower(c);
    while (c != 'n')
    {
        if (c == 'y')
        {
            // Output next prime number
            std::cout << nextPrime << std::endl;
            // And finding next prime number
            for (int i = nextPrime + 1;; ++i)
            {
                if (Primes::isPrime(i))
                {
                    nextPrime = i;
                    break;
                }
            }
            std::cin >> c;
        }
        else
        {
            std::cout << "Input must be a symbol 'Y' or 'N'. Try again:" << std::endl;
            std::cin >> c;
        }
    }
    return 0;
}
