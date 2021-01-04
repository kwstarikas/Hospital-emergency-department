import database.CS360DB;

import java.sql.SQLException;
import Add.AddPeople;
public class Main {
    public static void main(String[] argv){
        
        System.out.println("KAISER");

        try {

            AddPeople.addDoctor();
        } catch (SQLException | ClassNotFoundException throwables) {
            throwables.printStackTrace();
        }
    }
}
