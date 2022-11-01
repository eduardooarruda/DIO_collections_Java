package Map;

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
}
