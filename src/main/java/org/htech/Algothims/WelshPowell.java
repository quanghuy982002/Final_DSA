package org.htech.Algothims;

import java.util.*;

public class WelshPowell {
    // Hàm sắp xếp các đỉnh theo bậc giảm dần
    public static List<Integer> sortVerticesByDegree(Graph graph) {
        Map<Integer, Integer> degreeMap = new HashMap<>();
        for (int i = 0; i < graph.V; i++) {
            degreeMap.put(i, graph.adjList[i].size());
        }
        List<Map.Entry<Integer, Integer>> list = new LinkedList<>(degreeMap.entrySet());

        // Sắp xếp list theo giá trị của bậc (degree)
        list.sort((o1, o2) -> o2.getValue().compareTo(o1.getValue()));

        List<Integer> sortedVertices = new ArrayList<>();
        for (Map.Entry<Integer, Integer> entry : list) {
            sortedVertices.add(entry.getKey());
        }
        return sortedVertices;
    }

    // Hàm tô màu đồ thị
    public static void colorGraph(Graph graph) {
        int V = graph.V;
        List<Integer> sortedVertices = sortVerticesByDegree(graph);
        int[] color = new int[V];
        Arrays.fill(color, -1);
        int currentColor = 0;

        // Duyệt qua các đỉnh đã sắp xếp
        for (int u : sortedVertices) {
            if (color[u] == -1) {
                color[u] = currentColor;

                // Duyệt qua các đỉnh kề chưa được tô màu
                for (int v = 0; v < V; v++) {
                    if (color[v] == -1) {
                        boolean canColor = true;

                        // Kiểm tra xem đỉnh v có kề với bất kỳ đỉnh nào đã được tô màu hiện tại không
                        for (int w : graph.adjList[v]) {
                            if (color[w] == currentColor) {
                                canColor = false;
                                break;
                            }
                        }

                        // Nếu không kề với bất kỳ đỉnh nào đã được tô màu hiện tại, gán màu cho đỉnh v
                        if (canColor) {
                            color[v] = currentColor;
                        }
                    }
                }
                currentColor++;
            }
        }

        // In kết quả
        for (int i = 0; i < V; i++) {
            System.out.println("Đỉnh " + i + " được tô màu " + color[i]);
        }
    }
}
