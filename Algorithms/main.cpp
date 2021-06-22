#include <iostream>
#include "ZeroMatrix.h"
#include <vector>
using namespace std;

int main() {
    cout << "Hello, World!" << endl;

    vector<vector<int>> vect
            {
                    {0, 0, 0},
                    {4, 5, 6},
                    {7, 0, 9}
            };

    ZeroMatrix z;
    z.rotate(vect);

    return 0;
}
