# Palindrome Permutation: Given a string check if it is a permutation of a palindrome

# Hash Map solution
# Time Complexity: O(n)
# Space Complexity: O(n)
def palindrome_permutation(str):
    map = {}
    str = str.lower()
    for char in str:
        if char == ' ':
            continue
        elif char in map:
            map[char] += 1
        else:
            map[char] = 1

    odd_count = 0
    for key in map:
        if map[key] % 2 != 0:
            odd_count += 1
            if (odd_count > 1):
                return False

    return True

print(palindrome_permutation("Tact Coa"))
print(palindrome_permutation("abca"))
print(palindrome_permutation("abcab"))
print(palindrome_permutation("abab"))
print(palindrome_permutation(""))
print(palindrome_permutation("a"))
