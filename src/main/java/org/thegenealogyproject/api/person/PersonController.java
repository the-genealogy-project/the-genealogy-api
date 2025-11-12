package org.thegenealogyproject.api.person;

import lombok.AllArgsConstructor;
import org.springframework.graphql.data.method.annotation.Argument;
import org.springframework.graphql.data.method.annotation.QueryMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.UUID;

@RestController
@AllArgsConstructor
public class PersonController {
    private final PersonQueryService personQueryService;

    @QueryMapping(name = "person")
    public Person person(@Argument UUID id) {
        return personQueryService.getPerson(id);
    }
}
