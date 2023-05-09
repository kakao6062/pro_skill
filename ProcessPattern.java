import java.util.ArrayList;

public class ProcessPattern {
    private Process process = null;

    public void changePattern(Process process){
        this.process = process;
    }

    public void update(String table, String column, String after, String text, String value){
        this.process.update(table, column, after, text, value);
    }

    public void addColumn(String title, String state){
        this.process.addColumn(title, state);
    }

    public void deleteColumn(String title){
        this.process.deleteColumn(title);
    }

    public ArrayList<String> getList(String state){
        return this.process.getList(state);
    }
}
