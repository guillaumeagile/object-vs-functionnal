package org.example;

import static org.assertj.core.api.Assertions.assertThat;

import org.example.calisthenicOOP.EmployeeValidator;
import org.junit.jupiter.api.Test;

public class FirstDesign_EmployeeBusinessRuleTest {

	// https://joel-costigliola.github.io/assertj/assertj-core-features-highlight.html
	@Test
	void CanWeConstructAnObjectThatIsInvalid() {
		var sut = new Employee("", "Cassaigne", 18);
		assertThat(sut).isNotNull();

		var validateur = new EmployeeValidator(sut);
		assertThat( validateur.validate()).isFalse();
	}

	@Test
	void CanWeConstructAnObjectThatIsValid() {
		var sut = new Employee("Anthony", "Cassaigne", 18);

		var validateur = new EmployeeValidator(sut);
		assertThat( validateur.validate()).isTrue();
	}

	@Test
	void EmployeeToString() {
		var sut = new Employee("Anthony", "Cassaigne", 18);
		assertThat( sut.toString()).isEqualTo("Welcome {firstName='Anthony', lastName='Cassaigne'}");
	}

	@Test
	void EmployeeHascode() {
		var sut = new Employee("Anthony", "Cassaigne", 18);
		var sut2 = new Employee("Anthony", "Cassaigne", 18);
		assertThat( sut.hashCode()).isEqualTo(sut2.hashCode());
	}

	@Test
	void EmployeeEquality() {
		var sut = new Employee("Anthony", "Cassaigne", 18);
		var sut2 = new Employee("Anthony", "Cassaigne", 18);
		assertThat( sut).isEqualTo(sut2);
	}

	@Test
	void EmployeeNonEquality() {
		var sut = new Employee("Anthony", "Cassaigne", 18);
		var sut2 = new Employee("Anthony", "Ca", 18);
		assertThat( sut).isNotEqualTo(sut2);
	}


	@Test
	void RuleValidEmployee() {
		var sut = new Employee("Gaston", "Lagaffe", 18);

		var validator = new EmployeeValidator(sut);
		assertThat( validator.validate()).isTrue();
	}



	@Test
	void SecondRule_Invalid() {
		var sut = new Employee("Anthony", "", 18);

		var validateur = new EmployeeValidator(sut);
		assertThat( validateur.validate()).isFalse();
	}

	@Test
	void SecondRuleNull_Invalid() {
		var sut = new Employee("Anthony", null, 18);

		var validateur = new EmployeeValidator(sut);
		assertThat( validateur.validate()).isFalse();
	}

	@Test
	void FirstNameINvalidWrongCaracter() {
		var sut = new Employee("A#thony", "Cass", 18);

		var validateur = new EmployeeValidator(sut);
		assertThat( validateur.validate()).isFalse();
	}

	@Test
	void LastNameINvalidWrongCaracter() {
		var sut = new Employee("Anthony", "C1ss", 18);

		var validateur = new EmployeeValidator(sut);
		assertThat( validateur.validate()).isFalse();
	}
	// TODO: connaitre la liste des raisons pour lesquelles on est invalie


	// -> primitive obsession DEBUT
	@Test
	void ProperNameShouldBeValid(){
		var sut = new ProperName("Anthony");
		assertThat( sut.validate()).isTrue();
	}
	@Test
	void ProperNameShouldBeInValid(){
		var sut = new ProperName("Ant-hony");
		assertThat( sut.validate()).isFalse();
	}
// -> primitive obsession FIN


	// TODO: connaitre la liste des raisons pour lesquelles on est invalie





}
