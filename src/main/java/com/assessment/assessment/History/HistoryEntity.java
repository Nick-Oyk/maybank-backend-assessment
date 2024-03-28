package com.assessment.assessment.History;
import java.sql.Timestamp;
import java.util.UUID;

import org.hibernate.annotations.CreationTimestamp;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name="histories")
public class HistoryEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    private UUID id;

    @Column(columnDefinition = "varchar(255)")
    private String description;

    @Column(columnDefinition = "bit default 0")
    private Boolean isFavourite;

    @Column(columnDefinition = "bit default 0")
    private Boolean isDeleted;


    @CreationTimestamp
    private Timestamp createdAt; 
}
