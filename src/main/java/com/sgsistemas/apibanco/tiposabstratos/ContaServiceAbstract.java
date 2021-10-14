package com.sgsistemas.apibanco.tiposabstratos;

import com.sgsistemas.apibanco.pessoa.PessoaRepository;
import com.sgsistemas.apibanco.registro.Registro;
import com.sgsistemas.apibanco.registro.RegistroService;
import com.sgsistemas.apibanco.registro.TipoMov;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Calendar;
import java.util.List;

public abstract class ContaServiceAbstract<CONTA extends ContaBase, REPO extends JpaRepository<CONTA, Long>>{
    @Autowired
    REPO repo;
    @Autowired
    PessoaRepository pessoaRepository;
    @Autowired
    RegistroService registroService;

    public void deposito(Long id, double valor) {
        CONTA conta = repo.getById(id);

        if (conta.getCredito() < 500) {
            //gerando os juros
            List<Registro> registrosPendentes = registroService.listarCreditosPendentes(conta.getId());
            for (Registro registro : registrosPendentes) {
                registro.setJuros(registro.gerarJuros());
                conta.setJurosDaConta(conta.getJurosDaConta()+registro.gerarJuros());
                registro.setDataDeGeracaoDeJuros(Calendar.getInstance().getTime());
            }

            if (valor > ((500 - conta.getCredito())+conta.getJurosDaConta())) {
                for (Registro registro : registrosPendentes) {
                    registro.quitarJuros();
                    registro.setSituacao(true);
                    registroService.registrarRegistro(registro);
                }
//-------------------------------------------------------------------------//
                  double restante = valor - (500 - conta.getCredito()+conta.getJurosDaConta());
                  conta.setSaldoPositivo(restante);
                  conta.setCredito(500);
            }else {
                for (Registro registro : registrosPendentes){
                    if(valor >= (registro.getMovimentacao()-registro.getValorPago()+registro.getJuros())) {
                        registro.setSituacao(true);
                        valor = valor - (registro.getValorPendente());
                        registro.setValorPago(registro.getValorPendente());

                        conta.setCredito(conta.getCredito()+registro.getMovimentacao());
                        if(registro.equals(registrosPendentes.get(registrosPendentes.size()-1)))conta.setSaldoPositivo(valor);
                    }else{
                        registro.setValorPago(valor);
                        conta.setCredito(conta.getCredito()+valor);
                        break;
                    }
                }
       //        conta.setCredito(conta.getCredito() + valor);
            }
            repo.save(conta);
        } else {
            //  System.out.println(conta.getCredito());
            Registro registro = new Registro(TipoMov.DEPOSITO, valor, Calendar.getInstance().getTime());
            registroService.registrarRegistro(registro);
            conta.setRegistro(registro);
            conta.setSaldoPositivo(valor);
            repo.save(conta);
        }
    }
    public void saque(Long id, double valor) {
        CONTA conta = repo.getById(id);
        //caso o valor do saque seja maior do que o dispoivel em conta
        if(valor > conta.getSaldo()) {

            double debitoEmCredito = valor - conta.getSaldo();
            if(debitoEmCredito > conta.getCredito()) throw new RuntimeException("valor de credito insuficiente");
            conta.setSaldo(0);
            conta.setCredito(conta.getCredito()-debitoEmCredito);
            Registro registro = new Registro(TipoMov.CREDITO, debitoEmCredito, Calendar.getInstance().getTime());
            registro.setSituacao(false);
            conta.setRegistro(registro);
            repo.save(conta);
        }else {
            //throw new RuntimeException("valor de saque é maior do que o disponivel em conta");
            Registro registro = new Registro(TipoMov.SAQUE, valor, Calendar.getInstance().getTime());
            registroService.registrarRegistro(registro);
            conta.setRegistro(registro);

            conta.setSaldoNegativo(valor);
            repo.save(conta);
        }
    }

    public abstract void registrar(CONTA conta);

    public abstract List<CONTA> listarTodos();

    public abstract Boolean verificarExistencia(Long id);

    public String gerarExtrato(Long id_conta){
        CONTA conta = repo.getById(id_conta);
        return "NOME : "+conta.getPessoa().getNome()
                +"\nCPF: "+conta.getPessoa().getCpf()+
                "\n-------------------------------------------\n"+
                conta.getRegistros();
    }


}
