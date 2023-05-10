import java.util.ArrayList;

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
    public void addColumn(String tableName, ArrayList<String> data){
        DB.insertTable(tableName, data);
    }

    //行削除のメソッド
    public void deleteColumn(String title){
    }

    //delete table
    public void deleteTable(String table){
        DB.deleteTable(table);
    }

    /**
     * 作品一覧を返すメソッド
     */
    public ArrayList<String[]> getList(String tableName, String column, String value){
        return DB.getData(tableName, column, value);
    }

}