import java.util.HashMap;

public class BrowserHistory_1472 {
    int now = 0;
    HashMap<Integer,String> history;
    public BrowserHistory_1472(String homepage) {
        history = new HashMap<>();
        history.put(0,homepage);
    }

    public void visit(String url) {
        now++;
        history.put(now,url);
        int flag = now + 1;
        while(history.containsKey(flag)){
            history.remove(flag);
            flag++;
        }
    }

    public String back(int steps) {
        if(steps > now){
            now = 0;
            return history.get(0);
        }else{
            now = now - steps;
            return history.get(now);
        }
    }

    public String forward(int steps) {
        if(history.containsKey(steps + now)){
            now = now + steps;
            return history.get(now);
        }else{
            now = history.size()-1;
            return history.get(now);
        }
    }
}
