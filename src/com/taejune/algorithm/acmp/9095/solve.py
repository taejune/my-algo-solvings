'''
1 = 1

2 = 1 + 1
  = 2

3 = 1 + 1 + 1
  = 1 + 2
  = 2 + 1
  = 3

4 = 1 + 1 + 1 + 1
  = 1 + 1 + 2
  = 1 + 2 + 1
  = 1 + 3
  = 2 + 1 + 1
  = 2 + 2
  = 3 + 1

D[1] = 1
D[2] = 2
D[3] = 4
D[4] = D[3] + D[2] + D[1]
D[5] = D[4] + D[3] + D[2]

n = 1 + (n-1)
  = 2 + (n-2)
  = 3 + (n-3)

'''

def count(n):
	m = dict();
	m[1] = 1;
	m[2] = 2;
	m[3] = 4;
	
	if n<4:
		return m;

	for i in range(4, n+1):
		m[i] = m[i-1] + m[i-2] + m[i-3]

	return m;


def rcount(n):
	if n == 1:
		return 1;
	elif n == 2:
		return 2;
	elif n == 3:
		return 4;
	elif n > 3:
		return rcount(n-1) + rcount(n-2) + rcount(n-3);

T = int(raw_input());
answer = [];

for i in range(T):
	n = int(raw_input());
	answer.append(count(n)[n]);


for i in range(T):
	print(answer[i]);