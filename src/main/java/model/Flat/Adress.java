package model.Flat;

/**
 * Created by Эдуард on 29.07.15.
 */
public class Adress {
    private String street;
    private String city;
    private Integer namberFlat=0;
    private Integer noHouse=0;



    public Integer getNoHouse() {
        return noHouse;
    }

    public void setNoHouse(Integer noHouse) {
        this.noHouse = noHouse;
    }
    public String getStreet() {
        return street;
    }

    public void setStreet(String street) {
        this.street = street;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public Integer getNamberFlat() {
        return namberFlat;
    }

    public void setNamberFlat(Integer namberFlat) {
        this.namberFlat = namberFlat;
    }

}
