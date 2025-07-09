package data1;

public class Save implements Data{
    private SaveLoad saveload;

    public Save(SaveLoad saveload){
        this.saveload = saveload;
    }

    @Override
    public void executar() {
        saveload.save();
    }
}
