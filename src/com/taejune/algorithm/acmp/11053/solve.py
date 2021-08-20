
N = int(raw_input());
D = map(int, raw_input().split());

M = dict();

for i in range(N):
	M[i] = 1;
	for j in reversed(range(i)):
		if D[i] > D[j] and M[i] < M[j] + 1:
			M[i] = M[j] + 1;

print(max(M.values()));