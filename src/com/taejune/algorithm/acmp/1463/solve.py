

m = dict();

def count(n):
	global m;
	m[1] = 0;
	for i in range(2, n+1):	
		m[i] = m[i-1] + 1;
		if i%2 == 0 and m[i] > m[i/2] + 1:
			m[i] = m[i/2] + 1;
		if i%3 == 0 and m[i] > m[i/3] + 1:
			m[i] = m[i/3] + 1;

n = int(raw_input());
count(n);
print(m[n]);



