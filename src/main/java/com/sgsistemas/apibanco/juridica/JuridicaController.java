package com.sgsistemas.apibanco.juridica;

import com.sgsistemas.apibanco.fisica.Fisica;
import com.sgsistemas.apibanco.registro.RegistroService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(value = "/juridica")
public class JuridicaController {
   @Autowired
    JuridicaService juridicaService;
    @Autowired
    RegistroService registroService;

    @PostMapping
    public void cadastrarContaFisica(@RequestBody Juridica juridica) throws Exception {
        juridicaService.registrar(juridica);
    }

    @GetMapping
    public List<Juridica> listarTodos(){
        return juridicaService.listarTodos();
    }

//    @GetMapping("{id}")
//    public Juridica encontrarFisica(@PathVariable Long id){
//        return juridicaService.encontrarPeloId(id);
//    }
//
//





}
