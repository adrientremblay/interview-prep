#ifndef ALGORITHMS_ZEROMATRIX_H
#define ALGORITHMS_ZEROMATRIX_H
#include <vector>
using namespace std;

/**
 * Zero Matrix: Write an algorithm such that if an element in an MxN matrix is 0, it's entire row and columns are set to 0
 */
class ZeroMatrix {
    public:
        vector<vector<int>> hashSolution(vector<vector<int>> matrix);
};


#endif //ALGORITHMS_ZEROMATRIX_H
