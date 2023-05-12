public class Account {
    String ID;
    String username;
    String pass;//パスワード

    Account(String ID,String username,String pass){
        this.ID=ID;
        this.username=username;
        this.pass=pass;
    }
    /**
     * IDを取得するメソッド
     * @return ID
     */
    public String getID(){
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
     * @param ID 変更するアカウントのID
     * @param NewPass 新しいパスワード
     */
    public void setPass(String NewPass,String ID){
        DB.updateData("user", "pass", NewPass);
    }
}