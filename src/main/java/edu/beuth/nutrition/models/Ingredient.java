package edu.beuth.nutrition.models;


import javax.persistence.*;

@Entity
@Table(schema = "nutrition", name = "ingredients")
public class Ingredient {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "name")
    private String name;

    @JoinColumn(name = "detail_id")
    @ManyToOne
    private Detail detail;

    public String getName() {
        return name;
    }

    public Detail getDetail() {
        return detail;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setDetail(Detail detail) {
        this.detail = detail;
    }
}
