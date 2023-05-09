import java.util.ArrayList;

class DBTest {
    public static void main(String[] args) {
        String table_name = "hoge";
        DB.deleteTable(table_name);
        DB.createTable(table_name);
        ArrayList<String> hoge = new ArrayList<>();
        hoge.add("1");
        hoge.add("アナ雪");
        hoge.add("kakao");
        hoge.add("視聴済み");
        DB.insertTable(table_name, hoge);
        DB.updateData(table_name, "genre", "hoほほほほほ", "title", "アナ雪");
    }
}