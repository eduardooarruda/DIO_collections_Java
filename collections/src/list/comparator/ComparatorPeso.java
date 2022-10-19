package list.comparator;

import list.Pessoa;

import java.util.Comparator;

public class ComparatorPeso implements Comparator<Pessoa> {

    @Override
    public int compare(Pessoa o1, Pessoa o2) {
        return Double.compare(o2.getPeso(), o1.getPeso());
    }
}
