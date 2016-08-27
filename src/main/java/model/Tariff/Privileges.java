package model.Tariff;

/**
 * Created by Эдуард on 29.07.15.
 */
public enum Privileges {
    V1("SUBSIDY1",0.7),V2("SUBSIDY2",0.8),V3("SUBSIDY3",0.5),V4("PENSIONER",0.5),V5("NOSING",1);
    private String namePrivileges;
    private double discountsCoefficient;
    public String getNamePrivileges() {
        return namePrivileges;
    }
    public double getDiscountsCoefficient() {
        return discountsCoefficient;
    }
    Privileges(String namePrivileges, double  discountsCoefficient) {
        this.namePrivileges=namePrivileges;
        this.discountsCoefficient=discountsCoefficient;

    }
}
