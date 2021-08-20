
def gcf(a, b):
    while b != 0:
        r = a % b;
        a = b;
        b = r;
    
    return a;
    
def lcm(a, b):
    return a * b / gcf(a, b);

T = int(raw_input());
C = [];

for i in range(T):
    M, N, x, y = map(int, raw_input().split());

    max = lcm(M, N);
    D = x;
    while D <= max:
        D += M;
        if D % N == y:
            break;

    if D > max:
        C.append(-1)
    else:
        C.append(D)

for i in range(T):
    print(C[i]);

'''
5 7  2  3

 1:  1  1
 2:  2  2 
 3:  3  3
 4:  4  4 
 5:  5  5 
 6:  1  6 
 7:  2  7 
 8:  3  1 
 9:  4  2 
10:  5  3
11:  1  4
12:  2  5
13:  3  6
14:  4  7
15:  5  1
16:  1  2
17:  2  3
18:  3  4
19:  4  5
20:  5  6
21:  1  7
22:  2  1
23:  3  2
24:  4  3
25:  5  4
26:  1  5
27:  2  6
28:  3  7
29:  4  1
30:  5  2
31:  1  3
32:  2  4
33:  3  5
34:  4  6
35:  5  7

'''