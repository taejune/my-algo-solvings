package com.taejune.algorithm.programmers.heap;

import java.util.Comparator;
import java.util.PriorityQueue;

public class Problem02 {
    static class Solution {
        class Job implements Comparable<Job> {
            int startTime, duration;

            public Job(int startTime, int duration) {
                this.startTime = startTime;
                this.duration = duration;
            }

            public int getStartTime() {
                return startTime;
            }
            public int getDuration() {
                return duration;
            }

            @Override
            public int compareTo(Job o) {
                return (startTime <= o.getStartTime()) ? -1 : 1;
            }

            @Override
            public String toString() {
                return "Job [" + startTime + "/ " + duration + "]";
            }
        }

        public static class JobDurationComparator implements Comparator<Job> {
            @Override
            public int compare(Job o1, Job o2) {
                return o1.getDuration() - o2.getDuration();
            }
        }

        public int solution(int[][] jobs) {
            int answer = 0;

            PriorityQueue<Job> allJobs = new PriorityQueue<>();
            for (int[] job : jobs) {
                allJobs.offer(new Job(job[0], job[1]));
            }

            int currentTime = 0;
            PriorityQueue<Job> queuedJobs = new PriorityQueue<>(new JobDurationComparator());
            boolean allJobDone = false;
            while (!allJobDone) {
                Job current;
                if (queuedJobs.isEmpty()) {
                    current = allJobs.poll();
                    currentTime = current.getStartTime();
                } else {
                    current = queuedJobs.poll();
                }

                while (!allJobs.isEmpty() && (allJobs.peek().getStartTime() <= (currentTime + current.getDuration()))) {
                    queuedJobs.offer(allJobs.poll());
                }

//                System.out.println(current);
//                System.out.printf("current(%d) + duration(%d) - startTime (%d)\n", currentTime, current.getDuration(), current.getStartTime());

                answer += (currentTime + current.getDuration() - current.getStartTime());
                currentTime += current.getDuration();

                if (allJobs.isEmpty() && queuedJobs.isEmpty()) {
                    allJobDone = true;
                }
            }

            return answer / jobs.length;
        }
    }

    public static void main(String[] args) {
        int case01 = new Solution().solution(new int[][]{{0, 3}, {1, 9}, {2, 6}});
        assert case01 == 9;
        System.out.println(case01);

        int case02 = new Solution().solution(new int[][]{{0, 3}});
        assert case02 == 3;
        System.out.println(case02);

        int case03 = new Solution().solution(new int[][]{{0, 5}, {6, 5}});
        assert case03 == 5;
        System.out.println(case03);

    }
}
