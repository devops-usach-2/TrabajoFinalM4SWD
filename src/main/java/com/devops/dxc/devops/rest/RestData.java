package com.devops.dxc.devops.rest;

import com.devops.dxc.devops.model.Dxc;
import com.devops.dxc.devops.model.Util;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;

import java.util.logging.Level;
import java.util.logging.Logger;

@RestController
@RequestMapping(path = "/rest/msdxc")
public class RestData {

    private final static Logger LOGGER = Logger.getLogger("devops.subnivel.Control");

    @GetMapping(path = "/dxc", produces = MediaType.APPLICATION_JSON_VALUE)
    public @ResponseBody int getData(@RequestParam(name = "sueldo") String sueldo, @RequestParam(name = "ahorro") String ahorro) {

        LOGGER.log(Level.INFO, "< Trabajo DevOps - DXC > <Consultado Diez por ciento>");

        return Util.getDxc(Integer.parseInt(ahorro));
    }

    @GetMapping(path = "/impuesto", produces = MediaType.APPLICATION_JSON_VALUE)
    public @ResponseBody double getImpuesto(@RequestParam(name = "sueldo") String sueldo, @RequestParam(name = "retiro") String retiro) {

        LOGGER.log(Level.INFO, "< Trabajo DevOps - DXC > <Consultado Diez por ciento>");

        return  Util.getImpuesto(Integer.parseInt(sueldo), Integer.parseInt(retiro));

    }

    @GetMapping(path = "/saldoRestante", produces = MediaType.APPLICATION_JSON_VALUE)
    public @ResponseBody double getSaldoRestante(@RequestParam(name = "ahorro") String ahorro) {

        LOGGER.log(Level.INFO, "< Trabajo DevOps - DXC > <Consultado Diez por ciento>");

        return  Util.getSaldoRestante(Integer.parseInt(ahorro));

    }






}