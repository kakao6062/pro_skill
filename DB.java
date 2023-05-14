import java.sql.*;
import java.util.ArrayList;
import java.util.UUID;

public final class DB {

    //コンストラクタ (privateにすることでユーザ側のインスタンス生成を防止)
    private DB() {}

    /**
     * conを返す
     * @return con
     */
    public static final Connection getCon() {
        Connection con = null;
        //JDBCドライバロード
        try{
            Class.forName("org.sqlite.JDBC");
        }catch(ClassNotFoundException e){
            throw new IllegalStateException("ドライバのロードに失敗しました. ");
        }

        //データベース接続
        try {
            con = DriverManager.getConnection("jdbc:sqlite:./DataBase.db");
        } catch (SQLException e) {
            e.printStackTrace();
            System.exit(0);
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
            String sql;
            
            //命令をstring変数にべた書き
            if (tableName.equals("user")) {
                sql = "CREATE TABLE IF NOT EXISTS " + tableName
                            +"("
                            +"   id   TEXT"
                            +",  name TEXT UNIQUE"
                            +",  pass TEXT"
                            +")";
            }else{
                sql = "CREATE TABLE IF NOT EXISTS " + tableName
                            +"("
                            +"  title TEXT UNIQUE"
                            +", genre TEXT"
                            +", state TEXT"
                            +")";
            }
            //実行
            stm.executeUpdate(sql);

            //インスタンスリソース解放
            stm.close();
            con.close();
        }catch(SQLException e) {
            e.printStackTrace();
            System.exit(0);
        }
    }
    
    /**
     * tableNameにvaluesの要素を挿入
     * @return {@code 0} no errors {@code -1} error
     */
    public static final int insertRow(String tableName, ArrayList<String> data) {
        Connection con = getCon();

        int data_length = data.size();
        
        if (data_length != 2 && data_length != 3){
            System.out.println("Error : 要素の長さが指定の長さではありません.");
            return -1;
        }

        try{
            String data_value;

            if (data_length == 2) {
                data_value = String.format("'%s', '%s', '%s'", UUID.randomUUID().toString(), data.get(0), data.get(1));
            }else {
                data_value = String.format("'%s', '%s', '%s'", data.get(0), data.get(1), data.get(2));
            }

            Statement stm = con.createStatement();
            String sql = String.format("insert into '%s' values(%s);", tableName, data_value);

            stm.executeUpdate(sql);
            stm.close();
            con.close();
        }catch(SQLException e) {
            return -1;
        }
        return 0;
    }

    /**
     * tableNameのkeyがある行の決められた値をafterに変更<br>
     * <br>
     * keyを次のように設定<br>
     * <br>
     * {@code tableName == user} -> key = nameの任意の値<br>
     * <br>
     * {@code tableName != user} -> key = titleの任意の値
     */
    public static final void updateData(String tableName, String key, String after){
        Connection con = getCon();

        try {
            Statement stm = con.createStatement();
            String sql;
            ArrayList<String[]> data_tmp;

            if (tableName.equals("user")){
                data_tmp = getData(tableName, "name", key);
                sql = String.format("update user set pass = '%s' where name = '%s';", after, data_tmp.get(0)[1]);
            }else{
                data_tmp = getData(tableName, "title", key);
                sql = String.format("update %s set state = '%s' where title = '%s';", tableName, after, data_tmp.get(0)[0]);
            }
            stm.executeUpdate(sql);

            stm.close();
            con.close();
        } catch (Exception e) {
            e.printStackTrace();
            System.exit(0);
        }
    }

    /**
     * tableNameを削除
     */
    public static void deleteTable(String tableName) {
        Connection con = getCon();

        try{
            Statement stm = con.createStatement();
            String sql = String.format("drop table if exists '%s';", tableName);
            stm.executeUpdate(sql);

            stm.close();
            con.close();
        }catch(SQLException e){
            e.printStackTrace();
            System.exit(0);
        }
    }

    /**
     * tableNameのcolumnがvalueである行を削除
     */
    public static final void deleteRow(String tableName, String column, String value) {
        Connection con = getCon();
        try{
            Statement stm = con.createStatement();
            String sql = String.format("DELETE FROM %s WHERE %s = '%s';", tableName, column, value);
            stm.executeUpdate(sql);

            stm.close();
            con.close();
        }catch(SQLException e) {
            e.printStackTrace();
            System.exit(0);
        }
    }

    /**
     * tableNameからcolumnの値がvalueである全要素を取得
     */
    public static final ArrayList<String[]> getData(String tableName, String column, String value){
        Connection con = getCon();
        ArrayList<String[]> rt = new ArrayList<>();

        try{
            Statement stm = con.createStatement();
            String sql = String.format("select * from %s where %s = '%s';", tableName, column, value);
            System.out.println(sql);
            ResultSet rs = stm.executeQuery(sql);

            while(rs.next()) {
                String data_tmp[] = {rs.getString(1), rs.getString(2), rs.getString(3)};
                rt.add(data_tmp);
            }

            stm.close();
            con.close();
        }catch(SQLException e) {
            e.printStackTrace();
            System.exit(0);
        }
        return rt;
    }
}
