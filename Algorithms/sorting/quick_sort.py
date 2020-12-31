def quick_sort(list):
    # base case
    if (len(list) <= 1):
        return list 

    # swapping the pivot and the last element
    pivot = len(list) // 2
    last = len(list) - 1
    list[pivot], list[last] = list[last], list[pivot]
    pivot = last

    # swapping item_from_left with item_from_right multiple times
    item_from_left = 0
    item_from_right = last - 1
    while True:
        while list[item_from_left] < list[pivot]:
            item_from_left+=1
        while list[item_from_right] > list[pivot]:
            item_from_right-=1

        if item_from_left >= item_from_right:
            break

#        print("swapping ", list[item_from_left], list[item_from_right])
        list[item_from_left], list[item_from_right] = list[item_from_right], list[item_from_left]

    # swapping item_from_right with pivot
    list[item_from_left], list[pivot] = list[pivot], list[item_from_left]
    pivot = item_from_left

    # performing algo on left and right
    return quick_sort(list[:pivot]) + quick_sort(list[pivot:])

list = [4,6,2,1,5,3,8,7,9]
print(quick_sort(list))
