package org.thegenealogyproject.api.person;

import java.util.UUID;

public class PersonNotFoundException extends RuntimeException {
    public PersonNotFoundException(UUID id) {
        super(String.format("Person with the given ID: %s was not found.", id));
    }
}
