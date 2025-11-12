package org.thegenealogyproject.api.person;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

import java.util.UUID;

@Service
public class PersonPhotoService extends PhotoService<CreatePersonPhotoDto, PersonPhotoDto, Person> {
    private final PersonService personService;

    public PersonPhotoService(
            @Value("${the-genealogy-project.photo-upload-directory-path.people}") final String photoUploadDirectoryPath,
            final PersonService personService,
            final FileUtils fileUtils,
            final FileValidator fileValidator
    ) {
        super(fileUtils, fileValidator);
        this.personService = personService;
        this.photoUploadDirectoryPath = photoUploadDirectoryPath;
    }

    @Override
    protected Person getEntity(UUID id) {
        return personService.getPerson(id);
    }

    @Override
    protected void updateEntity(Person person) {
        personService.updatePerson(person);
    }

    @Override
    protected String createFileName(CreatePersonPhotoDto createPersonPhotoDto) {
        return createPersonPhotoDto.createFileName();
    }

    @Override
    protected PersonPhotoDto dto(UUID id, byte[] photoBytes, String extension) {
        return new PersonPhotoDto(id, photoBytes, extension);
    }

    @Override
    protected RuntimeException alreadyHasAPhotoUploadedException(UUID id) {
        return new PersonAlreadyHasAPhotoUploadedException(id);
    }

    @Override
    protected RuntimeException doesNotHaveAPhotoUploadedYetException(UUID id) {
        return new PersonDoesNotHaveAPhotoUploadedYetException(id);
    }

    @Override
    protected RuntimeException photoUploadException(UUID id) {
        return new PersonPhotoUploadException(id);
    }

    @Override
    protected RuntimeException photoDownloadException(UUID id) {
        return new PersonPhotoDownloadException(id);
    }

    @Override
    protected RuntimeException photoDeleteException(UUID id) {
        return new PersonPhotoDeleteException(id);
    }

    @Override
    protected RuntimeException photoNotFoundException(UUID id) {
        return new PersonPhotoNotFoundException(id);
    }
}
