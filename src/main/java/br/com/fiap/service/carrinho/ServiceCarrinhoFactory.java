package br.com.fiap.service.carrinho;

public final class ServiceCarrinhoFactory {

    private ServiceCarrinhoFactory() {

    }

    public static ServiceCarrinho create() {
        return new ServiceCarrinhoImpl();
    }
}
