
public class Account {
    int ID;
    String username;
    String pass;//パスワード

    Account(int ID,String username,String pass){
        this.ID=ID;
        this.username=username;
        this.pass=pass;
    }
    /**
     * IDを取得するメソッド
     * @return ID
     */
    public int getID(){
        return ID;
    }
    /**
     * ユーザー名を取得するメソッド
     * @return username ユーザー名
     */
    public String getUsername(){
        return username;
    }
    /**
     * 設定済みパスワードを取得するメソッド
     * @return pass パスワード
     */
    public String getPass(){
        return pass;
    }
    /**
     * パスワードを設定、変更するメソッド
     * @param newPass 新しいパスワード
     */
    public void setPass(String newPass){
        pass=newPass;
    }
}