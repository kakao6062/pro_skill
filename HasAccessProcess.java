import java.util.ArrayList;
import java.sql.*;

public class HasAccessProcess implements Process{
    //singleton
    private static HasAccessProcess process = new HasAccessProcess();
    private HasAccessProcess(){}
    public static HasAccessProcess getProcess() {
        return process;
    }

    //状態変更のメソッド
    public void update(String table, String column, String after, String text, String value){
        DB.updateData(table, column, after, text, value);
    }

    //カラム追加のメソッド
    public void addColumn(String title, String state){
    }

    //カラム削除のメソッド
    public void deleteColumn(String title){
    }

    /**
     * 作品一覧を返すメソッド
     */
    public ArrayList<String> getList(String state){
        return DB.getData();
    }

}