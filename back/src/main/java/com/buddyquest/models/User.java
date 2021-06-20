package com.buddyquest.models;

import javax.persistence.*;
import java.io.Serializable;
import java.time.LocalDate;
import java.util.Collection;


@Entity
@Table(name = "user")
public class User implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "firstName", length = 20, nullable = false )
    private String firstName;

    @Column(name = "lastName", length = 20, nullable = false)
    private String lastName;

    @Column(name = "inscriptionDate", nullable = false)
    private LocalDate inscriptionDate;

    @Column(name = "email", length = 30, nullable = false)
    private String email;

    @Column(name = "phone", length = 10)
    private String phone;

    @ManyToOne
    @JoinColumn(name = "localisationId", referencedColumnName = "id")
    private Localisation localisation;

    @OneToMany(mappedBy = "user")
    private Collection<Event> events;

    @OneToMany(mappedBy = "message")
    private Collection<Message> messages;

    public User(){

    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public LocalDate getInscriptionDate() {
        return inscriptionDate;
    }

    public void setInscriptionDate(LocalDate inscriptionDate) {
        this.inscriptionDate = inscriptionDate;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public Localisation getLocalisation() {
        return localisation;
    }

    public void setLocalisation(Localisation localisation) {
        this.localisation = localisation;
    }

    public Collection<Event> getEvents() {
        return events;
    }

    public void setEvents(Collection<Event> events) {
        this.events = events;
    }

    public Collection<Message> getMessages() {
        return messages;
    }

    public void setMessages(Collection<Message> messages) {
        this.messages = messages;
    }
}