package com.gadgetszan.mycattery;

import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

import static org.assertj.core.api.Assertions.assertThat;

@SpringBootTest
class MyCatteryApplicationTests {
	Calculator underTest = new Calculator();

	class Calculator{
		int add(int a,int b){
			return a+b;
		}
	}

	@Test
	void itShouldAddTwoNumbers() {
		//given
		int numberOne = 20;
		int numberTwo = 30;
		//when
		int result = underTest.add(numberOne,numberTwo);
		//then
		assertThat(result).isEqualTo(50);
	}

}
