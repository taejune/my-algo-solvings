


T = int(raw_input());
N = [];
D = {};
M = {};
A = [];

for i in range(T):
	N = int(raw_input());
	
	D[0] = map(int, raw_input().split());
	D[1] = map(int, raw_input().split());

	M[1] = dict();
	M[1][0] = 0;
	M[1][1] = D[0][0];
	M[1][2] = D[1][0];

	for i in range(2, N+1):
		M[i] = dict();
		M[i][0] = max(M[i-1][0], M[i-1][1], M[i-1][2]);
		M[i][1] = max(M[i-1][0] + D[0][i-1], M[i-1][2] + D[0][i-1]);
		M[i][2] = max(M[i-1][0] + D[1][i-1], M[i-1][1] + D[1][i-1]);

	A.append(max(M[N][0], M[N][1], M[N][2]));


for i in range(len(A)):
	print(A[i]);


# M[n][0] = max(M[n-1][0] + D(i, 1), M[n-1][1] + D(i, 1), M[n-1][2] + D(i, 0));
# M[n][1] = max(M[n-1][0] + D(i, 1), M[n-1][2] + D(i, 1));
# M[n][2] = max(M[n-1][0] + D(i, 0), M[n-1][1] + D(i, 0));