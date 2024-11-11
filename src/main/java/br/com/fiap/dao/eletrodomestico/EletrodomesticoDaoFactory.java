package br.com.fiap.dao.eletrodomestico;

public final class EletrodomesticoDaoFactory {
    private EletrodomesticoDaoFactory() {
    }

    public static DaoEletrodomestico create() {
        return new DaoEletrodomesticoImpl();
    }
}
