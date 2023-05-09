import java.util.ArrayList;

class DBTest {
    public static void main(String[] args) {
        String table_name = "hoge";
        DB.createTable(table_name);
        ArrayList<String> hoge = new ArrayList<>();
        hoge.add("1");
        hoge.add("2");
        hoge.add("kakao");
        hoge.add("1234");
        DB.insertTable(table_name, hoge);
    }
}