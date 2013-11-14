def lone_sum(a, b, c):
    origNums = [a, b, c]
    cleanNums = []
   
    for i in range(0, 3):
        testPoint = origNums[i]
        if origNums.index(testPoint) != i:
            origNums.remove(testPoint)
            origNums.remove(testPoint)
    
    for i in origNums:
        cleanNums.append(i)
    
    return sum(cleanNums)

def checker(function, expectedValue):
    return function == expectedValue

print checker(lone_sum(1, 2, 3),  6)              
print checker(lone_sum(3, 2, 3),  2)            
print checker(lone_sum(3, 3, 3),  0)              
print checker(lone_sum(9, 2, 2),  9)              
print checker(lone_sum(2, 2, 9),  9)              
print checker(lone_sum(2, 9, 2),  9)              
print checker(lone_sum(2, 9, 3),  14)          
print checker(lone_sum(4, 2, 3),  9)              
print checker(lone_sum(1, 3, 1),  3)