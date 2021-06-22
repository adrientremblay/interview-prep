# Rotate Matrix: Given an image represented by an NxN matrix, where each pixel in the image is 4 bytes, write a method to rotate the image by 90 degrees
# can you do this in place?

# Layer rotation solution
# Time Complexity O(n^2)
# Space Complexity: O(1)
import math
def rotate_matrix(matrix):
    N = len(matrix)
    for i in range(math.ceil(N/2)):
        for j in range(i, N - 1):
            i_old = i
            j_old = j
            value_old = matrix[i][j]
            for execution in range(4):
                i_new = j_old
                j_new = N - i_old - 1
                temp = matrix[i_new][j_new]
                matrix[i_new][j_new] = value_old
                i_old = i_new
                j_old = j_new
                value_old = temp 
    return matrix

print(rotate_matrix([]))
print(rotate_matrix([[1]]))
print(rotate_matrix([[1, 2], [3, 4]]))
print(rotate_matrix([[1, 2, 3], [4, 5, 6], [7, 8, 9]]))
