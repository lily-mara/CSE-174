def sum13(nums):
  num13 = 0

  for i in nums:
    if i == 13:
      num13 += 1

  while num13 > 0:
    i13 = nums.index(13)
    
    if i13 < len(nums) - 1 and nums[i13 + 1] != 13:
      nums.remove(nums[i13 + 1])
  
    nums.remove(13)
    num13 -= 1
  
  return sum(nums)

def checker(function, answer):
  return function == answer

print checker(sum13([1, 2, 2, 1]), 6)
print checker(sum13([1, 1]), 2)
print checker(sum13([1, 2, 2, 1, 13]), 6)
print checker(sum13([1, 2, 13, 2, 1, 13]), 4)
print checker(sum13([13, 1, 2, 13, 2, 1, 13]), 3)
print checker(sum13([]), 0)
print checker(sum13([13]), 0)
print checker(sum13([13, 13]), 0)
print checker(sum13([13, 0, 13]), 0)
print checker(sum13([13, 1, 13]), 0)
print checker(sum13([5, 7, 2]), 14)
print checker(sum13([5, 13, 2]), 5)
print checker(sum13([0]), 0 )
print checker(sum13([13, 0]), 0)
