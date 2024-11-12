package br.com.fiap.model;

public class Carrinho {

    private Long id;
    private String nomeItem;
    private float valor;
    private int quantidade;

    private boolean isPago;
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

    public boolean isPago() {
        return isPago;
    }

    public void setPago(boolean pago) {
        isPago = pago;
    }

    public Long getIdPessoa() {
        return idPessoa;
    }

    public float calcularTotal(float valor, int quantidade) {
        return valor * quantidade;
    }

    public boolean isPago(boolean isPago){
        if (isPago){
            return true;
        } else {
            return false;
        }
    }
}
