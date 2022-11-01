package set.comparator;

import set.Carro;

import java.util.Comparator;

public class ComparatorMarcaModeloPreco implements Comparator<Carro> {

    @Override
    public int compare(Carro o1, Carro o2) {
        int comparatorMarca = o1.getMarca().compareTo(o2.getMarca());
        if(comparatorMarca != 0) return comparatorMarca;

        int comparatorModelo = o1.getModelo().compareTo(o2.getModelo());
        if(comparatorModelo != 0) return comparatorModelo;

        return Double.compare(o2.getPreco(), o1.getPreco());
    }
}
