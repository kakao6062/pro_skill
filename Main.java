import java.util.*;

public class Main{
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        DB.createTable("user");

    }

    /**
     * method that check have access
     * @return String username
     */
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
        pro.update(, , );
    }

    /**
     * get works list that entered state
     * @return 
     */
    public void getList(){
        Scanner sc = new Scanner(System.in);
        String username = checkAccess();
        ProcessPattern pro = new ProcessPattern();
        String id = pro.getData("user", "name", username).get(0)[0];
        System.out.println("取得したいリストの種類を選択\n1: ジャンル\n2: 視聴状況");
        int choice = sc.nextInt();
        String column;
        if(choice == 1){
            column = "genre";
        } else {
            column = "state";
        }
        System.out.println("対象を入力");
        String key = sc.next();
        ArrayList<String[]> list = pro.getData(id, column, key);
        for(String[] s : list){
            System.out.println(String.format("%15s %s", s[0], s[choice]));
        }
    }

    public void setPass(){

    }
}
