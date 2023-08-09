package com.company.bookstore.models;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Objects;
import java.util.Set;

@Entity
@JsonIgnoreProperties({"hibernateLazyInitializer,handler"})
@Table(name = "publisher")
public class Publisher implements Serializable {
    @Id
    @Column(name = "publisher_id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer publisherId;
    private String street;
    private String city;
    private String state;

    private String postal_code;

    private String phone;
    private String email;

    private String publisher_name;
    @OneToMany( cascade = CascadeType.ALL, orphanRemoval = true, fetch = FetchType.EAGER)
    @JoinColumn(name = "publisher_id")
    //private Set<Book> books;

    public Integer getPublisherId() {
        return publisherId;
    }

    public String getStreet() {
        return street;
    }

    public String getPublisherName() {
        return publisher_name;
    }

    public String getCity() {
        return city;
    }
    public String getState() {
        return state;
    }
    public String getPostalCode() {
        return postal_code;
    }

    public String getPhone() {
        return phone;
    }


    public void setPublisherId(Integer publisherId) {
        this.publisherId = publisherId;
    }
    public void setPublisherName(String publisher_name) {
        this.publisher_name = publisher_name;
    }

    public void setStreet(String street) {
        this.street = street;
    }


    public void setCity(String city) {
        this.city = city;
    }


    public void setState(String state) {
        this.state = state;
    }


    public void setPostalCode(String postal_code) {
        this.postal_code = postal_code;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }


    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Publisher publisher = (Publisher) o;
        return publisherId.equals(publisher.publisherId) && publisher_name.equals(publisher.publisher_name) && street.equals(publisher.street) && city.equals(publisher.city) && state.equals(publisher.state) && postal_code.equals(publisher.postal_code) && phone.equals(publisher.phone) && email.equals(publisher.email);
    }

    @Override
    public int hashCode() {
        return Objects.hash(publisherId, publisher_name, street, city, state, postal_code, phone, email);
    }

    @Override
    public String toString() {
        return "Publisher{publisherID: " + publisherId +
                ", publisherName: '" + publisher_name + '\'' +
                ", streetName: '" + street + '\'' +
                ", cityName: '" + city + '\'' +
                ", state: " + state + '\'' +
                ", postalCode: " + postal_code + '\'' +
                ", phone: " + phone + '\'' +
                ", email:" + email + '\''
                ;
    }
//    public void setBooks(Set<Book> books) {
//        this.books = books;
//    }
}
