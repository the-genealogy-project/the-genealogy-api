package org.thegenealogyproject.api.person;

import java.time.LocalDate;
import java.util.UUID;

public final class PersonTestObject {
    public static Person person1() {
        return buildPerson(
                "FirstName1",
                "MiddleName1",
                "LastName1",
                "New York",
                LocalDate.of(1994, 3, 27),
                "New York",
                LocalDate.of(2025, 11, 12)
        );
    }

    public static Person person2() {
        return buildPerson(
                "FirstName2",
                "MiddleName2",
                "LastName2",
                "Los Angeles",
                LocalDate.of(1994, 3, 27),
                null,
                null
        );
    }

    private static Person buildPerson(
            String firstName,
            String middleName,
            String lastName,
            String placeOfBirth,
            LocalDate dateOfBirth,
            String placeOfDeath,
            LocalDate dateOfDeath
    ) {
        return new Person(
                UUID.randomUUID(),
                firstName,
                middleName,
                lastName,
                placeOfBirth,
                dateOfBirth,
                placeOfDeath,
                dateOfDeath,
                null,
                null,
                null,
                null
        );
    }
}
