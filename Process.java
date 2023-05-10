import java.util.ArrayList;

interface Process{
    public void update(String table, String column, String after, String text, String value);

    public void addColumn(String tableName, ArrayList<String> data);

    public void deleteColumn(String title);
    
    public void deleteTable(String table);

    public ArrayList<String[]> getList(String tableName, String column, String value);
}