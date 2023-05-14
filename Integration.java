import java.util.*;

class Integration {
    private String name;
    private String pass;
    private ProcessPattern pp = null;

    public void process() {
        int select = 100;
        DB.createTable("user");
        Scanner sc = new Scanner(System.in);

        while (select != 0) {
            System.out.println("行いたい処理を入力");
            System.out.println("1: 登録");
            System.out.println("2: ログイン");
            System.out.println("0: 終了");
            
            System.out.print("> ");
            select = sc.nextInt();

            switch (select) {
                case 1:registrationUser();  break;
                case 2:login();             break;
                case 0:return;
                default:System.out.println("入力が不適です．再入力してください．");
                    break;
            }
        }

        select = 100;

        while(select != 0) {
            System.out.println("行いたい処理を入力");
            System.out.println("1: リストの更新");
            System.out.println("2: リストの表示");
            System.out.println("3: 視聴状況の更新");
            System.out.println("4: パスワードの更新");
            System.out.println("0: 終了");
            System.out.println("> ");
            select = sc.nextInt();

            switch (select) {
                case 1:update();    break;
                case 2:getList();   break;
                case 3:update();    break;
                case 4:setPass();   break;
                default:System.out.println("入力が不適です．再入力してください．");
                    break;
            }
        }
    }

    private void registrationUser() {
        Scanner sc = new Scanner(System.in);
        System.out.print("名前を入力 > ");
        name = sc.next();
        System.out.print("パスワードを入力 > ");
        pass = sc.next();

        ArrayList<String> data = new ArrayList<>(Arrays.asList(name, pass));
        DB.insertRow("user", data);
        DB.createTable(name);

        System.out.println("登録完了");
    }

    private void login(){
        Scanner sc = new Scanner(System.in);
        System.out.print("名前を入力 > ");
        name = sc.next();
        System.out.print("パスワードを入力 > ");
        pass = sc.next();
        check(name, pass);

        System.out.println("ログイン完了");
    }

    private void check(String username, String pass){
        ArrayList<String[]> data = DB.getData("user", "name", username);
        if (pp == null) {
            pp = new ProcessPattern();
        }

        int passwd_idx = 2;
        if(pass.equals(data.get(0)[passwd_idx])){
            pp.changeToAccess();
        }else{
            pp.chageToNoAccess();
        }
    }

    /**
     * 視聴状況の更新
     */
    private void update(){
        Scanner sc = new Scanner(System.in);
        check(name, pass);
        System.out.print("どの作品について更新するかを入力 > ");
        String key = sc.next();
        System.out.print("変更後の状態を入力 > ");
        String state = sc.next();
        String id = pp.getData("user", "name", name).get(0)[0];
        pp.update(id, key, state);
    }

    /**
     * get works list that entered state
     */
    private void getList(){
        Scanner sc = new Scanner(System.in);
        check(name, pass);
        String id = pp.getData("user", "name", name).get(0)[0];
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
        ArrayList<String[]> list = pp.getData(id, column, key);
        for(String[] s : list){
            System.out.println(String.format("%15s %s", s[0], s[choice]));
        }
    }

    private void setPass(){
        Scanner sc = new Scanner(System.in);
        check(name, pass);
        System.out.print("更新後のパスワードを入力 > ");
        String after = sc.next();
        pp.update("user", name, after);
    }   
}