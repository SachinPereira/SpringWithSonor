package com.example.task2.model;

import javax.persistence.*;

@Entity
@Table(name="task2")
public class studentModel {
    @Id
    @GeneratedValue
    int idtask2;
    @Column(name="name")
    String name;
    @Column(name="address")
    String address;
    @Column(name="phone_number")
    String phone_number;

    @Override
    public String toString() {
        return "studentModel{" +
                "idtask2=" + idtask2 +
                ", name='" + name + '\'' +
                ", address='" + address + '\'' +
                ", phone_number=" + phone_number +
                '}';
    }

    public int getIdtask2() {
        return idtask2;
    }

    public void setIdtask2(int idtask2) {
        this.idtask2 = idtask2;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getPhone_number() {
        return phone_number;
    }

    public void setPhone_number(String phone_number) {
        this.phone_number = phone_number;
    }

    public studentModel(int idtask2, String name, String address, String phone_number) {
        this.idtask2 = idtask2;
        this.name = name;
        this.address = address;
        this.phone_number = phone_number;
    }

    public studentModel() {
        super();
    }
}
