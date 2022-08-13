package superSoccer;

import java.util.Scanner;
public class Tournament {

    //Attributes
    private String nameTournament;
    //private String[] teams;
    private Match[] matches;

    public Tournament() {

        Scanner scanner = new Scanner (System.in);

        System.out.println("\nEnter the name of the tournament: ");
        String tournamentName = scanner.nextLine();
        //System.out.println(tournamentName);

        System.out.println("Enter your team name: ");
        String teamLocal = scanner.nextLine();
        //System.out.println(teamName);

        System.out.println("Enter the quantity of teams: ");
        int teamsQuantity = scanner.nextInt();
        //System.out.println(teamsQuantity);

        this.nameTournament = tournamentName;
        this.matches = new Match[teamsQuantity];

        for (int i = 1; i < teamsQuantity; i++) {

            String visit = RandomData.getFullNameTeam();
            int localGoals = RandomData.getIntBetween(0,6);
            int visitGoals = RandomData.getIntBetween(0,6);
            matches[i] = new Match(teamLocal, visit, localGoals, visitGoals, i);

        }
        System.out.println("===================================="
                +" The Tournament has been loaded. "
                +"====================================\n");

    }


    // Constructor with params

    public Tournament(String nameTournament, Match[] matches) {
        this.nameTournament = nameTournament;
        this.matches = matches;
    }

    //Getters y Setters

    public String getNameTournament() {
        return nameTournament;
    }

    public void setNameTournament(String nameTournament) {
        this.nameTournament = nameTournament;
    }

    public Match[] getMatches() {
        return matches;
    }

    public void setMatches(Match[] matches) {
        this.matches = matches;
    }

    //Methods


    @Override
    public String toString() {
        String message = "";
        for (int i = 1; i < (matches.length); i++){
            message += matches[i].toStringEnhanced() + "\n";
            message+="===========================\n";
        }
        return "Tournament: " + nameTournament +"\n___________________________\n\n" + message;
    }

    public Match getMatchByDate(int f){
        System.out.println(matches[f].toStringEnhanced());
        return matches[f];
    }

    public Match getMatchBetweenTwoDates(int start, int end ){

        for(int i = start; i <= end; i++){
            System.out.println(matches[i].toStringEnhanced());
        }
        int i=0;
        return matches[i];
    }

    public void points(){

        String message = "";

        int localGoals;
        int visitGoals;
        int acc_wm=0;
        int acu_tm=0;
        int quantity_wm=0;
        int quantity_tm=0;
        int quantity_lm=0;
        int totalPoints;

        for(int i = 1; i < matches.length; i++){

            localGoals = matches[i].getLocalGoals();
            visitGoals = matches[i].getVisitGoals();

            if(localGoals>visitGoals){
                acc_wm+=3;
                quantity_wm+= 1;
            }
            else if(localGoals<visitGoals){
                quantity_lm+= 1;
            }
            else{
                quantity_tm+= 1;
                acu_tm+=1;
            }
        }
        totalPoints = acc_wm + acu_tm;

        message += "Points: "+totalPoints+"\n";
        message += "Quantity of won matches: "+quantity_wm +"\n";
        message += "Quantity of tied matches: "+quantity_tm+"\n";
        message += "Quantity of lost matches: "+quantity_lm+"\n";
        System.out.println(message);
    }

    public void average(){
        int accGoalsInFavour = 0;
        int accGoalsagainst = 0;

        float avgFavour=0;
        float avgAgainst=0;

        String message = "";
        for(int i=1; i < matches.length; i++){
            accGoalsInFavour+=matches[i].getLocalGoals();
            accGoalsagainst+=matches[i].getVisitGoals();
        }
        avgFavour=(float) accGoalsInFavour/matches.length;
        avgAgainst=(float) accGoalsagainst/matches.length;
        message += "Total goals in favour: "+accGoalsInFavour+"\n";
        message += "Total goals against: "+accGoalsagainst+"\n";
        System.out.println(message);
        System.out.println(String.format("Average goals in favour: %.2f", avgFavour));
        System.out.println(String.format("Average goals against: %.2f", avgAgainst));
    }

    public void maxMinGoals(){
        int mayFG=0;
        int minAG=100;
        String message="";

        for(int i = 1; i < matches.length; i++){
            if(matches[i].getLocalGoals()>mayFG)
                mayFG=matches[i].getLocalGoals();
            if(matches[i].getVisitGoals()<minAG)
                minAG=matches[i].getVisitGoals();
        }
        message += "Maximum quantity of goals in favor in a match: "+mayFG+"\n";
        message += "Minimum quantity of goals against in a match: "+minAG+"\n";
        System.out.println(message);
    }

    public void undefeatedFences(){
        int quantity_uf=0;
        for(int i = 1; i < matches.length; i++){
            if(matches[i].getVisitGoals()==0)
                quantity_uf++;
        }
        System.out.println("The quantity of undefeated fences is: "+quantity_uf);
    }

    public void campaign(){
        int max = matches.length * 3;
        int totalPoints;
        int localGoals;
        int visitGoals;
        int quantity_wm = 0;
        int quantity_tm = 0;

        String campaign="";

        for(int i = 1; i < matches.length; i++){

            localGoals = matches[i].getLocalGoals();
            visitGoals = matches[i].getVisitGoals();

            if(localGoals>visitGoals){
                quantity_wm++;
            }
            else if(localGoals==visitGoals){
                quantity_tm++;
            }
        }
        totalPoints=(quantity_wm*3) + (quantity_tm*1);

        if(totalPoints>=0 && totalPoints<(max * 0.25))
            campaign="BAD";
        else if(totalPoints>=(max * 0.25) && totalPoints<(max * 0.50))
            campaign="REGULAR";
        else if (totalPoints>=(max * 0.50) && totalPoints<(max * 0.75))
            campaign="GOOD";
        else if   (totalPoints>=(max * 0.75) && totalPoints<max)
            campaign="EXCELLENT";

        System.out.println("Of the " + max + " possible points, " + "obtained " + totalPoints +" points.");
        System.out.println("The campaign was "+ campaign+"\n");
    }
}
