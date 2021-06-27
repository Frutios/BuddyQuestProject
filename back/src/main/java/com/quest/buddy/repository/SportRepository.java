package com.quest.buddy.repository;


import java.util.List;

import com.quest.buddy.dtos.EventDto;
import com.quest.buddy.dtos.UserDto;
import com.quest.buddy.models.Sport;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

@Repository
public interface SportRepository extends CrudRepository<Sport, Long> {
        
    public List<Sport> findByName(String name);

    // @Query("select new com.example.IdsOnly(t.id, t.otherId) from TestTable t where t.creationDate > ?1 and t.type in (?2)")
    @Query("SELECT new com.quest.buddy.dtos.EventDto(e.title,e.description) FROM Event e WHERE e.sport.id = :sportId")
    public Iterable<EventDto> findEvents(@Param("sportId") Long sportId);
   
    @Query(value="SELECT * FROM User u WHERE u.sport_id = :sportId",nativeQuery=true)
    public Iterable<UserDto> findUsers(@Param("sportId") Long sportId);

    
}