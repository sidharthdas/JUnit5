package com.junitconcepts;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Nested;
import org.junit.jupiter.api.RepeatedTest;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestInstance;
import org.junit.jupiter.api.condition.EnabledOnOs;
import org.junit.jupiter.api.condition.OS;

@TestInstance(TestInstance.Lifecycle.PER_CLASS) // One instance will be created
class CalculationUtilTest {

	CalculationUtil calculationUtil;

	@BeforeEach
	void init() {
		System.out.println("Creating instances");
		calculationUtil = new CalculationUtil();
	}

	@Nested
	class AddTest {

		@Test

		@DisplayName("Testing positive values add method")
		void addTest() {
			assertEquals(2, calculationUtil.add(1, 1));
		}

		@Test

		@DisplayName("Testing negative values add method")
		void addTest2() {
			assertEquals(-2, calculationUtil.add(-1, -1));
		}

	}

	@Test

	@Disabled

	@DisplayName("Testing disabled annotation")
	void testMulDisabled() {
		assertEquals(1, calculationUtil.mul(1, 1));
	}

	@Test

	@DisplayName("Testing Enable on annotation")

	@EnabledOnOs(OS.MAC)
	void testMulEnabledOn() {
		assertEquals(1, calculationUtil.mul(1, 1));
	}

	@Test

	@DisplayName("Testing Div method")

	@RepeatedTest(5)
	void testDiv() {
		assertThrows(ArithmeticException.class, () -> calculationUtil.div(10, 0), "Should throw Arithmatic exception");
	}

	@Test

	@DisplayName("Testing assertAll on multiply method")
	void mulTestAll() {
		Assertions.assertAll(() -> assertEquals(200, calculationUtil.mul(10, 20)),
				() -> assertEquals(300, calculationUtil.mul(10, 30)), () -> assertEquals(0, calculationUtil.mul(10, 0)),
				() -> assertEquals(99, calculationUtil.mul(1, 99))

		);

	}
	
	@AfterEach
	void cleanUp() {
		System.out.println("Cleaning up . . . . ");
	}

}
