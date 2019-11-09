import random
import sys

n = int(sys.argv[1])
seed = int(sys.argv[2])

random.seed(seed)

my_set = set()
while (len(my_set) != n) :
    my_set.add(random.randint(1, n*10))

for i in my_set :
    print(i)
