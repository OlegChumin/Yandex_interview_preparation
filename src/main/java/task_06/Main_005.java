package task_06;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main_005 {
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

        int minDistance = aStar(cities, maxDistance, startCity, endCity);
        System.out.println(minDistance);
    }

    private static int aStar(int[][] cities, int maxDistance, int startCity, int endCity) {
        int n = cities.length;
        PriorityQueue<int[]> queue = new PriorityQueue<>(Comparator.comparingInt(a -> a[1]));
        queue.offer(new int[]{startCity, 0});

        int[] distances = new int[n + 1];
        Arrays.fill(distances, Integer.MAX_VALUE);
        distances[startCity] = 0;

        while (!queue.isEmpty()) {
            int[] current = queue.poll();
            int currentCity = current[0];
            int distance = current[1];

            if (currentCity == endCity) {
                break;
            }

            if (distance > distances[currentCity]) {
                continue;
            }

            for (int i = 1; i <= n; i++) {
                if (i != currentCity) {
                    int curDistance = Math.abs(cities[currentCity - 1][0] - cities[i - 1][0])
                            + Math.abs(cities[currentCity - 1][1] - cities[i - 1][1]);

                    if (curDistance <= maxDistance) {
                        int heuristic = Math.abs(cities[i - 1][0] - cities[endCity - 1][0])
                                + Math.abs(cities[i - 1][1] - cities[endCity - 1][1]);
                        int newDistance = distance + 1 + heuristic;

                        if (newDistance < distances[i]) {
                            distances[i] = newDistance;
                            queue.offer(new int[]{i, newDistance});
                        }
                    }
                }
            }
        }

        return distances[endCity] != Integer.MAX_VALUE ? distances[endCity] : -1;
    }
}
