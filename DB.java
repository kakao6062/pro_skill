import java.sql.*;
import java.util.ArrayList;
import java.util.UUID;

public final class DB {

    //コンストラクタ (privateにすることでユーザ側のインスタンス生成を防止)
    private DB() {}

    /**
     * conを返す
     */
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
                            +",  name TEXT"
                            +",  pass TEXT"
                            +")";
            }else{
                sql = "CREATE TABLE IF NOT EXISTS " + tableName
                            +"("
                            +"  title TEXT"
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
     * valuesの長さが2か3でない場合はerrorとする
     */
    public static final void insertTable(String tableName, ArrayList<String> data) {
        Connection con = getCon();

        int data_length = data.size();
        
        if (data_length != 2 && data_length != 3){
            System.out.println("Error : 要素の長さが指定の長さではありません.");
            return;
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
            e.printStackTrace();
            System.exit(0);
        }
    }

    /**
     * tableのtextがvalueである行のcolumnの値をafterに変更
     */
    public static final void updateData(String table, String column, String after, String text, String value){
        Connection con = getCon();

        try {
            Statement stm = con.createStatement();
            String sql = String.format("update %s set %s = '%s' where %s = '%s';", table, column, after, text, value);
            stm.executeUpdate(sql);

            stm.close();
            con.close();
        } catch (Exception e) {
            e.printStackTrace();
            System.exit(0);
        }
    }

    /**
     * tableを削除
     */
    public static void deleteTable(String table) {
        Connection con = getCon();

        try{
            Statement stm = con.createStatement();
            String sql = String.format("drop table if exists '%s';", table);
            stm.executeUpdate(sql);

            stm.close();
            con.close();
        }catch(SQLException e){
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
            ResultSet rs = stm.executeQuery(sql);

            while(rs.next()) {
                String data_tmp[] = {rs.getString(1), rs.getString(2), rs.getString(3)};
                rt.add(data_tmp);
            }
        }catch(SQLException e) {
            e.printStackTrace();
            System.exit(0);
        }
        return rt;
    }
}
