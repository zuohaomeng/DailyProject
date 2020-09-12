import java.util.ArrayList;
import java.util.List;

public class Main {
    public static List list = new ArrayList(10);

    public static void main(String[] args) {
    }


    public void get(){
        if(list.size()==0){
            synchronized (list){
                if(list.size()==0){
                    //查数据库
                }
            }
        }else {
            list.get(3);
        }
    }
}
