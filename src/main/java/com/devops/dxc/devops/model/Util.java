package com.devops.dxc.devops.model;

import com.devops.dxc.devops.api.UFClient;
import com.devops.dxc.devops.api.dto.UFClientResponse;

import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

@Service
@Slf4j
public class Util {

    private static transient UFClient ufClient;

    public Util(UFClient ufClient) {
        Util.ufClient = ufClient;
    }

    /**
     * Método para cacular el 10% del ahorro en la AFP.  Las reglas de negocio se pueden conocer en
     * https://www.previsionsocial.gob.cl/sps/preguntas-frecuentes-nuevo-retiro-seguro-10/
     *
     * @param ahorro
     * @return
     */
    public static int getDxc(int ahorro) {

        int uf = getUf();
        if (((ahorro * 0.1) / uf) > 150) {
            return (int) (150 * uf);
        } else if ((ahorro * 0.1) <= 1000000 && ahorro >= 1000000) {
            return (int) 1000000;
        } else if (ahorro <= 1000000) {
            return (int) ahorro;
        } else {
            return (int) (ahorro * 0.1);
        }
    }

    /**
     * Método para cacular el impuesto. Las reglas de negocio se pueden conocer en
     * https://eltipografo.cl/2020/12/te-explicamos-como-calcular-si-debes-pagar-impuestos-por-el-segundo-retiro-del-10
     *
     * @param retiro
     * @param sueldo
     * @return
     */
    public static double getImpuesto(int sueldo, int retiro) {
        double impuesto = 0;
        if ((sueldo >= 1500000) && (sueldo <= 2500000)) {
            impuesto = retiro * 0.08;
            return impuesto;
        } else if ((sueldo >= 2500001) && (sueldo <= 3500000)) {
            impuesto = retiro * 0.135;
            return impuesto;
        } else if ((sueldo >= 3500001) && (sueldo <= 4460000)) {
            impuesto = retiro * 0.23;
            return impuesto;
        } else if ((sueldo >= 4460001) && (sueldo <= 5950000)) {
            impuesto = retiro * 0.304;
            return impuesto;
        } else if ((sueldo >= 5950001)) {
            impuesto = retiro * 0.35;
            return impuesto;
        }
        return impuesto;
    }

    public static int getSaldoRestante(int ahorro) {
        return ahorro - getDxc(ahorro);
    }

    /**
     * Método que retorna el valor de la UF.  Este método debe ser refactorizado por una integración a un servicio
     * que retorne la UF en tiempo real.  Por ejemplo mindicador.cl
     *
     * @return
     */
    public static int getUf() {
        UFClientResponse response = ufClient.getUF();
        return response.getSerie().get(0).getValor().intValue();
    }

}
