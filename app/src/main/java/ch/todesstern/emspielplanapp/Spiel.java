package ch.todesstern.emspielplanapp;

import android.os.Parcelable;

/**
 * Created by kutt on 27.06.2016.
 */
public class Spiel
{
    private int id;
    private String nation1;
    private String nation2;
    private int tore1;
    private int tore2;
    private int tipp1;
    private int tipp2;
    private String datum;
    private String stadion;
    private int penalty;
    private String spielart;


    public int getId()
    {
        return id;
    }

    public void setId(int id)
    {
        this.id = id;
    }

    public String getNation1()
    {
        return nation1;
    }

    public void setNation1(String nation1)
    {
        this.nation1 = nation1;
    }

    public String getNation2()
    {
        return nation2;
    }

    public void setNation2(String nation2)
    {
        this.nation2 = nation2;
    }

    public int getTore1()
    {
        return tore1;
    }

    public void setTore1(int tore1)
    {
        this.tore1 = tore1;
    }

    public int getTore2()
    {
        return tore2;
    }

    public void setTore2(int tore2)
    {
        this.tore2 = tore2;
    }

    public int getTipp1()
    {
        return tipp1;
    }

    public void setTipp1(int tipp1)
    {
        this.tipp1 = tipp1;
    }

    public int getTipp2()
    {
        return tipp2;
    }

    public void setTipp2(int tipp2)
    {
        this.tipp2 = tipp2;
    }

    public String getDatum()
    {
        return datum;
    }

    public void setDatum(String datum)
    {
        this.datum = datum;
    }

    public String getStadion()
    {
        return stadion;
    }

    public void setStadion(String stadion)
    {
        this.stadion = stadion;
    }

    public int getPenalty()
    {
        return penalty;
    }

    public void setPenalty(int penalty)
    {
        this.penalty = penalty;
    }

    public String getSpielart()
    {
        return spielart;
    }

    public void setSpielart(String spielart)
    {
        this.spielart = spielart;
    }
}

