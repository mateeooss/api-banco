package com.sgsistemas.apibanco.juridica;

import com.sgsistemas.apibanco.fisica.Fisica;
import com.sgsistemas.apibanco.fisica.FisicaService;
import com.sgsistemas.apibanco.tiposabstratos.ContaControllerAbstract;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/juridica")
public class JuridicaController extends ContaControllerAbstract<Juridica, JuridicaService> {

}
