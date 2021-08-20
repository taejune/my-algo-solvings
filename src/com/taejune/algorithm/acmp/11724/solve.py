
G = dict();
visit = dict();

def bfs(node):
    global G, visit;
    queue = list();
    queue.append(node);

    while queue:
        cur = queue.pop(0);
	for i in G[cur]:
            if not visit[i]:
                queue.append(i);
                visit[i] = True;


N, M = map(int, raw_input().split());

for i in range(1, N+1):
    G[i] = list();
    visit[i] = False;

for i in range(M):
    s, e = map(int, raw_input().split());
    G[s].append(e);
    G[e].append(s);

nConnect = 0;

for i in range(1, N+1):
    if not visit[i]:
        bfs(i);
        nConnect += 1;

print(nConnect);
