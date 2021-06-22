//
// Created by atremblay on 6/22/2021.
//

#include <iostream>
#include "ZeroMatrix.h"
#include <vector>
#include <bits/stdc++.h>
using namespace std;

int ZeroMatrix::rotate(vector<vector<int>> vec) {
    unordered_set<int> rowsToZero;
    unordered_set<int> colsToZero;

    // finding rows and columns to zero
    for (int i = 0; i < vec.size() ; i++) {
        for (int j = 0 ; j < vec.at(i).size() ; j++) {
            if (vec.at(i).at(j) == 0)
                rowsToZero.insert(i);
                colsToZero.insert(j);
        }
    }

    for (int row : rowsToZero) {
        cout << row << " ";
    }
}