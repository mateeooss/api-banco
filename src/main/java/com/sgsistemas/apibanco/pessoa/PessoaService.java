package com.sgsistemas.apibanco.pessoa;

import com.sgsistemas.apibanco.fisica.Fisica;
import com.sgsistemas.apibanco.fisica.FisicaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class PessoaService {
    @Autowired
    PessoaRepository pessoaRepository;

    public Pessoa encontrarPeloId(Long id) {
        return pessoaRepository.getById(id);
    }

    public void registrar(Pessoa pessoa){
        pessoaRepository.save(pessoa);
    }

    public List<Pessoa> listarTodos(){
       return pessoaRepository.findAll();
    }


}
