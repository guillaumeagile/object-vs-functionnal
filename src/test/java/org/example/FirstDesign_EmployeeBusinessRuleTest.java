package org.example;

import static org.assertj.core.api.Assertions.assertThat;

import org.junit.jupiter.api.Test;

public class FirstDesign_EmployeeBusinessRuleTest {

	// https://joel-costigliola.github.io/assertj/assertj-core-features-highlight.html
	@Test
	void CanWeConstructAnObjectThatIsInvalid() {
		var sut = new Employee("", "Cassaigne", 18);
		assertThat(sut).isNotNull();

		var validateur = new EmployeeValidatorSimple(sut);
		assertThat( validateur.validate()).isFalse();
	}

	@Test
	void CanWeConstructAnObjectThatIsValid() {
		var sut = new Employee("Anthony", "Cassaigne", 18);

		var validateur = new EmployeeValidatorSimple(sut);
		assertThat( validateur.validate()).isTrue();
	}

	@Test
	void SecondRule_Invalid() {
		var sut = new Employee("Anthony", "", 18);

		var validateur = new EmployeeValidatorSimple(sut);
		assertThat( validateur.validate()).isFalse();
	}

	@Test
	void FirstNameINvalidWrongCaracter() {
		var sut = new Employee("A#thony", "Cass", 18);

		var validateur = new EmployeeValidatorSimple(sut);
		assertThat( validateur.validate()).isFalse();
	}

	@Test
	void LastNameINvalidWrongCaracter() {
		var sut = new Employee("Anthony", "C1ss", 18);

		var validateur = new EmployeeValidatorSimple(sut);
		assertThat( validateur.validate()).isFalse();
	}

}
