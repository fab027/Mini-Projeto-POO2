package clinica.service;

import clinica.model.Consulta;
import clinica.model.Exame;
import clinica.model.HistoricoClinico;
import clinica.model.Medico;
import clinica.model.Paciente;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class SistemaClinica {
    private final List<Medico> medicos;
    private final List<Paciente> pacientes;
    private final List<Exame> exames;
    private final List<Consulta> consultas;
    private final Map<String, HistoricoClinico> historicosPorDocumento;

    public SistemaClinica() {
        this.medicos = new ArrayList<>();
        this.pacientes = new ArrayList<>();
        this.exames = new ArrayList<>();
        this.consultas = new ArrayList<>();
        this.historicosPorDocumento = new HashMap<>();
    }

    public void cadastrarMedico(Medico medico) {
        medicos.add(medico);
    }

    public void cadastrarPaciente(Paciente paciente) {
        pacientes.add(paciente);
        historicosPorDocumento.putIfAbsent(paciente.getDocumento(), new HistoricoClinico(paciente));
    }

    public void cadastrarExame(Exame exame) {
        exames.add(exame);
    }

    public Consulta agendarConsulta(Paciente paciente, Medico medico, LocalDateTime dataHora) {
        Consulta consulta = new Consulta(paciente, medico, dataHora);
        consultas.add(consulta);
        return consulta;
    }

    public void registrarComparecimento(Consulta consulta) {
        if (consulta == null || !consultas.contains(consulta)) {
            throw new IllegalArgumentException("Não é possível registrar comparecimento sem consulta marcada.");
        }
        consulta.registrarComparecimento();
    }

    public void adicionarHistorico(Paciente paciente, String registro) {
        HistoricoClinico historico = historicosPorDocumento.get(paciente.getDocumento());
        if (historico == null) {
            throw new IllegalArgumentException("Paciente não cadastrado.");
        }
        historico.adicionarRegistro(registro);
    }

    public HistoricoClinico obterHistorico(Paciente paciente) {
        return historicosPorDocumento.get(paciente.getDocumento());
    }

    public List<Consulta> listarConsultas() {
        return List.copyOf(consultas);
    }
}
