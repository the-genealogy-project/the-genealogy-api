package org.thegenealogyproject.api.person;

import org.springframework.web.multipart.MultipartFile;

import java.util.UUID;

public interface MultipartFileToCreatePhotoDtoMapper<Dto> {
    Dto toDto(UUID id, MultipartFile file);
}
