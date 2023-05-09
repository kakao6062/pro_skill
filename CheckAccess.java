import java.util.ArrayList;

interface CheckAccess{
    public void check(String username, String pass){
        ArrayList<String> data = DB.getData("user", username);
        int passwd_idx;
        if(pass.equals(data(passwd_idx))){
            changePattern(HasAccessProcess);
            return;
        }
        changePattern(NoAccessProcess);
    }
}