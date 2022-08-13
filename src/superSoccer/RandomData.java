package superSoccer;

public class RandomData
{
    private static String NamesH[] = {"Juan", "José", "Pablo", "Marcelo", "Mario", "Pedro", "Fabián", "Marcos", "Julio", "Roberto"};
    private static String NamesW[] = {"María", "Silvana", "Mónica", "Natalia", "Valentina", "Cecilia", "Sofía", "Eugenia", "Florencia", "Bárbara"};
    private static String Surnames[] = {"Pérez", "Rodriguez", "López", "Marquez", "Rivadero", "Maldonado", "Alvarez", "Navas", "Zanin", "Bratti"};
    private static String preTeams[] = {"FC", "Atlético", "Club Atlético", "Sport Club", "Club Social y Deportivo", "Asociación Atlética"};
    private static String Teams[] = {"Andino", "Tesorieri", "Unión", "Estudiantes", "San Vicente", "Alianza", "Racing", "Independencia", "Rioja Juniors", "Defensores de La Boca", "San Lorenzo", "Velez Sarsfield", "San Martín", "Riojano", "Independiente", "San Román", "Riachuelo", "Güemes", "Banco Rioja"};

    public RandomData() {}

    //*****************************************************
    // RANDOM TEAMS

    public static String getNamePreTeam()
    {
        int pos = (int)(Math.random()* preTeams.length);
        return preTeams[pos];
    }

    public static String getNameTeam()
    {
        int pos = (int)(Math.random()*Teams.length);
        return Teams[pos];
    }

    public static String getFullNameTeam()
    {
        return (getNamePreTeam() + " " + getNameTeam());
    }

    //*********************************************************************

    public static String getNamesW()
    {
        int pos = (int)(Math.random()*10);
        return NamesW[pos];
    }

    public static String getNamesH()
    {
        int pos = (int)(Math.random()*10);
        return NamesH[pos];
    }

    public static String getNames()
    {
        int n = (int)(Math.random()*2);
        if (n==0)
            return getNamesW();
        else
            return getNamesH();
    }

    public static String getSurnames()
    {
        int pos = (int)(Math.random()*10);
        return Surnames[pos];
    }

    public static String getFullNameW()
    {
        return (getSurnames() + ", " + getNamesW());
    }

    public static String getFullNameH()
    {
        return (getSurnames() + ", " + getNamesH());
    }

    public static String getFullNames()
    {
        int n = (int)(Math.random()*2);
        if (n==0)
            return getFullNameW();
        else
            return getFullNameH();
    }

    public static float getRandom()
    {
        float n;
        n = (float) Math.random();
        return n;
    }

    public static int getIntBetween(int since, int until)
    {
        int aux;
        if (since > until)
        {
            aux = since;
            since = until;
            until = aux;
        }
        int n;
        n = (int) (Math.random()*((until+1)-since)+since);
        return n;
    }



}