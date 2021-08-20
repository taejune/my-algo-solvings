


def count(n):
	d = {};
	d[1] = {0: 0, 1: 1};

	for i in range(2, n+1):
		d[i] = {};
		d[i][0] = d[i-1][0] + d[i-1][1] ;
		d[i][1] = d[i-1][0];

	return d;



N = int(raw_input());
d = count(N);
print(d[N][0] + d[N][1]);





# 1

# 10

# 100
# 101

# 1000
# 1001
# 1010

