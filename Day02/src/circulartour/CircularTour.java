package com.circulartour;
import java.util.LinkedList;
import java.util.Queue;

public class CircularTour {

    // Find starting petrol pump for circular tour
    public static int circularTour(int[] petrol, int[] distance) {
        int n = petrol.length;
        Queue<Integer> queue = new LinkedList<>();
        int start = 0, surplus = 0, deficit = 0;

        for (int i = 0; i < n; i++) {
            surplus += petrol[i] - distance[i];
            if (surplus < 0) {
                // If deficit, reset start and surplus
                start = i + 1;
                deficit += surplus;
                surplus = 0;
            }
        }

        // If total surplus is greater than deficit, return start point
        return (surplus + deficit >= 0) ? start : -1;
    }

    public static void main(String[] args) {
        int[] petrol = {4, 6, 7, 4};
        int[] distance = {6, 5, 3, 5};
        System.out.println(circularTour(petrol, distance));
    }
}

