package com.sgsistemas.apibanco.juridica;

import com.sgsistemas.apibanco.fisica.Fisica;
import com.sgsistemas.apibanco.pessoa.PessoaService;
import com.sgsistemas.apibanco.registro.Registro;
import com.sgsistemas.apibanco.registro.RegistroService;
import com.sgsistemas.apibanco.registro.TipoMov;
import com.sgsistemas.apibanco.tiposabstratos.ContaServiceAbstract;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Calendar;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class JuridicaService extends ContaServiceAbstract<Juridica, JuridicaRepository> {
    @Autowired
    JuridicaRepository juridicaRepository;
    @Autowired
    RegistroService registroService;

    @Override
    public void registrar(Juridica juridica) {
        if(verificarExistencia(juridica.getPessoa().getId()) == true) throw new RuntimeException("essa pessoa ja tem uma conta do tipo juridica");
        juridicaRepository.save(juridica);
    }

    @Override
    public List<Juridica> listarTodos() {
        return juridicaRepository.findAll();
    }

    @Override
    public Boolean verificarExistencia(Long id) {
        if(juridicaRepository.findAll().stream().filter(o -> o.getPessoa().getId() == id).count() > 0)return true;
        return false;
    }

}
