# Is Unique: Implement an algorithm to determine if a string has all unique characters.
# What if you cannot use additional data structures?

# Hash Map solution
# Time Complexity: O(n)
# Space Complexity: O(n)
def is_unique_hm(string: str):
    map = {}

    for char in string:
        if char in map:
            return False
        map[char] = True

    return True

print(is_unique_hm("banana")) # False
print(is_unique_hm("cake")) # True
print(is_unique_hm("")) # True
