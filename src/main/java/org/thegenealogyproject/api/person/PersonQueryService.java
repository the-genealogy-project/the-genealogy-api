package org.thegenealogyproject.api.person;

import java.util.UUID;

public interface PersonQueryService {
    Person getPerson(UUID id);
}
