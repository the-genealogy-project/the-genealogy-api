package org.thegenealogyproject.api.person;

import lombok.RequiredArgsConstructor;

import java.io.IOException;
import java.util.UUID;

@RequiredArgsConstructor
public abstract class PhotoService<C extends CreatePhotoDto, D extends PhotoDto, E extends PhotoEntity> {
    protected final FileUtils fileUtils;
    protected final FileValidator fileValidator;

    protected String photoUploadDirectoryPath;

    protected abstract E getEntity(UUID id);

    protected abstract void updateEntity(E entity);

    protected abstract String createFileName(C createPhotoDto);

    protected abstract D dto(UUID id, byte[] photoBytes, String extension);

    protected abstract RuntimeException alreadyHasAPhotoUploadedException(UUID id);

    protected abstract RuntimeException doesNotHaveAPhotoUploadedYetException(UUID id);

    protected abstract RuntimeException photoUploadException(UUID id);

    protected abstract RuntimeException photoDownloadException(UUID id);

    protected abstract RuntimeException photoDeleteException(UUID id);

    protected abstract RuntimeException photoNotFoundException(UUID id);

    public String uploadPhoto(CreatePhotoDto photoDto) {
        var createPhotoDto = (C) photoDto;
        var entityId = createPhotoDto.getEntityId();

        try {
            fileValidator.validate(createPhotoDto);

            var entity = getEntity(entityId);

            if (entity.hasPhoto()) {
                throw alreadyHasAPhotoUploadedException(entityId);
            }

            String fileName = createFileName(createPhotoDto);
            fileUtils.store(
                    photoUploadDirectoryPath,
                    fileName,
                    createPhotoDto.getInputStream()
            );

            entity.setPhotoFileName(fileName);
            updateEntity(entity);

            return fileName;
        } catch (IOException exception) {
            throw photoUploadException(entityId);
        }
    }

    public D getPhoto(UUID id) {
        try {
            var entity = getEntity(id);

            if (!entity.hasPhoto()) {
                throw photoNotFoundException(id);
            }

            byte[] photoBytes = fileUtils.read(
                    photoUploadDirectoryPath,
                    entity.getPhotoFileName()
            );

            return dto(id, photoBytes, entity.getPhotoFileExtension());
        } catch (IOException exception) {
            throw photoDownloadException(id);
        }
    }

    public void deletePhoto(UUID id) {
        try {
            var entity = getEntity(id);

            if (!entity.hasPhoto()) {
                throw doesNotHaveAPhotoUploadedYetException(id);
            }

            fileUtils.delete(
                    photoUploadDirectoryPath,
                    entity.getPhotoFileName()
            );

            entity.setPhotoFileName(null);
            updateEntity(entity);
        } catch (IOException exception) {
            throw photoDeleteException(id);
        }
    }
}
