package clinica.model;

import java.time.LocalDateTime;

public class Consulta {
    private final Paciente paciente;
    private final Medico medico;
    private final LocalDateTime dataHora;
    private boolean compareceu;

    public Consulta(Paciente paciente, Medico medico, LocalDateTime dataHora) {
        if (paciente == null) {
            throw new IllegalArgumentException("Paciente é obrigatório.");
        }
        if (medico == null) {
            throw new IllegalArgumentException("Médico é obrigatório.");
        }
        if (dataHora == null) {
            throw new IllegalArgumentException("Data/hora é obrigatória.");
        }
        if (dataHora.isBefore(LocalDateTime.now())) {
            throw new IllegalArgumentException("Consulta não pode ser marcada no passado.");
        }
        this.paciente = paciente;
        this.medico = medico;
        this.dataHora = dataHora;
        this.compareceu = false;
    }

    public Paciente getPaciente() {
        return paciente;
    }

    public Medico getMedico() {
        return medico;
    }

    public LocalDateTime getDataHora() {
        return dataHora;
    }

    public boolean isCompareceu() {
        return compareceu;
    }

    public void registrarComparecimento() {
        this.compareceu = true;
    }

    @Override
    public String toString() {
        return "Consulta{" +
                "paciente=" + paciente.getNome() +
                ", medico=" + medico.getNome() +
                ", dataHora=" + dataHora +
                ", compareceu=" + compareceu +
                '}';
    }
}
