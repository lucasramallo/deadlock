package edu.ifpb.deadlock.detection;

import java.util.Arrays;

public class Main {
    public static void main(String[] args) {
        int[][] allocation = {{0, 0, 1, 0}, {2, 0, 0, 1}, {0, 0, 0, 0}};
        int[][] request = {{2, 0, 0, 1}, {2, 0, 1, 1}, {0, 0, 0, 0}};
        int[] available = {2, 1, 0, 0};
        int[] existingResources = {4, 2, 3, 1};

        // Simulação de alocação de recursos
        for (int i = 0; i < request.length; i++) {
            for (int j = 0; j < request[i].length; j++) {
                if (request[i][j] <= existingResources[i]) {
                    allocation[i][j] += request[i][j];
                }
            }
        }

        // Verifica se há deadlock
        if (detectDeadlock(allocation, request, available)) {
            System.out.println("Deadlock detectado!");
        } else {
            System.out.println("Nenhum deadlock detectado!");
        }
    }

    public static boolean detectDeadlock(int[][] allocation, int[][] request, int[] available) {
        int numProcesses = allocation.length;
        int numResources = allocation[0].length;

        boolean[] finish = new boolean[numProcesses];
        int[] work = Arrays.copyOf(available, available.length);

        boolean progressMade;

        do {
            progressMade = false;
            for (int i = 0; i < numProcesses; i++) {
                if (!finish[i]) {
                    boolean canAllocate = true;
                    for (int j = 0; j < numResources; j++) {
                        if (request[i][j] > work[j]) {
                            canAllocate = false;
                            break;
                        }
                    }
                    if (canAllocate) {
                        // Simula a alocação de recursos
                        for (int j = 0; j < numResources; j++) {
                            work[j] += allocation[i][j];
                        }
                        finish[i] = true;
                        progressMade = true;
                    }
                }
            }
        } while (progressMade);

        // Se algum processo não terminou, há um deadlock
        for (boolean processFinished : finish) {
            if (!processFinished) {
                return true; // Deadlock detectado
            }
        }
        return false; // Sem deadlock
    }
}