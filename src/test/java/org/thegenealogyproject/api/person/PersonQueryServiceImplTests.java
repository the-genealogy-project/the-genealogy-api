package org.thegenealogyproject.api.person;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import java.time.LocalDate;
import java.util.Optional;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.equalTo;
import static org.hamcrest.Matchers.not;
import static org.hamcrest.Matchers.nullValue;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.when;
import static org.thegenealogyproject.api.person.PersonTestConstants.PERSON_ID;
import static org.thegenealogyproject.api.person.PersonTestObject.person1;

@ExtendWith(MockitoExtension.class)
public class PersonQueryServiceImplTests {

    @Mock
    private PersonRepository personRepository;

    @InjectMocks
    private PersonQueryServiceImpl personQueryService;

    @Test
    public void getPersonTest_HappyPath() {
        when(personRepository.findById(any())).thenReturn(Optional.of(person1()));

        var result = personQueryService.getPerson(PERSON_ID);

        assertThat(result.getId(), not(nullValue()));
        assertThat(result.getFirstName(), equalTo("FirstName1"));
        assertThat(result.getMiddleName(), equalTo("MiddleName1"));
        assertThat(result.getLastName(), equalTo("LastName1"));
        assertThat(result.getPlaceOfBirth(), equalTo("New York"));
        assertThat(result.getDateOfBirth(), equalTo(LocalDate.of(1994, 3, 27)));
        assertThat(result.getPlaceOfDeath(), equalTo("New York"));
        assertThat(result.getDateOfDeath(), equalTo(LocalDate.of(2025, 11, 12)));
    }

    @Test
    public void getPersonTest_UnhappyPath_PersonNotFoundException() {
        when(personRepository.findById(any())).thenReturn(Optional.empty());

        var result = assertThrows(
                PersonNotFoundException.class,
                () -> personQueryService.getPerson(PERSON_ID)
        );

        assertThat(result.getMessage(), equalTo("Person with the given ID: 0203881f-4c90-4e73-8659-b93ac7ecb5eb was not found."));
    }
}
