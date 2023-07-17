package task_06;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main_003 {
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

        boolean[] visited = new boolean[n + 1];
        visited[startCity] = true;

        int minDistance = dfs(cities, maxDistance, startCity, endCity, visited);
        System.out.println(minDistance);
    }

    private static int dfs(int[][] cities, int maxDistance, int currentCity, int endCity, boolean[] visited) {
        if (currentCity == endCity) {
            return 0;
        }

        int minDistance = -1;

        for (int i = 1; i < cities.length + 1; i++) {
            if (!visited[i]) {
                int distance = Math.abs(cities[currentCity - 1][0] - cities[i - 1][0])
                        + Math.abs(cities[currentCity - 1][1] - cities[i - 1][1]);

                if (distance <= maxDistance) {
                    visited[i] = true;
                    int pathDistance = dfs(cities, maxDistance, i, endCity, visited);
                    if (pathDistance != -1) {
                        if (minDistance == -1 || pathDistance + 1 < minDistance) {
                            minDistance = pathDistance + 1;
                        }
                    }
                    visited[i] = false;
                }
            }
        }

        return minDistance;
    }
}
