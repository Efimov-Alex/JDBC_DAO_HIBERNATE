package ru.netology.repository;

import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
import lombok.AllArgsConstructor;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import ru.netology.model.Contact;
import ru.netology.model.PERSONS;

import java.util.List;
import java.util.Optional;

public interface Repos extends JpaRepository<PERSONS, Contact> {

    List<PERSONS> findPersonByCityOfLiving(String city);

    List<PERSONS> findPersonByContact_AgeLessThanOrderByContactAsc(Integer age);

    Optional<PERSONS> findPersonByContact_NameAndContact_Surname(String name, String surname);

}
/*
@Repository
@AllArgsConstructor
public class Repos {

    @PersistenceContext
    private EntityManager entityManager;

    public List<PERSONS> getPersonsByCity(String city) {
        var query = entityManager.createNamedQuery("findPersonByCity");
        query.setParameter("city", city);

        return query.getResultList();
    }


}

 */
