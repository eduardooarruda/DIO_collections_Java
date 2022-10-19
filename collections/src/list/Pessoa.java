package list;

import java.util.Objects;

public class Pessoa {
    private String nome;
    private double Peso;
    private double altura;

    public Pessoa(String nome, double peso, double altura) {
        this.nome = nome;
        Peso = peso;
        this.altura = altura;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public double getPeso() {
        return Peso;
    }

    public void setPeso(double peso) {
        Peso = peso;
    }

    public double getAltura() {
        return altura;
    }

    public void setAltura(double altura) {
        this.altura = altura;
    }

    //Os métodos equals e hashCode foram implementados para verificar se duas instâncias são iguais
    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Pessoa pessoa = (Pessoa) o;
        return Double.compare(pessoa.Peso, Peso) == 0 && Double.compare(pessoa.altura, altura) == 0 && Objects.equals(nome, pessoa.nome);
    }

    @Override
    public int hashCode() {
        return Objects.hash(nome, Peso, altura);
    }

    @Override
    public String toString() {
        return "Pessoa{" +
                "nome='" + nome + '\'' +
                ", Peso=" + Peso +
                ", altura=" + altura +
                '}';
    }
}
