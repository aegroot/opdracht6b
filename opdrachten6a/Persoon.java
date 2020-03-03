package opdrachten6a;

import java.util.ArrayList;


public class Persoon{
    private String naam;
    private double budget;
    private ArrayList<Game> games;



    public Persoon(String nm,double bud) {
        this.naam=nm;
        this.budget=bud;
        games = new ArrayList<Game>();

    }

    public double getBudget() {
        return this.budget;
    }
    public boolean koop(Game game){
        if (!(game.huidigewaarde() > budget)||games.contains(game))
        {games.add(game);
        budget-=game.huidigewaarde();
        return true;
    } else {return false;}

    }
    public boolean verkoop(Game g,Persoon p){
        boolean check=false;
        for(Game ga:games){
            if (g.equals(ga)){
                check=true;
            }
        }


        if ((g.huidigewaarde() > p.budget && check) == false){
        p.koop(g);
        games.remove(g);
        budget+=g.huidigewaarde();
        return true;}
        else{
        return false;}

    }
    @Override
    public String toString(){
        String  endString=naam+" heeft een budget van "+budget+" en bezit de volgende games:\n";
        for(Game game:games){
            endString+=game.toString();
        }

        return endString;
    }
}
