package br.com.fiap.service.eletrodomestico;

import br.com.fiap.exceptions.NotFoundException;
import br.com.fiap.model.Eletrodomestico;

public interface ServiceEletrodomestico {

    Eletrodomestico findByNome(String classificacao) throws NotFoundException;
}
