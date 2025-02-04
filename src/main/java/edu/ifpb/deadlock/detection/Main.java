package edu.ifpb.deadlock.detection;

public class Main {
    public static void main(String[] args) {
        int[][] allocation = {{0, 0}, {0, 0}};
        int[][] request = {{0, 0}, {0, 0}};
        int[] available = {0, 0};
        int[] existingResources = {0, 0};

        allocation[0] = new int[]{1, 2};
        allocation[1] = new int[]{1, 0};

        request[0] = new int[]{1, 0};
        request[1] = new int[]{0, 2};

        while (true) {
            for (int i = 0; i < request.length; i++) {
                for (int j = 0; j < request[i].length; j++) {
                    if(request[i][j] <= existingResources[i]) {
                        allocation[i][j] += request[i][j];
                    }
                }
            }

            for (int i = 0; i < request.length; i++) {
                for (int j = 0; j < request[i].length; j++) {
                    if(request[i][j] == 0 && request[i + 1][j + 1] == 0 ) {

                    }
                }

            }
        }
    }
}