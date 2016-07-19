package ch.todesstern.emspielplanapp;

import java.util.ArrayList;

/**
 * Created by kutt on 27.06.2016.
 */
public class Mannschaft
{
    private String name;
    private String gruppe;
    private int punkte = 0;
    private int torSumme = 0;
    private int torDiff = 0;
    public ArrayList<String> gewonnen = new ArrayList<String>();

    public String getName()
    {
        return name;
    }

    public void setName(String name)
    {
        this.name = name;
    }

    public String getGruppe()
    {
        return gruppe;
    }

    public void setGruppe(String gruppe)
    {
        this.gruppe = gruppe;
    }

    public int getPunkte()
    {
        return punkte;
    }

    public void addPunkte(int punkte)
    {
        this.punkte += punkte;
    }

    public int getTorSumme()
    {
        return torSumme;
    }

    public void addTore(int tore)
    {
        this.torSumme += tore;
    }

    public int getTorDiff()
    {
        return torDiff;
    }

    public void addTorDiff(int torDiff)
    {
        this.torDiff += torDiff;
    }
}
