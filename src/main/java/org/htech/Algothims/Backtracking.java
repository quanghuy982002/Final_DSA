package org.htech.Algothims;

import org.htech.Graph;


public class Backtracking {
    public static void backtrackingColoring(Graph graph) {
        colorGraph(graph, 0, graph.graph.length);
    }

    private static boolean colorGraph(Graph graph, int vertex, int n) {
        if (vertex == n) return true;
        for (int color = 0; color < n; color++) {
            if (isSafe(graph.graph, graph.colors, vertex, color)) {
                graph.setColor(vertex, color);
                if (colorGraph(graph, vertex + 1, n)) return true;
                graph.setColor(vertex, -1);
            }
        }
        return false;
    }

    private static boolean isSafe(int[][] graph, int[] result, int vertex, int color) {
        for (int i = 0; i < graph.length; i++) {
            if (graph[vertex][i] == 1 && color == result[i]) return false;
        }
        return true;
    }
}
