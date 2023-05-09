import java.util.ArrayList;
import java.util.Arrays;

class DBTest {
    public static void main(String[] args) {
        String table_name = "hoge";
        DB.deleteTable(table_name);
        DB.createTable(table_name);
        DB.createTable("user");
        ArrayList<String> hoge = new ArrayList<>(Arrays.asList("アナ雪", "映画", "視聴済み"));
        ArrayList<String> fuga = new ArrayList<>(Arrays.asList("kakao", "12345"));
        DB.insertTable("user", fuga);
        DB.insertTable(table_name, hoge);
        DB.updateData(table_name, "genre", "hoほほほほほ", "title", "アナ雪");
    }
}