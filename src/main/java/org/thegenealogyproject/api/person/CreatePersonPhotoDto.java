package org.thegenealogyproject.api.person;

import java.util.UUID;

public class CreatePersonPhotoDto extends CreatePhotoDto {
    private final UUID personId;

    public CreatePersonPhotoDto(
            UUID personId,
            boolean isEmpty,
            String originalFilename,
            Long size,
            String contentType,
            byte[] inputStreamBytes
    ) {
        super(isEmpty, originalFilename, size, contentType, inputStreamBytes);
        this.personId = personId;
    }

    @Override
    public UUID getEntityId() {
        return personId;
    }
}
