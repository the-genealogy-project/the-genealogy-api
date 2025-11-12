package org.thegenealogyproject.api.person;

import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.JoinTable;
import jakarta.persistence.ManyToMany;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;

import java.time.LocalDate;
import java.time.Period;
import java.util.HashSet;
import java.util.Set;
import java.util.UUID;

@Entity
@Table(name = "people")
@AllArgsConstructor
@NoArgsConstructor
@Getter
public class Person extends PhotoEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    private UUID id;

    private String firstName;

    private String middleName;

    private String lastName;

    private String placeOfBirth;

    private LocalDate dateOfBirth;

    private String placeOfDeath;

    private LocalDate dateOfDeath;

    private String photoFileName;

    @ManyToMany(fetch = FetchType.EAGER)
    @JoinTable(
            name = "person_parents",
            joinColumns = @JoinColumn(name = "person_id"),
            inverseJoinColumns = @JoinColumn(name = "parent_id")
    )
    private Set<Person> parents = new HashSet<>();

    @ManyToMany(fetch = FetchType.EAGER)
    @JoinTable(
            name = "person_children",
            joinColumns = @JoinColumn(name = "person_id"),
            inverseJoinColumns = @JoinColumn(name = "child_id")
    )
    private Set<Person> children = new HashSet<>();

    @ManyToMany(fetch = FetchType.EAGER)
    @JoinTable(
            name = "person_siblings",
            joinColumns = @JoinColumn(name = "person_id"),
            inverseJoinColumns = @JoinColumn(name = "sibling_id")
    )
    private Set<Person> siblings = new HashSet<>();

    @ManyToMany(fetch = FetchType.EAGER)
    @JoinTable(
            name = "person_spouses",
            joinColumns = @JoinColumn(name = "person_id"),
            inverseJoinColumns = @JoinColumn(name = "spouse_id")
    )
    private Set<Person> spouses = new HashSet<>();

    @Override
    public String getPhotoFileName() {
        return photoFileName;
    }

    @Override
    public void setPhotoFileName(String photoFileName) {
        this.photoFileName = photoFileName;
    }

    public int calculateAge() {
        return dateOfDeath == null ?
                Period.between(dateOfBirth, LocalDate.now()).getYears() :
                Period.between(dateOfBirth, dateOfDeath).getYears();
    }
}
