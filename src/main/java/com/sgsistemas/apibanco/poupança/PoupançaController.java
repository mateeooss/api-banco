package com.sgsistemas.apibanco.poupança;
import com.sgsistemas.apibanco.fisica.Fisica;
import com.sgsistemas.apibanco.registro.RegistroService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
@RestController
@RequestMapping("/poupança")
public class poupançaController {
    @Autowired
    PoupançaService poupançaService;
    @Autowired
    RegistroService registroService;


    @PostMapping()
    public void cadastrar(Poupança poupança){

    }

    @GetMapping
    public List<Poupança> listarTodos(){
        return poupançaService.listarTodos();
    }

    @GetMapping("{id}")
    public Poupança encontrarFisica(@PathVariable Long id){
        return poupançaService.encontrarPeloId(id);
    }




}
