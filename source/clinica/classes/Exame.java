package clinica.model;

public class Exame {
    private final String nome;
    private final int prazoDias;

    public Exame(String nome, int prazoDias) {
        if (nome == null || nome.isBlank()) {
            throw new IllegalArgumentException("Nome do exame é obrigatório.");
        }
        if (prazoDias <= 0) {
            throw new IllegalArgumentException("Prazo do exame deve ser maior que zero.");
        }
        this.nome = nome;
        this.prazoDias = prazoDias;
    }

    public String getNome() {
        return nome;
    }

    public int getPrazoDias() {
        return prazoDias;
    }

    @Override
    public String toString() {
        return nome + " (prazo: " + prazoDias + " dias)";
    }
}
