package edu.ifpb.deadlock.banqueiro;

import java.util.Arrays;

public class Processo implements Cloneable {
    private String nome;
    private int[] alocado;
    private int[] necessario;

    public void execute(int tempo) {
        try {
            while (!Arrays.equals(necessario, alocado)) {
                // Simulação de execução do processo
            }
            System.out.println("Executando processo " + nome);
            Thread.sleep(tempo);
        } catch (Exception e) {
            System.err.println(e);
        }
    }

    @Override
    public Processo clone() {
        try {
            Processo clone = (Processo) super.clone();
            // Cópia profunda dos arrays para evitar referências compartilhadas
            clone.alocado = alocado != null ? alocado.clone() : null;
            clone.necessario = necessario != null ? necessario.clone() : null;
            return clone;
        } catch (CloneNotSupportedException e) {
            throw new RuntimeException("Erro ao clonar o objeto Processo", e);
        }
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public int[] getAlocado() {
        return alocado;
    }

    public void setAlocado(int[] alocado) {
        this.alocado = alocado;
    }

    public int[] getNecessario() {
        return necessario;
    }

    public void setNecessario(int[] necessario) {
        this.necessario = necessario;
    }

    @Override
    public String toString() {
        return "Processo{" +
                "nome='" + nome + '\'' +
                ", alocado=" + Arrays.toString(alocado) +
                ", necessario=" + Arrays.toString(necessario) +
                '}';
    }
}
