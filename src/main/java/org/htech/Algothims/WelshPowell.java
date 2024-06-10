package org.htech.Algothims;

import org.htech.Graph;

import java.util.Arrays;
import java.util.stream.IntStream;

public class WelshPowell {
    public static void welshPowellColoring(Graph graph) {
        int n = graph.graph.length;
        Integer[] vertices = IntStream.range(0, n).boxed().toArray(Integer[]::new);
        Arrays.sort(vertices, (a, b) -> Integer.compare(degree(graph.graph, b), degree(graph.graph, a)));
        int color = 0;
        for (int i = 0; i < n; i++) {
            int u = vertices[i];
            if (graph.getColor(u) == -1) {
                graph.setColor(u, color);
                for (int j = i + 1; j < n; j++) {
                    int v = vertices[j];
                    if (graph.getColor(v) == -1 && isSafe(graph.graph, graph.colors, u, v)) {
                        graph.setColor(v, color);
                    }
                }
                color++;
            }
        }
    }

    private static int degree(int[][] graph, int vertex) {
        return (int) Arrays.stream(graph[vertex]).filter(v -> v == 1).count();
    }

    private static boolean isSafe(int[][] graph, int[] result, int u, int v) {
        for (int i = 0; i < graph.length; i++) {
            if (graph[v][i] == 1 && result[i] == result[u]) {
                return false;
            }
        }
        return true;
    }
}
