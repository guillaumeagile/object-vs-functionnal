package org.example;

import static org.assertj.core.api.Assertions.assertThat;

import org.junit.jupiter.api.Test;

public class EmployeeBusinessRuleTest {

	
	@Test
	void FirstDesign_CanWeConstructAnObjectThatIsInvalid() {
		var sut = new Employee("", "Cassaigne", 18);
		assertThat(sut).isNotNull();

		var validateur = new EmployeeValidatorSimple(sut);
		assertThat( validateur.validate()).isFalse();
	}

	@Test
	void FirstDesign_CanWeConstructAnObjectThatIsValid() {
		var sut = new Employee("Anthony", "Cassaigne", 18);

		var validateur = new EmployeeValidatorSimple(sut);
		assertThat( validateur.validate()).isTrue();
	}

	@Test
	void FirstDesign_SecondRule_Invalid() {
		var sut = new Employee("Anthony", "", 18);

		var validateur = new EmployeeValidatorSimple(sut);
		assertThat( validateur.validate()).isFalse();
	}

}
