

def count(n):
	d = {};
	d[1] = {1: 1, 2: 0, 3: 0};
	d[2] = {1: 0, 2: 1, 3: 0};
	d[3] = {1: 1, 2: 1, 3: 1};

	if n < 4:
		return d;

	for i in range(4, n+1):
		d[i] = dict();
		d[i][1] = d[i-1][2] + d[i-1][3];
		d[i][2] = d[i-2][1] + d[i-2][3];
		d[i][3] = d[i-3][1] + d[i-3][2];

	return d;


T = int(raw_input());
p = [];

for i in range(T):
	p.append(int(raw_input()));

d = count(max(p))

for i in range(T):
	print((d[p[i]][1] + d[p[i]][2] + d[p[i]][3]) % 1000000009) ;



# 1

# 2

# 1 2
# 2 1
# 3

# 1 2 1
# 1 3
# 3 1


# 1 3 1
# 2 1 2
# 2 3
# 3 2

# 1 2 3
# 1 3 2
# 2 1 3
# 2 3 1
# 3 1 2
# 3 2 1

# 1 2 1 3
# 1 2 3 1
# 2 1 3 1
# 2 3 2
# 3 1 2 1
# 3 1 3


# C(n) = (C(n-1) -  D(1))+ (C(n-2) - D(2)) + (C(n-3) - D(3))

# c = {};
# c[1] = 1;
# c[2] = 1;
# c[3] = 3;

# d = {};
# d[1] = {1: 1, 2: 0, 3: 0};
# d[2] = {1: 0, 2: 1, 3: 0};
# d[3] = {1: 1, 2: 1, 3: 1};

# def count(n):
# 	global c, d;

# 	if n < 4:
# 		return c;

# 	for i in range(4, n+1):
# 		c[i] = (c[i-1] - d[i-1][1]) + (c[i-2] - d[i-2][2]) + (c[i-3] - d[i-3][3]);
# 		d[i] = dict();
# 		d[i][1] = c[i-1] - d[i-1][1];
# 		d[i][2] = c[i-2] - d[i-2][2];
# 		d[i][3] = c[i-3] - d[i-3][3];

# 	return c;



# T = int(raw_input());
# p = [];

# for i in range(T):
# 	p.append(int(raw_input()));

# count(max(p))

# for i in range(T):
# 	print(c[p[i]]);


# C(n) = C(n-1)[2] + C(n-1)[3] + C(n-2)[1] + C(n-2)[3] +  C(n-3)[1] + C(n-3)[2];  