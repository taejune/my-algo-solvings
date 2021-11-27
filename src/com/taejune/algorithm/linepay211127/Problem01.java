package com.taejune.algorithm.linepay211127;

import java.util.*;

public class Problem01 {

    static class Solution {
        class Item {
            int price;
            int quantity;

            public Item(int price, int quantity) {
                this.price = price;
                this.quantity = quantity;
            }

            public int getPrice() {
                return this.price;
            }

            public int getQuantity() {
                return this.quantity;
            }

            public void setQuantity(int quantity) {
                this.quantity = quantity;
            }
        }

        public int[] solution(String[] record) {
            int sumFIFO = 0;
            int sumLIFO = 0;

            Queue<Integer> fifo = new LinkedList<>();
            Stack<Integer> lifo = new Stack<>();


            for (String r : record) {
                StringTokenizer parser = new StringTokenizer(r);
                String category = parser.nextToken();
                int price = Integer.parseInt(parser.nextToken());
                int qty = Integer.parseInt(parser.nextToken());

                if (category.equals("P")) {
                    for (int i = 0; i < qty; i++) {
                        fifo.offer(price);
                        lifo.add(price);
                    }

                } else {
                    for(int i=0; i<qty; i++) {
                        sumFIFO += fifo.remove();
                        sumLIFO += lifo.pop();
                    }
                }
            }

            System.out.println(sumFIFO);
            System.out.println(sumLIFO);
            return new int[]{sumFIFO, sumLIFO};
        }


        public int sum(List<Item> p, int sales) {
            int sum = 0;

            for (int i = 0; i < sales; i++) {
                Item item = p.get(0);
                int remains = item.getQuantity();
                if (remains > 0) {
                    sum += item.getPrice();
                    item.setQuantity(remains - 1);
                } else {
                    p.remove(0);
                    item = p.get(0);
                    remains = item.getQuantity();
                    if (remains > 0) {
                        sum += item.getPrice();
                        item.setQuantity(remains - 1);
                    }
                }

            }

            return sum;
        }

    }

    public static void main(String[] args) {
        int[] case01 = new Solution().solution(new String[]{"P 300 6", "P 500 3", "S 1000 4", "P 600 2", "S 1200 1"});
        int[] case02 = new Solution().solution(new String[]{"P 300 6", "P 500 3", "S 1000 4", "P 600 1", "S 1200 2"});
        int[] case03 = new Solution().solution(new String[]{"P 100 4", "P 300 9", "S 1000 7", "P 1000 8", "S 700 7", "S 700 3"});
    }
}
