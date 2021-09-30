package com.sgsistemas.apibanco.poupança;

import com.sgsistemas.apibanco.pessoa.PessoaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class PoupançaService{
    @Autowired
    poupançaRepository poupançaRepository;
    @Autowired
    PessoaService pessoaService;

    public void registrar(Poupança poupança) throws Exception {
        if(verificarExistencia(poupança.getPessoa().getId()) == true) throw new Exception("essa pessoa ja tem uma conta do tipo poupança");
        poupançaRepository.save(poupança);
    }

    public List<Poupança> listarTodos() {
        return poupançaRepository.findAll();
    }


    public Boolean verificarExistencia(Long id){
        Poupança poupança = poupançaRepository.getById(id);
        System.out.println(poupançaRepository.findPessoaByid(id));
        if(poupançaRepository.findPessoaByid(id).equals(Optional.empty())) return false;
        return true;

    }
    public Poupança encontrarPeloId(Long id) {
        return poupançaRepository.getById(id);
    }
}
