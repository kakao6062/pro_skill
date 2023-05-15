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

    /**
     * 対話処理本体
     */
    public void process() {
        int select;
        boolean flag = true;
        DB.createTable("user");

        while (flag) {
            System.out.println("行いたい処理を入力");
            System.out.println("1: 登録");
            System.out.println("2: ログイン");
            System.out.println("0: 終了");
            
            System.out.print("> ");
            select = sc.nextInt();
            System.out.println();

            switch (select) {
                case 1: registrationUser();
                        flag = false;        break;
                case 2: login();
                        flag = false;        break;
                case 0:return;
                default:System.out.println("入力が不適です．再入力してください．");
                    break;
            }
            System.out.println();
        }
        flag = true;
        while(flag) {
            System.out.println("行いたい処理を入力");
            System.out.println("1: リストの追加");
            System.out.println("2: リストの更新");
            System.out.println("3: リストの表示");
            System.out.println("4: 視聴状況の更新");
            System.out.println("5: パスワードの更新");
            System.out.println("0: 終了");
            System.out.print("> ");
            select = sc.nextInt();
            System.out.println();

            switch (select) {
                case 1: add();       break;
                case 2: update();    break;
                case 3: getList();   break;
                case 4: update();    break;
                case 5: setPass();   break;
                case 0: return;
                default:System.out.println("入力が不適です．再入力してください．");
                        break;
            }
            System.out.println();
        }
    }

    /**
     * ユーザ登録を行う
     */
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

    /**
     * 登録済みユーザのログインを行う
     */
    private void login(){
        System.out.print("名前を入力 > ");
        name = sc.next();
        System.out.print("パスワードを入力 > ");
        pass = sc.next();
        if(check(name, pass)){
            System.out.println("ログイン完了");
            check(name, pass);
        }else{
            login();
        }
    }

    private boolean check(String username, String pass){
        ArrayList<String[]> data = DB.getData("user", "name", username);
        if (pp == null) {
            pp = new ProcessPattern();
        }
        if(data.size()==0){
            System.out.println("そのような名前は登録されていません");
            return false;
        }
        int passwd_idx = 2;
        if(pass.equals(data.get(0)[passwd_idx])){
            pp.changeToAccess();
            return true;
        }else{
            pp.chageToNoAccess();
            System.out.println("パスワードエラー");
            return false;
        }
    }

    /**
     * 視聴リストに項目を追加する
     */
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
     * 視聴リストの表示
     */
    private void getList(){
        check(name, pass);
        System.out.print("取得したいリストの種類を選択\n1: ジャンル\n2: 視聴状況\n> ");
        int choice = sc.nextInt();
        System.out.println();
        String column;
        if(choice == 1){
            column = "genre";
        } else {
            column = "state";
        }
        System.out.print("ジャンルまたは視聴状況を入力 > ");
        String key = sc.next();
        System.out.println();
        ArrayList<String[]> list = pp.getData(name, column, key);
        for(String[] s : list){
            System.out.println(String.format("%15s %s", s[0], s[choice]));
        }
    }

    /**
     * パスワード更新
     */
    private void setPass(){
        check(name, pass);
        System.out.print("更新後のパスワードを入力 > ");
        String after = sc.next();
        pp.update("user", name, after);
    }   
}