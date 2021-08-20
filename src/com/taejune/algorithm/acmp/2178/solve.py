


n, m = map(int, raw_input().split());

matrix = [];

for i in range(n):
    r = [];
    while len(r) != m:
        tmp = map(int, raw_input().split());
        r += tmp;
    matrix.append(r);

print(matrix)
