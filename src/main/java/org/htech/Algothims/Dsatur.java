package org.htech.flAlgothims;

import java.util.Arrays;
import java.util.Comparator;
import java.util.PriorityQueue;

public class Dsatur {
    public static int dsaturColoring(int[][] graph) {
        int n = graph.length;
        int[] result = new int[n];
        Arrays.fill(result, -1);
        int[] degree = new int[n];
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                if (graph[i][j] == 1) {
                    degree[i]++;
                }
            }
        }
        PriorityQueue<Integer> queue = new PriorityQueue<>(Comparator.comparingInt(a -> -degree[a]));
        for (int i = 0; i < n; i++) {
            queue.add(i);
        }
        while (!queue.isEmpty()) {
            int u = queue.poll();
            boolean[] available = new boolean[n];
            Arrays.fill(available, true);
            for (int v = 0; v < n; v++) {
                if (graph[u][v] == 1 && result[v] != -1) {
                    available[result[v]] = false;
                }
            }
            int cr;
            for (cr = 0; cr < n; cr++) {
                if (available[cr]) break;
            }
            result[u] = cr;
        }
        return Arrays.stream(result).max().orElse(0) + 1;
    }
}
