package Streams;

import java.util.*;
import java.util.function.Function;

public class Main {

    public static void main(String[] args) {
        Map<Integer, Aluno> turma = new HashMap<>() {
            {
                put(1, new Aluno("Eduarda", 18, 123456));
                put(3, new Aluno("Fábio", 17, 789065));
                put(2, new Aluno("Tatianne", 19, 123445));
            }
        };


        System.out.println("Ordernando o map pela idade");

        //Classe anônima

        /*
        Set<Map.Entry<Integer, Aluno>> setAluno = new TreeSet<>(new Comparator<Map.Entry<Integer, Aluno>>() {
            @Override
            public int compare(Map.Entry<Integer, Aluno> aluno1, Map.Entry<Integer, Aluno> aluno2) {
                return Integer.compare(aluno1.getValue().getIdade(), aluno2.getValue().getIdade());
            }
        });
         */

        //Function
        /*
        Set<Map.Entry<Integer, Aluno>> setAluno = new TreeSet<>(Comparator.comparing(
                new Function<Map.Entry<Integer, Aluno>, Integer>() {
                    @Override
                    public Integer apply(Map.Entry<Integer, Aluno> aluno) {
                        return aluno.getValue().getIdade();
                    }
                }));

         */

        //Lambda

        Set<Map.Entry<Integer, Aluno>> setAluno = new TreeSet<>(Comparator.comparing(
                aluno -> aluno.getValue().getIdade()));

        setAluno.addAll(turma.entrySet());

        for (Map.Entry<Integer, Aluno> aluno : setAluno)
            System.out.println(aluno.getKey() + " = " + aluno.getValue());

    }

}
