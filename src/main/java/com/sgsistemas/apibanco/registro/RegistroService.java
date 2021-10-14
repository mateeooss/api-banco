package com.sgsistemas.apibanco.registro;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class RegistroService {
    @Autowired
    RegistroRepository registroRepository;

    public void registrarRegistro(Registro registro){
        registroRepository.save(registro);
    }

    public List<Registro> encontrarTodos(){
        return registroRepository.findAll();
    }

    public List<Registro> listarCreditosPendentes(Long id){
        return registroRepository.listarCreditosPendentes(id);
    }

}
