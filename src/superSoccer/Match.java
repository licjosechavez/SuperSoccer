package superSoccer;

public class Match {

    //Attributes
    private String local;
    private String visit;
    private int localGoals;
    private int visitGoals;
    private int date;

    // Constructor without params
    public Match() {

    }

    // Constructor with params
    public Match(String local, String visit, int localGoals, int visitGoals, int date) {
        this.local = local;
        this.visit = visit;
        this.localGoals = localGoals;
        this.visitGoals = visitGoals;
        this.date = date;
    }

    // Getters y Setters
    public String getLocal() {
        return local;
    }

    public void setLocal(String local) {
        this.local = local;
    }

    public String getVisit() {
        return visit;
    }

    public void setVisit(String visit) {
        this.visit = visit;
    }

    public int getLocalGoals() {
        return localGoals;
    }

    public void setLocalGoals(int localGoals) {
        this.localGoals = localGoals;
    }

    public int getVisitGoals() {
        return visitGoals;
    }

    public void setVisitGoals(int visitGoals) {
        this.visitGoals = visitGoals;
    }

    public int getDate() {
        return date;
    }

    public void setDate(int date) {
        this.date = date;
    }

    //Methods

    @Override
    public String toString() {
        String message = "";
        message+= "Local:" + local + "\n";
        message+= "Visit:" + visit + "\n";
        message+= "Local goals:" + localGoals + "\n";
        message+= "Visit goals:" + visitGoals + "\n";
        message+= "Date Nº:" + date + "\n";

        return message;
    }

    public String toStringEnhanced(){
        String messageEnhanced = "";
        messageEnhanced+= "Date Nª: " + date + "\n";
        messageEnhanced+= local + ": " + localGoals + " VS " + visit + ": " + visitGoals + "\n";

        return messageEnhanced;
    }
}