package com.task.transport.repositories;

import com.task.transport.models.Transport;
import jakarta.persistence.EntityManager;
import jakarta.persistence.criteria.CriteriaBuilder;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface TransportRepository extends JpaRepository <Transport, Long> {

        List<Transport> findByMark(@Param("mark") String mark);
        Transport findByNumber(@Param("number") String number);
        //List<Transport> findByMarkANDModel(String model);
        @Query(value = "SELECT t from Transport as t "+ "where (:mark is null or t.mark = :mark)" +
                " AND (:model is null or t.model = :model)"+
                " AND (:category is null or t.category = :category)"+
                " AND (:number is null or t.number = :number)"+
                " AND (:year is null or t.year = :year)")
        List<Transport> findTransport(@Param("mark") String mark,
                                      @Param("model") String model,
                                      @Param("category") String category,
                                      @Param("number") String number,
                                      @Param("year") Integer year);



}
