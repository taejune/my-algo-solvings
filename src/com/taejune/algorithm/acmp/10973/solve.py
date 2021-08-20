
def swap(a, b):
    return b, a;

def prev_permutation(row):
    N = len(row);
    pivot = N-1;

    while pivot > 0 and not row[pivot-1] > row[pivot]:
        pivot -= 1;

    if pivot == 0:
        return [-1];

    max = pivot;
    pivot -= 1;

    for i in range(pivot+1, N):
        if row[i] < row[pivot] and row[i] > row[max]:
            max = i;

    row[pivot], row[max] = swap(row[pivot], row[max]);

    toSort = row[pivot+1:]
    toSort.sort(reverse=True);
    del row[pivot+1:];

    return row + toSort;


N = int(raw_input());
row = map(int, raw_input().split());
print(' '.join(map(str, prev_permutation(row))));

# 0   1   2   3
# -------------

# 1   3   2   4
# 1   2   4   3
# 1   2   3   4

# 1  3  5  2  4
# 1  3  4  5  2
# 1  3  4  2  5