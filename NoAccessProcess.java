import java.util.ArrayList;

public class NoAccessProcess implements Process{
    void printMsg(){
        System.out.println("アクセス権がありません");
    }

    //状態変更のメソッド
    public void update(String title, String state){
        printMsg();
    }

    //カラム追加のメソッド
    public void addColumn(String title, String state){
        printMsg();
    }

    //カラム削除のメソッド
    public void deleteColumn(String title){
        printMsg();        
    }


    //作品一覧を返すメソッド
    public ArrayList<String> getList(String state){
        printMsg();
        return null;
    }

}