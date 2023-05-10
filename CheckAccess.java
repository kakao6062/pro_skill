import java.util.ArrayList;

public class CheckAccess{
    private CheckAccess(){}
    public static void check(String username, String pass){
        ArrayList<String[]> data = DB.getData("user", "name", username);
        // data userID username passwd
        ProcessPattern process = new ProcessPattern();
        int passwd_idx = 2;
        if(pass.equals(data.get(0)[passwd_idx])){
            process.changeToAccess();
            return;
        }
        process.chageToNoAccess();
        return;
    }
}