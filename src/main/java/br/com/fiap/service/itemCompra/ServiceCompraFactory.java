package br.com.fiap.service.itemCompra;

public final class ServiceCompraFactory {

    private ServiceCompraFactory() {

    }

    public static ServiceCompra create() {
        return new ServiceCompraImpl();
    }
}
