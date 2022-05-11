package com.devops.dxc.devops;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
class DevopsApplicationTests {

	@Test
	void getDxcTest() {
		Assertions.assertEquals(600000, Util.getDxc(600000));
		Assertions.assertEquals(1000000, Util.getDxc(1000000));
		Assertions.assertEquals(1000000, Util.getDxc(3000000));
		Assertions.assertEquals(1000000, Util.getDxc(9000000));
		Assertions.assertEquals(1200000, Util.getDxc(12000000));
		Assertions.assertEquals(4757700, Util.getDxc(50000000));
	}

	@Test
	void getImpuestoTest() {
		Assertions.assertEquals(8000, Util.getImpuesto(1600000, 100000));
		Assertions.assertEquals(0, Util.getImpuesto(1400000, 100000));
		Assertions.assertEquals(0, Util.getImpuesto(600000, 100000));		
	}

	@Test
	void getSaldoRestanteTest() {
		Assertions.assertEquals(4000000, Util.getSaldoRestante(5000000));
		Assertions.assertEquals(33300000, Util.getSaldoRestante(37000000));
	}

	@Test
	void getUfTest() {
		Assertions.assertEquals(31718, Util.getUf());
	}

}
