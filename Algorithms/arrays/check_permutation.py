# Check Permutation: Given two strings, write a method to decide if one is a premutation of the other.

# Hash Map solution
# Time Complexity: O(n)
# Space Complexity: O(n)
def check_permutation(s1, s2):
    history = {}

    for char in s1:
        if not char in history:
            history[char] = 1
        else:
            history[char] += 1

    for char in s2:
        if not char in history:
            return False
        history[char] -= 1

    for key, value in history.items():
        if value != 0:
            return False

    return True

print(check_permutation("abc", "bac")) # True
print(check_permutation("", "")) # True 
print(check_permutation("a", "")) # False
print(check_permutation("dumbass", "donald")) # False
print(check_permutation("abc", "baca")) # False
