package org.htech.Algothims;

import java.util.Arrays;
import java.util.Comparator;
import java.util.PriorityQueue;

public class Dsatur {
    // Hàm tô màu đồ thị
    public static void colorGraph(Graph graph) {
        int V = graph.V;
        int[] colors = new int[V];
        int[] saturation = new int[V];
        int[] degree = new int[V];
        PriorityQueue<Integer> queue = new PriorityQueue<>(new Comparator<Integer>() {
            @Override
            public int compare(Integer i1, Integer i2) {
                return Integer.compare(saturation[i2], saturation[i1]);
            }
        });


        // Khởi tạo mảng degree
        for (int v = 0; v < V; v++) {
            degree[v] = graph.adjList[v].size();
        }

        // Khởi tạo hàng đợi
        for (int v = 0; v < V; v++) {
            queue.add(v);
        }

        while (!queue.isEmpty()) {
            int u = queue.poll();
            boolean[] available = new boolean[V];
            Arrays.fill(available, true);

            // Đánh dấu màu đã được sử dụng của các đỉnh kề của u
            for (int neighbor : graph.adjList[u]) {
                if (colors[neighbor] != -1) {
                    available[colors[neighbor]] = false;
                }
            }

            // Tìm màu nhỏ nhất có sẵn cho đỉnh u
            int minColor = 0;
            while (!available[minColor]) {
                minColor++;
            }

            // Gán màu cho đỉnh u
            colors[u] = minColor;

            // Cập nhật độ bão hòa (saturation) của các đỉnh kề của u
            for (int neighbor : graph.adjList[u]) {
                if (colors[neighbor] == -1) {
                    saturation[neighbor]++;
                }
            }

            // Thêm lại các đỉnh chưa được tô màu vào hàng đợi
            for (int v = 0; v < V; v++) {
                if (colors[v] == -1) {
                    queue.remove(v); // Loại bỏ và thêm lại để cập nhật thứ tự ưu tiên
                    queue.add(v);
                }
            }
        }

        // In kết quả
        for (int i = 0; i < V; i++) {
            System.out.println("Đỉnh " + i + " được tô màu " + colors[i]);
        }
    }
}
