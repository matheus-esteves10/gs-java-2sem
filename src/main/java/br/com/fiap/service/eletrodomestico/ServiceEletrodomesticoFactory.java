package br.com.fiap.service.eletrodomestico;

public final class ServiceEletrodomesticoFactory {

    private ServiceEletrodomesticoFactory() {
    }

    public static ServiceEletrodomestico create() {
        return new ServiceEletrodomesticoImpl();
    }
}
