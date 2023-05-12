import java.util.ArrayList;
import java.util.Arrays;

class DBTest {
    public static void main(String[] args) {
        String table_name = "hoge";
        DB.deleteTable(table_name);
        DB.deleteTable("user");
        DB.createTable(table_name);
        DB.createTable("user");

        String name[] = {"hoge", "poyo", "fuga", "jhga", "jaja"};
        String pass[] = {"1", "2", "3", "4", "5"};
        String title[] = {"void", "it", "cats fight", "null", "pega"};
        String genre[] = {"coc", "movie", "movie", "book", "book"};
        String state[] = {"ok", "ok", "ok", "ok", "ng"};

        for (int i = 0; i < 5; i++){
            ArrayList<String> hoge = new ArrayList<>(Arrays.asList(name[i], pass[i]));
            ArrayList<String> fuga = new ArrayList<>(Arrays.asList(title[i], genre[i], state[i]));
            DB.insertRow("user", hoge);
            DB.insertRow(table_name, fuga);
        }
        ArrayList<String[]> hoge = DB.getData("user", "name", "hoge");
        ArrayList<String[]> fuga = DB.getData(table_name, "title", "void");
        
        for (String[] str : hoge) {
            for (String i : str) {
                System.out.print(i + " ");
            }
            System.out.println();
        }        
        for (String[] str : fuga) {
            for (String i : str) {
                System.out.print(i + " ");
            }
            System.out.println();
        }

        DB.updateData("user", "hoge", "nyokinyoki");
        DB.updateData(table_name, "void", "最高");

        
        hoge = DB.getData("user", "name", "hoge");
        fuga = DB.getData(table_name, "title", "void");
        
        for (String[] str : hoge) {
            for (String i : str) {
                System.out.print(i + " ");
            }
            System.out.println();
        }        
        for (String[] str : fuga) {
            for (String i : str) {
                System.out.print(i + " ");
            }
            System.out.println();
        }
    }
}