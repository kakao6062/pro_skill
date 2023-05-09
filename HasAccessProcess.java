import java.util.ArrayList;
import java.sql.*;

public class HasAccessProcess implements Process{

    //状態変更のメソッド
    public void update(String title, String state){
        Connection con = DB.getCon();
        
    }

    //カラム追加のメソッド
    public void addColumn(String title, String state){
        Connection con = DB.getCon();
        PreparedStatement ps = con.preparedStatement("INSTER INTO table() VALUES");
    }

    //カラム削除のメソッド
    public void deleteColumn(String title){
        PreparedStatement ps = con.preparedStatement("DELETE FROM table WHERE column");
    }

    /**
     * 作品一覧を返すメソッド
     */
    public ArrayList<String> getList(String state){
        ArrayList<String> list = new ArrayList<>();
        return list;
    }

}