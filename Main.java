import java.util.*;

public class Main{
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        DB.createTable("user");

    }

    public String checkAccess(){
        Scanner sc = new Scanner(System.in);
        String username = sc.next();
        String pass = sc.next();
        CheckAccess.check(username, pass);
        return username;
    }

    public void createTable(){
        Scanner sc = new Scanner(System.in);
        String table = sc.next();
        DB.createTable(table);
    }

    public void update(){
        Scanner sc = new Scanner(System.in);
        String username = checkAccess();
        ProcessPattern pro = new ProcessPattern();
        ArrayList<String[]> data = pro.getData("user", "name", username);
        //tableのtitleがvalueである行のcolumnの値をafterに変更
        String title = sc.next();
        pro.update(, , , , );
    }

    public void getList(){

    }

    public void setPass(){

    }
}
