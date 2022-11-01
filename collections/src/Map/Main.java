package Map;

import java.sql.SQLOutput;
import java.util.*;

public class Main {
    public static void main(String[] args) {
        Map<Integer, LinguagemProgramacao> linguagens = new HashMap<>() {{
            put(1, new LinguagemProgramacao("Python", 1989));
            put(3, new LinguagemProgramacao("Java", 1995));
            put(2, new LinguagemProgramacao("JavaScript", 1995));
        }};

        System.out.println("Todas as linguagens de programação: " + linguagens + "\n");

        System.out.println("Alterar Javascript para C#: ");
        linguagens.put(1, new LinguagemProgramacao("C#", 2002));
        System.out.println(linguagens + "\n");

        System.out.println("Conferir se a linguagem 1 está no Map: " + linguagens.containsKey(1) + "\n");

        System.out.println("Valor da linguagem 2: " + linguagens.get(2));

        System.out.println("Exibir todas as chaves: ");
        Set<Integer> chavesMap = linguagens.keySet();
        System.out.println(chavesMap + "\n");

        System.out.println("Exibir todos os valores: ");
        Collection<LinguagemProgramacao> valores = linguagens.values();
        System.out.println(valores + "\n");

        List<Integer> anoCriacao = new ArrayList<>();

        for (LinguagemProgramacao l : valores) {
            anoCriacao.add(l.getAnoCriacao());
        }

        int maisVelha = Collections.min(anoCriacao);

        System.out.println("Linguagem mais velha: " + maisVelha);
        //Para navergar de forma separada entre chaves e valores
        Set<Map.Entry<Integer, LinguagemProgramacao>> entries = linguagens.entrySet();
        LinguagemProgramacao linguagemMaisVelha = null;

        for (Map.Entry<Integer, LinguagemProgramacao> entry : entries) {
            if (entry.getValue().getAnoCriacao() == maisVelha) {
                linguagemMaisVelha = entry.getValue();
                System.out.println(linguagemMaisVelha);
            }
        }

        System.out.println("\nMostrar  todas as linguagens de programação com iterator: ");
        Iterator<LinguagemProgramacao> iterator = linguagens.values().iterator();
        while (iterator.hasNext()) {
            System.out.println(iterator.next());
        }

        System.out.println("\nQuantidade de Linguagens de programção: " + linguagens.size());

        System.out.println("\nRemover a Linguagem C#: ");
        Iterator<LinguagemProgramacao> iterator2 = linguagens.values().iterator();
        while (iterator2.hasNext()) {
            if (iterator2.next().getNome().equals("C#")) iterator2.remove();
        }

        for (LinguagemProgramacao l : linguagens.values()) {
            System.out.println(l);
        }

        System.out.println("\nMostrar todas as linguagens na ordem que foram inseridas: ");

        Map<Integer, LinguagemProgramacao> linguagens2 = new LinkedHashMap<>() {{
            put(1, new LinguagemProgramacao("Python", 1989));
            put(3, new LinguagemProgramacao("Java", 1995));
            put(2, new LinguagemProgramacao("JavaScript", 1995));
        }};

        System.out.println(linguagens2 + "\n");

        System.out.println("\nOrdernar pela chave: ");
        Map<Integer, LinguagemProgramacao> linguagens3 = new TreeMap<>(linguagens2);
        System.out.println(linguagens3 + "\n");

        linguagens.clear();
        System.out.println("Apagar todo o Map linguagens: " + linguagens);

        System.out.println("Confirir se o Map linguagens está vazio: " + linguagens.isEmpty());
    }
}
