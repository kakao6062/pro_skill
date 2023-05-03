import java.sql.*;

class DBTest {
    public static void main(String[] args) {
        try{
            Class.forName("org.sqlite.JDBC");
        }catch(ClassNotFoundException e){
            throw new IllegalStateException("ドライバのロードに失敗しました. ");
        }
        Connection con = null;
        //データベース接続
        try {
            con = DriverManager.getConnection("jdbc:sqlite:./test.db");            
        } catch (SQLException e) {
            e.printStackTrace();
        }
        try {
            Statement stm = con.createStatement();
            String sql = "CREATE TABLE IF NOT EXISTS hoge"
                        +"("
                        +"   id INT"
                        +",  name VARCHAR(20)"
                        +",  age  INT"
                        +")";
            stm.executeUpdate(sql);
            con.close();            
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}