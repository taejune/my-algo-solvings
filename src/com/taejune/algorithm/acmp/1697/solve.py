
N, K = map(int, raw_input().split());

queue = list();
visit = [False] * 100001;

time = 0;
queue.append([N, time]);

while N != K:

	N, time = queue.pop(0);
	visit[N] = True;

	if not visit[N * 2]: 
		queue.append([N * 2, time+1]);

	if not visit[N + 1]: 
		queue.append([N + 1, time+1]);
	
	if not visit[N - 1]: 
		queue.append([N - 1, time+1]);

print(time);