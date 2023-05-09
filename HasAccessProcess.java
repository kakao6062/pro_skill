import java.util.ArrayList;
import java.sql.*;

public class HasAccessProcess implements Process{

    //状態変更のメソッド
    public void update(String title, String state){
        Connection con = DB.getCon();
        
        try{PreparedStatement ps = con.prepareStatement(
            String.format("UPDATE table SET title = %s WHERE state = %s", title, state));
        }
    }

    //カラム追加のメソッド
    public void addColumn(String title, String state){
        Connection con = DB.getCon();
    }

    //カラム削除のメソッド
    public void deleteColumn(String title){
        Connection con = DB.getCon();
    }

    /**
     * 作品一覧を返すメソッド
     */
    public ArrayList<String> getList(String state){
        ArrayList<String> list = new ArrayList<>();
        return list;
    }

}