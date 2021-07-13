package com.quest.buddy.models;

import javax.persistence.*;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Size;

import com.quest.buddy.dtos.UserDto;
import org.modelmapper.ModelMapper;
import java.time.LocalDateTime;

@Entity
@Table(name = "user")
public class User implements BaseModel<UserDto> {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Size(min = 2, max = 20)
    @NotBlank(message = "Le prénom est obligatoire")
    @Column(name = "firstName", nullable = false)
    private String firstName;

    @Size(min = 2, max = 20) 
    @NotBlank(message = "Le nom est obligatoire")
    @Column(name = "lastName", nullable = false)
    private String lastName;

    @Column(name = "userName", nullable = false)
    private String userName;

    @Column(name = "inscriptionDate", nullable = false)
    private LocalDateTime inscriptionDate;

    @NotBlank(message = "L\'email est obligatoire")
    @Column(name = "email", nullable = false)
    private String email;

    @Size(min = 8)
    @NotBlank(message = "Mot de passe obligatoire")
    @Column(name = "password", nullable = false)
    private String password;

    @Size(min = 4, max = 30)
    @NotBlank(message = "Pseudo obligatoire")
    @Column(name = "pseudonym", length = 30, nullable = false)
    private String pseudonym;

    @Size(min = 4, max = 12)
    @Column(name = "phone")
    private String phone;

    @Column(name = "urlAvatar", length = 50)
    private String urlAvatar;

    @Size(min = 20, max = 250)
    @NotBlank(message = "La description est obligatoire")
    @Column(name = "description", nullable = false)
    private String description;

    @ManyToOne
    @JoinColumn(name = "localisationId", referencedColumnName = "id")
    private Localisation localisation;

    public User(){
        this.localisation = null;
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

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public LocalDateTime getInscriptionDate() {
        return inscriptionDate;
    }

    public void setInscriptionDate(LocalDateTime inscriptionDate) {
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

    public String getFullName(){
        return this.firstName + " " + this.lastName;
    }
    public String getUrlAvatar() {
        return urlAvatar;
    }

    public void setUrlAvatar(String urlAvatar) {
        this.urlAvatar = urlAvatar;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    @Override
    public UserDto toDto(){
        ModelMapper modelMapper = new ModelMapper();
        UserDto userDto = modelMapper.map(this, UserDto.class);
        return userDto;
    }
}
