package com.sgsistemas.apibanco.registro;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class RegistroService {
    @Autowired
    RegistroRepository registroRepository;

    public void registrarRegistro(Registro registro){
        registroRepository.save(registro);
    }





}
