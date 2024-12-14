package pe.edu.I202224460.examen_final.entity;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import java.util.Date;

@Entity
@Getter
@Setter
@Table(name = "car")
public class Car {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer carId;
    private String make;
    private String model;
    private Integer year;
    private String vin;
    private String licensePlate;
    private String ownerName;
    private String ownerContact;
    private Date purchaseDate;
    private Integer mileage;
    private String engineType;
    private String color;
    private String insuranceCompany;
    private String insurancePolicyNumber;
    private Date registrationExpirationDate;
    private Date serviceDueDate;
}
