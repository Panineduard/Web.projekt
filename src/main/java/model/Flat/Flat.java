package model.Flat;

import model.Tariff.Privileges;


/**
 * Created by Эдуард on 29.07.15.
 */
public class Flat {
    Integer personalAccount=0;
    float area=0;
    Integer countOfResidents=0;
    Privileges privilege;
    Adress adress = new Adress();

    public Integer getPersonalAccount() {
        return personalAccount;
    }

    public void setPersonalAccount(Integer personalAccount) {
        this.personalAccount = personalAccount;
    }

    public float getArea() {
        return area;
    }

    public void setArea(float area) {
        this.area = area;
    }

    public Integer getCountOfResidents() {
        return countOfResidents;
    }

    public void setCountOfResidents(Integer countOfResidents) {
        this.countOfResidents = countOfResidents;
    }

    public Privileges getPrivilege() {
        return privilege;
    }

    public void setPrivilege(Privileges privilege) {
        this.privilege = privilege;
    }

    public Adress getAdress() {
        return adress;
    }

    public void setAdress(Adress adress) {
        this.adress = adress;
    }
}
