# One Away: There are three types of edits that can be performed on string: insert a character,
# remove a character, or replace a character. Given two string, write a function to check if they are
# one edit (or zero edits) away.


# If Statement 
# Time Complexity: O(n)
# Space Complexity: O(1)
def one_away(long, short):
    used_op = False

    if len(short) > len(long):
        short, long = long, short
  
    i_short = 0
    i_long = 0

    while i_long < len(long):
        if i_short >= len(short): # short over length
            if used_op:
                return False
            else:
                used_op = True
        else: # short under length
            if long[i_long] != short[i_short]:
                if used_op:
                    return False
                else:
                    if i_long < len(long) - 1 and long[i_long + 1] == short[i_short] : #skip
                        i_short-=1
                    # otherwise replace
                    used_op = True
    
        i_long += 1
        i_short += 1
  
    return True

print(one_away("pale", "ple"));
print(one_away("pales", "pale"));
print(one_away("pale", "bale"));
print(one_away("pale", "bake"));
