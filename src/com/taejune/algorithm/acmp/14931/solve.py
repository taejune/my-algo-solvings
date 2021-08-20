N, M = map(int, raw_input().split());

D = list();
for i in range(N):
    l = raw_input();
    r = [];
    for j in range(M):
        r.append(int(l[j]));
    D.append(r);

ans = 0;

for i in range(pow(2, N*M)):
    case = bin(i).split('b')[1].zfill(N*M);
    sum = 0;
    
    # 가로 직사각형 숫자 추가 
    for i in range(N):
        num = 0;
        for j in range(M):
            if not (int(case) & (1<<(i*M + j))):
                num = num*10 + D[i][j];
                # print('rnum: ' + str(num));
            else:
                sum += num;
                num = 0;
        # print('rsum: ' + str(num));
        sum += num;
    
    # 세로 직사각형 숫자 추가 
    for j in range(M):
        num = 0;
        for i in range(N):
            if int(case) & (1<<(i*M + j)):
                num = num*10 + D[i][j];
                # print('cnum: ' + str(num));
            else:
                sum += num;
                num = 0;
        # print('csum: ' + str(num));
        sum += num;

    # print(case + ' ' + str(sum));

    ans = max(ans, sum);

print(ans);