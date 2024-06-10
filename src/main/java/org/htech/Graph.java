package org.htech;

import java.util.Arrays;

public class Graph {
    public int[][] graph;
    public int[] colors;

    public Graph(int[][] graph) {
        this.graph = graph;
        this.colors = new int[graph.length];
        Arrays.fill(colors, -1);
    }

    public void setColor(int vertex, int color) {
        colors[vertex] = color;
    }

    public int getColor(int vertex) {
        return colors[vertex];
    }

    public void printGraphWithColors() {
        for (int i = 0; i < graph.length; i++) {
            System.out.println("Vertex " + i + " -> Color " + colors[i]);
        }
        System.out.println("Edges:");
        for (int i = 0; i < graph.length; i++) {
            for (int j = i + 1; j < graph.length; j++) {
                if (graph[i][j] == 1) {
                    System.out.println("Edge (" + i + ", " + j + ") connects colors " + colors[i] + " and " + colors[j]);
                }
            }
        }
    }
}
