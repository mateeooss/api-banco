package com.sgsistemas.apibanco.juridica;

import com.sgsistemas.apibanco.fisica.FisicaService;
import com.sgsistemas.apibanco.tiposabstratos.ContaControllerAbstract;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(value = "/juridica")
public class JuridicaController extends ContaControllerAbstract<Juridica, FisicaService> {
    JuridicaService juridicaService;

    @Override
    public List<Juridica> listarTodos() {
        return juridicaService.listarTodos();
    }

//    @GetMapping("{id}")
//    public Juridica encontrarFisica(@PathVariable Long id){
//        return juridicaService.encontrarPeloId(id);
//    }
//
//





}
