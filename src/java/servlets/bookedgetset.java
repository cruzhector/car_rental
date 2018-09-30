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
public class bookedgetset {
    String carname;
    String carimg;
    String fromdate;
    String todate;

    public bookedgetset(){}
    
    public bookedgetset(String carname, String carimg, String fromdate, String todate) {
        this.carname = carname;
        this.carimg = carimg;
        this.fromdate = fromdate;
        this.todate = todate;
    }

    public String getCarname() {
        return carname;
    }

    public void setCarname(String carname) {
        this.carname = carname;
    }

    public String getCarimg() {
        return carimg;
    }

    public void setCarimg(String carimg) {
        this.carimg = carimg;
    }

    public String getFromdate() {
        return fromdate;
    }

    public void setFromdate(String fromdate) {
        this.fromdate = fromdate;
    }

    public String getTodate() {
        return todate;
    }

    public void setTodate(String todate) {
        this.todate = todate;
    }
    
}
