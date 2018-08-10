/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package getsets;

/**
 *
 * @author kolip
 */
public class homegetset {
 public String city;
 public String from;
 public String to;

    public homegetset(String city, String from, String to) {
        this.city = city;
        this.from = from;
        this.to = to;
    }
    public homegetset(){}

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public String getFrom() {
        return from;
    }

    public void setFrom(String from) {
        this.from = from;
    }

    public String getTo() {
        return to;
    }

    public void setTo(String to) {
        this.to = to;
    }
 
}
