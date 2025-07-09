package data;

public class Load implements Data{
    private final SaveLoad saveload;

    public Load(SaveLoad saveload){
        this.saveload = saveload;
    }

    @Override
    public void executar() {
        saveload.load();
    }
}
