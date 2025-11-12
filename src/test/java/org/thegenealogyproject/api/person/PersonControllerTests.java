package org.thegenealogyproject.api.person;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import java.time.LocalDate;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.equalTo;
import static org.hamcrest.Matchers.is;
import static org.hamcrest.Matchers.not;
import static org.hamcrest.Matchers.nullValue;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.when;
import static org.thegenealogyproject.api.person.PersonTestConstants.PERSON_ID;
import static org.thegenealogyproject.api.person.PersonTestObject.person2;

@ExtendWith(MockitoExtension.class)
public class PersonControllerTests {

    @Mock
    private PersonQueryService personQueryService;

    @InjectMocks
    private PersonController personController;

    @Test
    public void personTest() {
        when(personQueryService.getPerson(any())).thenReturn(person2());

        var result = personController.person(PERSON_ID);

        assertThat(result.getId(), not(nullValue()));
        assertThat(result.getFirstName(), equalTo("FirstName2"));
        assertThat(result.getMiddleName(), equalTo("MiddleName2"));
        assertThat(result.getLastName(), equalTo("LastName2"));
        assertThat(result.getPlaceOfBirth(), equalTo("Los Angeles"));
        assertThat(result.getDateOfBirth(), equalTo(LocalDate.of(1994, 3, 27)));
        assertThat(result.getPlaceOfDeath(), is(nullValue()));
        assertThat(result.getDateOfDeath(), is(nullValue()));
    }
}
