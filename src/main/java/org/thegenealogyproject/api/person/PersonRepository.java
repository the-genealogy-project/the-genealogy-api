package org.thegenealogyproject.api.person;

import org.springframework.data.neo4j.repository.Neo4jRepository;

import java.util.UUID;

public interface PersonRepository extends Neo4jRepository<Person, UUID> {
}
