package br.com.fiap.model;

public class Eletrodomestico {
    private Long id;
    private String categoria;
    private float consumoKwH;
    private float tempoConsumo;
    private int quantidadeDiasLigado;

    public Eletrodomestico() {
    }

    public Eletrodomestico(String categoria, float consumoKwH, float tempoConsumo, int quantidadeDiasLigado) {
        this.categoria = categoria;
        this.consumoKwH = consumoKwH;
        this.tempoConsumo = tempoConsumo;
        this.quantidadeDiasLigado = quantidadeDiasLigado;
    }

    public Long getId() {
        return id;
    }

    public String getCategoria() {
        return categoria;
    }

    public void setCategoria(String categoria) {
        this.categoria = categoria;
    }

    public float getConsumoKwH() {
        return consumoKwH;
    }

    public void setConsumoKwH(float consumoKwH) {
        this.consumoKwH = consumoKwH;
    }

    public float getTempoConsumo() {
        return tempoConsumo;
    }

    public void setTempoConsumo(float tempoConsumo) {
        this.tempoConsumo = tempoConsumo;
    }

    public int getQuantidadeDiasLigado() {
        return quantidadeDiasLigado;
    }

    public void setQuantidadeDiasLigado(int quantidadeDiasLigado) {
        this.quantidadeDiasLigado = quantidadeDiasLigado;
    }

    public float calcularConsumo() {
        return consumoKwH * tempoConsumo * quantidadeDiasLigado;
    }
}
