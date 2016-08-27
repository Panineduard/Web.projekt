package Servise;

        import model.Flat.Adress;

        import java.util.HashMap;
        import java.util.Map;

/**
 * Created by Эдуард on 06.08.15.
 */
public class Storage {
    private Map storage;

    private static class InstanceHolder {
        private static final Storage instance = new Storage();
    }

    public static Storage getInstance() {
        return InstanceHolder.instance;
    }

    private Storage() {
        this.storage = new HashMap<Integer,Adress>();
    }

    public void putToStorage(Object id, Object value) {
        this.storage.put(id, value);
    }

    public <T> T getById(Object id) throws ClassCastException{
        return (T) this.storage.get(id);
    }
}

