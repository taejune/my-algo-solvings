

def count(n):
	m = {};
	m[1] = 1;
	m[2] = 2;

	for i in range(3, n+1):
		m[i] = m[i-1] + m[i-2];

	return m;

n = int(raw_input());
print(count(n)[n] % 10007);


# def count(n):
# 	if n==1:
# 		return 1;
# 	elif n==2:
# 		return 2;
# 	else:
# 		return count(n-1) + count(n-2);
# n = int(raw_input());
# print(count(n % 10007));