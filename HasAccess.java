import java.util.ArrayList;

public class HasAccess implements CheckAccess{

    //状態変更のメソッド
    public void changeState(String state){

    }

    //カラム追加のメソッド
    public void addColumn(String title, String state){

    }

    //カラム削除のメソッド
    public void deleteColumn(String title){
        
    }

    //作品一覧を返すメソッド
    public ArrayList<String> getList(String state){
        ArrayList<String> list = new ArrayList<>();
        return list;
    }

}