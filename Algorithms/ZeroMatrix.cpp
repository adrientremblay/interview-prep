#include <iostream>
#include "ZeroMatrix.h"
#include <vector>
#include <bits/stdc++.h>
using namespace std;

/**
 * The hash set solution to the problem. Iterate through the matrix, making note of all zeros. Record the column and row index in two
 * hash sets. Then iterate through these sets and zero the rows and columns.
 * Time complexity: M*N
 * Space complexity: M + N ???
 */
vector<vector<int>> ZeroMatrix::hashSolution(vector<vector<int>> matrix) {
    unordered_set<int> rowsToZero;
    unordered_set<int> colsToZero;

    // finding rows and columns to zero
    for (int i = 0; i < matrix.size() ; i++) {
        for (int j = 0 ; j < matrix.at(i).size() ; j++) {
            if (matrix.at(i).at(j) == 0) {
                rowsToZero.insert(i);
                colsToZero.insert(j);
            }
        }
    }

    int m = matrix.size();
    // zeroing the rows
    for (int rowIndex : rowsToZero) {
        matrix.at(rowIndex).assign(m, 0);
    }

    // zeroing the cols
    for (int colIndex : colsToZero) {
        for (int i = 0 ; i < matrix.at(colIndex).size() ; i++) {
            matrix.at(i).at(colIndex) = 0;
        }
    }

    return matrix;
}