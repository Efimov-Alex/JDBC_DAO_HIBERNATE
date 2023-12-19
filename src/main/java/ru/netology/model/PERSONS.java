package ru.netology.model;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@AllArgsConstructor
@NoArgsConstructor
@Data
@Builder
@Table(name = "persons")
@NamedNativeQuery(
        name = "findPersonByCity",
        query = "select * from persons p where p.city_of_living = :city"
)
public class PERSONS {
    @EmbeddedId
    private Contact contact;
    @Column(length = 20, name = "phone_number", nullable = false)
    private String phoneNumber;
    @Column(length = 255, name = "city_of_living", nullable = false)
    private String cityOfLiving;


}