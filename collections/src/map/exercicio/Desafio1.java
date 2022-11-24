/*
    Dada a população estimada de alguns estados do NE brasileiro, faça:

        Estado = PE - População = 9.616.621

        Estado = AL - População = 3.351.543

        Estado = CE - População = 9.187.103

        Estado = RN - População = 3.534.265

    Crie um dicionário e relacione os estados e suas populações;

    Substitua a população do estado do RN por 3.534.165;

    Confira se o estado PB está no dicionário, caso não adicione: PB -
    4.039.277;

    Exiba a população PE;

    Exiba todos os estados e suas populações na ordem que foi
    informado;

    Exiba os estados e suas populações em ordem alfabética;

    Exiba o estado com o menor população e sua quantidade;

    Exiba o estado com a maior população e sua quantidade;

    Exiba a soma da população desses estados;

    Exiba a média da população deste dicionário de estados;

    Remova os estados com a população menor que 4.000.000;

    Apague o dicionário de estados;

    Confira se o dicionário está vazio.
 */
package map.exercicio;

import java.util.*;

public class Desafio1 {
    public static void main(String[] args) {
        Map<String, Integer> estadosNE = new HashMap<>(){{
            put("PE", 9_616_621);
            put("AL", 3_351_543);
            put("CE", 9_187_103);
            put("RN", 3_534_265);
        }};

        //Substitua a população do estado do RN por 3.534.165;
        estadosNE.put("RN", 3_534_165);

        System.out.println("\nConfirir se o estado do PE está no Map: " + estadosNE.containsKey("PB"));

        //Adicionar o estado do PB:
        estadosNE.put("PB", 4_039_277);

        System.out.println("\nTodos os Estados:");
        for(Map.Entry<String, Integer> estado: estadosNE.entrySet())
            System.out.println(estado.getKey() + ": " + estado.getValue());

        System.out.println("\nPopulação do estado PE: " + estadosNE.get("PE"));

        System.out.println("\nTodos os Estados na ordem que foram inseridos:");
        Map<String, Integer> estadosNE2 = new LinkedHashMap<>(){{
            put("PE", 9_616_621);
            put("AL", 3_351_543);
            put("CE", 9_187_103);
            put("RN", 3_534_165);
            put("PB", 4_039_277);
        }};

        for(Map.Entry<String, Integer> estado: estadosNE2.entrySet())
            System.out.println(estado.getKey() + ": " + estado.getValue());

        System.out.println("\nOrdernado em ordem Alfabertica por Estado: ");
        Map<String, Integer> estadosNE3 = new TreeMap<>(estadosNE2);

        for(Map.Entry<String, Integer> estado: estadosNE3.entrySet())
            System.out.println(estado.getKey() + ": " + estado.getValue());

        String estadoMenorPopulacao = estadosNE.entrySet()
                .stream()
                .filter(e -> e.getValue().equals(Collections.min(estadosNE3.values())))
                .findFirst()
                .map(Map.Entry::getKey)
                .orElse(null);

        System.out.println("\nEstado com a menor populacao: " + estadoMenorPopulacao + ": "
                + Collections.min(estadosNE.values()));

        int soma = 0;

        for(Map.Entry<String, Integer> estado : estadosNE.entrySet())
            soma += estado.getValue();

        System.out.println("\nSoma da população nestes estados: " + soma);

        System.out.println("\nMedia da populacao: " + soma/estadosNE.size());

        System.out.println("\nRemover todos os estados com população inferior a 4.000.000:");
        List<String> estadosParaRemocao = new ArrayList<>();

        for(Map.Entry<String, Integer> estado : estadosNE.entrySet()){
            if(estado.getValue() < 4_000_000) estadosParaRemocao.add(estado.getKey());
        }
        for(String estado: estadosParaRemocao){
            estadosNE.remove(estado);
        }
        for(String estado: estadosNE.keySet()){
            System.out.println(estado);
        }

        estadosNE.clear();
        System.out.println("\nApagar todos os estados: " + estadosNE);

        System.out.println("Conferir se o Map estar vazio: " + estadosNE.isEmpty());
    }
}
