package map.comparator;

import map.LinguagemProgramacao;

import java.util.Comparator;
import java.util.Map;

public class ComparetorAnoCriacao implements Comparator <Map.Entry<String, LinguagemProgramacao>> {

    @Override
    public int compare(Map.Entry<String, LinguagemProgramacao> linguagem1, Map.Entry<String, LinguagemProgramacao> linguagem2) {
        return Integer.compare(linguagem1.getValue().getAnoCriacao(), linguagem2.getValue().getAnoCriacao());
    }
}
