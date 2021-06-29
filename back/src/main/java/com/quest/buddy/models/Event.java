package com.quest.buddy.models;

import org.springframework.format.annotation.DateTimeFormat;

import java.time.LocalDateTime;
import java.util.List;

import javax.persistence.*;

import com.googlecode.jmapper.JMapper;
import com.quest.buddy.dtos.EventDto;

@Entity
@Table(name = "event")
public class Event implements BaseModel<EventDto> {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "title", length = 80, nullable = false)
    private String title;

    @Column(name = "urlImage", length = 200)
    private String urlImage;

    @Column(name = "nbPartnerMax")
    private int nbPartnerMax;

    @ManyToOne
    @JoinColumn(name = "sportId", referencedColumnName = "id")
    private Sport sport;

    @Column(name = "dateEventCreate")
    private LocalDateTime dateEventCreate;

    @DateTimeFormat(pattern = "yyyy-MM-dd")
    @Column(name = "startTime")
    private LocalDateTime startTime;

    @Column(name = "endTime")
    private LocalDateTime endTime;

    @Column(name = "place")
    private String place;

    @Column(name = "flatGender")
    private byte flatGender;

    @Column(name = "ageMax")
    private byte ageMax;

    @Column(name = "ageMin")
    private byte ageMin;

    @ManyToOne
    @JoinColumn(name = "userId", referencedColumnName = "id")
    private User user;

    @Column(name = "description")
    private String description;

    @Column(name = "state")
    private byte state;

    @ManyToOne
    @JoinColumn(name = "localisation_Id", referencedColumnName = "id")
    private Localisation localisation;

    public Event() {
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getUrlImage() {
        return urlImage;
    }

    public void setUrlImage(String urlImage) {
        this.urlImage = urlImage;
    }

    public int getNbPartnerMax() {
        return nbPartnerMax;
    }

    public void setNbPartnerMax(int nbPartnerMax) {
        this.nbPartnerMax = nbPartnerMax;
    }

    public Sport getSport() {
        return sport;
    }

    public void setSport(Sport sport) {
        this.sport = sport;
    }

    public LocalDateTime getStartTime() {
        return startTime;
    }

    public void setStartTime(LocalDateTime startTime) {
        this.startTime = startTime;
    }

    public LocalDateTime getEndTime() {
        return endTime;
    }

    public void setEndTime(LocalDateTime endTime) {
        this.endTime = endTime;
    }

    public String getPlace() {
        return place;
    }

    public void setPlace(String place) {
        this.place = place;
    }

    public byte getFlatGender() {
        return flatGender;
    }

    public void setFlatGender(byte flatGender) {
        this.flatGender = flatGender;
    }

    public byte getAgeMax() {
        return ageMax;
    }

    public void setAgeMax(byte ageMax) {
        this.ageMax = ageMax;
    }

    public byte getAgeMin() {
        return ageMin;
    }

    public void setAgeMin(byte ageMin) {
        this.ageMin = ageMin;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public byte getState() {
        return state;
    }

    public void setState(byte state) {
        this.state = state;
    }

    public Localisation getLocalisation() {
        return localisation;
    }

    public void setLocalisation(Localisation localisation) {
        this.localisation = localisation;
    }

    public LocalDateTime getDateEventCreate() {
        return dateEventCreate;
    }

    public void setDateEventCreate(LocalDateTime dateEventCreate) {
        this.dateEventCreate = dateEventCreate;
    }

    public String getInfoDateEventCreate(){
        //create if par today
        return "Publié - " + this.dateEventCreate.toLocalDate().toString() + " "+this.dateEventCreate.toLocalTime().toString() ;
    }
    public String getInfoDateEvent(){
        //15 July 2021        10h00 ->11h30
        String dateFormatStart,dateFormatEnd ;
        dateFormatStart =this.startTime.toLocalDate().toString() +" " + this.startTime.toLocalTime().toString() ;
        dateFormatEnd=this.endTime.toLocalDate().toString() +" "+this.endTime.toLocalTime().toString();
        return  dateFormatStart +" --> "+dateFormatEnd;
    }
    public String getInfoNroPartner(){
        return this.nbPartnerMax + " Partners";
    }
    @Override
    public EventDto toDto(){
        JMapper<EventDto, Event> eventMapper = new JMapper<>(EventDto.class, Event.class);

        EventDto eventDto = eventMapper.getDestination(this);
        return eventDto;
    }


}
