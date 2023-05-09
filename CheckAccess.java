import java.util.*;
import java.sql.*;

public class CheckAccess{
    public boolean check(String username, String pass){
        ArrayList<String> list = DB.getData(username, pass);
    }
    
}