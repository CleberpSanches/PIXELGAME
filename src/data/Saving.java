package data;

public class Saving {
    private Data data;
    public Saving(Data data) {
        this.data = data;
    }
    public void saving() {
        data.executar();
    }
}
