package org.htech;

import org.htech.Algothims.Backtracking;
import org.htech.Algothims.Dsatur;
import org.htech.Algothims.WelshPowell;

public class Main {
    public static void main(String[] args) {
        int[][] matrix = {
                {0, 1, 0, 1, 0},
                {1, 0, 1, 1, 0},
                {0, 1, 0, 1, 1},
                {1, 1, 1, 0, 1},
                {0, 0, 1, 1, 0}
        };

        Graph graph1 = new Graph(matrix);
        Graph graph2 = new Graph(matrix);
        Graph graph3 = new Graph(matrix);

        long startTime = System.nanoTime();
        Dsatur.dsaturColoring(graph1);
        long endTime = System.nanoTime();
        long dsaturTime = endTime - startTime;

        startTime = System.nanoTime();
        WelshPowell.welshPowellColoring(graph2);
        endTime = System.nanoTime();
        long welshPowellTime = endTime - startTime;

        startTime = System.nanoTime();
        Backtracking.backtrackingColoring(graph3);
        endTime = System.nanoTime();
        long backtrackingTime = endTime - startTime;

        System.out.println("Dsatur Algorithm:");
        graph1.printGraphWithColors();
        System.out.println("Time taken: " + dsaturTime + " ns");

        System.out.println("\nWelsh-Powell Algorithm:");
        graph2.printGraphWithColors();
        System.out.println("Time taken: " + welshPowellTime + " ns");

        System.out.println("\nBacktracking Algorithm:");
        graph3.printGraphWithColors();
        System.out.println("Time taken: " + backtrackingTime + " ns");
    }
}

