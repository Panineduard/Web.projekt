package model.Tariff;

import java.util.Date;

/**
 * Created by Эдуард on 29.07.15.
 */
public class Tariff {
    private float gas=0;
    private float heating=0;
    private float electricPower=0;
    private float hotWater=0;
    private float coldWater=0;
    private float sewerage =0;
    private float rent=0;
    private float garbageRemoval=0;
    Date date = new Date();
    @Override
    public String toString(){
    return "Gas - "+gas+" Heating - "  +heating+" electricPower - "+electricPower+ "  Date - "+ date;
    }

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }

    public float getGas() {
        return gas;
    }

    public void setGas(float gas) {
        this.gas = gas;
    }

    public float getHeating() {
        return heating;
    }

    public void setHeating(float heating) {
        this.heating = heating;
    }

    public float getElectricPower() {
        return electricPower;
    }

    public void setElectricPower(float electricPower) {
        this.electricPower = electricPower;
    }

    public float getHotWater() {
        return hotWater;
    }

    public void setHotWater(float hotWater) {
        this.hotWater = hotWater;
    }

    public float getColdWater() {
        return coldWater;
    }

    public void setColdWater(float coldWater) {
        this.coldWater = coldWater;
    }

    public float getSewerage() {
        return sewerage;
    }

    public void setSewerage(float sewerage) {
        this.sewerage = sewerage;
    }

    public float getRent() {
        return rent;
    }

    public void setRent(float rent) {
        this.rent = rent;
    }

    public float getGarbageRemoval() {
        return garbageRemoval;
    }

    public void setGarbageRemoval(float garbageRemoval) {
        this.garbageRemoval = garbageRemoval;
    }



}
