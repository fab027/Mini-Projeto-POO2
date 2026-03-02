package clinica.model;

public abstract class Pessoa {
    private final String nome;
    private final String documento;

    protected Pessoa(String nome, String documento) {
        if (nome == null || nome.isBlank()) {
            throw new IllegalArgumentException("Nome é obrigatório.");
        }
        if (documento == null || documento.isBlank()) {
            throw new IllegalArgumentException("Documento é obrigatório.");
        }
        this.nome = nome;
        this.documento = documento;
    }

    public String getNome() {
        return nome;
    }

    public String getDocumento() {
        return documento;
    }
}
