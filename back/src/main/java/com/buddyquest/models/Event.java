package com.buddyquest.models;

import java.io.Serializable;
import java.time.LocalDateTime;
import java.util.Collection;
import javax.persistence.*;

@Entity
@Table(name = "event")
public class Event implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "title", length = 80, nullable = false)
    private String title;

    @Column(name = "urlImage", length = 200)
    private String urlImage;

    @Column(name = "nbPartnerMax", nullable = false)
    private int nbPartnerMax;

    @ManyToOne
    @JoinColumn(name = "sport")
    private Sport sport;

    @Column(name = "startTime", nullable = false)
    private LocalDateTime startTime;

    @Column(name = "endTime", nullable = false)
    private LocalDateTime endTime;

    @Column(name = "place", nullable = false)
    private String place;

    @Column(name = "flatGender", nullable = false)
    private byte flatGender;

    @Column(name = "ageMax")
    private byte ageMax;

    @Column(name = "ageMin")
    private byte ageMin;

    @ManyToOne
    @JoinColumn(name = "user")
    private User creator;

    @Column(name = "description", nullable = false)
    private String description;

    @Column(name = "state", nullable = false)
    private byte state;

    @OneToMany(mappedBy = "localisation")
    private Collection<Localisation> localisations;

    @OneToMany(mappedBy = "logEvent")
    private Collection<LogEvent> logEvents;

    @OneToMany(mappedBy = "message")
    private Collection<Message> messages;

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

    public User getCreator() {
        return creator;
    }

    public void setCreator(User creator) {
        this.creator = creator;
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

    public Collection<Localisation> getLocalisations() {
        return localisations;
    }

    public void setLocalisations(Collection<Localisation> localisations) {
        this.localisations = localisations;
    }

    public Collection<LogEvent> getLogEvents() {
        return logEvents;
    }

    public void setLogEvents(Collection<LogEvent> logEvents) {
        this.logEvents = logEvents;
    }

    public Collection<Message> getMessages() {
        return messages;
    }

    public void setMessages(Collection<Message> messages) {
        this.messages = messages;
    }
}
