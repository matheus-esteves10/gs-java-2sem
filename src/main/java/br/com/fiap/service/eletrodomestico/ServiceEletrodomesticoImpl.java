package br.com.fiap.service.eletrodomestico;

import br.com.fiap.dao.eletrodomestico.DaoEletrodomestico;
import br.com.fiap.dao.eletrodomestico.EletrodomesticoDaoFactory;
import br.com.fiap.exceptions.NotFoundException;
import br.com.fiap.model.Eletrodomestico;

public class ServiceEletrodomesticoImpl implements ServiceEletrodomestico{

    private final DaoEletrodomestico dao = EletrodomesticoDaoFactory.create();
    @Override
    public Eletrodomestico findByNome(String classificacao) throws NotFoundException {
        return this.dao.readByNome(classificacao);
    }
}
