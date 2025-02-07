package edu.ifpb.deadlock.banqueiro;

import java.util.ArrayList;
import java.util.Arrays;

public class Main {
    public static void main(String[] args) {
        int[] recursosDisponiveis = {1, 1};
        ArrayList<Processo> processos = new ArrayList<>();
        Banqueiro banqueiro = new Banqueiro();

        Processo p1 = new Processo();
        p1.setNome("P1");
        p1.setAlocado(new int[]{1, 0});
        p1.setNecessario(new int[]{2, 2});

        Processo p2 = new Processo();
        p2.setNome("P2");
        p2.setAlocado(new int[]{0, 1});
        p2.setNecessario(new int[]{2, 2});

        processos.add(p1);
        processos.add(p2);

        // P1 solicita [1, 1]
        p1.setAlocado(new int[]{1, 1});
        recursosDisponiveis = new int[]{1, 1};
        processos.remove(p1);
        //

        boolean isSafe = banqueiro.isSafe(processos, recursosDisponiveis);
        System.out.println(isSafe ? "Recursos podem ser alocados" : "Recursos não podem ser alocados pois geram deadlock");
    }
}
