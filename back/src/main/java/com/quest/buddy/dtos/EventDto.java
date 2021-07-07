package com.quest.buddy.dtos;

import com.quest.buddy.models.Event;

import com.quest.buddy.models.Localisation;
import com.quest.buddy.models.Sport;
import com.quest.buddy.models.User;
import org.modelmapper.ModelMapper;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

public class EventDto implements BaseDto<Event> {


    private String title;
    private String urlImage;
    private String nbPartnerMax;
    private Long sportId;
    private LocalDateTime dateEventCreate;
    private String startTime;
    private String endTime;
    private String place;
    private byte flatGender;
    private String  ageMax;
    private String  ageMin;
    private Long userId;
    //@Length(min=0,max = 300)
    private String description;
    private byte state;
    private Long  localisation_Id;

    public EventDto(String title, String description) {
        this.title = title;
        this.description = description;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title.trim();
    }

    public String getUrlImage() {
        return urlImage;
    }

    public void setUrlImage(String urlImage) {
        this.urlImage = urlImage;
    }


    public void setNbPartnerMax(String nbPartnerMax) {
        if(nbPartnerMax.trim().isEmpty()){
            this.nbPartnerMax = "0";
        }else{
            this.nbPartnerMax = nbPartnerMax;
        }
    }

    public Long getSportId() {
        return sportId;
    }

    public void setSportId(Long sportId) {
        this.sportId = sportId;
    }

    public LocalDateTime getDateEventCreate() {
        return dateEventCreate;
    }

    public void setDateEventCreate(LocalDateTime dateEventCreate) {
        this.dateEventCreate = dateEventCreate;
    }

    public String getStartTime() {
        return startTime;
    }

    public void setStartTime(String startTime) {
        this.startTime = startTime;
    }

    public String getEndTime() {
        return endTime;
    }

    public void setEndTime(String endTime) {
        this.endTime = endTime;
    }

    public String getPlace() {
        return place;
    }

    public void setPlace(String place) {
        this.place = place;
    }



    public void setFlatGender(byte flatGender) {
        this.flatGender = flatGender;
    }

    public String getAgeMax() {
        return ageMax;
    }

    public void setAgeMax(String ageMax) {
        if(ageMax.trim().isEmpty()){
            this.ageMax ="0";
        }else{
            this.ageMax = ageMax;
        }
    }

    public String getAgeMin() {
        return ageMin;
    }

    public void setAgeMin(String ageMin) {
        if(ageMin.trim().isEmpty()){
            this.ageMin ="0";
        }else{
            this.ageMin = ageMin;
        }

    }

    public Long getUserId() {
        return userId;
    }

    public void setUserId(Long userId) {
        this.userId = userId;
    }


    public void setDescription(String description) {
        this.description = description.trim();
    }

    public byte getState() {
        return state;
    }

    public void setState(byte state) {
        this.state = state;
    }


    public void setLocalisation_Id(Long localisation_Id) {
        this.localisation_Id = localisation_Id;
    }

    @Override
    public Event toSource() {
        ModelMapper modelMapper = new ModelMapper();
        Event event = modelMapper.map(this, Event.class);
        return event;
    }
    public Event modelMapperCreate(EventDto eventDto){
        Event event = new Event();
        User user = new User();
        event.setDateEventCreate(LocalDateTime.now());
        user.setId(eventDto.userId);
        event.setUser(user);
        event = modelMapper(eventDto,event);
        return event;
    }
    public Event modelMapperUpdate(EventDto eventDto,Event eventOri){
        Event event = modelMapper(eventDto,eventOri);
        return event;
    }
    private Event modelMapper(EventDto eventDto, Event event){
        Sport sport = new Sport();
        Localisation localisation = new Localisation();
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm");
        sport.setId(eventDto.sportId);
        localisation.setId(eventDto.localisation_Id);
        event.setTitle(eventDto.title);
        event.setNbPartnerMax(Integer.parseInt(eventDto.nbPartnerMax) );
        event.setSport(sport);
        event.setStartTime(LocalDateTime.parse(eventDto.startTime,formatter));
        event.setEndTime(LocalDateTime.parse(eventDto.endTime,formatter));
        event.setFlatGender(eventDto.flatGender);
        event.setAgeMin(Byte.parseByte(eventDto.ageMin));
        event.setAgeMax(Byte.parseByte(eventDto.ageMax));
        event.setDescription(eventDto.description);
        event.setLocalisation(localisation);
        event.setPlace(eventDto.place);
        event.setUrlImage("");

        event.setState((byte)1);
        event.setDateEventModify(LocalDateTime.now());
       return event;
    }
}
