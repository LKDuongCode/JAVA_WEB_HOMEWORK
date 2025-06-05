package com.duong.ss19.entity.theater;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Table(name = "theater")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class Theater {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false)
    private String theaterName;

    @Column(nullable = false)
    private String address;

    @Column(nullable = false)
    private Integer numberScreenRoom;

    @Column(nullable = false)
    private boolean status;
}
