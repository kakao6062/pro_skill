import java.util.ArrayList;

class CheckAccess{
    public void check(String username, String pass){
        ArrayList<String> data = DB.getData("user", username);
        ProcessPattern process = new ProcessPattern();
        int passwd_idx = ;
        if(pass.equals(data(passwd_idx))){
            process.changeToAccess();
            return;
        }
        process.chageToNoAccess();
    }
}