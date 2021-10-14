package com.sgsistemas.apibanco.poupança;

import com.sgsistemas.apibanco.pessoa.PessoaService;
import com.sgsistemas.apibanco.tiposabstratos.ContaServiceAbstract;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class PoupançaService extends ContaServiceAbstract<Poupança, PoupançaRepository> {
    @Autowired
    PoupançaRepository poupançaRepository;
    @Autowired
    PessoaService pessoaService;

    @Override
   public void registrar(Poupança poupança) {
//        if(verificarExistencia(poupança.getPessoa().getId()) == true) throw new Exception("essa pessoa ja tem uma conta do tipo fisica");
//        repo.save(conta);
   }

    @Override
    public List<Poupança> listarTodos() {
        return null;
    }

    @Override
    public Boolean verificarExistencia(Long id) {
        return null;
    }

}
