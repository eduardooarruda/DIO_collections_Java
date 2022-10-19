package list.comparator;

import list.Pessoa;

import java.util.Comparator;

public class ComparatorAltura implements Comparator<Pessoa> {
    @Override
    public int compare(Pessoa o1, Pessoa o2) {
        //Trocando a ordem dos parametros do método compare modifica a ordem
        //, por exemplo pode ficar em ordem decrescente ou crescente
        return Double.compare(o2.getAltura(), o1.getAltura());
    }
}
