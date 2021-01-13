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

# Sorting First solution
# Time Complexity: O(nlog(n))
# Space Complexity: O(1)
def is_unique_sf(string: str):
    string = sorted(string)

    i = 0
    while (i < len(string) - 1):
        if string[i] == string[i+1]:
            return False
        i+=1

    return True

print(is_unique_sf("banana")) # False
print(is_unique_sf("cake")) # True
print(is_unique_sf("")) # True
