package com.leantech.demo.entitiy;

import lombok.*;

import javax.persistence.*;
import java.io.Serializable;


@Entity
@Table(name = "position")
@Data
@ToString
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class Position implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long id;

    private String name;

}
