# String Compression: Implement a method to perform basic string compression using the counts
# of repeated characters. For example, the string aabcccccaaa would become a2b1c5a3. If the
# "compressed" string would not become smaller than the original string, your method should return
#the original string. You can assume the string has only uppercase and lowercase letters (a-z).

# Variable Solution 
# Time Complexity: O(n)
# Space Complexity: O(1)
def string_compression(string):
    if len(string) == 0:
        return string

    result = ""
    current_letter = string[0]
    count = 0

    for char in string:
        if char == current_letter:
            count+=1
        else:
            result += current_letter + str(count)
            current_letter = char
            count = 1
    result += current_letter + str(count)

    if len(result) < len(string):
        return result 
    else:
        return string

print(string_compression('aabcccccaaa'))
print(string_compression('aab'))
print(string_compression('abababab'))
print(string_compression(''))
    
