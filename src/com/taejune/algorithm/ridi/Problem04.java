package com.taejune.algorithm.ridi;

import java.util.HashMap;
import java.util.Map;

/*
좌표평면 위에 사냥꾼과 몬스터 N 마리가 있습니다. 다음 그림과 같이 사냥꾼, 몬스터, 총알의 방향을 표시합니다.

image

사냥꾼은 (0,0) 위치에 있으며, 각 몬스터는 (0,0) 을 제외한 (x1, y1), (x2, y2), …, (xn, yn) 위치의 점으로 표현됩니다. (xi, yi는 정수)
사냥꾼은 M 개의 총알이 담긴 총을 가지고 있고, 총으로 몬스터를 사냥하려고 합니다.
사냥꾼이 총을 좌표평면의 (a, b) 방향으로 쐈을 때, 총알은 사냥꾼이 위치한 (0,0) 을 기준으로 (a, b)를 향해 일직선으로 무한히 날아갑니다.

몬스터제거하기3_ryprwa.png

이때, 다음과 같이 총알이 날아가는 경로 위에 있는 몬스터는 총알에 맞게 되며, 총알에 맞은 몬스터는 사라집니다.

몬스터제거하기4_kfk49f.png

몬스터제거하기5_tavctn.png

몬스터제거하기6_gpai1c.png

단, 몬스터에 맞은 총알은 몬스터와 함께 사라지기 때문에, 한 개의 총알로 몬스터를 연속해서 사냥할 수 없습니다.

몬스터제거하기7_t83rqf.png

8마리의 몬스터가 [[2,3],[4,5],[3,-3],[2,-4],[3,-6],[-3,-3],[-5,0],[-4,4]] 위치에있고 6발의 총알의 움직임을 나타내는 좌표 평면의 값이 [[4,1],[4,6],[1,-2],[-4,-4],[-3,0],[-4,4]]인 경우는 아래 그림과 같이 나타낼 수 있습니다.

image

이 경우 5마리의 몬스터를 사냥할 수 있습니다.

image

N마리 몬스터의 좌표가 담긴 배열 monsters와 M개의 총알의 움직임을 나타낸 좌표가 담긴 배열 bullets가 매개변수로 주어질 때, 사냥에 성공한 몬스터의 수를 return 하도록 solution 함수를 완성해 주세요. 단, 한 마리도 사냥하지 못하는 경우에는 -1을 return 해주세요.

제한사항
monsters는 2차원 배열로 주어지고, 배열의 길이(N)는 100,000 이하의 자연수입니다.
monsters의 각 원소는 2개의 원소로 이루어져 있으며, 몬스터의 위치를 나타내는 좌표평면 값 (x, y)를 나타냅니다(순서대로 [x축 좌표, y축 좌표]를 나타냅니다).
몬스터의 좌표평면 값 (x, y)에서 x와 y는 -1,000,000,000 이상 1,000,000,000 이하의 정수입니다. 단, (x, y) = (0, 0)인 경우는 주어지지 않고, 몬스터의 좌표평면 값은 중복되지 않습니다.
bullets는 2차원 배열로 주어지고, 배열의 길이(M)는 100,000 이하의 자연수입니다.
bullets의 각 원소는 2개의 원소로 이루어져 있으며, 총알의 움직임을 나타내는 방향 (a, b)를 나타냅니다(순서대로 [x축 좌표, y축 좌표]를 나타냅니다).
총알의 움직임을 나타내는 방향 (a, b)에서 a와 b는 -1,000,000,000 이상 1,000,000,000 이하의 정수입니다. 단, (a, b) = (0, 0)인 경우는 주어지지 않습니다.

입출력 예
monsters	bullets	answer
[[2,3],[4,5],[3,-3],[2,-4],[3,-6],[-3,-3],[-5,0],[-4,4]]	[[4,1],[4,6],[1,-2],[-4,-4],[-3,0],[-4,4]]	5
[[-4,4],[-2,2],[6,2],[0,-2]]	[[3,1],[-1,1],[-1,1],[0,-4],[2,-3]]	4
[[1,2],[-2,-1],[1,-2],[3,-1]]	[[1,0],[2,1]]	-1
입출력 예 설명
입출력 예 #1
문제의 예시와 같습니다.

입출력 예 #2
 */
public class Problem04 {
    public int solution(int[][] monsters, int[][] bullets) {
        int answer = -1;
        Map<Double, Integer> rMap = new HashMap<>();
        Map<Double, Integer> lMap = new HashMap<>();

        int rLimit = 0;
        int lLimit = 0;

        int cnt = 0;

        for(int i=0; i < monsters.length; i++){
            if(monsters[i][0] != 0){
                double key = monsters[i][1] / (double)monsters[i][0];
                if(monsters[i][0] > 0){
                    rMap.put(key, rMap.getOrDefault(key, 0) + 1);
                }
                else if(monsters[i][0] < 0){
                    lMap.put(key, lMap.getOrDefault(key, 0) + 1);
                }
            } else {
                if(monsters[i][1] > 0) { rLimit++; }
                if(monsters[i][1] < 0) { lLimit++; }
            }
        }

        for(int i=0; i < bullets.length; i++){
            if(bullets[i][0] != 0) {
                double key = bullets[i][1] / (double) bullets[i][0];
                if (bullets[i][0] > 0) {
                    if (rMap.get(key) != null && rMap.get(key) > 0) {
                        cnt++;
                        rMap.put(key, (rMap.get(key) - 1));
                    }

                } else if (bullets[i][0] < 0) {
                    if (lMap.get(key) != null && lMap.get(key) > 0) {
                        cnt++;
                        lMap.put(key, (lMap.get(key) - 1));
                    }
                }
            } else {
                if(bullets[i][1] > 0) { cnt++; rLimit--; }
                if(bullets[i][1] < 0) { cnt++; lLimit--; }

            }
        }


        if(cnt != 0) answer = cnt;
        return answer;
    }

    public static void main(String[] args) {

    }
}
