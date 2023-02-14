#include <string>
#include <iostream>
namespace happy
{
    // Without recursion
    bool isHappy(int n)
    {
        int sum = 0;
        int len = std::to_string(n).size();
        while (n != 1)
        {
            len = std::to_string(n).size();
            for (int i = 1; i <= len; ++i)
            {
                sum += (n % 10) * (n % 10);
                n /= 10;
            }
            n = sum;
            sum = 0;
            if (n == 89 || n == 9)
            {
                return false;
            }
        }
        return true;
    }

    // With recursion
    bool isHappyRec(int n)
    {
        if (n == 1)
        {
            return true;
        }
        if (n == 89 || n == 9)
        {
            return false;
        }
        int sum = 0;
        int len = std::to_string(n).size();
        for (int i = 1; i <= len; ++i)
        {
            sum += (n % 10) * (n % 10);
            n /= 10;
        }
        return isHappy(sum) ? true : false;
    }
}

int main()
{
    // Processing user input
    std::cout << "Enter a number:" << std::endl;
    int n = 0;
    std::cin >> n;
    while (n > 1000000 || n <= 0)
    {
        // Program will generate first n Happy numbers
        // If n is greater than 1000000, that program will fail, because "int" will
        // overflow
        std::cout << "This program can generate only up to 1 000 000 happy numbers! Try again:" << std::endl;
        std::cin >> n;
    }

    int count = 0;
    for (int i = 1;; ++i)
    {
        // if (happy::isHappy(i))
        if (happy::isHappyRec(i))
        {
            std::cout << i << std::endl;
            ++count;
            if (count == n)
            {
                break;
            }
        }
    }
    
    return 0;
}
