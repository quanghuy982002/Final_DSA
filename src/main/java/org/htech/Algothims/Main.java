package org.htech.Algothims;

import java.util.Random;

public class Main {
    // Hàm sinh ma trận kề ngẫu nhiên
    static int[][] generateRandomAdjacencyMatrix(int V, double probability) {
        int[][] matrix = new int[V][V];
        Random random = new Random();
        for (int i = 0; i < V; i++) {
            for (int j = i + 1; j < V; j++) {
                if (random.nextDouble() < probability) {
                    matrix[i][j] = matrix[j][i] = 1;
                }
            }
        }
        return matrix;
    }

    // Hàm chuyển ma trận kề thành đồ thị và thực hiện tô màu bằng thuật toán DSatur
    static void processGraph(int[][] adjacencyMatrix) {
        int V = adjacencyMatrix.length;
        Graph graph = new Graph(V);

        // Chuyển ma trận kề thành đồ thị
        for (int i = 0; i < V; i++) {
            for (int j = i + 1; j < V; j++) {
                if (adjacencyMatrix[i][j] == 1) {
                    graph.addEdge(i, j);
                }
            }
        }

        // Thực hiện thuật toán DSatur
        System.out.println("\nKết quả tô màu bằng thuật toán DSatur:");
        long startTime = System.nanoTime();
        Dsatur.colorGraph(graph);
        long endTime = System.nanoTime();
        long duration = (endTime - startTime) / 1000000;  // Chuyển đổi sang milliseconds

        System.out.println("\nThời gian chạy thuật toán DSatur: " + duration + " milliseconds");

        // Thực hiện thuật toán WelshPowell
        System.out.println("\nKết quả tô màu bằng thuật toán WelshPowell:");
        long startTimeWelshPowell = System.nanoTime();
        WelshPowell.colorGraph(graph);
        long endTimeWelshPowell = System.nanoTime();
        long durationWelshPowell = (endTimeWelshPowell - startTimeWelshPowell) / 1000000;  // Chuyển đổi sang milliseconds

        System.out.println("\nThời gian chạy thuật toán WelshPowell: " + durationWelshPowell + " milliseconds");


        int[] colors = new int[V];
        int m = 3; // Số màu

        // Thực hiện thuật toán Backtracking
        System.out.println("\nKết quả tô màu bằng thuật toán Backtracking:");
        long startTimeBacktracking = System.nanoTime();
        Backtracking.colorGraph(graph);
        long endTimeBacktracking = System.nanoTime();
        long durationBacktracking = (endTimeBacktracking - startTimeBacktracking) / 1000000;  // Chuyển đổi sang milliseconds

        System.out.println("\nThời gian chạy thuật toán Backtracking: " + durationBacktracking + " milliseconds");

    }

    public static void main(String[] args) {
        int V = 5; // Số đỉnh của đồ thị
        double probability = 0.5; // Xác suất có cạnh giữa hai đỉnh bất kỳ

        int[][] adjacencyMatrix = generateRandomAdjacencyMatrix(V, probability);

        // In ma trận kề
        System.out.println("Ma trận kề của đồ thị:");
        for (int i = 0; i < V; i++) {
            for (int j = 0; j < V; j++) {
                System.out.print(adjacencyMatrix[i][j] + " ");
            }
            System.out.println();
        }

        // Xử lý đồ thị và tô màu bằng thuật toán DSatur
        processGraph(adjacencyMatrix);

    }
}
