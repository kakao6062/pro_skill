import java.util.ArrayList;

interface Process{
    public void update(String table, String column, String after, String text, String value);

    public void addColumn(String title, String state);

    public void deleteColumn(String title);

    public ArrayList<String> getList(String state);
}