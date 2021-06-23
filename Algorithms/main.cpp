#include <iostream>
#include "ZeroMatrix.h"
#include <vector>

using namespace std;

void printMatrix (vector<vector<int>> matrix);

int main() {
    cout << "Hello, World!" << endl;

    vector<vector<int>> matrix {
            {0, 1, 2},
            {8, 5, 6},
            {8, 0, 9}
    };

    ZeroMatrix z;
    printMatrix(z.hashSolution(matrix));

    return 0;
}

void printMatrix (vector<vector<int>> matrix) {
   for (vector<int> row : matrix) {
      for (int number : row) {
          cout << number << " ";
      }
      cout << "\n";
   }
}