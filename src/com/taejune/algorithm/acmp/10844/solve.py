
def count(n):
	d = {};
	d[1] = {0: 1, 1: 1, 2: 1, 3: 1, 4: 1: 5: 1, 6: 1, 7: 1, 8: 1, 9: 1};
	
	if n < 2:
		return d;

	for i in range(2, n+1):
		d[i] = dict();
		d[i][1] = d[i-1][2] + d[i-1][3];
		d[i][2] = d[i-2][1] + d[i-2][3];
		d[i][3] = d[i-3][1] + d[i-3][2];
		d[i][4] = d[i-3][1] + d[i-3][2];
		d[i][5] = d[i-3][1] + d[i-3][2];
		d[i][6] = d[i-3][1] + d[i-3][2];
		d[i][7] = d[i-3][1] + d[i-3][2];
		d[i][8] = d[i-3][1] + d[i-3][2];
		d[i][9] = d[i-3][1] + d[i-3][2];

	return d;


T = int(raw_input());
p = [];

for i in range(T):
	p.append(int(raw_input()));

d = count(max(p))

for i in range(T):
	for i in range(10):
		((d[p[i]][1] + d[p[i]][2] + d[p[i]][3]) % 1000000009) ;




# 1 2 3 4 5 6 7 8 9 

# 10 12
# 21 23
# 32 34
# 43 45
# 54 56
# 65 67


# 101
# 121 123
# 210 232 234
# 321 323 343 345
# 432 434 454 456





