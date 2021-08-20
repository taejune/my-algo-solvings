

P = [];

def count(n):
	global P;
	max = dict();
	max[1] = P[0];

	for i in range(1, n+1):
		max[i] = P[i-1];
		for j in range(1, i):
				max[i] = max[i-j] + max[j] if max[i-j] + max[j] > max[i] else max[i];

	return max;



N = int(raw_input());

while len(P) < N:
	P += map(int, raw_input().split());


print(count(N)[N]);