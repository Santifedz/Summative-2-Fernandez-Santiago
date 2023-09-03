package com.company.bookstore.models;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Objects;

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

    private String postalCode;

    private String phone;
    private String email;

    private String publisherName;
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
        return publisherName;
    }

    public String getCity() {
        return city;
    }
    public String getState() {
        return state;
    }
    public String getPostalCode() {
        return postalCode;
    }

    public String getPhone() {
        return phone;
    }


    public void setPublisherId(Integer publisherId) {
        this.publisherId = publisherId;
    }
    public void setPublisherName(String publisherName) {
        this.publisherName = publisherName;
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


    public void setPostalCode(String postalCode) {
        this.postalCode = postalCode;
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
        return publisherId.equals(publisher.publisherId) && publisherName.equals(publisher.publisherName) && street.equals(publisher.street) && city.equals(publisher.city) && state.equals(publisher.state) && postalCode.equals(publisher.postalCode) && phone.equals(publisher.phone) && email.equals(publisher.email);
    }

    @Override
    public int hashCode() {
        return Objects.hash(publisherId, publisherName, street, city, state, postalCode, phone, email);
    }

    @Override
    public String toString() {
        return "Publisher{publisherID: " + publisherId +
                ", publisherName: '" + publisherName + '\'' +
                ", streetName: '" + street + '\'' +
                ", cityName: '" + city + '\'' +
                ", state: " + state + '\'' +
                ", postalCode: " + postalCode + '\'' +
                ", phone: " + phone + '\'' +
                ", email:" + email + '\''
                ;
    }
//    public void setBooks(Set<Book> books) {
//        this.books = books;
//    }
}
