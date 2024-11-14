package br.com.fiap.model;

import java.util.List;

public class Compra {

    private Long idCompra;
    private Double valorCompra;
    private Boolean isPago;
    private int numeroParcelas;
    private Long idUsuario;

    public Compra() {
    }

    public Compra(Long idCompra, Double valorCompra, Boolean isPago, int numeroParcelas, Long idUsuario) {
        this.idCompra = idCompra;
        this.valorCompra = valorCompra;
        this.isPago = isPago;
        this.numeroParcelas = numeroParcelas;
        this.idUsuario = idUsuario;
    }

    public Long getIdCompra() {
        return idCompra;
    }

    public void setIdCompra(Long idCompra) {
        this.idCompra = idCompra;
    }

    public Double getValorCompra() {
        return valorCompra;
    }


    public Boolean getPago() {
        return isPago;
    }

    public void setPago(Boolean pago) {
        this.isPago = pago;
    }

    public int getNumeroParcelas() {
        return numeroParcelas;
    }

    public void setNumeroParcelas(int numeroParcelas) {
        this.numeroParcelas = numeroParcelas;
    }

    public Long getIdUsuario() {
        return idUsuario;
    }

    public void setIdUsuario(Long idUsuario) {
        this.idUsuario = idUsuario;
    }

    public boolean pago(boolean isPago){
        if (isPago){
            return true;
        } else {
            return false;
        }
    }
}
