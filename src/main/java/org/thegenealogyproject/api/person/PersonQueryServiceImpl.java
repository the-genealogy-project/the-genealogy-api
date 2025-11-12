package org.thegenealogyproject.api.person;

import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.UUID;

@Service
@AllArgsConstructor
public class PersonQueryServiceImpl implements PersonQueryService {
    private final PersonRepository personRepository;

    @Override
    public Person getPerson(UUID id) {
        return personRepository.findById(id)
                .orElseThrow(() -> new PersonNotFoundException(id));
    }
}
