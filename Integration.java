import java.util.*;

class Integration {
    public static void main(String[] args) {
        Integration integration = new Integration();
        integration.process();
    }

    private String name;
    private String pass;
    private ProcessPattern pp = null;
    private Scanner sc = new Scanner(System.in);

    public void process() {
        int select = 100;
        DB.createTable("user");

        while (select != -1) {
            System.out.println("行いたい処理を入力");
            System.out.println("1: 登録");
            System.out.println("2: ログイン");
            System.out.println("0: 終了");
            
            System.out.print("> ");
            select = sc.nextInt();

            switch (select) {
                case 1: registrationUser();
                        select = -1;        break;
                case 2: login();
                        select = -1;        break;
                case 0:return;
                default:System.out.println("入力が不適です．再入力してください．");
                    break;
            }
        }

        select = 100;

        while(select != -1) {
            System.out.println("行いたい処理を入力");
            System.out.println("1: リストの追加");
            System.out.println("2: リストの更新");
            System.out.println("3: リストの表示");
            System.out.println("4: 視聴状況の更新");
            System.out.println("5: パスワードの更新");
            System.out.println("0: 終了");
            System.out.print("> ");
            select = sc.nextInt();

            switch (select) {
                case 1: add();      break;
                case 2: update();   break;
                case 3: getList();  break;
                case 4: update();   break;
                case 5: setPass();  break;
                case 0: return;
                default:System.out.println("入力が不適です．再入力してください．");
                        break;
            }
        }
    }

    private void registrationUser() {
        int error = -1;
        
        System.out.print("名前を入力 > ");
        name = sc.next();
        System.out.print("パスワードを入力 > ");
        pass = sc.next();

        ArrayList<String> data = new ArrayList<>(Arrays.asList(name, pass));
        error = DB.insertRow("user", data);

        if (error == 0) {
            DB.createTable(name);
            check(name, pass);
            System.out.println("登録完了");
        }else{
            System.out.println("この名前は既に使用されてます．異なる名前にしてください．");
            registrationUser();
        }        
    }

    private void login(){
        System.out.print("名前を入力 > ");
        name = sc.next();
        System.out.print("パスワードを入力 > ");
        pass = sc.next();
        if(check(name, pass)){
            System.out.println("ログイン完了");
            check(name, pass);
        }else{
            System.out.println("パスワードエラー");
            login();
        }
    }

    private boolean check(String username, String pass){
        ArrayList<String[]> data = DB.getData("user", "name", username);
        if (pp == null) {
            pp = new ProcessPattern();
        }

        int passwd_idx = 2;
        if(pass.equals(data.get(0)[passwd_idx])){
            pp.changeToAccess();
            return true;
        }else{
            pp.chageToNoAccess();
            return false;
        }
    }

    private void add() {
        ArrayList<String> data = new ArrayList<>();
        System.out.print("作品名を入力 > ");
        data.add(sc.next());
        System.out.print("ジャンルを入力 > ");
        data.add(sc.next());
        System.out.print("状態を入力 > ");
        data.add(sc.next());

        int error = pp.insertRow(name, data);

        if (error != 0) {
            System.out.println("すでにその作品があるか，アクセス権がありません．");
        }
    }

    /**
     * 視聴状況の更新
     */
    private void update(){
        check(name, pass);
        System.out.print("どの作品について更新するかを入力 > ");
        String key = sc.next();
        System.out.print("変更後の状態を入力 > ");
        String state = sc.next();
        pp.update(name, key, state);
    }

    /**
     * get works list that entered state
     */
    private void getList(){
        check(name, pass);
        System.out.print("取得したいリストの種類を選択\n1: ジャンル\n2: 視聴状況\n> ");
        int choice = sc.nextInt();
        String column;
        if(choice == 1){
            column = "genre";
        } else {
            column = "state";
        }
        System.out.print("作品名を入力 > ");
        String key = sc.next();
        ArrayList<String[]> list = pp.getData(name, column, key);
        for(String[] s : list){
            System.out.println(String.format("%15s %s", s[0], s[choice]));
        }
    }

    private void setPass(){
        check(name, pass);
        System.out.print("更新後のパスワードを入力 > ");
        String after = sc.next();
        pp.update("user", name, after);
    }   
}