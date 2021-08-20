
n = int(raw_input());
D = map(int, raw_input().split());

M = dict();
M[0] = D[0];

for i in range(1, n):
	M[i] = D[i];
	if M[i] < M[i-1] + D[i]:
		M[i] = M[i-1] + D[i];

print(max(M.values()));