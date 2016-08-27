package model.Flat;

import model.Tariff.Tariff;

import java.util.Date;

/**
 * Created by Эдуард on 29.07.15.
 */
public class PaymentHistory {


    private Tariff counter=new Tariff();
    private Date date =new Date();

    public Tariff getCounter() {
        return counter;
    }

    public void setCounter(Tariff counter) {
        this.counter = counter;
    }
    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }



}
