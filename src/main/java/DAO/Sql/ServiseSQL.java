package DAO.Sql;

import DAO.DataGenerator;
import Servise.Count;
import Servise.Storage;
import com.sun.org.apache.xpath.internal.operations.*;
import model.Flat.Adress;
import model.Flat.Flat;
import model.FlatOwner.Login;
import model.FlatOwner.Person;
import model.Tariff.Tariff;


import java.io.IOException;
import java.lang.String;
import java.sql.*;
import java.sql.Date;
import java.util.*;


/**
 * Created by ������ on 02.08.15.
 */
public class ServiseSQL {
    private static String ADDRES = "jdbc:postgresql://localhost:5432/Utilities_payments";
    private static String NAME = "postgres";
    private static String PASWORD = "123";
    private static Connection getDbConnection() {
        Connection dbConnection = null;
        try {
            Class.forName("org.postgresql.Driver");
        } catch (ClassNotFoundException e) {
            System.out.println(e.getMessage());
        }
        try {
            dbConnection = DriverManager.getConnection(ADDRES, NAME, PASWORD);
            return dbConnection;
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
        return dbConnection;
    }
    private static Integer maxIdPerson() throws SQLException {
        Connection dbConnection = null;
        dbConnection = getDbConnection();
        Integer id = 0;
        String checkId = "SELECT MAX (\"userid\") FROM \"People\"  ;";
        Statement statement1 = dbConnection.createStatement();
        ResultSet resultSet1 = statement1.executeQuery(checkId);
        if (resultSet1.next()) {
            id = resultSet1.getInt(1);
        }
        return id;
    }
    private static boolean inputDBPerson(Person person) throws SQLException {
        boolean flagRepeat = true;

        Connection dbConnection = getDbConnection();
        String searchSQL = "SELECT 1 FROM \"People\" WHERE userid = ?;"; //"SELECT 1 FROM \"People\" where userid = ?;"
        PreparedStatement ps4 =dbConnection.prepareStatement(searchSQL);
        ps4.setInt(1,person.getUserID());
        ResultSet resultSet = ps4.executeQuery();

        while (resultSet.next()) {
                System.out.println("User already exists!");
                flagRepeat = false;
               }
        if (flagRepeat) {
            PreparedStatement ps = dbConnection.prepareStatement("INSERT INTO \"People\" (userid,name,firstname,lastname,phone,Email)" +
                    "VALUES (?,?,?,?,?,?)");
            PreparedStatement ps1 = dbConnection.prepareStatement("INSERT INTO \"Login\"(username,password,idperson)" +
                    "VALUES (?,?,?)");
            ps1.setString(1, person.getLogin().getUserName());
            ps1.setString(2, person.getLogin().getPassword());
            ps1.setInt(3, person.getUserID());
            ps.setInt(1, person.getUserID());
            ps.setString(2, person.getName());
            ps.setString(3, person.getFirstName());
            ps.setString(4, person.getLastName());
            ps.setString(5, person.getPhone());
            ps.setString(6, person.getEmail());
            ps.execute();
            ps1.execute();
            ps1.close();
            ps.close();
            dbConnection.close();
            resultSet.close();
            ps.close();
            ps4.close();
            ps1.close();
            System.out.println("Successfully added!");
        }
        dbConnection.close();
        resultSet.close();

        ps4.close();

        return flagRepeat;
    }
    private static boolean inputDataFlat(Flat flat,Person person) throws SQLException {
        Connection connection=getDbConnection();
        boolean flagRepeat = true;
        String setParametr ="INSERT INTO \"Flat\" " +
                "(personalaccount, idperson, area, countofresidents)VALUES (?, ?, ?, ?);";
        String setAdress ="INSERT INTO  \"Adress\" (idflat,street,city,namberflat,nohouse)VALUES (?,?,?,?,?)";
        String searchSQL = "SELECT 1 FROM \"Flat\" WHERE personalaccount=?;";
        PreparedStatement ps1 = connection.prepareStatement(searchSQL);

        ps1.setInt(1, flat.getPersonalAccount());
        ResultSet rs = ps1.executeQuery();
        while (rs.next()){
            flagRepeat =false;}
        if (flagRepeat){
        PreparedStatement ps3 = connection.prepareStatement(setAdress);
        PreparedStatement ps = connection.prepareStatement(setParametr);
            ps3.setInt(1, flat.getPersonalAccount());
            ps3.setString(2, flat.getAdress().getStreet());
            ps3.setString(3, flat.getAdress().getCity());
            ps3.setInt(4, flat.getAdress().getNamberFlat());
            ps3.setInt(5, flat.getAdress().getNoHouse());
        ps.setInt(1, flat.getPersonalAccount());
        ps.setInt(2, person.getUserID());
        ps.setFloat(3, flat.getArea());
        ps.setInt(4, flat.getCountOfResidents());
        ps.execute();
            ps3.execute();

            ps.close();
            ps3.close();
                System.out.println("Flat successfully added!");
            }
//
//
        else {
            System.out.println("Flat already exists! ");
        }
        ps1.close();
        return flagRepeat;
    }
    private static boolean inputPaymentHistory(Tariff tariff,Integer idflat) throws SQLException {
        boolean flagRepeat = true;

        Connection dbConnection = getDbConnection();
        String searchSQL = "SELECT 1 FROM \"PaymentHistory\" WHERE idflat = ?;"; //"SELECT 1 FROM \"People\" where userid = ?;"
        PreparedStatement ps4 =dbConnection.prepareStatement(searchSQL);
        ps4.setInt(1,idflat);
        ResultSet resultSet = ps4.executeQuery();

        while (resultSet.next()) {
            System.out.println("User already exists!");
            flagRepeat = false;
        }
        if (flagRepeat) {

            PreparedStatement ps = dbConnection.prepareStatement("INSERT INTO \"PaymentHistory\" (idflat,datepay,gas,heating,electricpower" +
                    ",hotwater,coldwater,sewerage,rent,garbageremoval)" +
                    "VALUES (?,?,?,?,?,?,?,?,?,?)");
            ps.setInt(1, idflat);
            ps.setDate(2, new Date(tariff.getDate().getTime()));
            ps.setFloat(3, tariff.getGas());
            ps.setFloat(4, tariff.getHeating());
            ps.setFloat(5, tariff.getElectricPower());
            ps.setFloat(6, tariff.getHotWater());
            ps.setFloat(7, tariff.getColdWater());
            ps.setFloat(8, tariff.getSewerage());
            ps.setFloat(9, tariff.getRent());
            ps.setFloat(10, tariff.getGarbageRemoval());
            ps.execute();

            dbConnection.close();
            resultSet.close();
            ps.close();
            ps4.close();

            System.out.println("Successfully added!");
        }
        dbConnection.close();
        resultSet.close();

        ps4.close();

        return flagRepeat;
    }
    private static boolean inputCounterHistory(Tariff tariff,Integer idflat) throws SQLException {
        boolean flagRepeat = true;

        Connection dbConnection = getDbConnection();
        String searchSQL = "SELECT 1 FROM \"CounterHistory\" WHERE idflat = ?;"; //"SELECT 1 FROM \"People\" where userid = ?;"
        PreparedStatement ps4 =dbConnection.prepareStatement(searchSQL);
        ps4.setInt(1,idflat);
        ResultSet resultSet = ps4.executeQuery();

        while (resultSet.next()) {
            System.out.println("User already exists!");
            flagRepeat = false;
        }
        if (flagRepeat) {

            PreparedStatement ps = dbConnection.prepareStatement("INSERT INTO \"CounterHistory\" (idflat,datepay,gas,heating,electricpower" +
                    ",hotwater,coldwater,sewerage,rent,garbageremoval)" +
                    "VALUES (?,?,?,?,?,?,?,?,?,?)");
            ps.setInt(1, idflat);
            ps.setDate(2, new Date(tariff.getDate().getTime()));
            ps.setFloat(3, tariff.getGas());
            ps.setFloat(4, tariff.getHeating());
            ps.setFloat(5, tariff.getElectricPower());
            ps.setFloat(6, tariff.getHotWater());
            ps.setFloat(7, tariff.getColdWater());
            ps.setFloat(8, tariff.getSewerage());
            ps.setFloat(9, tariff.getRent());
            ps.setFloat(10, tariff.getGarbageRemoval());
            ps.execute();

            dbConnection.close();
            resultSet.close();
            ps.close();
            ps4.close();

            System.out.println("Successfully added!");
        }
        dbConnection.close();
        resultSet.close();

        ps4.close();

        return flagRepeat;
    }
    private static Tariff searchInCounterHistoryByIdFlat(Integer idflat) throws SQLException {
        Tariff tariff=new Tariff();
    Connection con = getDbConnection();
        Statement st = con.createStatement();
        String SQL = "SELECT * FROM \"CounterHistory\" WHERE \"idflat\" = "+idflat;
        ResultSet rs = st.executeQuery(SQL);
        while (rs.next()){
            tariff.setElectricPower(rs.getFloat("electricpower"));
            tariff.setColdWater(rs.getFloat("coldwater"));
            tariff.setSewerage(rs.getFloat("sewerage"));
            tariff.setRent(rs.getFloat("rent"));
            tariff.setHotWater(rs.getFloat("hotwater"));
            tariff.setGarbageRemoval(rs.getFloat("garbageremoval"));
            tariff.setGas(rs.getFloat("gas"));
            tariff.setHeating(rs.getFloat("heating"));


        }
     return tariff;
    }
    private static Tariff searchInPaymentHistoryByIdFlat(Integer idflat) throws SQLException {
        Tariff tariff=new Tariff();
        Connection con = getDbConnection();
        Statement st = con.createStatement();
        String SQL = "SELECT * FROM \"PaymentHistory\" WHERE \"idflat\" = "+idflat;
        ResultSet rs = st.executeQuery(SQL);
        while (rs.next()){
            tariff.setElectricPower(rs.getFloat("electricpower"));
            tariff.setColdWater(rs.getFloat("coldwater"));
            tariff.setSewerage(rs.getFloat("sewerage"));
            tariff.setRent(rs.getFloat("rent"));
            tariff.setHotWater(rs.getFloat("hotwater"));
            tariff.setGarbageRemoval(rs.getFloat("garbageremoval"));
            tariff.setGas(rs.getFloat("gas"));
            tariff.setHeating(rs.getFloat("heating"));


        }
        return tariff;
    }
    private static Integer searchInFlatsByAddress(Adress adress) throws SQLException {
        Integer idFlat=0;
        Connection con = getDbConnection();
        Statement st = con.createStatement();
        String SQL = "SELECT * FROM \"Adress\" WHERE \"street\" = '"+adress.getStreet()+"'";
        ResultSet rs = st.executeQuery(SQL);
        while (rs.next()){
            if(adress.getCity().equals(rs.getString("city"))) {

                if (adress.getStreet().equals(rs.getString("street"))) {

                    if (adress.getNamberFlat().equals(rs.getInt("namberflat"))) {

                        if (adress.getNoHouse().equals(rs.getInt("nohouse"))) {
                            idFlat = rs.getInt("idflat");
                        }
                    }
                }
            }


        }
    return idFlat;
    }
    private static Tariff searchDebts(Adress adress) throws SQLException {
    Integer id = searchInFlatsByAddress(adress);
    Tariff tariffPayment = new Tariff();
        tariffPayment = searchInPaymentHistoryByIdFlat(id);
    Tariff tariffCounter =new Tariff();
        tariffPayment= searchInPaymentHistoryByIdFlat(id);
    Count count=new Count();
    return count.countDifferencesTariffs(tariffPayment,tariffCounter);

}
    private static List<Integer> searchByLastname(String lastname) throws SQLException {

        List<Integer> id=new ArrayList<Integer>();
        Connection con = getDbConnection();
        Statement st = con.createStatement();
        String SQL = "SELECT f.*,p.* from \"Flat\" f  LEFT join \"People\" p ON p.userid=f.idperson WHERE p.lastname = '"+lastname+"'";
        ResultSet rs = st.executeQuery(SQL);
        while (rs.next()){
        id.add(rs.getInt("personalaccount"));
        }
        return id;
    }
    private static List<Tariff> searchByInn(String inn) throws SQLException {
        Integer inn1 = Integer.valueOf(inn);
        List<Tariff> tariffs=new ArrayList<Tariff>();
        List<Integer> idFlats=new ArrayList<Integer>();
        Connection con = getDbConnection();
        Statement st = con.createStatement();
        String SQL = "SELECT f.*,p.* from \"Flat\" f  LEFT join \"People\" p ON p.userid=f.idperson WHERE p.userid = '"+inn1+"'";
        ResultSet rs = st.executeQuery(SQL);
        while (rs.next()){
            idFlats.add(rs.getInt("personalaccount"));
        }
        for (Integer id:idFlats){
            Tariff tariff1=new Tariff();
            Tariff tariff2=new Tariff();
            tariff1=searchInCounterHistoryByIdFlat(id);
            tariff2=searchInPaymentHistoryByIdFlat(id);
            Count count =new Count();
            tariffs.add(count.countDifferencesTariffs(tariff2, tariff1));
        }
        return tariffs;
    }
    private  static Tariff searchDedtByIdFlats(String id) throws SQLException {
        Integer id1 = Integer.valueOf(id);
        Tariff tariff1=new Tariff();
        Tariff tariff2=new Tariff();
        tariff1=searchInCounterHistoryByIdFlat(id1);
        tariff2=searchInPaymentHistoryByIdFlat(id1);
        Count count =new Count();
        return count.countDifferencesTariffs(tariff2, tariff1);
    }
    private static String seachIdByLogin(Login login) throws SQLException {
        boolean flagRepeat = true;
        Integer id = 0;
        Connection dbConnection = getDbConnection();
        String searchSQL = "SELECT * FROM \"Login\" WHERE \"username\" = ? AND \"password\"=?; " ;
        PreparedStatement ps4 =dbConnection.prepareStatement(searchSQL);
        ps4.setString(1,login.getUserName());
        ps4.setString(2,login.getPassword());
        ResultSet resultSet = ps4.executeQuery();

        while (resultSet.next()) {
            System.out.println("You are registered under the ID");
            id=resultSet.getInt("idperson");
        }
     return id.toString();
    }
    public String  getIdBylogin(Login login) throws SQLException {return seachIdByLogin(login);}
    public Tariff getDebtByIdFlst(String id) throws SQLException {return searchDedtByIdFlats(id);}
    public List<Tariff> getDebtByInn(String inn) throws SQLException {return searchByInn(inn);}
    public  Tariff getDebts(Adress adress) throws SQLException {
      return searchDebts(adress);
    }
    public Integer getMaxIdPerson() throws SQLException {
        return maxIdPerson();
    }
    public boolean setPerson(Person person) throws SQLException {
        return inputDBPerson(person);
    }
    public boolean setFlat(Flat flat,Person person) throws SQLException {
        return inputDataFlat(flat, person);
    }
    public boolean setCounterHistory(Tariff tariff,Integer idflat) throws SQLException {
        return inputCounterHistory(tariff, idflat);
    }
    public  boolean setPaymentHistory(Tariff tariff,Integer idflat) throws SQLException {
        return  inputPaymentHistory(tariff, idflat);
    }
    public Tariff getTariffInCounterHistoryByIdFlat(Integer idflat) throws SQLException {
        return searchInCounterHistoryByIdFlat(idflat);
    }
    public  Tariff getTariffInPaymentHistoryByIdFlat(Integer idflat) throws SQLException {
        return searchInPaymentHistoryByIdFlat(idflat);
    }
    public List<Integer> getIdFlatsByLastname(String lastname) throws SQLException {
        return searchByLastname(lastname);
    }


    public static void main(String[]args) throws SQLException, IOException {
        DataGenerator dataGenerator= new DataGenerator();
          Adress adress = new Adress();

        adress.setNoHouse(118);
        adress.setCity("City5");
        adress.setNamberFlat(45);
        adress.setStreet("Street5");


//        System.out.println(searchDebts(adress));
//        System.out.println(maxIdPerson());

//        Count count = new Count();
//        System.out.println(count.countDifferencesTariffs(searchInPaymentHistoryByIdFlat(1),searchInCounterHistoryByIdFlat(1)));
//        System.out.println(searchInPaymentHistoryByIdFlat(1));
//        System.out.println(searchInCounterHistoryByIdFlat(1));

        for (int i=1;i<400;i++) {
            inputPaymentHistory(dataGenerator.getTariffs().get(i),i);
            inputCounterHistory(dataGenerator.getTariffs().get(i), i);}
//        inputDataFlat(dataGenerator.getFlats().get(i),dataGenerator.getPeople().get(i));}
//         System.out.println(inputDBPerson(dataGenerator.getPeople().get(34)));

    }

}
