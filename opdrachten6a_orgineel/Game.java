package opdrachten6a_orgineel;

import java.time.LocalDate;

public class Game{
    private String naam;
    private int releasejaar;
    private double niewprijs;

    public Game(String nm ,int rj,double nwpr){
        this.naam=nm;
        this.niewprijs=nwpr;
        this.releasejaar=rj;
    }
    public double huidigewaarde(){
        int jaar= LocalDate.now().getYear();
        int jdiff=jaar-releasejaar;
        if (jdiff==0)
            return niewprijs;
        else
            return niewprijs*(1-Math.pow(0.3,jdiff));
    }

    public String getNaam() {
        return naam;
    }

    public int getReleasejaar() {
        return releasejaar;
    }
    @Override
    public boolean equals(Object o){
        boolean gelijk=false;
       if (o instanceof Game){
           if (this.niewprijs == ((Game) o).niewprijs&&
                   this.naam.equals(((Game) o).naam)&&
                   this.releasejaar==((Game) o).releasejaar) {
               gelijk=true;

           }


       }
        return gelijk;
    }
    @Override
    public String toString(){
        return naam+", uitgegeven in "+releasejaar+": niewprijs: "+niewprijs+" nu voor: "+huidigewaarde()+"\n";
    }
}
