from __future__ import print_function;
import operator;

N = int(raw_input());
D = map(int, raw_input().split());

M = dict();
I = dict();

for i in range(N):
	M[i] = 1;
	I[i] = i;
	for j in reversed(range(i)):
		if D[i] > D[j] and M[i] < M[j] + 1:
			M[i] = M[j] + 1;
			I[i] = j;

index, value = max(enumerate(M.values()), key=operator.itemgetter(1));

l = [index];
while I[index] != index:
	l.append(I[index]);
	index = I[index];

print(value);
for i in reversed(l):
	print(D[i], end=" ");
