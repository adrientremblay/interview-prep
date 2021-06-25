#include <gtest/gtest.h>
#include "ZeroMatrix.h"
#include <vector>

TEST(BasicTest, BasicAssertions) {
    vector<vector<int>> matrix {
            {0, 1, 2},
            {8, 5, 6},
            {8, 0, 9}
    };

    vector<vector<int>> answer {
            {0, 0, 0},
            {0, 0, 6},
            {0, 0, 0}
    };

    ZeroMatrix z;
    vector<vector<int>> zeroed = z.hashSolution(matrix);

    EXPECT_EQ(zeroed, answer);
}