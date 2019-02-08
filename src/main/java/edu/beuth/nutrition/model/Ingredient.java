package edu.beuth.nutrition.model;


import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;

@Entity
@Table(schema = "nutrition", name = "ingredients")
public class Ingredient {

    @Column(name = "name")
    private String name;

    @Column(name = "detail_id")
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
