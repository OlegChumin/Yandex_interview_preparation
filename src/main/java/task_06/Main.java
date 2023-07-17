package task_06;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {
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

        int minDistance = bfs(cities, maxDistance, startCity, endCity);
        System.out.println(minDistance);
    }

    private static int bfs(int[][] cities, int maxDistance, int startCity, int endCity) {
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

        // Используем поиск в ширину (BFS) с оптимизациями
        Queue<Integer> queue = new LinkedList<>();
        boolean[] visited = new boolean[n + 1];
        visited[startCity] = true;
        queue.offer(startCity);

        int[] distances = new int[n + 1];
        Arrays.fill(distances, Integer.MAX_VALUE);
        distances[startCity] = 0;

        while (!queue.isEmpty()) {
            int current = queue.poll();

            if (current == endCity) {
                break;
            }

            int distance = distances[current];
            for (int neighbor : graph.get(current)) {
                if (!visited[neighbor]) {
                    visited[neighbor] = true;
                    queue.offer(neighbor);
                    distances[neighbor] = distance + 1;
                }
            }
        }

        return distances[endCity] != Integer.MAX_VALUE ? distances[endCity] : -1;
    }
}
