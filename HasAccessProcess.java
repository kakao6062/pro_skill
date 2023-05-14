import java.util.ArrayList;

public non-sealed class HasAccessProcess implements Process{
    //singleton
    private static HasAccessProcess process = new HasAccessProcess();
    private HasAccessProcess(){}
    public static HasAccessProcess getProcess() {
        return process;
    }

    //状態変更のメソッド
    public void update(String table, String after, String column){
        DB.updateData(table, after, column);
    }

    //カラム追加のメソッド
    public void insertRow(String tableName, ArrayList<String> data){
        DB.insertRow(tableName, data);
    }

    //行削除のメソッド
    public void deleteRow(String tableName, String column, String value){
        DB.deleteRow(tableName, column, value);
    }

    //delete table
    public void deleteTable(String table){
        DB.deleteTable(table);
    }

    /**
     * 情報を返すメソッド
     */
    public ArrayList<String[]> getData(String tableName, String column, String value){
        return DB.getData(tableName, column, value);
    }

    /**
     * パスワードを設定、変更するメソッド
     * @param ID 変更するアカウントのID
     * @param NewPass 新しいパスワード
     */
    public void setPass(String NewPass,String ID){
        DB.updateData("user", NewPass, "pass");
    }
}