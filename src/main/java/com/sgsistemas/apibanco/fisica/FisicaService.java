package com.sgsistemas.apibanco.fisica;

import com.sgsistemas.apibanco.pessoa.PessoaService;
import com.sgsistemas.apibanco.registro.Registro;
import com.sgsistemas.apibanco.registro.RegistroService;
import com.sgsistemas.apibanco.tiposabstratos.ContaServiceAbstract;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class FisicaService  extends ContaServiceAbstract<Fisica, FisicaRepository> {
    FisicaRepository fisicaRepository;
    @Override
    public List<Fisica> listarTodos() {
        return fisicaRepository.findAll();
    }
//   @Autowired
//   FisicaRepository fisicaRepository;
//    @Autowired
//    PessoaService pessoaService;
//    @Autowired
//    RegistroService registroService;
//
//    public void registrar(Fisica fisica) throws Exception {
//        if(verificarExistencia(fisica.getPessoa().getId()) == true) throw new Exception("essa pessoa ja tem uma conta do tipo fisica");
//        fisicaRepository.save(fisica);
//    }
//
//    public List<Fisica> listarTodos() {
//       return fisicaRepository.findAll();
//    }
//
//
//    public Boolean verificarExistencia(Long id) {
//        Fisica fisica = fisicaRepository.getById(id);
//        System.out.println(fisicaRepository.findPessoaByid(id));
//        if (fisicaRepository.findPessoaByid(id).equals(Optional.empty())) return false;
//        return true;
//    }
//
//    public Fisica encontrarPeloId(Long id) {
//        return fisicaRepository.getById(id);
//    }
//
//    public void deposito(Long id, double valor) {
//        Fisica fisica =fisicaRepository.getById(id);
//
//        Registro registro = new Registro(Registro.TipoDemovimentacao.DEPOSITO, valor);
//        registroService.registrarRegistro(registro);
//
//        fisica.setRegistros(registro);
//        fisica.setSaldoPositivo(valor);
//        fisicaRepository.save(fisica);
//    }
//
//    public void debito(Long id, double valor) {
//        Fisica fisica =fisicaRepository.getById(id);
//        fisica.setSaldoNegativo(valor);
//        fisicaRepository.save(fisica);
//    }
//
//    public void saque(Long id, double valor) {
//        Fisica fisica = fisicaRepository.getById(id);
//        if(fisica.getSaldo() < valor) throw new RuntimeException("valor de saque é maior do que o disponivel em conta");
//
//        Registro registro = new Registro(Registro.TipoDemovimentacao.SAQUE, valor);
//        registroService.registrarRegistro(registro);
//        fisica.setRegistros(registro);
//
//        fisica.setSaldoNegativo(valor);
//        fisicaRepository.save(fisica);
//
//
//    }
//    public void transferir(Long id_conta_origem, Long id_conta_destino, double valor) {
//        Fisica conta_origem = fisicaRepository.getById(id_conta_origem);
//        Fisica conta_destino = fisicaRepository.getById(id_conta_destino);
//        if(conta_origem.getSaldo() < valor) throw new RuntimeException("valor de saque é maior do que o disponivel em conta");
//
//        Registro registro = new Registro(Registro.TipoDemovimentacao.TRANSFERENCIA, valor, conta_destino);
//        registroService.registrarRegistro(registro);
//        conta_origem.setRegistros(registro);
//
//        conta_origem.setSaldoNegativo(valor);
//        conta_destino.setSaldoPositivo(valor);
//        fisicaRepository.save(conta_destino);
//        fisicaRepository.save(conta_origem);
//    }
//
//    public List<Registro> getRegistrosById(Long id_conta) {
//       Fisica fisica = fisicaRepository.getById(id_conta);
//       return fisica.getRegistros();
//
//    }
}
