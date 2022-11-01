package list;

import java.util.*;
import list.comparator.ComparatorAltura;
import list.comparator.ComparatorNomeAlturaPeso;

public class Main {
    public static void main(String[] args) {
        //Forma mais comum de criar uma Lista:
        List<Pessoa> listaPessoas1 = new ArrayList<>() {{
            add(new Pessoa("Eduardo", 63, 166));
            add(new Pessoa("Gabriel", 70, 168));
            add(new Pessoa("Joana", 56, 160));
            add(new Pessoa("Helena", 78, 189));
        }};


        //Uma forma de criar uma lista passando os objetos como argumentos:
        List<Pessoa> listaPessoas2 = new ArrayList<>(Arrays.asList(
                new Pessoa("Maria", 65, 170),
                new Pessoa("Jonh", 80, 178),
                new Pessoa("Carlos", 89, 199),
                new Pessoa("Maria", 102, 200)
        ));

        // Uma forma limitada, pois torna a lista imutável, portanto não pode remover
        // ou adicionar elementos na lista.
        List<Pessoa> listaPessoas3 = Arrays.asList(
                new Pessoa("Mario", 55, 160),
                new Pessoa("lucas", 34, 127),
                new Pessoa("Sara", 100, 188),
                new Pessoa("Fabiana", 87, 179)
        );

        System.out.println("Lista de objetos em cada lista: " + "\n");
        System.out.println("listaPessoas1: " + listaPessoas1 + "\n");
        System.out.println("listaPessoas2: " + listaPessoas2 + "\n");
        System.out.println("listaPessoas3: " + listaPessoas3 + "\n");
        System.out.println();

        //Para adicionar um objeeto Pessoa na posição 1
        listaPessoas1.add(1, new Pessoa("Carla", 76, 186));


        System.out.println("Posição da instâncias Carla, que possui peso igual 76 e altura 186: " +
                listaPessoas1.indexOf(new Pessoa("Carla", 76, 186)) + "\n");


        System.out.println("Verifica se a LsitaPessoa1 contém o objeto eduardo com peso igual 63 e altura igual 166: " +
                listaPessoas1.contains(new Pessoa("eduardo", 63, 166)) + "\n");

        System.out.println("Conteúdo da posição 3 dentro da listaPessoas1: " + listaPessoas1.get(3) + "\n");

        //Nova Lista para testar alguns métodos da biblioteca Collections
        List<Double> pesos = new ArrayList<Double>(Arrays.asList(67.5, 66.5, 98.7, 56.0, 67.0, 87.0, 76.4));
        System.out.println("Menor peso: " + Collections.min(pesos));
        System.out.println("Maior peso: " + Collections.max(pesos));

        Iterator<Double> iterator = pesos.iterator();
        double soma = 0;

        while (iterator.hasNext()) {
            double next = iterator.next();
            soma += next;
        }

        /* Outra forma de somar:
        for (double peso:pesos) {
            soma += peso;
        }
        */
        System.out.println("Soma de todos os pesos: " + soma);

        //size() retorna o número de elementos da lista
        System.out.printf("Média dos pesos: %.2f KG%n%n", soma / pesos.size());

        //Remove remove um elemnto da lista pode ser passados como argumentos tanto posição quanto o objeto
        listaPessoas1.remove(listaPessoas1.size() - 1);
        System.out.println("Removido o último elemento da listaPessoas1: " + listaPessoas1 + "\n");

        System.out.println("Apagar toda listaPessoas1: ");
        listaPessoas1.clear();
        System.out.println(listaPessoas1);

        System.out.println("Confirir se a listaPessoas1 está vazia: " + listaPessoas1.isEmpty() +"\n\n");

        System.out.println("Em baralhar a listaPessoas2: ");
        System.out.println("listaPessoas2 original: " + listaPessoas2);
        Collections.shuffle(listaPessoas2);
        System.out.println("listaPessoas2 embaralhada: " + listaPessoas2 + "\n\n");

        System.out.println("Ordernar a lista listaPessoas2 pelo nome:");
        // Atenção para utilizar o método sort tem que se implementado o metodo compareTo
        Collections.sort(listaPessoas2);
        System.out.println(listaPessoas2 + "\n\n");

        System.out.println("Ordernar a lista listaPessoas2 apartir da altura: ");
        //Collections.sort(listaPessoas2, new ComparatorAltura());
        listaPessoas2.sort(new ComparatorAltura());
        System.out.println(listaPessoas2 + "\n\n");

        System.out.println("Ordernar a lista listaPessoas2 apartir ddo Nome, Altura e Peso: ");
        //Collections.sort(listaPessoas2, new ComparatorAltura());
        listaPessoas2.sort(new ComparatorNomeAlturaPeso());
        System.out.println(listaPessoas2);

    }
}

