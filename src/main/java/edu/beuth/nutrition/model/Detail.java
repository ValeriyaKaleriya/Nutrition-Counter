package edu.beuth.nutrition.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;


@Entity
@Table(schema = "nutrition", name = "details")
public class Detail {

    @Column(name = "kcal")
    private int kcal;

    @Column(name = "fat")
    private double fat;

    @Column(name = "protein")
    private double protein;

    @Column(name = "carb")
    private double carb;

    public int getKcal() {
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

    private void setKcal(int kcal) {
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
