package com.kozja.filter.domain;

import org.hibernate.validator.constraints.Range;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.criteria.CriteriaBuilder;
import javax.validation.constraints.Max;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

@Entity
public class Client {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int id;

    @NotNull
    @Size(min = 2, max = 40, message = "Dlugosc imienia jest nieprawidlowa")
    private String name;
    @NotNull
    @Range(min = 1, max = 99, message = "Podany wiek jest nieprawidlowy")
    private int age;
    @NotNull
    @Range(min = 20, max = 250, message = "Podany wzrost jest nieprawidlowy")
    private int height;
    @NotNull
    @Range(min = 2, max = 300, message = "Podana waga jest nieprawidlowa")
    private int weight;

    public Client()
    {

     }

    public Client(String name, int age, int height, int weight)
    {
        this.name = name;
        this.age = age;
        this.height = height;
        this.weight = weight;
    }

    @Override
    public String toString() {
        return "Klient: " + name + " " + age + "lat " + height + "cm " + weight + "kg";
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public int getHeight() {
        return height;
    }

    public void setHeight(int height) {
        this.height = height;
    }

    public int getWeight() {
        return weight;
    }

    public void setWeight(int weight) {
        this.weight = weight;
    }

}
