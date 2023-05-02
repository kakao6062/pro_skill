import java.sql.*;
import java.util.ArrayList;

public class Access implements HasAccess{
    private HasAccess access = null;
    
    //状態変更のメソッド
    public void changeState(String state){

    }

    //カラム追加のメソッド
    public void addColumn(String title, String state){

    }

    //カラム削除のメソッド


    //作品一覧を返すメソッド
    public ArrayList getList(String state){
        ArrayList list = new ArrayList<>();
        return list;
    }

    //パスワード照合

}