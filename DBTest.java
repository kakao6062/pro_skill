import java.util.ArrayList;
import java.util.Arrays;

class DBTest {
    public static void main(String[] args) {
        String table_name = "hoge";
        DB.deleteTable(table_name);
        DB.createTable(table_name);
        DB.createTable("user");
        int count = 0;
        while(count++ < 5){
            ArrayList<String> hoge = new ArrayList<>(Arrays.asList("アナ雪", "映画", "視聴済み"));
            DB.insertTable(table_name, hoge);
        }
        ArrayList<String[]> hoge = DB.getData(table_name, "title", "アナ雪");

        for (String[] i:hoge){
            for (String str:i) {
                System.out.print(str + " ");
            }
            System.out.println();
        }
    }
}