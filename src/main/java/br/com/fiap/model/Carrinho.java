package br.com.fiap.model;

public class Carrinho {

    private Long id;
    private String nomeItem;
    private float valor;
    private Integer quantidade;

    private boolean isPago;
    private Long idPessoa;

    public Carrinho() {
    }

    public Carrinho(String nomeItem, float valor, Integer quantidade, boolean isPago) {
        this.nomeItem = nomeItem;
        this.valor = valor;
        this.quantidade = quantidade;
        setPago(isPago);
        float valorTotal = calcularTotal(valor, quantidade);
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

    public Integer getQuantidade() {
        return quantidade;
    }

    public void setQuantidade(Integer quantidade) {
        this.quantidade = quantidade;
    }

    public boolean isPago() {
        return isPago;
    }

    public void setPago(boolean pago) {
        if(pago(isPago) == true) {
            this.isPago = pago;
        } else {
            throw new RuntimeException("O item precisa ser pago para ser adicionado a lista de comprados");
        }
    }

    public Long getIdPessoa() {
        return idPessoa;
    }

    public float calcularTotal(float valor, Integer quantidade) {
        return valor * quantidade;
    }

    public boolean pago(boolean isPago){
        if (isPago){
            return true;
        } else {
            return false;
        }
    }
}
