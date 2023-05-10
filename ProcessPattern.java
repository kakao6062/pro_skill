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

    public void addColumn(String tableName, ArrayList<String> data){
        this.process.addColumn(tableName, data);
    }

    public void deleteColumn(String title){
        this.process.deleteColumn(title);
    }
    
    public void deleteTable(String table){
        this.process.deleteTable(table);
    }

    public ArrayList<String[]> getList(String tableName, String column, String value){
        return this.process.getList(tableName, column, value);
    }
}
