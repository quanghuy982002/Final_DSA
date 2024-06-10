package org.htech.Algothims;

import java.util.LinkedList;

public class Graph {
    int V;
    LinkedList<Integer>[] adjList;

    // Constructor
    Graph(int V) {
        this.V = V;
        adjList = new LinkedList[V];
        for (int i = 0; i < V; i++) {
            adjList[i] = new LinkedList<>();
        }
    }

    // Thêm cạnh
    void addEdge(int u, int v) {
        adjList[u].add(v);
        adjList[v].add(u); // Đồ thị vô hướng
    }
}
