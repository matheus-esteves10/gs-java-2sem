package br.com.fiap.model;

public class Carrinho {

    private Long id;
    private String nomeItem;
    private float valor;
    private int quantidade;
    private Long idPessoa;

    public Carrinho() {
    }

    public Carrinho(String nomeItem, float valor, int quantidade) {
        this.nomeItem = nomeItem;
        this.valor = valor;
        this.quantidade = quantidade;
        calcularTotal(valor,quantidade);
    }

    public Long getId() {
        return id;
    }

    public String getNomeItem() {
        return nomeItem;
    }

    public void setNomeItem(String nomeItem) {
        this.nomeItem = nomeItem;
    }

    public float getValor() {
        return valor;
    }

    public void setValor(float valor) {
        this.valor = valor;
    }

    public int getQuantidade() {
        return quantidade;
    }

    public void setQuantidade(int quantidade) {
        this.quantidade = quantidade;
    }

    public Long getIdPessoa() {
        return idPessoa;
    }

    public float calcularTotal(float valor, int quantidade) {
        return valor * quantidade;
    }
}
