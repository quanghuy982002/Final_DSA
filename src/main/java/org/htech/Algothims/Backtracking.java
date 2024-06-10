package org.htech.Algothims;

public class Backtracking {

    // Hàm tô màu đồ thị
    public static void colorGraph(Graph graph) {
        int V = graph.V;
        int[] colors = new int[V];

        // Thực hiện thuật toán Backtracking
        boolean result = colorUtil(graph, colors, 0);

        if (result) {
            // In kết quả
            for (int i = 0; i < V; i++) {
                System.out.println("Đỉnh " + i + " được tô màu " + colors[i]);
            }
        } else {
            System.out.println("Không tìm được cách tô màu hợp lệ");
        }
    }

    // Hàm đệ quy để tô màu đồ thị
    private static boolean colorUtil(Graph graph, int[] colors, int v) {
        int V = graph.V;
        if (v == V) {
            return true;
        }

        for (int c = 1; c <= V; c++) {
            if (isValid(graph, colors, v, c)) {
                colors[v] = c;
                if (colorUtil(graph, colors, v + 1)) {
                    return true;
                }
                colors[v] = 0;
            }
        }
        return false;
    }

    // Hàm kiểm tra tính hợp lệ của việc gán màu cho đỉnh v
    private static boolean isValid(Graph graph, int[] colors, int v, int c) {
        for (int u : graph.adjList[v]) {
            if (colors[u] == c) {
                return false;
            }
        }
        return true;
    }
}
