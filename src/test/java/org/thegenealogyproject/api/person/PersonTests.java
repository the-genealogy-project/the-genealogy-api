package org.thegenealogyproject.api.person;

import org.junit.jupiter.api.Test;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.equalTo;
import static org.thegenealogyproject.api.person.PersonTestObject.person;

public class PersonTests {

    @Test
    public void calculateAgeTest() {
        var result = person().calculateAge();

        assertThat(result, equalTo(31));
    }
}
