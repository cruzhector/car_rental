/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package servlets;

/**
 *
 * @author kolip
 */
public class carsgetset{
 public String carname;
 public String cartype;
 public String transmission;
 public String seats;
 public int cost;
 public String img;

    public carsgetset(String carname, String cartype, String transmission, String seats, int cost, String img) {
        this.carname = carname;
        this.cartype = cartype;
        this.transmission = transmission;
        this.seats = seats;
        this.cost = cost;
        this.img = img;
    }
 public carsgetset(){}

    public String getCarname() {
        return carname;
    }

    public void setCarname(String carname) {
        this.carname = carname;
    }

    public String getCartype() {
        return cartype;
    }

    public void setCartype(String cartype) {
        this.cartype = cartype;
    }

    public String getTransmission() {
        return transmission;
    }

    public void setTransmission(String transmission) {
        this.transmission = transmission;
    }

    public String getSeats() {
        return seats;
    }

    public void setSeats(String seats) {
        this.seats = seats;
    }

    public int getCost() {
        return cost;
    }

    public void setCost(int cost) {
        this.cost = cost;
    }

    public String getImg() {
        return img;
    }

    public void setImg(String img) {
        this.img = img;
    }
 
 
 
}
