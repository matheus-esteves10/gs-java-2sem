package br.com.fiap.model;

import java.util.List;

public class Compra {

    private Long idCompra;
    private Double valorCompra;
    private Boolean isPago;
    private List<CompraProduto> produtos;
    private Long idUsuario;

    public Compra() {
    }

    public Compra(Long idCompra, Double valorCompra, Boolean isPago, Long idUsuario) {
        this.idCompra = idCompra;
        this.valorCompra = valorCompra;
        this.isPago = isPago;
        this.idUsuario = idUsuario;
    }

    public Long getIdCompra() {
        return idCompra;
    }


    public Double getValorCompra() {
        return valorCompra;
    }

    public void setValorCompra(Double valorCompra) {
        this.valorCompra = valorCompra;
    }

    public Boolean getPago() {
        return isPago;
    }

    public void setPago(Boolean pago) {
        isPago = pago;
    }

    public void setIdCompra(Long idCompra) {
        this.idCompra = idCompra;
    }

    public Long getIdUsuario() {
        return idUsuario;
    }

    public void setIdUsuario(Long idUsuario) {
        this.idUsuario = idUsuario;
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

    public Double calcularValorTotal() {
        return produtos.stream()
                .mapToDouble(cp -> cp.getProduto().getValorProduto() * cp.getQuantidade())
                .sum();
    }

    public boolean pago(boolean isPago){
        if (isPago){
            return true;
        } else {
            return false;
        }
    }
}
