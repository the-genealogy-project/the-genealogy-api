package org.thegenealogyproject.api.person;

import lombok.AllArgsConstructor;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.NoArgsConstructor;
import org.springframework.data.neo4j.core.schema.GeneratedValue;
import org.springframework.data.neo4j.core.schema.Id;
import org.springframework.data.neo4j.core.schema.Node;
import org.springframework.data.neo4j.core.schema.Relationship;

import java.time.LocalDate;
import java.time.Period;
import java.util.HashSet;
import java.util.Set;
import java.util.UUID;

@Node("People")
@AllArgsConstructor
@NoArgsConstructor
@Getter
@EqualsAndHashCode(onlyExplicitlyIncluded = true)
public class Person {

    @Id
    @GeneratedValue
    @EqualsAndHashCode.Include
    private UUID id;

    private String firstName;

    private String middleName;

    private String lastName;

    private String placeOfBirth;

    private LocalDate dateOfBirth;

    private String placeOfDeath;

    private LocalDate dateOfDeath;

    @Relationship(type = "PARENT_OF", direction = Relationship.Direction.OUTGOING)
    private Set<Person> children = new HashSet<>();

    @Relationship(type = "PARENT_OF", direction = Relationship.Direction.INCOMING)
    private Set<Person> parents = new HashSet<>();

    @Relationship(type = "SIBLING_OF", direction = Relationship.Direction.OUTGOING)
    private Set<Person> siblings = new HashSet<>();

    @Relationship(type = "SPOUSE_OF", direction = Relationship.Direction.OUTGOING)
    private Set<Person> spouses = new HashSet<>();

    public int calculateAge() {
        return dateOfDeath == null ?
                Period.between(dateOfBirth, LocalDate.now()).getYears() :
                Period.between(dateOfBirth, dateOfDeath).getYears();
    }
}
