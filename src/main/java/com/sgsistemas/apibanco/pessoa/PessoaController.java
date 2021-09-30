package com.sgsistemas.apibanco.pessoa;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.xml.ws.Action;
import java.util.List;

@RestController
@RequestMapping("/pessoa")
public class PessoaController {
    @Autowired
    PessoaService pessoaService;

    @PostMapping
    public void registrar(@RequestBody Pessoa pessoa){
        pessoaService.registrar(pessoa);
    }

    @GetMapping
    public List<Pessoa> listarTodos(){
        return pessoaService.listarTodos();
    }

    @GetMapping("{id}")
    public Pessoa encontrarPeloId(@PathVariable Long id){
        return pessoaService.encontrarPeloId(id);
    }




}
