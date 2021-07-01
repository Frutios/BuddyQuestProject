package com.quest.buddy.repository;


import com.quest.buddy.models.UserEvent;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface UserEventRepository extends CrudRepository<UserEvent, Long> {

    @Autowired
    public Iterable<UserEvent> findUserEventByEvent_Id(Long id);


    @Query(value="SELECT * FROM user_event u WHERE u.event_id = :eventId and u.user_id = :userId",nativeQuery=true)
    public Optional<UserEvent> findUserEventId(@Param("eventId") Long eventId,@Param("userId") Long userId );

    @Query(value="SELECT  * FROM user_event u WHERE u.event_id = :eventId and u.user_id = :userId",nativeQuery=true)
    public UserEvent findUserEventUserId(@Param("eventId") Long eventId,@Param("userId") Long userId );
}