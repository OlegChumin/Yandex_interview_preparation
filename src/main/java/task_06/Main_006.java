package task_06;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main_006 {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(reader.readLine());

        int[][] cities = new int[n][2];
        for (int i = 0; i < n; i++) {
            String[] coordinates = reader.readLine().split(" ");
            cities[i][0] = Integer.parseInt(coordinates[0]);
            cities[i][1] = Integer.parseInt(coordinates[1]);
        }

        int maxDistance = Integer.parseInt(reader.readLine());
        String[] startEnd = reader.readLine().split(" ");
        int startCity = Integer.parseInt(startEnd[0]);
        int endCity = Integer.parseInt(startEnd[1]);

        int minDistance = findShortestPath(cities, maxDistance, startCity, endCity);
        System.out.println(minDistance);
    }

    private static int findShortestPath(int[][] cities, int maxDistance, int startCity, int endCity) {
        int n = cities.length;

        // Создаем граф
        List<List<Integer>> graph = new ArrayList<>();
        for (int i = 0; i <= n; i++) {
            graph.add(new ArrayList<>());
        }
        for (int i = 0; i < n; i++) {
            for (int j = i + 1; j < n; j++) {
                int distance = Math.abs(cities[i][0] - cities[j][0]) + Math.abs(cities[i][1] - cities[j][1]);
                if (distance <= maxDistance) {
                    graph.get(i + 1).add(j + 1);
                    graph.get(j + 1).add(i + 1);
                }
            }
        }

        // Используем поиск в глубину (DFS) для нахождения пути
        boolean[] visited = new boolean[n + 1];
        visited[startCity] = true;
        int pathLength = dfs(graph, visited, startCity, endCity, 0);

        return pathLength != Integer.MAX_VALUE ? pathLength : -1;
    }

    private static int dfs(List<List<Integer>> graph, boolean[] visited, int current, int endCity, int distance) {
        if (current == endCity) {
            return distance;
        }

        int minDistance = Integer.MAX_VALUE;
        for (int neighbor : graph.get(current)) {
            if (!visited[neighbor]) {
                visited[neighbor] = true;
                int pathLength = dfs(graph, visited, neighbor, endCity, distance + 1);
                minDistance = Math.min(minDistance, pathLength);
                visited[neighbor] = false;
            }
        }

        return minDistance;
    }
}
