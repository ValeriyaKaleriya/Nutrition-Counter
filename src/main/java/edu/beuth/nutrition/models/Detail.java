package edu.beuth.nutrition.models;

import javax.persistence.*;


@Entity
@Table(schema = "nutrition", name = "details")
public class Detail {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "kcal")
    private double kcal;

    @Column(name = "fat")
    private double fat;

    @Column(name = "prot")
    private double protein;

    @Column(name = "carb")
    private double carb;


    public Detail() {

    }

    public Detail(double kcal, double fat, double protein, double carb) {
        this.kcal = kcal;
        this.fat = fat;
        this.protein = protein;
        this.carb = carb;
    }

    public double getKcal() {
        return kcal;
    }

    public double getFat() {
        return fat;
    }

    public double getProtein() {
        return protein;
    }

    public double getCarb() {
        return carb;
    }

    public void setKcal(double kcal) {
        this.kcal = kcal;
    }

    public void setFat(double fat) {
        this.fat = fat;
    }

    public void setProtein(double protein) {
        this.protein = protein;
    }

    public void setCarb(double carb) {
        this.carb = carb;
    }
}
