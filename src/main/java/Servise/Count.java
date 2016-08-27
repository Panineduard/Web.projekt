package Servise;

import model.Tariff.Tariff;

/**
 * Created by Эдуард on 03.08.15.
 */
public class Count {
    public Tariff countDifferencesTariffs(Tariff tariff1,Tariff tariff2){
        Tariff tariff=new Tariff();

        tariff.setHeating(tariff1.getHeating()-tariff2.getHeating());
        tariff.setGas(tariff1.getGas() - tariff2.getGas());
        tariff.setGarbageRemoval(tariff1.getGarbageRemoval() - tariff2.getGarbageRemoval());
        tariff.setHotWater(tariff1.getHotWater() - tariff2.getHotWater());
        tariff.setColdWater(tariff1.getColdWater() - tariff2.getColdWater());
        tariff.setElectricPower(tariff1.getElectricPower() - tariff2.getElectricPower());
        tariff.setRent(tariff1.getRent() - tariff2.getRent());
        tariff.setSewerage(tariff1.getSewerage()-tariff2.getSewerage());

        return tariff;
    }
    public Float TotalCost(Tariff tariff){
        return tariff.getSewerage()+tariff.getRent()+tariff.getElectricPower()+tariff.getColdWater()+tariff.getGarbageRemoval()+tariff.getGas()+tariff.getHeating()+tariff.getHotWater();
    }

}
