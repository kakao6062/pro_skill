import java.util.ArrayList;

interface Process{
    public void update(String state);

    public void addColumn(String title, String state);

    public void deleteColumn(String title);

    public ArrayList<String> getList(String state);
}