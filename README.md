# Mini Projeto – Sistema Simplificado de Clínica

## Programação Orientada a Objetos II

Atividade para a matéria de POO2.

## Objetivo

Desenvolver um sistema simplificado de gerenciamento de clínica médica aplicando corretamente os fundamentos de Programação Orientada a Objetos aprendidos em POO1.

## Escopo implementado

- Cadastro de **Médico**.

- Cadastro de **Paciente**.

- Cadastro de **Exame**.

- **Agendamento de consulta**.

- **Registro de comparecimento**.

- **Histórico clínico** do paciente.

## Regras de negócio atendidas

- Consulta **não pode ser marcada no passado**.

- Não registra comparecimento sem consulta marcada.

- Exame deve ter prazo **> 0**.

- Histórico não aceita texto vazio.

- Atributos das classes de domínio são privados.

## Estrutura

```text

source/

Main.java

clinica/classes/

Pessoa.java

Medico.java

Paciente.java

Exame.java

Consulta.java

HistoricoClinico.java

clinica/sistema/

SistemaClinica.java

uml/

umlprojetopoo2.pdf

```

## Diagrama UML

Diagrama de classes em arquivo PDF: `uml/umlprojetopoo2.pdf`.

## Decisões de modelagem

- `Pessoa` é classe abstrata para centralizar `nome` e `documento`.

- `Medico` e `Paciente` herdam de `Pessoa`.

- `SistemaClinica` concentra o fluxo de cadastro e operações para simplificar a orquestração.

- `HistoricoClinico` mantém lista imutável para leitura externa (`Collections.unmodifiableList`).

- `Collections` é uma biblioteca Java que implementa estrutura de dados comumente.
