/*
Crie um conjunto contendo as cores do arco-íris e:

Exiba todas as cores uma abaixo da outra

A quantidade de cores que o arco-íris tem

Exiba as cores em ordem alfabética

Exiba as cores na ordem inversa da que foi informada

Exiba todas as cores que começam com a letra ”v”

Remova todas as cores que não começam com a letra “v”

Limpe o conjunto

Confira se o conjunto está vazio
 */
package set.exercicios;

import list.Pessoa;

import java.util.*;

public class Exercicio01 {

    public static void main(String[] args) {
        Set<String> coresArcoiris = new HashSet<>(){{
            add("Azual");
            add("Vermelho");
            add("Amarelo");
            add("Verde");
            add("Laranja");
            add("Anil");
            add("Violeta");
        }};

        System.out.println("Todos as cores do arco-íris");
        Iterator<String> cores = coresArcoiris.iterator();
        while(cores.hasNext()) System.out.println(cores.next());

        System.out.println();

        System.out.println("Quantidade de cores do arco-íris: " + coresArcoiris.size() + "\n");

        coresArcoiris = new TreeSet<String>(coresArcoiris);

        System.out.println("Cores do arco-íris ordenados em ordem alfabética: ");
        Iterator<String> cores2 = coresArcoiris.iterator();
        while(cores2.hasNext()) System.out.println(cores2.next());
        System.out.println();

        System.out.println("Cores na ordem inversa: ");
        coresArcoiris = new LinkedHashSet<>(coresArcoiris);
        List<String> coresArcoirisList = new ArrayList<>(coresArcoiris);
        Collections.reverse(coresArcoirisList);
        for(String cor: coresArcoirisList) System.out.println(cor);
        System.out.println();

        System.out.println("Todas as cores que começam com a letra v: ");
        for (String cor: coresArcoiris)
            if(cor.toLowerCase().startsWith("v")) System.out.println(cor);

        System.out.println();

        System.out.println("Remover todas as cores que não começam com a letra v: ");
        Iterator<String> cores3 = coresArcoiris.iterator();
        while(cores3.hasNext())
            if(!cores3.next().toLowerCase().startsWith("v")) cores3.remove();
        System.out.println(coresArcoiris + "\n");

        coresArcoiris.clear();

        System.out.println("Apagando todas as cores do arco-íris: " + coresArcoiris + "\n");

        System.out.println("Verificando se o arco-íris estar sem nenhum cor: " + coresArcoiris.isEmpty() + "\n");
    }
}
