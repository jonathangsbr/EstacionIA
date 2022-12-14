package objects;

public class Parking {
    private int tipo;
    private boolean ocupado;

    public Parking(int tipo, boolean ocupado){
        this.tipo = tipo;
        this.ocupado = ocupado;
    }

    public int getTipo(){
        return this.tipo;
    }

    public boolean isOcupado(){
        return ocupado;
    }

    @Override
    public String toString() {
        String str = "";
        if(this.tipo == 1){
            str += this.ocupado ? "M" : "-";
        }else if(this.tipo == 2){
            str += this.ocupado ? "C" : "+";
        }else{
            str += this.ocupado ? "T" : "*";
        }
        return "["+str+"]";
    }

    public void setOcupado(boolean ocupied) {
        this.ocupado = ocupied;
    }

    public int getTamanho() {
        if(this.tipo == 1){
            return 2;
        }else if(this.tipo == 2){
            return 6;
        }
        return 10;
    }
}