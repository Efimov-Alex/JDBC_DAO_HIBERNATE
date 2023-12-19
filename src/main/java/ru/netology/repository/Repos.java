package ru.netology.repository;

import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Repository;
import ru.netology.model.PERSONS;

import java.util.List;

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
