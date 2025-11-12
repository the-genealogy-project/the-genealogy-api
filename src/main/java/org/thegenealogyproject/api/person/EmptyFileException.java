package org.thegenealogyproject.api.person;

public class EmptyFileException extends RuntimeException {
    public EmptyFileException(String fileName) {
        super(String.format("Üres fájl: %s", fileName));
    }
}
