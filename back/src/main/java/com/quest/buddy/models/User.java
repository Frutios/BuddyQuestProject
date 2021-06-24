package com.quest.buddy.models;

import javax.persistence.*;

import org.springframework.context.annotation.Lazy;

import java.time.LocalDate;
import java.util.List;


@Entity
@Table(name = "user")
public class User {

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

    @Column(name = "password", length = 30, nullable = false)
    private String password;

    @Column(name = "pseudonym", length = 30, nullable = false)
    private String pseudonym;


    @Column(name = "phone", length = 10)
    private String phone;

    @ManyToOne
    @JoinColumn(name = "localisationId", referencedColumnName = "id")
    private Localisation localisation;

    @OneToMany(mappedBy = "user")
    @Lazy
    private List<Event> events;

    @OneToMany(mappedBy = "message")
    @Lazy
    private List<Message> messages;

    @OneToMany(mappedBy = "user")
    @Lazy
    private List<MySport> mySports;

    public User(){

    }

    public User(String firstName, String lastName, LocalDate inscriptionDate, String email, String password, String pseudonym, String phone, Localisation localisation) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.inscriptionDate = inscriptionDate;
        this.email = email;
        this.password = password;
        this.pseudonym = pseudonym;
        this.phone = phone;
        this.localisation = localisation;
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

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getPseudonym() {
        return pseudonym;
    }

    public void setPseudonym(String pseudonym) {
        this.pseudonym = pseudonym;
    }

    public Localisation getLocalisation() {
        return localisation;
    }

    public void setLocalisation(Localisation localisation) {
        this.localisation = localisation;
    }

    public List<Event> getEvents() {
        return events;
    }

    public void setEvents(List<Event> events) {
        this.events = events;
    }

    public List<Message> getMessages() {
        return messages;
    }

    public void setMessages(List<Message> messages) {
        this.messages = messages;
    }
}