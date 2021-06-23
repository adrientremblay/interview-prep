//
// Created by atremblay on 6/22/2021.
//

#include <iostream>
#include "ZeroMatrix.h"
#include <vector>
#include <bits/stdc++.h>
using namespace std;

vector<vector<int>> ZeroMatrix::rotate(vector<vector<int>> matrix) {
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

    int n = matrix.size();
    // zeroing the rows
    for (int rowIndex : rowsToZero) {
        matrix.at(rowIndex).assign(n, 0);
    }

    // zeroing the cols
    for (int colIndex : colsToZero) {
        for (int i = 0 ; i < matrix.at(colIndex).size() ; i++) {
            matrix.at(i).at(colIndex) = 0;
        }
    }

    return matrix;
}