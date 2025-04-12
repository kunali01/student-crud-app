package com.FlynautDemo.demo.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;

import java.time.LocalDate;

@Entity
public class Students {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    private String name;
    private String email;
    private LocalDate created;
    private LocalDate modified;
    private int status;


    public int getId() { return id; }
    public void setId(int id) { this.id = id; }

    public String getName() { return name; }
    public void setName(String name) { this.name = name; }

    public String getEmail() { return email; }
    public void setEmail(String email) { this.email = email; }

    public LocalDate getCreated() { return created; }
    public void setCreated(LocalDate created) { this.created = created; }

    public LocalDate getModified() { return modified; }
    public void setModified(LocalDate modified) { this.modified = modified; }

    public int getStatus() { return status; }
    public void setStatus(int status) { this.status = status; }
}
