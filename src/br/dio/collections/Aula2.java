package br.dio.collections;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

public class Aula2 {
    public static void main(String[] args) {

        List<Gato> meusGatos = new ArrayList<>() {{
            add(new Gato("Jon", 18, "preto"));
            add(new Gato("Simba", 6, "tigrado"));
            add(new Gato("Jon", 12, "amarelo"));
        }};

        System.out.println(meusGatos);
        System.out.println("--\t Ordem de inserção\t--");

        System.out.printf("--\t Ordem aleatória\t--");
        Collections.shuffle(meusGatos);
        System.out.println(meusGatos);

        System.out.printf("--\t Ordem Natural (nome)\t--");
        Collections.sort(meusGatos);
        System.out.println(meusGatos);

        System.out.println("--\t Ordem Idade\t --");
        Collections.sort(meusGatos, new ComparadorIdade());
        //meusGatos.sort(new ComparadorIdade());
        System.out.println(meusGatos);

        System.out.println("--\t Ordem de Cor\t -- ");
        Collections.sort(meusGatos, new ComparadorCor());
        System.out.println(meusGatos);


        System.out.println("--\t Ordenar por Nome/Cor/Idade");
        Collections.sort(meusGatos, new comparadorNomeCorIdade());
        System.out.println(meusGatos);
    }
}

class Gato implements Comparable<Gato> { // utiliza coparable
    private String nome;
    private Integer idade;
    private String cor;

    // pressionar alt + interset > construtor:
    public Gato(String nome, Integer idade, String cor) {
        this.nome = nome;
        this.idade = idade;
        this.cor = cor;
    }

    // pressionar alt + interset > Getter:
    public String getNome() {
        return nome;
    }

    public Integer getIdade() {
        return idade;
    }

    public String getCor() {
        return cor;
    }

    // pressionar alt + interset > ToString:


    @Override
    public String toString() {
        return "{" +
                "nome='" + nome + '\'' +
                ", idade=" + idade +
                ", cor='" + cor + '\'' +
                '}';
    }

    @Override
    public int compareTo(Gato gato) {
        return this.getNome().compareToIgnoreCase(gato.getNome());
    }
}

class ComparadorIdade implements Comparator<Gato> {

    @Override
    public int compare(Gato g1, Gato g2) {
        return Integer.compare(g1.getIdade(), g2.getIdade());
    }
}

class ComparadorCor implements Comparator<Gato> {

    @Override
    public int compare(Gato g1, Gato g2) {
        return g1.getCor().compareToIgnoreCase(g2.getCor());
    }
}

class comparadorNomeCorIdade implements Comparator<Gato> {

    @Override
    public int compare(Gato g1, Gato g2) {
        int nome = g1.getNome().compareToIgnoreCase(g2.getNome());
        if (nome != 0) return nome;

        int cor = g1.getCor().compareToIgnoreCase(g2.getCor());
        if (cor != 0) return cor;

        return Integer.compare(g1.getIdade(), g2.getIdade());

    }
}