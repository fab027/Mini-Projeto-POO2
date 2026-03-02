import clinica.model.Consulta;
import clinica.model.Exame;
import clinica.model.Medico;
import clinica.model.Paciente;
import clinica.service.SistemaClinica;

import java.time.LocalDateTime;

public class Main {
    public static void main(String[] args) {
        SistemaClinica sistema = new SistemaClinica();

        Medico medico = new Medico("Dra. Camila Rocha", "111.111.111-11", "CRM-SP 12345", "Clínica Geral");
        Paciente paciente = new Paciente("João Martins", "222.222.222-22", "CV-90871");

        sistema.cadastrarMedico(medico);
        sistema.cadastrarPaciente(paciente);
        sistema.cadastrarExame(new Exame("Hemograma", 5));

        System.out.println("=== Cenário válido ===");
        Consulta consultaValida = sistema.agendarConsulta(paciente, medico, LocalDateTime.now().plusDays(1));
        sistema.registrarComparecimento(consultaValida);
        sistema.adicionarHistorico(paciente, "Paciente compareceu e relatou melhora.");
        System.out.println(consultaValida);
        System.out.println("Histórico: " + sistema.obterHistorico(paciente).getRegistros());

        System.out.println("\n=== Cenário inválido ===");
        try {
            sistema.agendarConsulta(paciente, medico, LocalDateTime.now().minusHours(3));
        } catch (IllegalArgumentException e) {
            System.out.println("Erro esperado: " + e.getMessage());
        }

        try {
            sistema.cadastrarExame(new Exame("Raio-X", 0));
        } catch (IllegalArgumentException e) {
            System.out.println("Erro esperado: " + e.getMessage());
        }

        try {
            sistema.adicionarHistorico(paciente, "  ");
        } catch (IllegalArgumentException e) {
            System.out.println("Erro esperado: " + e.getMessage());
        }

        System.out.println("\n=== Cenário de borda ===");
        Consulta consultaBorda = sistema.agendarConsulta(paciente, medico, LocalDateTime.now().plusMinutes(1));
        System.out.println("Consulta de borda criada: " + consultaBorda);

        try {
            sistema.registrarComparecimento(null);
        } catch (IllegalArgumentException e) {
            System.out.println("Erro esperado: " + e.getMessage());
        }
    }
}
