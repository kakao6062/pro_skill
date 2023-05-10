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
            ArrayList<String> hoge = new ArrayList<>(Arrays.asList(String.format("%d", count-1), String.format("%d", count)));
            ArrayList<String> fuga = new ArrayList<>(Arrays.asList("fuga", "hoge", String.format("%d", count)));
            DB.insertRow("user", hoge);
            DB.insertRow(table_name, fuga);
        }
        ArrayList<String[]> hoge = DB.getData("user", "name", "0");

        for (String[] str : hoge) {
            for (String i : str) {
                System.out.print(i + " ");
            }
            System.out.println();
        }
        DB.updateData("user", "4000", "name", "0");
        hoge = DB.getData("user", "name", "0");

        for (String[] str : hoge) {
            for (String i : str) {
                System.out.print(i + " ");
            }
            System.out.println();
        }
    }
}