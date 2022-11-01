package set;

import java.util.Objects;

public class Carro implements Comparable<Carro> {
    private String marca;
    private String modelo;
    private Double preco;

    public Carro(String marca, String modelo, double preco) {
        this.marca = marca;
        this.modelo = modelo;
        this.preco = preco;
    }

    public String getMarca() {
        return marca;
    }

    public String getModelo() {
        return modelo;
    }

    public Double getPreco() {
        return preco;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Carro carro = (Carro) o;
        return marca.equals(carro.marca) && modelo.equals(carro.modelo);
    }

    @Override
    public int hashCode() {
        return Objects.hash(marca, modelo);
    }

    @Override
    public String toString() {
        return "{" +
                "marca='" + marca + '\'' +
                ", modelo='" + modelo + '\'' +
                ", preco=" + preco +
                '}';
    }

    @Override
    public int compareTo(Carro o) {
        int comparePreco = Double.compare(this.getPreco(), o.getPreco());
        if(comparePreco != 0) return comparePreco;

        int compareMarca = this.getMarca().compareTo(o.getMarca());
        if(compareMarca != 0) return compareMarca;

        return this.getModelo().compareTo(o.getModelo());
    }
}
