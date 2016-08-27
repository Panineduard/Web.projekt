package DAO;

import model.Flat.Adress;
import model.Flat.Flat;
import model.FlatOwner.Login;
import model.FlatOwner.Person;
import model.Tariff.Privileges;
import model.Tariff.Tariff;


import java.util.*;

/**
 * Created by ������ on 29.07.15.
 */
public class DataGenerator {

    private static Date getReleaseDate() {
        Random random = new Random();
        Calendar c = Calendar.getInstance();
        c.add(Calendar.YEAR, -random.nextInt(5));
        c.add(Calendar.MONTH, 1+random.nextInt(11));
        c.add(Calendar.DAY_OF_MONTH, 1+random.nextInt(30));

        return  c.getTime();
    }

    private static List<Person> personGenerator(){
        Random random=new Random();
        List<Person> people=new ArrayList<Person>();
        for (int i=0;i<1000;i++){
            Login login =new Login();
            Person person=new Person();
            login.setUserName("username" + i);
            login.setPassword("pasw" + random.nextInt(100));
            person.setName("name" + i);
            person.setFirstName("firstName" + i);
            person.setLastName("lastName" + i);
            person.setPhone("+380" + random.nextInt(10) + "" + random.nextInt(99999999));
            person.setUserID(i);
            person.setLogin(login);
            people.add(person);
        }
      return people;
    }
    public List<Person> getPeople(){
        return personGenerator();
    }
    public  List<Flat> getFlats(){return flatsGenerator();}

    private static List<Flat> flatsGenerator(){
        Random random=new Random();
        List<Privileges>privilegs =new ArrayList<Privileges>();
        for (Privileges privileges:Privileges.values()){privilegs.add(privileges);}

        List<Flat>flats = new ArrayList<Flat>();
        for (int i=0;i<1000;i++){
            Adress adress= new Adress();
            adress.setCity("City" + i);
            adress.setNamberFlat(random.nextInt(150));
            adress.setStreet("Street" + i);
            adress.setNoHouse(random.nextInt(300));
            Flat flat = new Flat();
            flat.setAdress(adress);
            flat.setArea(random.nextInt(50)+random.nextFloat());
            flat.setCountOfResidents(1+random.nextInt(6));
            flat.setPrivilege(privilegs.get(random.nextInt(4)));
            flat.setPersonalAccount(i);
            flats.add(flat);
        }
        return flats;
    }

    private static List<Tariff> paymantGenerator(){
        Random random = new Random();
        List<Tariff> tariffs =new ArrayList<Tariff>();
        for (int i = 0; i < 1000; i++){
            Tariff tariff = new Tariff();
            tariff.setColdWater(random.nextInt(1000) + random.nextFloat());
            tariff.setElectricPower(random.nextInt(1000) + random.nextFloat());
            tariff.setGarbageRemoval(random.nextInt(1000) + random.nextFloat());
            tariff.setGas(random.nextInt(1000) + random.nextFloat());
            tariff.setHeating(random.nextInt(1000) + random.nextFloat());
            tariff.setHotWater(random.nextInt(1000) + random.nextFloat());
            tariff.setRent(random.nextInt(1000) + random.nextFloat());
            tariff.setSewerage(random.nextInt(1000) + random.nextFloat());
            tariff.setDate(getReleaseDate());
            tariffs.add(tariff);

        }

        return tariffs;
    }
    public  List<Tariff> getTariffs(){
        return paymantGenerator();
    }
}
