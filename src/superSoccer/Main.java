package superSoccer;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {

        // Variables
        int option=0;
        Scanner scanner = new Scanner (System.in);
        boolean flag = true;

        // Header
        System.out.println("\nPractical Work - 18/06/2022");
        System.out.println("JAVA/SPRING Course - " +
                "GLOBAL ACADEMY");
        System.out.println("Author: Chavez José");
        System.out.println("<< Custom developed software by #ChavezDrive >>\n");
        System.out.println("Wellcome to Super Soccer v. 1.0");

        // Menu

        Tournament tournament = new Tournament();

        do{
            System.out.println("\nSelect an option -->\n"

                    +"\t\t\t1. Show all tournament dates\n"
                    +"\t\t\t2. Show the result of a specific date\n"
                    +"\t\t\t3. Show results between two dates\n"
                    +"\t\t\t4. Show number of points, won watches, drawn and lost\n"
                    +"\t\t\t5. Average goals in favour and goals against\n"
                    +"\t\t\t6. Maximum number of goals in favor in a match\n"
                    +"\t\t\t   Minimum number of goals against in a match\n"
                    +"\t\t\t7. Quantity of undefeated fences\n"
                    +"\t\t\t8. Campaign of Team: Bad| Regular| Good| Excellent|\n"
                    +"\t\t\t9. Exit\n"
            );

            option = scanner.nextInt();

            switch(option){

                case 1:{
                    if(tournament==null){
                        System.out.println("===================================="
                                +" You must upload the Tournament. "
                                +"====================================\n");
                        break;
                    }else{
                        System.out.println("===================================="
                                +" All Tournament dates. "
                                +"====================================\n");
                        System.out.println(tournament.toString());
                        break;
                    }
                }
                case 2:{
                    if(tournament==null){
                        System.out.println("===================================="
                                +" You must upload the Tournament. "
                                +"====================================\n");
                        break;
                    }else{
                        int specifiedDate=0;
                        Scanner date = new Scanner(System.in);
                        System.out.println("===================================="
                                +" Result of a specific date "
                                +"====================================\n");
                        System.out.println("¿What date you want to search for?");
                        specifiedDate = date.nextInt();
                        do{
                            if(specifiedDate>0 && specifiedDate<tournament.getMatches().length){
                                tournament.getMatchByDate(specifiedDate);
                                break;
                            }else{
                                System.out.println("Incorrect date");
                                break;
                            }
                        }while(specifiedDate<=tournament.getMatches().length);
                        break;
                    }
                }
                case 3:{
                    if(tournament==null){
                        System.out.println("===================================="
                                +" You must upload the Tournament. "
                                +"====================================\n");
                        break;
                    }else{
                        int start;
                        int end;
                        Scanner fecha = new Scanner(System.in);
                        System.out.println("===================================="
                                +" Show results between two dates "
                                +"====================================\n");
                        System.out.println("Enter the start date:");
                        start = fecha.nextInt();
                        System.out.println("Enter the end date:");
                        end = fecha.nextInt();

                        if(start<end && end<tournament.getMatches().length){
                            tournament.getMatchBetweenTwoDates(start, end);
                            break;
                        }else{
                            System.out.println("The 'start' value must be less than the 'end' value");
                            System.out.println("And the values must be between 1 and " + tournament.getMatches().length );
                            break;
                        }
                    }
                }
                case 4:{
                    if(tournament==null){
                        System.out.println("===================================="
                                +" You must upload the Tournament. "
                                +"====================================\n");
                        break;
                    }else{
                        System.out.println("===================================="
                                +" Quantity of points, won watches, drawn and lost "
                                +"====================================\n");
                        tournament.points();
                        break;
                    }
                }
                case 5:{
                    if(tournament==null){
                        System.out.println("===================================="
                                +" You must upload the Tournament. "
                                +"====================================\n");
                        break;
                    }else{
                        System.out.println("===================================="
                                +" Average goals in favour and goals against "
                                +"====================================\n");
                        tournament.average();
                        break;
                    }
                }
                case 6:{
                    if(tournament==null){
                        System.out.println("===================================="
                                +" You must upload the Tournament. "
                                +"====================================\n");
                        break;
                    }else{
                        System.out.println("===================================="
                                +" Maximum quantity of goals in favor in a match\n"
                                +"\t Minimum quantity of goals against in a match "
                                +"====================================\n");
                        tournament.maxMinGoals();
                        break;
                    }
                }
                case 7:{
                    if(tournament==null){
                        System.out.println("===================================="
                                +" You must upload the Tournament. "
                                +"====================================\n");
                        break;
                    }else{
                        System.out.println("===================================="
                                +" Quantity of undefeated fences "
                                +"====================================\n");
                        tournament.undefeatedFences();
                        break;
                    }
                }
                case 8:{
                    if(tournament==null){
                        System.out.println("===================================="
                                +" You must upload the Tournament. "
                                +"====================================\n");
                        break;
                    }else{
                        System.out.println("===================================="
                                +" Campaign of "
                                +"====================================\n");
                        tournament.campaign();
                        break;
                    }
                }
                case 9:{
                    //Exit of systema
                    System.out.println("===================================="
                            +" Good bye. Coming soon the super footbal 2.0 update! "
                            +"====================================\n");
                    flag = false;
                    break;
                }
                default:{
                    System.out.println("The selected option is incorrect.");
                    break;
                }
            }
        }while(flag!=false);

    }
}