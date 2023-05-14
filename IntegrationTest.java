import java.io.InputStream;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import static org.junit.Assert.*;
import java.io.BufferedReader;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.PrintStream;
import java.io.StringReader;

public class IntegrationTest {
    // public static void main(String[] args) {
    //     DB.deleteTable("user");
    //     Integration ig = new Integration();
    //     ig.process();
    // }
    private StandardInputStream in = new StandardInputStream();
    private StandardOutputStream out = new StandardOutputStream();
    @Before
    public void before(){
        System.setIn(in);
        System.setOut(out);
    }

    @After
    public void after(){
        System.setIn(null);
        System.setOut(null);
    }

    @Test public void integrationTest(){
        Integration integration = new Integration();
        assertEquals(out.readLine(), "testmsg");
        // in.inputln("1");
        // assertEquals(out.readLine(), "入力が不適です．再入力してください．");
        // in.inputln("a");
    }
}

class StandardInputStream extends InputStream {
    private StringBuilder sb = new StringBuilder();
    private String lf = System.getProperty("line.separator");

    /**
     * 文字列を入力する。改行は自動的に行う
     * @param str 入力文字列
     */
    public void inputln(String str){
        sb.append(str).append(lf);
    }

    @Override
    public int read() {
        if (sb.length() == 0) return -1;
        int result = sb.charAt(0);
        sb.deleteCharAt(0);
        return result;
    }
}

class StandardOutputStream extends PrintStream {
    private BufferedReader br = new BufferedReader(new StringReader(""));

    public StandardOutputStream() {
        super(new ByteArrayOutputStream());
    }

    /**
     * 1行分の文字列を読み込む
     * @return 改行を含まない文字。終端の場合はnull
     */
    public String readLine() {
        String line = "";
        try {
            if ((line = br.readLine()) != null) return line;
            br = new BufferedReader(new StringReader(out.toString()));
            ((ByteArrayOutputStream) out).reset();
            return br.readLine();
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
}