# Two pointer final position method
# TC: O(n)
# SC: O(1)

def URLify(string, n):
    array = [char for char in string]

    # Finding number of spaces O(n)
    spaces = 0
    for i in range(n):
        char = array[i]
        if char == ' ':
            spaces += 1

    # URLifying O(n)
    left = n - 1
    right = n - 1 + (2 * spaces)
    while left > 0:
        char = array[left]
        if char == ' ':
            array[right] = '%'
            array[right - 1] = '0'
            array[right - 2] = '2'
            right -= 3
        else:
            array[right] = char
            right -= 1
        left -= 1

    return "".join(array)

print(URLify("Mr John Smith    ", 13))
print(URLify("", 0))
print(URLify("a", 1))
print(URLify("   ", 1))

