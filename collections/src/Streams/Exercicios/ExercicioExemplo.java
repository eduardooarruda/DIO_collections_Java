package Streams.Exercicios;

import java.util.Arrays;
import java.util.Comparator;
import java.util.List;
import java.util.Set;
import java.util.function.*;
import java.util.stream.Collectors;

public class ExercicioExemplo {
    public static void main(String[] args) {
        List<String> numerosAleatorios = Arrays.asList("0", "0", "0", "4", "4", "2", "3", "9", "7", "5", "6", "1", "8");

        System.out.println("Imprimir todos os numeros da lista de numeros aleatorios com stream: ");
        //O método forEach pede uma inteface Consumer
        /*
        numerosAleatorios.stream().forEach(new Consumer<String>() {
            @Override
            public void accept(String s) {
                System.out.println(s);
            }
        });
         */

        //numerosAleatorios.stream().forEach(System.out::println);

        // Mesmo exemplo com lambda
        // numerosAleatorios.stream().forEach(s -> System.out.println(s));

        //O proprio List já possui um forEach:
        numerosAleatorios.forEach(s -> System.out.println(s));

        System.out.println("\nTransformar os 5 primeiros numeros da lista em um set:");
        //limit: tem um long como parametro que indica o limite que deve ser pecorrido
        //collect: Pega a lista e coletar para outro tipo.
        Set<String> setNumerosAleatorios = numerosAleatorios.stream().limit(5).collect(Collectors.toSet());

        setNumerosAleatorios.forEach(System.out::println);

        System.out.println("\nTransforma a lista em uma lista de numeros inteiros: ");

        //No Function signfica que recebe uma string e retorna um inteiro.
        /*
        List<Integer> integerNumerosAleatorios = numerosAleatorios.stream()
                .map(new Function<String, Integer>() {
                    @Override
                    public Integer apply(String s) {
                        return Integer.parseInt(s);
                    }
                }).collect(Collectors.toList());
         */

        List<Integer> integerNumerosAleatorios = numerosAleatorios.stream()
                .map(i -> Integer.parseInt(i))
                .collect(Collectors.toList());
        /*
        List<Integer> integerNumerosAleatorios = numerosAleatorios.stream()
                .map(Integer::parseInt)
                .collect(Collectors.toList());
         */

        integerNumerosAleatorios.forEach(System.out::println);

        System.out.println("Numeros pares maiores que dois e que sao pares:");

        //O filter perde como argumento um Predicate

        /*
        numerosAleatorios.stream()
                .map(Integer::parseInt)
                .filter(new Predicate<Integer>() {
                    @Override
                    public boolean test(Integer numero) {
                        if(numero%2 == 0 && numero > 2) return true;
                        return false;
                    }
                })
                .collect(Collectors.toList())
                .forEach(n -> System.out.print(n +" - "));
         */

        //Lambda

        numerosAleatorios.stream()
                .map(Integer::parseInt)
                .filter(numero -> (numero % 2 == 0 && numero > 2))
                .collect(Collectors.toList())
                .forEach(System.out::println);

        System.out.println("\nMedia dos numeros: ");

        /*
        numerosAleatorios.stream()
                .mapToInt(new ToIntFunction<String>() {
                    @Override
                    public int applyAsInt(String numero) {
                        return Integer.parseInt(numero);
                    }
                })
                .average()// tem que possui o metodo do OpcionalDouble que é ifPresent
                .ifPresent(new DoubleConsumer() { // Se calular a media de certo
                    @Override
                    public void accept(double value) {
                        System.out.println(value);
                    }
                });
         */

        numerosAleatorios.stream()
                .mapToInt(Integer::parseInt)
                .average()
                .ifPresent(System.out::println);

        System.out.println("\nRemocao dos numeros impares:");
        //Nao pode ser feito com stream, porque o stream nao modifica a variavel
        //removeIf é um método da List
        /*
        integerNumerosAleatorios.removeIf(
                new Predicate<Integer>() {
                    @Override
                    public boolean test(Integer numero) {
                        if(numero % 2 != 0) return true;
                        return false;
                    }
                }
        );
        */

        integerNumerosAleatorios.removeIf( numero -> numero % 2 != 0);

        System.out.println(integerNumerosAleatorios);

        System.out.println("\nLista sem os 3 primeiros numeros");
        numerosAleatorios.stream()
                .skip(3)
                .forEach(System.out::println);

        System.out.println("Retirando os numeros repétidos da lista e contando quanto eles eram: ");
        numerosAleatorios.stream()
                .distinct()
                .forEach(System.out::println);
        long quantidadeNumerosSemRepecao = numerosAleatorios.stream()
                .distinct()
                .count();
        System.out.println("\nQuantidade de numeros: " + ( numerosAleatorios.size() - quantidadeNumerosSemRepecao) );

        System.out.println("\nMenor valor da lista = ");

        numerosAleatorios.stream()
                .mapToInt(Integer::parseInt)
                .min()
                .ifPresent(System.out::println);

        System.out.print("\nMaior valor da lista: ");
        numerosAleatorios.stream()
                .mapToInt(Integer::parseInt)
                .max()
                .ifPresent(System.out::println);

    }
}
