package br.com.fiap.dao.eletrodomestico;

import br.com.fiap.model.Eletrodomestico;

public interface DaoEletrodomestico {

    Eletrodomestico readByNome(String classificacao);

}
