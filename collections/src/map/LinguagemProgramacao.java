package map;

import java.util.Objects;

public class LinguagemProgramacao {
    private String nome;
    private Integer anoCriacao;

    public LinguagemProgramacao(String nome, Integer anoCriacao) {
        this.nome = nome;
        this.anoCriacao = anoCriacao;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public Integer getAnoCriacao() {
        return anoCriacao;
    }

    public void setAnoCriacao(Integer anoCriacao) {
        this.anoCriacao = anoCriacao;
    }

    @Override
    public String toString() {
        return "{" +
                "nome='" + nome + '\'' +
                ", anoCriacao=" + anoCriacao +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        LinguagemProgramacao that = (LinguagemProgramacao) o;
        return nome.equals(that.nome) && anoCriacao.equals(that.anoCriacao);
    }

    @Override
    public int hashCode() {
        return Objects.hash(nome, anoCriacao);
    }
}
