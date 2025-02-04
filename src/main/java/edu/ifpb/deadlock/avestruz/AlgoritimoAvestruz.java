package edu.ifpb.deadlock.avestruz;

import java.util.Random;

public class AlgoritimoAvestruz {
    public static void main(String[] args) {
        System.out.println("Executando o sistema...");

        for (int i = 0; i < 10; i++) {
            algoritmoAvestruz();
        }

        System.out.println("Sistema continua rodando normalmente.");
    }

    public static void algoritmoAvestruz() {
        Random random = new Random();
        int a = random.nextInt(2);

        try {
            int resultado = 10 / a;
            System.out.println("Resultado: " + resultado);
        } catch (ArithmeticException e) {
        }
    }
}
