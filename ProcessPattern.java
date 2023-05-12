import java.util.ArrayList;

public class ProcessPattern {
    private Process process = null;

    public ProcessPattern(){}

    public void changeToAccess(){
        this.process = HasAccessProcess.getProcess();
    }

    public void chageToNoAccess(){
        this.process = NoAccessProcess.getProcess();
    }

    public void update(String table, String column, String after, String text, String value){
        this.process.update(table, column, after, text, value);
    }

    public void deleteTable(String table){
        this.process.deleteTable(table);
    }

    public void deleteRow(String tableName, String column, String value){
        this.process.deleteRow(tableName, column, value);;
    }

    public ArrayList<String[]> getData(String tableName, String column, String value){
        return this.process.getData(tableName, column, value);
    }

    public void insertRow(String tableName, ArrayList<String> data){
        this.process.insertRow(tableName, data);
    }

    

    public void setPass(String NewPass,String ID){
        this.process.setPass(NewPass, ID);
    }
}
