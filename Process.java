import java.util.ArrayList;

interface Process{
    public void update(String table, String column, String after, String text, String value);

    public void addRow(String tableName, ArrayList<String> data);

    public void deleteRow(String tableName, String column, String value);
    
    public void deleteTable(String table);

    public ArrayList<String[]> getList(String tableName, String column, String value);
}