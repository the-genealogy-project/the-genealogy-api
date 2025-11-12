package org.thegenealogyproject.api.person;

import lombok.Getter;

import java.util.UUID;

@Getter
public class PersonPhotoDto extends PhotoDto {
    private final UUID personId;

    public PersonPhotoDto(UUID personId, byte[] photoBytes, String fileExtension) {
        super(photoBytes, fileExtension);
        this.personId = personId;
    }
}
