package model.Tariff;

/**
 * Created by Эдуард on 29.07.15.
 */
public enum TariffStandart {

    T1("GAS",43.128),T2("HATING",16.42),T3("ELECTRIC_POWER",0.366),T4("HOT_WATER",122.76),T5("COLD_WATER", 45.98),
    T6("SEWERAGE",7.18),T7("RENT",2.26),T8("GARBAGEREMOVAL",2.61);
    private String namePrivileges;
    private double discountsCoefficient;
    public String getNamePrivileges() {
        return namePrivileges;
    }
    public double getDiscountsCoefficient() {
        return discountsCoefficient;
    }
    TariffStandart(String namePrivileges, double  discountsCoefficient) {
        this.namePrivileges=namePrivileges;
        this.discountsCoefficient=discountsCoefficient;

    }
}
