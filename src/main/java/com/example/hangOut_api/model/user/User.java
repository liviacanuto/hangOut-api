package com.example.hangOut_api.model.user;

import jakarta.persistence.*;

import java.util.Objects;

@Entity
@Table(name = "user", schema = "public", uniqueConstraints = @UniqueConstraint(columnNames = "email"))
public class User {
    @Id
    @Column
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "first_name")
    private String firstName;

    @Column(name = "last_name")
    private String lastName;

    @Column(unique = true, nullable = false)
    private String email;

    @Column
    private String password;

    public User(String firstName, String lastName, String email, String password) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.email = email;
        this.password = password;
    }

    public User(Long id, String firstName, String lastName, String email, String password) {
        this(firstName, lastName, email, password);
        this.id = id;
    }

    public User(UserRegisterDTO data) {
        this(data.firstName(), data.lastName(), data.email(), data.password());
    }

    public User() {
    }

    public long getId() {
        return this.id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getFirstName() {
        return this.firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return this.lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getEmail() {
        return this.email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPassword() {
        return this.password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || this.getClass() != o.getClass()) return false;
        User user = (User) o;
        return Objects.equals(this.id, user.id);
    }

    @Override
    public int hashCode() {
        return Objects.hash(this.id, this.firstName, this.lastName, this.email, this.password);
    }

    @Override
    public String toString() {
        return "User{" +
                "id=" +
                this.id +
                ", firstName='" +
                this.firstName +
                '\'' +
                ", lastName='" +
                this.lastName +
                '\'' +
                ", email='" +
                this.email +
                '\'' +
                ", password='" +
                this.password +
                '\'' +
                '}';
    }
}
