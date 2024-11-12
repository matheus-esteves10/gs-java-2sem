package br.com.fiap.dao.carrinho;

public final class DaoCarrinhoFactory {

    private DaoCarrinhoFactory() {
    }

    public static DaoCarrinho create() {
        return new DaoCarrinhoImpl();
    }
}
