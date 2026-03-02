package clinica.model;

public class Medico extends Pessoa {
    private final String crm;
    private final String especialidade;

    public Medico(String nome, String documento, String crm, String especialidade) {
        super(nome, documento);
        if (crm == null || crm.isBlank()) {
            throw new IllegalArgumentException("CRM é obrigatório.");
        }
        if (especialidade == null || especialidade.isBlank()) {
            throw new IllegalArgumentException("Especialidade é obrigatória.");
        }
        this.crm = crm;
        this.especialidade = especialidade;
    }

    public String getCrm() {
        return crm;
    }

    public String getEspecialidade() {
        return especialidade;
    }

    @Override
    public String toString() {
        return getNome() + " (CRM: " + crm + ", " + especialidade + ")";
    }
}
