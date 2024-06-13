package ResultSetdemo;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.Statement;
import java.sql.ResultSet;

public class ResultSetLibrayimplement {

    public static void main(String[] args) throws Exception {
        Class.forName("com.mysql.cj.jdbc.Driver");
        Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/register", "root", "rudra@123456");
//        BY DEFAULT THIS TWO ARGS WERE PROVIDED
        Statement st = con.createStatement(ResultSet.TYPE_SCROLL_INSENSITIVE , ResultSet.CONCUR_READ_ONLY);
//         Statement st = con.createStatement(ResultSet.CONCUR_READ_ONLY; , ResultSet.TYPE_FORWARD_ONLY); WRONG
        ResultSet rs = st.executeQuery("SELECT * FROM reg");
        
        while (rs.next()) {
            System.out.print(" " + rs.getInt(1));
            System.out.print(" , " + rs.getString(2));
            System.out.print(" , " + rs.getString(3));

            System.out.println();
        }
    }
}

