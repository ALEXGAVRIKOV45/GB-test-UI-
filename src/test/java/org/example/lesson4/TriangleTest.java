package org.example.lesson4;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

public class TriangleTest {

	@BeforeAll
	static void beforeAll() {
		System.out.println("Метод выполнится 1 раз перед тестами!");
	}

	@Test
	@DisplayName("Проверка формулы расчета 3 стороны")
	void givenSidesTriangleWhenCalcAreaThenArea() {
		double result = TriangleArea.CalcArea(3,4,5);
		Assertions.assertEquals(6,result);
	}

	@Test
	@DisplayName("Проверка формулы расчета 1 сторона = 0")
	void givenSidesTriangleWhenCalcAreaThenArea2() {
		double result = TriangleArea.CalcArea(0, 4, 5);
		Assertions.assertEquals(0, result);
	}

	@ParameterizedTest
	@DisplayName("Проверка формулы расчета")
	@CsvSource({"0,5,0,8", "6,3,4,5"})
	void givenSidesTriangleWhenCalcAreaThenArea3(double expectedResult, int a, int b, int c) {
		Assertions.assertEquals(expectedResult, TriangleArea.CalcArea(a, b, c));
	}



	}
