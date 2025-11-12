package org.thegenealogyproject.api.person;

import java.util.UUID;

public class PersonDoesNotHaveAPhotoUploadedYetException extends RuntimeException {
    public PersonDoesNotHaveAPhotoUploadedYetException(UUID id) {
        super(String.format("Személy a következő azonosítóval: #%s még nem rendelkezik feltöltött fényképpel", id));
    }
}
