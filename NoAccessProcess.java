import java.util.ArrayList;

public class NoAccessProcess implements Process{
    //singleton
    private static NoAccessProcess process = new NoAccessProcess();
    private NoAccessProcess(){}
    public static NoAccessProcess getProcess() {
        return process;
    }

    void printMsg(){
        System.out.println("アクセス権がありません");
    }

    //状態変更のメソッド
    public void update(String table, String column, String after, String text, String value){
        printMsg();
    }

    //カラム追加のメソッド
    public void addRow(String tableName, ArrayList<String> data){
        printMsg();
    }

    //行削除のメソッド
    public void deleteRow(String tableName, String column, String value){
        printMsg();        
    }
    
    //delete table
    public void deleteTable(String table){
        printMsg();
    }

    //作品一覧を返すメソッド
    public ArrayList<String[]> getList(String tableName, String column, String value){
        printMsg();
        return null;
    }

}