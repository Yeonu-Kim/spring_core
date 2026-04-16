package wafflestudio.wapang.singleton;

public class SingletonService {
    private static final SingletonService instance = new SingletonService();
    public static  SingletonService getInstance() {
        return instance;
    }
    private SingletonService () {};
    public void somethingLogic() {
        System.out.println("어쩌구 로직");
    }
}
