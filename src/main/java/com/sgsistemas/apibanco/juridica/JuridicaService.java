package com.sgsistemas.apibanco.juridica;

import com.sgsistemas.apibanco.pessoa.PessoaService;
import com.sgsistemas.apibanco.tiposabstratos.ContaServiceAbstract;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class JuridicaService extends ContaServiceAbstract<Juridica, JuridicaRepository> {
    JuridicaRepository juridicaRepository;
    @Override
    public List<Juridica> listarTodos() {
        return juridicaRepository.findAll();
    }
//    @Autowired
//    JuridicaRepository juridicaRepository;
//    @Autowired
//    PessoaService pessoaService;
//
//    public void registrar(Juridica juridica) throws Exception {
//       if(verificarExistencia(juridica.getPessoa().getId()) == true) throw new Exception("essa pessoa ja tem uma conta do tipo fisica");
//        juridicaRepository.save(juridica);
//    }
//
//    private boolean verificarExistencia(Long id) {
//        Juridica juridica = juridicaRepository.getById(id);
//        System.out.println(juridicaRepository.findPessoaByid(id));
//        if(juridicaRepository.findPessoaByid(id).equals(Optional.empty())) return false;
//        return true;
//    }
//
//    public List<Juridica> listarTodos() {
//        return juridicaRepository.findAll();
//    }
//
//    public Juridica encontrarPeloId(Long id) {
//        return juridicaRepository.getById(id);
//    }

}
