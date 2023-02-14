#include <iostream>
#include <vector>
#include <string>
namespace name
{
    const std::vector<std::string> one_nine = {"", "one", "two", "three", "four", "five",
                                               "six", "seven", "eight", "nine"};
    const std::vector<std::string> eleven_nineteen = {"", "eleven", "twelve", "thirteen", "fourteen",
                                                      "fifteen", "sixteen", "seventeen", "eighteen", "nineteen"};
    const std::vector<std::string> ten_ninety = {"", "ten", "twenty", "thirty", "fourty", "fifty",
                                                 "sixty", "seventy", "eighty", "ninety"};
    const std::vector<std::string> hundred_billion = {"", "hundred", "thousand", "million", "billion"};

    std::string fromOneToNinetyNine(const int &n);
    std::string hundreds(const int &n);
    std::string thousands(const int &n);
    std::string millions(const int &n);
    std::string billions(const int &n);

    std::string nameOf(const int &n)
    {
        if (n == 0)
        {
            return "zero";
        }
        if (n < 100)
        {
            return fromOneToNinetyNine(n);
        }
        if (n >= 100 && n < 1000)
        {
            return hundreds(n);
        }
        if (n >= 1000 & n < 1000000)
        {
            return thousands(n);
        }
        if (n >= 1000000 & n < 1000000000)
        {
            return millions(n);
        }
        if (n >= 1000000000)
        {
            return billions(n);
        }
        return "Oops!";
    }

    std::string fromOneToNinetyNine(const int &n)
    {
        if (n < 10)
        {
            return one_nine[n] + " ";
        }

        if (n < 20 && n > 10)
        {
            return eleven_nineteen[n % 10] + " ";
        }
        else
        {
            return ten_ninety[(n / 10) % 10] + " " + (n % 10 == 0 ? "" : one_nine[n % 10] + " ");
        }
        return "";
    }

    std::string hundreds(const int &n)
    {
        int h = n / 100;
        return (h != 0 ? (one_nine[h] + " " + hundred_billion[1]) + " " : "") + fromOneToNinetyNine(n - (h * 100));
    }

    std::string thousands(const int &n)
    {
        int t = n / 1000;
        return (t != 0 ? (hundreds(t) + hundred_billion[2] + " ") : "") + hundreds(n - (t * 1000));
    }

    std::string millions(const int &n)
    {
        int m = n / 1000000;
        return (m != 0 ? (thousands(m) + hundred_billion[3] + " ") : "") + thousands(n - (m * 1000000));
    }

    std::string billions(const int &n)
    {
        int b = n / 1000000000;
        return millions(b) + hundred_billion[4] + " " + millions(n - (b * 1000000000));
    }

}

int main()
{
    // Processing user input
    std::cout << "Enter a number:" << std::endl;
    int n = 0;
    std::cin >> n;
    while (n > 2000000000 || n <= 0)
    {
        // Program will generate name of n
        std::cout << "This program can generate names of numbers only up to 2 000 000 000! Try again:" << std::endl;
        std::cin >> n;
    }
    std::cout << name::nameOf(n) << std::endl;
    return 0;
}
