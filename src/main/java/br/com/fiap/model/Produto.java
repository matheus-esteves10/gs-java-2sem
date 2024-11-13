package br.com.fiap.model;

public class Produto {

    private Long idProduto;
    private String nomeProduto;
    private Double valorProduto;
    private String imagemProduto;
    private String dsProduto;

    public Produto() {
    }

    public Produto(Long idProduto, String nomeProduto, Double valorProduto, String imagemProduto, String dsProduto) {
        this.idProduto = idProduto;
        this.nomeProduto = nomeProduto;
        this.valorProduto = valorProduto;
        this.imagemProduto = imagemProduto;
        this.dsProduto = dsProduto;
    }

    public Long getIdProduto() {
        return idProduto;
    }


    public String getNomeProduto() {
        return nomeProduto;
    }

    public void setNomeProduto(String nomeProduto) {
        this.nomeProduto = nomeProduto;
    }

    public Double getValorProduto() {
        return valorProduto;
    }

    public void setValorProduto(Double valorProduto) {
        this.valorProduto = valorProduto;
    }

    public String getImagemProduto() {
        return imagemProduto;
    }

    public void setImagemProduto(String imagemProduto) {
        this.imagemProduto = imagemProduto;
    }

    public String getDsProduto() {
        return dsProduto;
    }

    public void setDsProduto(String dsProduto) {
        this.dsProduto = dsProduto;
    }
}
