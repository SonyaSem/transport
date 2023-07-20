package com.task.transport.models;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Table(name="transport")
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Transport {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    private String mark;
    private String model;
    private String category;
    @Column(unique = true)
    private String number;
    private String type;
    private int year;
    private boolean trailer;

}
