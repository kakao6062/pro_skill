import java.util.*;
<<<<<<< HEAD

public class CheckAccess{
=======
import java.sql.*;

public class CheckAccess{
    public boolean check(String username, String pass){
        ArrayList<String> list = DB.getData(username, pass);
    }
>>>>>>> cahe-2
    
}