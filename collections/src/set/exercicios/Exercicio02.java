/*
    Crie uma classe LinguagemFavorita que possua os atributos
    nome, anoDeCriacao e ide. Em seguida, crie um conjunto com
    3 linguagens e faça um programa que ordene esse conjunto
    por:

    Ordem de Inserção

    Ordem Natural (nome)

    IDE

    Ano de criação e nome

    Nome, ano de criacao e IDE

    Ao final, exiba as linguagens no console, um abaixo da outra.
 */
package set.exercicios;

import java.util.Comparator;
import java.util.LinkedHashSet;
import java.util.Set;
import java.util.TreeSet;

public class Exercicio02 {
    public static void main(String[] args) {
        Set<LinguagemFavorita> linguagensFavoritas = new LinkedHashSet<>() {{
            add(new LinguagemFavorita("Python", 1989, "Pycharm"));
            add(new LinguagemFavorita("C#", 2002, "VScode"));
            add(new LinguagemFavorita("Java", 1991, "Intellij"));
        }};

        System.out.println("Na ordem de insersão: " + linguagensFavoritas + "\n");

        linguagensFavoritas = new TreeSet<>(linguagensFavoritas);
        System.out.println("Na ordem alfabética: " + linguagensFavoritas + "\n");

        Set<LinguagemFavorita> linguagensFavoritas2 = new TreeSet<>(new ComparatorIDE());
        linguagensFavoritas2.addAll(linguagensFavoritas);
        System.out.println("Na ordem da IDE: " + linguagensFavoritas2 + "\n");

        linguagensFavoritas2 = new TreeSet<>(new ComparatorAnoCriacaoNome());
        linguagensFavoritas2.addAll(linguagensFavoritas);
        System.out.println("Na ordem do ano de criação e do nome: " + linguagensFavoritas2 + "\n");

        linguagensFavoritas2 = new TreeSet<>(new ComparatorNomeAnoCriacaoIde());
        linguagensFavoritas2.addAll(linguagensFavoritas);
        System.out.println("Na ordem nome, ano de crição e IDE: " + linguagensFavoritas2);
    }
}

class LinguagemFavorita implements Comparable<LinguagemFavorita> {
    private String nome;
    private Integer anoDeCriacao;
    private String ide;

    public LinguagemFavorita(String nome, Integer anoDeCriacao, String ide) {
        this.nome = nome;
        this.anoDeCriacao = anoDeCriacao;
        this.ide = ide;
    }

    public String getNome() {
        return nome;
    }

    public Integer getAnoDeCriacao() {
        return anoDeCriacao;
    }

    public String getIde() {
        return ide;
    }

    @Override
    public String toString() {
        return "{" +
                "nome='" + nome + '\'' +
                ", anoDeCriacao=" + anoDeCriacao +
                ", ide='" + ide + '\'' +
                '}';
    }


    @Override
    public int compareTo(LinguagemFavorita o) {
        return this.getNome().compareToIgnoreCase(o.getNome());
    }
}

class ComparatorIDE implements Comparator<LinguagemFavorita> {

    @Override
    public int compare(LinguagemFavorita o1, LinguagemFavorita o2) {
        return o1.getIde().compareToIgnoreCase(o2.getIde());
    }
}

class ComparatorAnoCriacaoNome implements Comparator<LinguagemFavorita> {

    @Override
    public int compare(LinguagemFavorita o1, LinguagemFavorita o2) {
        int comparatorAnoCriacao = Integer.compare(o1.getAnoDeCriacao(), o2.getAnoDeCriacao());

        if (comparatorAnoCriacao != 0) return comparatorAnoCriacao;

        return o1.getNome().compareToIgnoreCase(o2.getNome());
    }

}

class ComparatorNomeAnoCriacaoIde implements Comparator<LinguagemFavorita>{

    @Override
    public int compare(LinguagemFavorita o1, LinguagemFavorita o2) {
        int comparatorNome = o1.getNome().compareToIgnoreCase(o2.getNome());
        if (comparatorNome != 0) return comparatorNome;

        int comparatorAno = Integer.compare(o1.getAnoDeCriacao(), o2.getAnoDeCriacao());
        if(comparatorAno != 0) return comparatorAno;

        return o1.getIde().compareToIgnoreCase(o2.getIde());
    }
}