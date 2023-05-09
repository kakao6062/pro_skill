import java.util.ArrayList;

public class ProcessPattern {
    private Process process = null;

    private void changePattern(Process process){
        this.process = process;
    }

    public void update(String state){
        this.process.update(state);
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
