import java.util.ArrayList;

interface Process{
    public void update(String table, String key, String after);

    public void deleteTable(String table);

    public void deleteRow(String tableName, String column, String value);

    public ArrayList<String[]> getData(String tableName, String column, String value);

    public void insertRow(String tableName, ArrayList<String> data);

    public void setPass(String NewPass,String ID);
}