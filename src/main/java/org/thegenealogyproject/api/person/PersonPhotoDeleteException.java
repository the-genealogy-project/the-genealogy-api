package org.thegenealogyproject.api.person;

import java.util.UUID;

public class PersonPhotoDeleteException extends RuntimeException {
    public PersonPhotoDeleteException(UUID id) {
        super(String.format("Fénykép törlése az alábbi személynél: #%s sikertelen volt", id));
    }
}
