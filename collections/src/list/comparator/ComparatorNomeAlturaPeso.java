package list.comparator;

import list.Pessoa;

import java.util.Comparator;

public class ComparatorNomeAlturaPeso implements Comparator<Pessoa> {

    @Override
    public int compare(Pessoa o1, Pessoa o2) {
        int comparatorNome = o1.getNome().compareTo(o2.getNome());
        if (comparatorNome !=0 ) return comparatorNome;

        int comparatorAltura = Double.compare(o2.getAltura(),o1.getAltura());
        if (comparatorAltura !=0) return comparatorAltura;

        return Double.compare(o2.getPeso(), o1.getPeso());
    }
}
