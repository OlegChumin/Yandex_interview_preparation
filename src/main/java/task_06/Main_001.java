package task_06;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main_001 {
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

        int minDistance = findShortestDistance(cities, maxDistance, startCity, endCity);
        System.out.println(minDistance);
    }

    private static int findShortestDistance(int[][] cities, int maxDistance, int startCity, int endCity) {
        int n = cities.length;
        Queue<Integer> queue = new LinkedList<>();
        int[] distances = new int[n + 1];
        Arrays.fill(distances, Integer.MAX_VALUE);

        queue.add(startCity);
        distances[startCity] = 0;

        while (!queue.isEmpty()) {
            int currentCity = queue.poll();

            for (int i = 1; i <= n; i++) {
                int distance = Math.abs(cities[currentCity - 1][0] - cities[i - 1][0])
                        + Math.abs(cities[currentCity - 1][1] - cities[i - 1][1]);

                if (distance <= maxDistance && distances[currentCity] + 1 < distances[i]) {
                    distances[i] = distances[currentCity] + 1;
                    queue.add(i);
                }
            }
        }

        return distances[endCity] != Integer.MAX_VALUE ? distances[endCity] : -1;
    }
}
