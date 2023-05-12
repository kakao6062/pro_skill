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

    public void update(String table, String key, String after){
        printMsg();
    }

    //delete table
    public void deleteTable(String table){
        printMsg();
    }
    
    public void deleteRow(String tableName, String column, String value){
        printMsg();        
    }

    public ArrayList<String[]> getData(String tableName, String column, String value){
        printMsg();
        return null;
    }
    
    public void insertRow(String tableName, ArrayList<String> data){
        printMsg();
    }

    public void setPass(String NewPass,String ID){
        printMsg();
    }
}