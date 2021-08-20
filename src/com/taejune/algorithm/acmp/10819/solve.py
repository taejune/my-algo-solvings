

def swap(a, b):
    return b, a;

def next_permutation(row):
    N = len(row);
    pivot = N-1;

    while pivot > 0 and not row[pivot-1] < row[pivot]:
        pivot -= 1;

    if pivot == 0:
        return False;

    min = pivot;
    pivot -= 1;

    for i in range(pivot+1, N):
        if row[i] > row[pivot] and row[i] < row[min]:
            min = i;

    row[pivot], row[min] = swap(row[pivot], row[min]);

    toSort = row[pivot+1:]
    toSort.sort();
    del row[pivot+1:];
    row += toSort;

    return True;

def func(arr):
    sum = 0;
    
    for i in range(len(arr) -1):
        sum += abs(arr[i+1] - arr[i]);
    
    return sum;

N = int(raw_input());
A = map(int, raw_input().split());


max = 0;
idx = range(N);

while True:
    calc = func([A[idx[j]] for j in range(len(idx))]);
    if max < calc:
        max = calc;
    
    if not next_permutation(idx): break;
        
print(max);