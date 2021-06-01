from itertools import combinations



num_buns = 5
num_required = 3
buns = [[] for i in range(num_buns)]
if num_required == 0:
    print(buns)
start = 0
for c in combinations(buns, num_buns - num_required + 1):
    for item in c:
        item.append(start)
    print(c)
    start += 1
print() 
print(buns)