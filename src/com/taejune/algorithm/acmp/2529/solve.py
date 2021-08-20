


















''' 모든 부등호가 연관되어있을 때...'''
# k = int(raw_input());
# signs = raw_input().split();

# tree = dict();
# current = 0;
# tree[current] = [0];

# for i in range(len(signs)):
	
# 	if signs[i] == '>':
# 		current -= 1;
# 	else:
# 		current += 1;
	
# 	if tree.get(current) == None:
# 		tree[current] = list();
		
# 	tree[current].append(i+1);

# minlevel = min(tree.keys());
# maxlevel = max(tree.keys());

# vMax = [None]*(k+1);
# vMin = [None]*(k+1);
# values = range(9-k, 10);

# for i in range(maxlevel, minlevel-1, -1):
# 	for j in range(len(tree[i])):
# 		vMax[tree[i][j]] = values.pop();

# values = range(0, k+1);
# for i in range(maxlevel, minlevel-1, -1):
# 	tree[i].reverse();
# 	for j in range(len(tree[i])):
# 		vMin[tree[i][j]] = values.pop();

# print(tree);
# print(''.join(map(str, vMax)));
# print(''.join(map(str, vMin)));