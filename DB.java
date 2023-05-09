import java.sql.*;
import java.util.ArrayList;

public final class DB {

    private DB() {}

    public static final Connection getCon() {
        Connection con = null;
        //JDBCドライバロード
        try{
            Class.forName("org.sqlite.JDBC");
        }catch(ClassNotFoundException e){
            throw new IllegalStateException("ドライバのロードに失敗しました. ");
        }

        //データベース接続 & userTable作成
        try {
            con = DriverManager.getConnection("jdbc:sqlite:./DataBase.db");
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return con;
    }

    /**
     * tableNameという名前のtableを作る
     */
    public static final void createTable(String tableName) {
        Connection con = getCon();

        try{
            //インスタンス生成
            Statement stm = con.createStatement();

            //命令をstring変数にべた書き
            String sql = "CREATE TABLE IF NOT EXISTS " + tableName
                        +"("
                        +"   id    INT"
                        +",  title  INT"
                        +",  genre TEXT"
                        +",  state TEXT"
                        +")";
            
            //実行
            stm.executeUpdate(sql);

            //インスタンスリソース解放
            stm.close();
            con.close();
        }catch(SQLException e) {
            e.printStackTrace();
        }
    }
    
    /**
     * tableNameにvaluesの要素を挿入
     * valuesの長さが3か4でない場合はerrorとする
     */
    public static final void insertTable(String tableName, ArrayList<String> data) {
        Connection con = getCon();

        int data_length = data.size();
        
        if (data_length != 2 && data_length != 4){
            System.out.println("Error : 要素の長さが指定の長さではありません.");
            return;
        }

        try{
            String data_value = "";

            if (data_length == 2) {
                data_value = "'" + data.get(0) +"'" + ", " + "CONVERT(INT, CONVERT(VARBINARY(4), NEWID)), " + "'" + data.get(1) + "'";
            }else {
                data_value = data.get(0) + ", " + "'" + data.get(1) + "', " + "'" + data.get(2) + "', "+ "'" + data.get(3) + "'";
            }

            Statement stm = con.createStatement();
            String sql = "INSERT INTO " + tableName + " values(" + data_value + ");";
            stm.executeUpdate(sql);
            stm.close();
            con.close();
        }catch(SQLException e) {
            e.printStackTrace();
        }
    }

    /**
     * tableのtextがvalueである行のcolumnの値をafterに変更
     */
    public static final void updateData(String table, String column, String after, String text, String value){
        Connection con = getCon();

        try {
            Statement stm = con.createStatement();
            String sql = "update " + table + " set " + column + " = '" + after + "' where " + text + " = '"+ value + "';";
            System.out.println(sql);
            stm.executeUpdate(sql);

            stm.close();
            con.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    /**
     * tableを削除
     */
    public static void deleteTable(String table) {
        Connection con = getCon();

        try{
            Statement stm = con.createStatement();
            String sql = "drop table if exists '" + table + "';";
            stm.executeUpdate(sql);

            stm.close();
            con.close();
        }catch(SQLException e){
            e.printStackTrace();
        }
    }

    public static final ArrayList<String> getData(String tableName, String field){
        Connection con = getCon();

        try{
            Statement stm = con.createStatement();
            String sql = "SELECT " + field + " from " + tableName;
            ResultSet rs = stm.executeQuery(sql);

            while (rs.next()) {
                
            }
        }catch(SQLException e) {

        }
        ArrayList<String> rt = new ArrayList<>();
        return rt;
    }
}
