import java.util.ArrayList;

interface CheckAccess{
    public void changeState(String state);

    public void addColumn(String title, String state);

    public ArrayList<String> getList(String state);
}