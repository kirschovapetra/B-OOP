package pack1;
public class Datum {
    private int den;
    private int mesiac;
    private int rok;

    Datum(int d, int m, int r){
        if (r<0){
            throw new IllegalArgumentException("nespravny rok");
        }
        else{
            this.rok = r;
        }
        if (m<1 || m>12){
            throw new IllegalArgumentException("nespravny mesiac");
        }
        else{
            this.mesiac = m;
        }
        switch(m){
            case 1:
            case 3:
            case 5:
            case 7:
            case 8:
            case 10:
            case 12:
                if (d<1 || d>31){
                    throw new IllegalArgumentException("nespravny den");
                }
                else{
                    this.den = d;
                }
                break;
            case 2:
                if (d<1 || d>28){
                    throw new IllegalArgumentException("nespravny den");
                }
                else{
                    this.den = d;
                }
                break;
            case 4:
            case 6:
            case 9:
            case 11:
                if (d<1 || d>30){
                    throw new IllegalArgumentException("nespravny rok");
                }
                else{
                    this.den = d;
                }
                break;
        }





    }

    public int getDen() {
        return den;
    }

    public int getMesiac() {
        return mesiac;
    }

    public int getRok() {
        return rok;
    }


}