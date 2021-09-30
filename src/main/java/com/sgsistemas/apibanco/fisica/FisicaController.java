package com.sgsistemas.apibanco.fisica;

import com.sgsistemas.apibanco.registro.Registro;
import com.sgsistemas.apibanco.registro.RegistroService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/fisica")
public class FisicaController {
    @Autowired
    FisicaService fisicaService;
    @Autowired
    RegistroService registroService;


    @PostMapping
    public void cadastrarContaFisica(@RequestBody Fisica fisica) throws Exception {
        fisicaService.registrar(fisica);
    }
    @PutMapping("/{id}/deposito/{valor}")
    public void realizarDeposito(@PathVariable Long id, @PathVariable double valor){
        fisicaService.deposito(id, valor);
    }
    @GetMapping("/registros/{id_conta}")
    public List<Registro> buscarRegistros(@PathVariable Long id_conta){
        return fisicaService.getRegistrosById(id_conta);
    }



    @PutMapping("/{id}/debitar/{valor}")
    public void realizarDebito(@PathVariable Long id, @PathVariable double valor){
        fisicaService.debito(id, valor);
    }
    @PutMapping("/{id}/saque/{valor}")
    public void saque(@PathVariable Long id, @PathVariable double valor){
        fisicaService.saque(id, valor);
    }
    @PutMapping("/{id_conta_origem}/transferencia/{id_conta_destino}/{valor}")
    public void transferencia(@PathVariable Long id_conta_origem, @PathVariable Long id_conta_destino, @PathVariable double valor ){
        fisicaService.transferir(id_conta_origem, id_conta_destino, valor);
    }

    @GetMapping
    public List<Fisica> listarTodos(){
        return fisicaService.listarTodos();
    }

    @GetMapping("{id}")
    public Fisica encontrarFisica(@PathVariable Long id){
        return fisicaService.encontrarPeloId(id);
    }





}
