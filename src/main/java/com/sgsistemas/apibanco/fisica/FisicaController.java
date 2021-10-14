package com.sgsistemas.apibanco.fisica;

import com.sgsistemas.apibanco.registro.Registro;
import com.sgsistemas.apibanco.registro.RegistroService;
import com.sgsistemas.apibanco.tiposabstratos.ContaControllerAbstract;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/fisica")
public class FisicaController extends ContaControllerAbstract<Fisica, FisicaService> {

}
