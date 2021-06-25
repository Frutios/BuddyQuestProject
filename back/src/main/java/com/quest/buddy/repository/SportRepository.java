package com.quest.buddy.repository;



import java.util.List;

import com.quest.buddy.models.Sport;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

@Repository
public interface SportRepository extends CrudRepository<Sport, Long> {
    
    @Query("SELECT s FROM Sport s WHERE s.name = (:name)")
        public Sport findByName(@Param("name") String name);

    @Query(value="SELECT * FROM Sport s WHERE s.name like %:filter% or s.description like %:filter%",nativeQuery=true)
    public Iterable<Sport> findSportsByKeyword(@Param("filter") String name);
}