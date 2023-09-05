package com.example.moonblogserver.category;


import lombok.NoArgsConstructor;
import javax.persistence.*;
import java.util.UUID;


@Entity
@Table(name="category")
public class Category {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private UUID id;
    private String label;
    private String description;

    public Category(){};

    public Category(String label, String description) {
        super();
        this.label = label;
        this.description = description;
    }
    public UUID getId() {
        return id;
    }
    public String getDescription() {
        return description;
    }
    public String getLabel() {
        return label;
    }
    public void setDescription(String description) {
        this.description = description;
    }
    public void setLabel(String label) {
        this.label = label;
    }
}
