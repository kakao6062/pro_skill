import java.util.ArrayList;
import java.util.Arrays;

class DBTest {
    public static void main(String[] args) {
        String table_name = "hoge";
        DB.deleteTable(table_name);
        DB.deleteTable("user");
        DB.createTable(table_name);
        DB.createTable("user");
        int count = 0;
        while(count++ < 5){
            ArrayList<String> hoge = new ArrayList<>(Arrays.asList("hoge", String.format("%d", count)));
            DB.insertTable("user", hoge);
        }
        ArrayList<String[]> hoge = DB.getData("user", "name", "hoge");

        for (String[] i:hoge){
            for (String str:i) {
                System.out.print(str + " ");
            }
            System.out.println();
        }
        System.out.println();

        DB.deleteLow("user", "pass", "1");

        hoge = DB.getData("user", "name", "hoge");
        for (String[] i:hoge){
            for (String str:i) {
                System.out.print(str + " ");
            }
            System.out.println();
        }
    }
}