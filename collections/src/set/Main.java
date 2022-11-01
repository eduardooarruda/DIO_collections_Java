package set;

import set.comparator.ComparatorMarcaModeloPreco;

import java.util.*;


public class Main {
    public static void main(String[] args) {
        Set<Carro> conjuntoCarros = new HashSet<>(Arrays.asList(
                new Carro("Volkswagen", "Gol", 25.0 ),
                new Carro("General Motors", "Celta", 33.0),
                new Carro("Toyota", "Corolla", 34.7),
                new Carro("Toyota", "Corolla",34.7),
                new Carro("Fiat", "Punto", 17.9),
                new Carro("Volkswagen", "Gol" , 25.0),
                new Carro("Volkswagen", "Gol", 25.0 )
        ));

        System.out.println("Conjuntos de carros:\n " + conjuntoCarros + "\n\n");

        System.out.println("Verificar se o Carro Fiat Punto com preco 17.9 está presente no conjunto: " +
                conjuntoCarros.contains(new Carro("Fiat", "Punto", 17.9)) + "\n");

        System.out.println("Todos os modelos de carros: ");
        Iterator<Carro> carros = conjuntoCarros.iterator();
        while(carros.hasNext()){
            System.out.println(carros.next().getModelo());
        }

        System.out.println("Quantidade de itens no conjuto: "+ conjuntoCarros.size() + "\n");

        System.out.println("Remover o carro do modelo corolla: ");
        conjuntoCarros.remove(new Carro("Toyota", "Corolla", 34.7));
        System.out.println(conjuntoCarros + "\n");

        System.out.println("Mostrar os carros na ordem que foram isnseridos: ");
        //Para fazer isso tem usar a classe LinkedHashSet
        Set<Carro> conjuntoCarros2 = new LinkedHashSet<>(){{
            add(new Carro("Volkswagen", "Gol", 25.0 ));
            add(new Carro("General Motors", "Celta", 27.0));
            add(new Carro("Toyota", "Corolla", 33d));
            add(new Carro("Fiat", "Punto", 33.0));
            add(new Carro("Fiat", "Uno", 33.0));
        }};
        System.out.println(conjuntoCarros2 +"\n");

        System.out.println("Inseir os valores dos carros de forma ordenada: ");
        Set<Double> valoresCarros = new TreeSet<>(){{
            add(25.500);
            add(23.000);
            add(30.000);
            add(40.000);
        }};

        System.out.println(valoresCarros);

        System.out.println("Apagar o conjuntoCarros: " );
        conjuntoCarros.clear();
        System.out.println(conjuntoCarros);

        System.out.println("Verificar se o conjntoCarros está vazia: " + conjuntoCarros.isEmpty());

        System.out.println("Inserir ordenado: ");
        Set<Carro> conjuntoCarros3 = new TreeSet<>(conjuntoCarros2);
        System.out.println(conjuntoCarros3 + "\n\n");

        System.out.println("conjuntoCarros4 ordernado por Marca|Modelo|Preço:");
        //Inicialmente o conjunto está vazio, mas quando ele for sendo adicionado elementos ele vai ser
        //organizado por Marca|Modelo|Preço
        Set<Carro> conjuntoCarros4 = new TreeSet<>(new ComparatorMarcaModeloPreco());
        conjuntoCarros4.addAll(conjuntoCarros2);
        System.out.println(conjuntoCarros4);


    }
}
