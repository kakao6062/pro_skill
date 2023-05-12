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

    /**
     * 視聴状況の更新
     */
    public void update(){
        Scanner sc = new Scanner(System.in);
        String username = checkAccess();
        ProcessPattern pro = new ProcessPattern();
        System.out.println("更新内容を入力");
        String after = sc.next();
        String id = pro.getData("user", "name", username).get(0)[0];
        pro.update(id, "state", after);
    }

    /**
     * get works list that entered state
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
        Scanner sc = new Scanner(System.in);
        String username = checkAccess();
        ProcessPattern pro = new ProcessPattern();
        System.out.println("更新内容を入力");
        String after = sc.next();
        pro.update("user", "pass", after);
    }
}
