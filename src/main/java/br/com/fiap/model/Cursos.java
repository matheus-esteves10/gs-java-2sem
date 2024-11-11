package br.com.fiap.model;

import java.util.List;

public class Cursos {
    private String titulo;
    private String poster;
    private String classificacao;
    private String quanidadeHoras;
    private List<Usuario> usuariosMatriculados;

    public Cursos() {
    }

    public Cursos(String titulo, String poster, String classificacao, String quanidadeHoras, List<Usuario> usuariosMatriculados) {
        this.titulo = titulo;
        this.poster = poster;
        this.classificacao = classificacao;
        this.quanidadeHoras = quanidadeHoras;
        this.usuariosMatriculados = usuariosMatriculados;
    }

    public Cursos(String titulo, String poster, String classificacao, String quanidadeHoras) {
        this.titulo = titulo;
        this.poster = poster;
        this.classificacao = classificacao;
        this.quanidadeHoras = quanidadeHoras;
    }

    public String getTitulo() {
        return titulo;
    }

    public void setTitulo(String titulo) {
        this.titulo = titulo;
    }

    public String getPoster() {
        return poster;
    }

    public void setPoster(String poster) {
        this.poster = poster;
    }

    public String getClassificacao() {
        return classificacao;
    }

    public void setClassificacao(String classificacao) {
        this.classificacao = classificacao;
    }

    public String getQuanidadeHoras() {
        return quanidadeHoras;
    }

    public void setQuanidadeHoras(String quanidadeHoras) {
        this.quanidadeHoras = quanidadeHoras;
    }

    public List<Usuario> getUsuariosMatriculados() {
        return usuariosMatriculados;
    }

    public void setUsuariosMatriculados(List<Usuario> usuariosMatriculados) {
        this.usuariosMatriculados = usuariosMatriculados;
    }
}
