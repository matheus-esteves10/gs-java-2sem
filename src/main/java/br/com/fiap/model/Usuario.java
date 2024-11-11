package br.com.fiap.model;

import java.time.LocalDate;
import java.util.List;

public class Usuario {

    private String nome;
    private String cpf;
    private LocalDate dataNacimento;
    private String email;
    private String senha;
    private List<Cursos> cursosEmAndamento;
    private List<Cursos> cursosConcluidos;

    public Usuario() {
    }

    public Usuario(String senha, String email, LocalDate dataNacimento, String cpf, String nome) {
        this.senha = senha;
        this.email = email;
        this.dataNacimento = dataNacimento;
        setCpf(cpf);
        this.nome = nome;
    }

    public Usuario(String nome, String cpf, LocalDate dataNacimento, String email, String senha, List<Cursos> cursosEmAndamento, List<Cursos> cursosConcluidos) {
        this.nome = nome;
        setCpf(cpf);
        this.dataNacimento = dataNacimento;
        this.email = email;
        this.senha = senha;
        this.cursosEmAndamento = cursosEmAndamento;
        this.cursosConcluidos = cursosConcluidos;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getCpf() {
        return cpf;
    }

    public void setCpf(String cpf) {
        if (isCpfValid(cpf)) {
            this.cpf = cpf;
        } else {
            throw new RuntimeException("O cpf é inválido");
        }
    }

    public LocalDate getDataNacimento() {
        return dataNacimento;
    }

    public void setDataNacimento(LocalDate dataNacimento) {
        this.dataNacimento = dataNacimento;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getSenha() {
        return senha;
    }

    public void setSenha(String senha) {
        this.senha = senha;
    }

    public List<Cursos> getCursosEmAndamento() {
        return cursosEmAndamento;
    }

    public void setCursosEmAndamento(List<Cursos> cursosEmAndamento) {
        this.cursosEmAndamento = cursosEmAndamento;
    }

    public List<Cursos> getCursosConcluidos() {
        return cursosConcluidos;
    }

    public void setCursosConcluidos(List<Cursos> cursosConcluidos) {
        this.cursosConcluidos = cursosConcluidos;
    }


    public boolean isCpfValid(String cpf) {
        cpf = cpf.replaceAll("[^0-9]", ""); // Remover caracteres não numéricos

        if (cpf.length() != 11)
            return false;

        if (cpf.matches("(\\d)\\1*")) // Verificar se todos os dígitos são iguais (caso contrário, não é um CPF válido)
            return false;

        // Calcular o primeiro dígito verificador
        int soma = 0;
        for (int i = 0; i < 9; i++) {
            soma += (10 - i) * Character.getNumericValue(cpf.charAt(i));
        }
        int resto = soma % 11;
        int digitoVerificador1 = (resto < 2) ? 0 : (11 - resto);

        // Verificando o primeiro dígito verificador
        if (Character.getNumericValue(cpf.charAt(9)) != digitoVerificador1)
            return false;

        // Calculando o segundo dígito verificador
        soma = 0;
        for (int i = 0; i < 10; i++) {
            soma += (11 - i) * Character.getNumericValue(cpf.charAt(i));
        }
        resto = soma % 11;
        int digitoVerificador2 = (resto < 2) ? 0 : (11 - resto);

        // Verificando o segundo dígito verificador
        if (Character.getNumericValue(cpf.charAt(10)) != digitoVerificador2)
            return false;

        // CPF válido
        return true;
    }
}
