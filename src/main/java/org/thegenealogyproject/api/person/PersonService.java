package org.thegenealogyproject.api.person;

import java.util.UUID;

public interface PersonService {
    Person getPerson(UUID id);
}
