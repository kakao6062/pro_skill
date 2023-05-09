import java.util.ArrayList;
import java.sql.*;

public class HasAccessProcess implements Process{

    //状態変更のメソッド
<<<<<<< HEAD
    public void update(String state){

=======
    public void update(String title, String state){
        Connection con = DB.getCon();
        
>>>>>>> cahe-2
    }

    //カラム追加のメソッド
    public void addColumn(String title, String state){
<<<<<<< HEAD

=======
        Connection con = DB.getCon();
        PreparedStatement ps = con.preparedStatement("INSTER INTO table() VALUES");
>>>>>>> cahe-2
    }

    //カラム削除のメソッド
    public void deleteColumn(String title){
<<<<<<< HEAD
        PreparedStatement ps = con.preparedStatement("delete from ");
    }

    //作品一覧を返すメソッド
=======
        PreparedStatement ps = con.preparedStatement("DELETE FROM table WHERE column");
    }

    /**
     * 作品一覧を返すメソッド
     */
>>>>>>> cahe-2
    public ArrayList<String> getList(String state){
        ArrayList<String> list = new ArrayList<>();
        return list;
    }

}