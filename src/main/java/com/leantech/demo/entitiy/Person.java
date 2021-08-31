package com.leantech.demo.entitiy;

import com.leantech.demo.payload.NewPersonRequest;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import javax.persistence.*;
import java.io.Serializable;

@Entity
@Table(name = "person")
@Getter
@Setter
@ToString
public class Person implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long id;

    private String name;
    private String lastName;
    private String address;
    private String cellphone;
    private String cityName;


    public Person(NewPersonRequest newPersonRequest) {
        this.name = newPersonRequest.getName();
        this.lastName = newPersonRequest.getLastName();
        this.address = newPersonRequest.getAddress();
        this.cellphone = newPersonRequest.getCellphone();
        this.cityName = newPersonRequest.getCityName();
    }

    public Person() {

    }
}
