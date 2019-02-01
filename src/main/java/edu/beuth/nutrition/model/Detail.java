package edu.beuth.nutrition.model;

public class Detail {

    private int kcal;

    private double fat;

    private double protein;

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
