


n = int(raw_input());
q = [];

for i in range(n):
	q.append(int(raw_input()));






''' '''
m[n][0] = max( m[n-1][0], m[n-1][1], m[n-1][2])
m[n][1] = m[n-1][0] + q[n] 
m[n][2] = m[n-1][1] + q[n] 