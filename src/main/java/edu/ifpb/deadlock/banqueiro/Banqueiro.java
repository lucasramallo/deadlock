package edu.ifpb.deadlock.banqueiro;

import java.util.ArrayList;

public class Banqueiro {
    public boolean isSafe(ArrayList<Processo> processos, int[] recursosDisponiveis) {
        boolean isSafe = false;

        for (Processo processo : processos) {
            int counter = 0;

            for (int i = 0; i < processo.getNecessario().length; i++) {
                if ((processo.getNecessario()[i] - processo.getAlocado()[i]) <= recursosDisponiveis[i]) {
                    counter++;
                }
            }

            if (counter == processo.getNecessario().length) {
                isSafe = true;
                break;
            }
        }

        return isSafe;
    }
}
