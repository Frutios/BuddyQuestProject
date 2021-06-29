package com.quest.buddy.services;

import com.quest.buddy.models.UserEvent;
import com.quest.buddy.repository.UserEventRepository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service("UserEventService")
public class UserEventServiceImpl implements UserEventService{
    @Autowired
    private UserEventRepository userEventRepository;

    @Autowired
    private ErrorServiceImp errorService;

    @Override
    public void create(UserEvent userEvent) throws MessageErrorException {
        Long eventId = userEvent.getEvent().getId();
        Long userId = userEvent.getUser().getId();
        if(existEventUserId(eventId,userId)){
            throw new MessageErrorException("User exist in envent ");
           // errorService.AddError("User Event", "Event already" + userEvent.getUser().getFullName() + " exist");
        }
        else
        {
            userEventRepository.save(userEvent);
        }
    }

    @Override
    public void remove(Long id) {
        userEventRepository.deleteById(id);
    }

    @Override
    public void update(UserEvent userEvent) {
        userEventRepository.save(userEvent);
    }


    @Override
    public Iterable<UserEvent> getAll() {
        Iterable<UserEvent> userEvents = null;
        try {
            userEvents = userEventRepository.findAll();
        } catch (Exception e) {
            errorService.AddError("Event Users", "Error getting Event Users" );
        }
        return userEvents;
    }
    public Iterable<UserEvent> getEventAll(Long id){
        Iterable<UserEvent> userEvents = null;
        try {
            userEvents = userEventRepository.findUserEventByEvent_Id(id);
        } catch (Exception e) {
            errorService.AddError("Event Users", "Error while finding event users" );
        }
        return userEvents;

    }
    @Override
    public UserEvent findById(Long id) {
        return userEventRepository.findById(id).orElse(null);
    }

    public boolean existEventUserId(Long Eventid, Long UserId){
        Optional<UserEvent> userExist = null;
        try {
            userExist = userEventRepository.findUserEventId(Eventid,UserId);
        } catch (Exception e) {
            errorService.AddError("Event User", "User exists in this event ");
        }
        return userExist.isPresent();

    }

    public UserEvent findEventUser(Long Eventid, Long UserId){
        UserEvent userEvent = null;
        try {
            userEvent = userEventRepository.findUserEventUserId(Eventid,UserId);
        } catch (Exception e) {
            errorService.AddError("Event User", "User exists in this event ");
        }
        return userEvent;

    }
}
