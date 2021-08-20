import math;

N = int(raw_input());
D = range(N+1);

for i in range(1, N+1):
	for j in range(1, int(math.sqrt(i))+1):
		if D[i] > D[i-j*j] + 1:
			D[i] = D[i-j*j] + 1;

print(D[N]);


# D[N] = min(D[N-i^2] + 1);
# 1 <= i^2 <= N