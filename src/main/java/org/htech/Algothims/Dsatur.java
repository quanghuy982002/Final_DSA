package org.htech.Algothims;

import org.htech.Graph;

import java.util.Arrays;
import java.util.Comparator;
import java.util.PriorityQueue;

public class Dsatur {
    public static void dsaturColoring(Graph graph) {
        int n = graph.graph.length;
        int[] degree = new int[n];
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                if (graph.graph[i][j] == 1) {
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
                if (graph.graph[u][v] == 1 && graph.getColor(v) != -1) {
                    available[graph.getColor(v)] = false;
                }
            }
            int cr;
            for (cr = 0; cr < n; cr++) {
                if (available[cr]) break;
            }
            graph.setColor(u, cr);
        }
    }
}
