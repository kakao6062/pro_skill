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

    public void addRow(String tableName, ArrayList<String> data){
        this.process.addRow(tableName, data);
    }

    public void deleteRow(String tableName, String column, String value){
        this.process.deleteRow(tableName, column, value);;
    }
    
    public void deleteTable(String table){
        this.process.deleteTable(table);
    }

    public ArrayList<String[]> getList(String tableName, String column, String value){
        return this.process.getList(tableName, column, value);
    }
}
