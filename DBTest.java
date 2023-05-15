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

    @Test
    public void testInsertRow() {
        DB.insertRow(null, null);
    }
    
}