
n = int(raw_input());
D = map(int, raw_input().split());

M = dict();
S = dict();

M[0] = D[0];
S[0] = D[0];

for i in range(1, n):
	M[i] = M[i-1] + D[i] if M[i-1] + D[i] > D[i] else D[i];
	S[i] = S[i-1] + D[i] if S[i-1] + D[i] > M[i-1] else M[i-1];
	

print(max(S.values() + M.values()));


# D: 10 -4  3  1  5  6 -35 12 21 -1 -100 200
# M: 10  6  9 10 15 21 -14 12 33 32  -68  
# S: 10 10 13 14 19 25  21 33 54 53   32