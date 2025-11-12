package org.thegenealogyproject.api.person;

import org.junit.jupiter.api.Named;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.stream.Stream;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.equalTo;
import static org.thegenealogyproject.api.person.PersonTestObject.person1;
import static org.thegenealogyproject.api.person.PersonTestObject.person2;

public class PersonTests {

    static Stream<Arguments> peopleParams() {
        return Stream.of(
                Arguments.of(Named.of("person1", person1()), 31),
                Arguments.of(Named.of("person1", person2()), 31)
        );
    }

    @ParameterizedTest(name = "{index} => {0}")
    @MethodSource("peopleParams")
    public void calculateAgeTest(Person person, int expectedAge) {
        var result = person.calculateAge();

        assertThat(result, equalTo(expectedAge));
    }
}
