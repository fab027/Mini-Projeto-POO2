package clinica.model;

public class Paciente extends Pessoa {
    private final String numeroConvenio;

    public Paciente(String nome, String documento, String numeroConvenio) {
        super(nome, documento);
        if (numeroConvenio == null || numeroConvenio.isBlank()) {
            throw new IllegalArgumentException("Número do convênio é obrigatório.");
        }
        this.numeroConvenio = numeroConvenio;
    }

    public String getNumeroConvenio() {
        return numeroConvenio;
    }

    @Override
    public String toString() {
        return getNome() + " (Convênio: " + numeroConvenio + ")";
    }
}
