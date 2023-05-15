import java.util.ArrayList;
import java.util.Arrays;
import java.sql.*;

import org.junit.Test;
import static org.junit.Assert.*;


public class DBTest {
    //テストケース
    static String name[] = {"hoge", "poyo", "fuga", "jhga", "jaja"};
    static String pass[] = {"1", "2", "3", "4", "5"};
    static String title[] = {"void", "it", "cats fight", "null", "pega"};
    static String genre[] = {"coc", "movie", "movie", "book", "book"};
    static String state[] = {"ok", "ok", "ok", "ok", "ng"};
    
    /**
     * getConテスト
     */
    @Test
    public void testGetCon(){
        Connection con = null;
        con = DB.getCon();
        assertNotNull(con);
    }

    /**
     * createTableテスト
     */
    @Test
    public void testCreateTable() {
        DB.createTable("user");
        DB.createTable("hoge");
    }

    /**
     * insertRowテスト
     */
    @Test
    public void testInsertRow() {
        int error_user_test = 0;
        int error_name_test = 0;

        //正常動作テスト
        for (int i = 0; i < 5; i++) {
            ArrayList<String> user_test = new ArrayList<>();
            user_test.add(name[i]);
            user_test.add(pass[i]);
            error_user_test = DB.insertRow("user", user_test);
            
            ArrayList<String> name_test = new ArrayList<>(); 
            name_test.add(title[i]);
            name_test.add(genre[i]);
            name_test.add(state[i]);
            error_name_test = DB.insertRow("hoge", name_test);
        }
        assertEquals(-1, error_user_test);
        assertEquals(-1, error_name_test);

        //異常動作テスト
        ArrayList<String> user_error_test = new ArrayList<>(Arrays.asList("hoge", "password"));
        error_user_test = DB.insertRow("user", user_error_test);
        assertEquals(-1, error_user_test);

        ArrayList<String> name_error_test = new ArrayList<>(Arrays.asList("void", "movie", "hogehoge"));
        error_name_test = DB.insertRow("hoge", name_error_test);
        assertEquals(-1, error_name_test);
    }
    
    /**
     * getDataテスト
     */
    @Test
    public void testGetData() {
        ArrayList<String[]> rt = DB.getData("user", "name", "hoge");
        String[] rt_array = rt.get(0);
        assertEquals("hoge", rt_array[1]);
        assertEquals("1", rt_array[2]);

        rt = DB.getData("hoge", "title", "void");
        rt_array = rt.get(0);
        assertEquals("void", rt_array[0]);
        assertEquals("coc", rt_array[1]);
        assertEquals("ok", rt_array[2]);
    }

    /**
     * updateDataテスト
     */
    @Test
    public void testUpdateData() {
        DB.updateData("user", "hoge", "changepass");
        ArrayList<String[]> rt = DB.getData("user", "name", "hoge");
        String[] rt_array = rt.get(0);
        assertEquals("changepass", rt_array[2]);

        DB.updateData("hoge", "void", "excellent");
        rt = DB.getData("hoge", "title", "void");
        rt_array = rt.get(0);
        assertEquals("excellent", rt_array[2]);
    }

    /**
     * deleteRowテスト
     */
    @Test
    public void testDeleteRow() {
        int before_size = DB.getData("hoge", "state", "ok").size();
        DB.deleteRow("hoge", "title", "it");
        int after_size = DB.getData("hoge", "state", "ok").size();

        assertEquals(1, before_size - after_size);
    }

    /**
     * deleteTableテスト
     */
    @Test
    public void testDeleteTable() {
        DB.deleteTable("user");
        DB.deleteTable("hoge");
    }
}