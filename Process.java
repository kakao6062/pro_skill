import java.util.ArrayList;

interface Process{
<<<<<<< HEAD
    public void update(String state);
=======
    public void update(String title, String state);
>>>>>>> cahe-2

    public void addColumn(String title, String state);

    public void deleteColumn(String title);

    public ArrayList<String> getList(String state);
}