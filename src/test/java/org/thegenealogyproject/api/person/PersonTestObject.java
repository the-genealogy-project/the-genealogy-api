package org.thegenealogyproject.api.person;

import java.time.LocalDate;
import java.util.UUID;

public final class PersonTestObject {
    public static Person person() {
        return new Person(
                UUID.randomUUID(),
                "John",
                null,
                "Doe",
                "New York",
                LocalDate.of(1994, 3, 27),
                "New York",
                LocalDate.of(2025, 11, 12),
                null,
                null,
                null,
                null
        );
    }
}
