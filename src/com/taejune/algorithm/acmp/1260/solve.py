from __future__ import print_function;

D = dict();
V = dict();

def dfs(v):
	global D, V;

	print(v, end=" ");
	V[v] = 1;
	for i in range(len(D[v])):
		if V[D[v][i]] == 0:
			dfs(D[v][i]);


def bfs(v):
	global D, V;
	
	print(v, end=" ");
	c = [];
	V[v] = 0;
	c.append(v);

	while c:
		t = c.pop(0);
		for i in range(len(D[t])):
			if V[D[t][i]] == 1:
				V[D[t][i]] = 0;
				c.append(D[t][i]);
				print(D[t][i],  end=" ");



N, M, S = map(int, raw_input().split());

for i in range(1, N+1):
	D[i] = list();
	V[i] = 0;
	
for i in range(M):
	r, c = map(int, raw_input().split());
	D[r].append(c);
	D[c].append(r);

for i in range(1, N+1):
	D[i].sort();

dfs(S);
print('');
bfs(S);