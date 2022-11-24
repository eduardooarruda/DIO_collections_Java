package map.comparator;

import map.LinguagemProgramacao;

import java.util.Comparator;
import java.util.Map;

public class ComparatorNomeLinguagem implements Comparator<Map.Entry<String, LinguagemProgramacao>> {

    @Override
    public int compare(Map.Entry<String, LinguagemProgramacao> linguagem1, Map.Entry<String, LinguagemProgramacao> linguagem2) {
        return linguagem1.getValue().getNome().compareToIgnoreCase(linguagem2.getValue().getNome());
    }
}
