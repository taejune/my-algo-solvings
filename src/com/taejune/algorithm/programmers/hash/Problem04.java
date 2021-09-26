package com.taejune.algorithm.programmers.hash;

import java.util.*;

public class Problem04 {
    static class Solution {
        class Genre implements Comparable<Genre> {
            private String name;
            private int playTimes;

            public Genre(String name, int nPlayTimes) {
                this.name = name;
                this.playTimes = nPlayTimes;
            }

            public String getName() {
                return this.name;
            }

            public int getPlayTimes() {
                return this.playTimes;
            }

            @Override
            public int compareTo(Genre o) {
                if (this.playTimes > o.getPlayTimes()) {
                    return -1;
                } else if (this.playTimes < o.getPlayTimes()) {
                    return 1;
                }
                return 0;
            }

            @Override
            public String toString() {
                return "[" + this.name + "]: " + this.playTimes;
            }
        }

        class Record implements Comparable<Record> {
            private int id;
            private String genre;
            private int playTimes;

            public Record(int id, String genre, int nPlayTimes) {
                this.id = id;
                this.genre = genre;
                this.playTimes = nPlayTimes;
            }

            public int getId() {
                return this.id;
            }

            public int getPlayTimes() {
                return this.playTimes;
            }

            @Override
            public int compareTo(Record o) {
                if (this.playTimes > o.getPlayTimes()) {
                    return -1;
                } else if (this.playTimes < o.getPlayTimes()) {
                    return 1;
                }

                if (this.id > o.getId()) {
                    return 1;
                } else if (this.id < o.getId()) {
                    return -1;
                }
                return 0;
            }

            @Override
            public String toString() {
                return "[ID]: " + this.id + "/[Genre]: " + this.genre + "/[Played]: " + this.playTimes + " times";
            }
        }

        public int[] solution(String[] genres, int[] plays) {
            List<Integer> bestAlbum = new ArrayList<>();

            Map<String, List<Integer>> recordIdsByGenres = new HashMap<>();
            Map<String, Integer> totalPlayTimesByGenres = new HashMap<>();
            for (int id = 0; id < genres.length; id++) {
                List<Integer> ids = recordIdsByGenres.getOrDefault(genres[id], new ArrayList<>());
                ids.add(id);
                recordIdsByGenres.put(genres[id], ids);

                int sum = totalPlayTimesByGenres.getOrDefault(genres[id], 0);
                totalPlayTimesByGenres.put(genres[id], sum + plays[id]);
            }

            PriorityQueue<Genre> orderedGenreQueue = new PriorityQueue<>();
            for (String genre : totalPlayTimesByGenres.keySet()) {
                orderedGenreQueue.add(new Genre(genre, totalPlayTimesByGenres.get(genre)));
            }

            int nGenres = orderedGenreQueue.size();
            for (int i = 0; i < nGenres; i++) {
                PriorityQueue<Record> orderedRecordQueue = new PriorityQueue<>();
                Genre g = orderedGenreQueue.poll();

                List<Integer> sameGenreRecordIds = recordIdsByGenres.get(g.getName());
                for (int id : sameGenreRecordIds) {
                    orderedRecordQueue.add(new Record(id, g.getName(), plays[id]));
                }

                bestAlbum.add(orderedRecordQueue.poll().getId());
                Record second = orderedRecordQueue.poll();
                if(second != null) {
                    bestAlbum.add(second.getId());
                }
            }

            int[] answer = new int[bestAlbum.size()];
            for (int idx = 0; idx < bestAlbum.size(); idx++) {
                answer[idx] = bestAlbum.get(idx);
            }
            return answer;
        }
    }

    public static void main(String[] args) {
        int[] case01 = new Solution().solution(new String[]{"classic", "pop", "classic", "classic", "pop"}, new int[]{500, 600, 150, 800, 2500});
        print(case01);
    }

    private static void print(int[] solve) {
        System.out.print("[");
        for (int i = 0; i < solve.length; i++) {
            if (i != 0) {
                System.out.print(",");
            }
            System.out.print(solve[i]);
        }
        System.out.print("]");
    }
}
