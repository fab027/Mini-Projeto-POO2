package clinica.model;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class HistoricoClinico {
    private final Paciente paciente;
    private final List<String> registros;

    public HistoricoClinico(Paciente paciente) {
        if (paciente == null) {
            throw new IllegalArgumentException("Paciente é obrigatório para histórico.");
        }
        this.paciente = paciente;
        this.registros = new ArrayList<>();
    }

    public void adicionarRegistro(String texto) {
        if (texto == null || texto.isBlank()) {
            throw new IllegalArgumentException("Histórico não aceita texto vazio.");
        }
        registros.add(texto.trim());
    }

    public Paciente getPaciente() {
        return paciente;
    }

    public List<String> getRegistros() {
        return Collections.unmodifiableList(registros);
    }
}
