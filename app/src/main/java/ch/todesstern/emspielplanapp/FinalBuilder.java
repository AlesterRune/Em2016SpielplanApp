package ch.todesstern.emspielplanapp;

import android.content.Context;

import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.HashMap;

import ch.todesstern.emspielplanapp.util.MannschaftsComparator;
import ch.todesstern.emspielplanapp.util.Platz;
import ch.todesstern.emspielplanapp.util.RanglistenGenerator;
import ch.todesstern.emspielplanapp.util.Spielarten;

/**
 * Created by kutt on 05.07.2016.
 */
public class FinalBuilder
{
    public boolean updateAchtelfinale(Context context)
    {
        DbConnection conn = DbConnection.getInstance(context);
        HashMap<String, Mannschaft> achtelfinalisten = getAchtelfinalisten(context);
        ArrayList<Spiel> spiele = conn.getSpieleOfGruppe(context, Spielarten.ACHTEL_FINALE);
        Spiel spiel;

        // Achtelfinale 1: id 37
        spiel = spiele.get(0);
        spiel.setNation1(achtelfinalisten.get(Platz.ZWEITER_A).getName());
        spiel.setNation2(achtelfinalisten.get(Platz.ZWEITER_C).getName());
        if( !conn.update(context, spiel) )
        {
            return false;
        }
        // Achtelfinale 2: id 38
        spiel = spiele.get(1);
        spiel.setNation1(achtelfinalisten.get(Platz.ERSTER_B).getName());
        spiel.setNation2(getDrittplatzierter(context, spiel.getId()).getName());
        if( !conn.update(context, spiel) )
        {
            return false;
        }
        // Achtelfinale 3: id 39
        spiel = spiele.get(2);
        spiel.setNation1(achtelfinalisten.get(Platz.ERSTER_D).getName());
        spiel.setNation2(getDrittplatzierter(context, spiel.getId()).getName());
        if( !conn.update(context, spiel) )
        {
            return false;
        }
        // Achtelfinale 4: id 40
        spiel = spiele.get(3);
        spiel.setNation1(achtelfinalisten.get(Platz.ERSTER_A).getName());
        spiel.setNation2(getDrittplatzierter(context, spiel.getId()).getName());
        if( !conn.update(context, spiel) )
        {
            return false;
        }
        // Achtelfinale 5: id 41
        spiel = spiele.get(4);
        spiel.setNation1(achtelfinalisten.get(Platz.ERSTER_C).getName());
        spiel.setNation2(getDrittplatzierter(context, spiel.getId()).getName());
        if( !conn.update(context, spiel) )
        {
            return false;
        }
        // Achtelfinale 6: id 42
        spiel = spiele.get(5);
        spiel.setNation1(achtelfinalisten.get(Platz.ERSTER_F).getName());
        spiel.setNation2(achtelfinalisten.get(Platz.ZWEITER_E).getName());
        if( !conn.update(context, spiel) )
        {
            return false;
        }
        // Achtelfinale 7: id 43
        spiel = spiele.get(6);
        spiel.setNation1(achtelfinalisten.get(Platz.ERSTER_E).getName());
        spiel.setNation2(achtelfinalisten.get(Platz.ZWEITER_D).getName());
        if( !conn.update(context, spiel) )
        {
            return false;
        }
        // Achtelfinale 8: id 44
        spiel = spiele.get(7);
        spiel.setNation1(achtelfinalisten.get(Platz.ZWEITER_B).getName());
        spiel.setNation2(achtelfinalisten.get(Platz.ZWEITER_F).getName());
        if( !conn.update(context, spiel) )
        {
            return false;
        }

        return true;
    }

    public boolean updateHalbfinale(Context context)
    {
        DbConnection conn = DbConnection.getInstance(context);
        ArrayList<Spiel> viertelfinale = conn.getSpieleOfGruppe(context, Spielarten.VIERTEL_FINALE);
        ArrayList<Spiel> halbfinale = conn.getSpieleOfGruppe(context, Spielarten.HALB_FINALE);
        Spiel spiel;

        // Halbfinale 1: id 49 (Sieger VF1 vs Sieger VF2)
        spiel = halbfinale.get(0);
        String gewinnerVf1 = getGewinnerOfSpiel(viertelfinale.get(0));
        String gewinnerVf2 = getGewinnerOfSpiel(viertelfinale.get(1));
        spiel.setNation1(gewinnerVf1);
        spiel.setNation2(gewinnerVf2);
        if( !conn.update(context, spiel) )
        {
            return false;
        }

        // Halbfinale 2: id 50 (Sieger VF3 vs Sieger VF4)
        spiel = halbfinale.get(1);
        String gewinnerVf3 = getGewinnerOfSpiel(viertelfinale.get(2));
        String gewinnerVf4 = getGewinnerOfSpiel(viertelfinale.get(3));
        spiel.setNation1(gewinnerVf3);
        spiel.setNation2(gewinnerVf4);
        if( !conn.update(context, spiel) )
        {
            return false;
        }

        return true;
    }

    public boolean updateFinale(Context context)
    {
        DbConnection conn = DbConnection.getInstance(context);
        ArrayList<Spiel> halbfinale = conn.getSpieleOfGruppe(context, Spielarten.HALB_FINALE);
        ArrayList<Spiel> finale = conn.getSpieleOfGruppe(context, Spielarten.FINALE);
        Spiel spiel;

        // Finale: id 51 (Sieger HF1 vs Sieger HF2)
        spiel = finale.get(0);
        String gewinnerHf1 = getGewinnerOfSpiel(halbfinale.get(0));
        String gewinnerHf2 = getGewinnerOfSpiel(halbfinale.get(1));
        spiel.setNation1(gewinnerHf1);
        spiel.setNation2(gewinnerHf2);
        return conn.update(context, spiel);

    }

    public boolean updateViertelfinale(Context context)
    {
        DbConnection conn = DbConnection.getInstance(context);
        ArrayList<Spiel> achtelfinale = conn.getSpieleOfGruppe(context, Spielarten.ACHTEL_FINALE);
        ArrayList<Spiel> viertelfinale = conn.getSpieleOfGruppe(context, Spielarten.VIERTEL_FINALE);
        Spiel spiel;

        // Viertelfinale 1: id 45 (Sieger AF1 vs Sieger AF3)
        spiel = viertelfinale.get(0);
        String gewinnerAf1 = getGewinnerOfSpiel(achtelfinale.get(0));
        String gewinnerAf3 = getGewinnerOfSpiel(achtelfinale.get(2));
        spiel.setNation1(gewinnerAf1);
        spiel.setNation2(gewinnerAf3);
        if( !conn.update(context, spiel) )
        {
            return false;
        }

        // Viertelfinale 2: id 46 (Sieger AF2 vs Sieger AF6)
        spiel = viertelfinale.get(1);
        String gewinnerAf2 = getGewinnerOfSpiel(achtelfinale.get(1));
        String gewinnerAf6 = getGewinnerOfSpiel(achtelfinale.get(5));
        spiel.setNation1(gewinnerAf2);
        spiel.setNation2(gewinnerAf6);
        if( !conn.update(context, spiel) )
        {
            return false;
        }

        // Viertelfinale 3: id 47 (Sieger AF5 vs Sieger AF7)
        spiel = viertelfinale.get(2);
        String gewinnerAf5 = getGewinnerOfSpiel(achtelfinale.get(4));
        String gewinnerAf7 = getGewinnerOfSpiel(achtelfinale.get(6));
        spiel.setNation1(gewinnerAf5);
        spiel.setNation2(gewinnerAf7);
        if( !conn.update(context, spiel) )
        {
            return false;
        }

        // Viertelfinale 4: id 48 (Sieger AF4 vs Sieger AF8)
        spiel = viertelfinale.get(3);
        String gewinnerAf4 = getGewinnerOfSpiel(achtelfinale.get(3));
        String gewinnerAf8 = getGewinnerOfSpiel(achtelfinale.get(7));
        spiel.setNation1(gewinnerAf4);
        spiel.setNation2(gewinnerAf8);
        if( !conn.update(context, spiel) )
        {
            return false;
        }

        return true;
    }

    private HashMap<String, Mannschaft> getAchtelfinalisten(Context context)
    {
        RanglistenGenerator rangGen = new RanglistenGenerator();
        HashMap<String, Mannschaft> achtelfinalisten = new HashMap<>();

        ArrayList<Mannschaft> gruppeA = rangGen.generateRangliste(context, Spielarten.GRUPPE_A);
        ArrayList<Mannschaft> gruppeB = rangGen.generateRangliste(context, Spielarten.GRUPPE_B);
        ArrayList<Mannschaft> gruppeC = rangGen.generateRangliste(context, Spielarten.GRUPPE_C);
        ArrayList<Mannschaft> gruppeD = rangGen.generateRangliste(context, Spielarten.GRUPPE_D);
        ArrayList<Mannschaft> gruppeE = rangGen.generateRangliste(context, Spielarten.GRUPPE_E);
        ArrayList<Mannschaft> gruppeF = rangGen.generateRangliste(context, Spielarten.GRUPPE_F);

        // add ERSTER pro GRUPPE
        achtelfinalisten.put(Platz.ERSTER_A, gruppeA.get(0));
        achtelfinalisten.put(Platz.ERSTER_B, gruppeB.get(0));
        achtelfinalisten.put(Platz.ERSTER_C, gruppeC.get(0));
        achtelfinalisten.put(Platz.ERSTER_D, gruppeD.get(0));
        achtelfinalisten.put(Platz.ERSTER_E, gruppeE.get(0));
        achtelfinalisten.put(Platz.ERSTER_F, gruppeF.get(0));
        // add ZWEITER pro GRUPPE
        achtelfinalisten.put(Platz.ZWEITER_A, gruppeA.get(1));
        achtelfinalisten.put(Platz.ZWEITER_B, gruppeB.get(1));
        achtelfinalisten.put(Platz.ZWEITER_C, gruppeC.get(1));
        achtelfinalisten.put(Platz.ZWEITER_D, gruppeD.get(1));
        achtelfinalisten.put(Platz.ZWEITER_E, gruppeE.get(1));
        achtelfinalisten.put(Platz.ZWEITER_F, gruppeF.get(1));
        // add DRITTER pro GRUPPE
        achtelfinalisten.put(Platz.DRITTER_A, gruppeA.get(2));
        achtelfinalisten.put(Platz.DRITTER_B, gruppeB.get(2));
        achtelfinalisten.put(Platz.DRITTER_C, gruppeC.get(2));
        achtelfinalisten.put(Platz.DRITTER_D, gruppeD.get(2));
        achtelfinalisten.put(Platz.DRITTER_E, gruppeE.get(2));
        achtelfinalisten.put(Platz.DRITTER_F, gruppeF.get(2));

        return achtelfinalisten;
    }

    private Mannschaft getDrittplatzierter(Context context, int spielId)
    {
        String drittePattern = ""; // z.B. abcd, acdf, usw.
        HashMap<String, Mannschaft> achtelfinalisten = getAchtelfinalisten(context);
        ArrayList<Mannschaft> drittplatzierte = new ArrayList<>();
        drittplatzierte.add(achtelfinalisten.get(Platz.DRITTER_A));
        drittplatzierte.add(achtelfinalisten.get(Platz.DRITTER_B));
        drittplatzierte.add(achtelfinalisten.get(Platz.DRITTER_C));
        drittplatzierte.add(achtelfinalisten.get(Platz.DRITTER_D));
        drittplatzierte.add(achtelfinalisten.get(Platz.DRITTER_E));
        drittplatzierte.add(achtelfinalisten.get(Platz.DRITTER_F));

        Collections.sort(drittplatzierte, new MannschaftsComparator(MannschaftsComparator.DESC));

        drittplatzierte.remove(5);
        drittplatzierte.remove(4);

        Collections.sort(drittplatzierte, new Comparator<Mannschaft>()
        {
            @Override
            public int compare(Mannschaft m1, Mannschaft m2)
            {
                return m1.getGruppe().compareTo(m2.getGruppe());
            }
        });

        for(Mannschaft mannschaft : drittplatzierte)
        {
            drittePattern += mannschaft.getGruppe();
        }

        return getDritterOfPattern(context, drittePattern, spielId);
    }

    private Mannschaft getDritterOfPattern(Context context, String pattern, int spielId)
    {
        HashMap<String, Mannschaft> achtelfinalisten = getAchtelfinalisten(context);

        switch (pattern)
        {
            case "abcd":
                switch (spielId)
                {
                    case 38:
                        return achtelfinalisten.get(Platz.DRITTER_D);
                    case 39:
                        return achtelfinalisten.get(Platz.DRITTER_B);
                    case 40:
                        return achtelfinalisten.get(Platz.DRITTER_C);
                    case 41:
                        return achtelfinalisten.get(Platz.DRITTER_A);
                }
                break;
            case "abce":
                switch (spielId)
                {
                    case 38:
                        return achtelfinalisten.get(Platz.DRITTER_A);
                    case 39:
                        return achtelfinalisten.get(Platz.DRITTER_E);
                    case 40:
                        return achtelfinalisten.get(Platz.DRITTER_C);
                    case 41:
                        return achtelfinalisten.get(Platz.DRITTER_B);
                }
                break;
            case "abcf":
                switch (spielId)
                {
                    case 38:
                        return achtelfinalisten.get(Platz.DRITTER_A);
                    case 39:
                        return achtelfinalisten.get(Platz.DRITTER_F);
                    case 40:
                        return achtelfinalisten.get(Platz.DRITTER_C);
                    case 41:
                        return achtelfinalisten.get(Platz.DRITTER_B);
                }
                break;
            case "abde":
                switch (spielId)
                {
                    case 38:
                        return achtelfinalisten.get(Platz.DRITTER_A);
                    case 39:
                        return achtelfinalisten.get(Platz.DRITTER_E);
                    case 40:
                        return achtelfinalisten.get(Platz.DRITTER_D);
                    case 41:
                        return achtelfinalisten.get(Platz.DRITTER_B);
                }
                break;
            case "abdf":
                switch (spielId)
                {
                    case 38:
                        return achtelfinalisten.get(Platz.DRITTER_A);
                    case 39:
                        return achtelfinalisten.get(Platz.DRITTER_F);
                    case 40:
                        return achtelfinalisten.get(Platz.DRITTER_D);
                    case 41:
                        return achtelfinalisten.get(Platz.DRITTER_B);
                }
                break;
            case "abef":
                switch (spielId)
                {
                    case 38:
                        return achtelfinalisten.get(Platz.DRITTER_A);
                    case 39:
                        return achtelfinalisten.get(Platz.DRITTER_F);
                    case 40:
                        return achtelfinalisten.get(Platz.DRITTER_E);
                    case 41:
                        return achtelfinalisten.get(Platz.DRITTER_B);
                }
                break;
            case "acde":
                switch (spielId)
                {
                    case 38:
                        return achtelfinalisten.get(Platz.DRITTER_D);
                    case 39:
                        return achtelfinalisten.get(Platz.DRITTER_E);
                    case 40:
                        return achtelfinalisten.get(Platz.DRITTER_C);
                    case 41:
                        return achtelfinalisten.get(Platz.DRITTER_A);
                }
                break;
            case "acdf":
                switch (spielId)
                {
                    case 38:
                        return achtelfinalisten.get(Platz.DRITTER_D);
                    case 39:
                        return achtelfinalisten.get(Platz.DRITTER_F);
                    case 40:
                        return achtelfinalisten.get(Platz.DRITTER_C);
                    case 41:
                        return achtelfinalisten.get(Platz.DRITTER_A);
                }
                break;
            case "acef":
                switch (spielId)
                {
                    case 38:
                        return achtelfinalisten.get(Platz.DRITTER_A);
                    case 39:
                        return achtelfinalisten.get(Platz.DRITTER_E);
                    case 40:
                        return achtelfinalisten.get(Platz.DRITTER_C);
                    case 41:
                        return achtelfinalisten.get(Platz.DRITTER_F);
                }
                break;
            case "adef":
                switch (spielId)
                {
                    case 38:
                        return achtelfinalisten.get(Platz.DRITTER_A);
                    case 39:
                        return achtelfinalisten.get(Platz.DRITTER_E);
                    case 40:
                        return achtelfinalisten.get(Platz.DRITTER_D);
                    case 41:
                        return achtelfinalisten.get(Platz.DRITTER_F);
                }
                break;
            case "bcde":
                switch (spielId)
                {
                    case 38:
                        return achtelfinalisten.get(Platz.DRITTER_D);
                    case 39:
                        return achtelfinalisten.get(Platz.DRITTER_E);
                    case 40:
                        return achtelfinalisten.get(Platz.DRITTER_C);
                    case 41:
                        return achtelfinalisten.get(Platz.DRITTER_B);
                }
                break;
            case "bcdf":
                switch (spielId)
                {
                    case 38:
                        return achtelfinalisten.get(Platz.DRITTER_D);
                    case 39:
                        return achtelfinalisten.get(Platz.DRITTER_F);
                    case 40:
                        return achtelfinalisten.get(Platz.DRITTER_C);
                    case 41:
                        return achtelfinalisten.get(Platz.DRITTER_B);
                }
                break;
            case "bcef":
                switch (spielId)
                {
                    case 38:
                        return achtelfinalisten.get(Platz.DRITTER_C);
                    case 39:
                        return achtelfinalisten.get(Platz.DRITTER_F);
                    case 40:
                        return achtelfinalisten.get(Platz.DRITTER_E);
                    case 41:
                        return achtelfinalisten.get(Platz.DRITTER_B);
                }
                break;
            case "bdef":
                switch (spielId)
                {
                    case 38:
                        return achtelfinalisten.get(Platz.DRITTER_D);
                    case 39:
                        return achtelfinalisten.get(Platz.DRITTER_F);
                    case 40:
                        return achtelfinalisten.get(Platz.DRITTER_E);
                    case 41:
                        return achtelfinalisten.get(Platz.DRITTER_B);
                }
                break;
            case "cdef":
                switch (spielId)
                {
                    case 38:
                        return achtelfinalisten.get(Platz.DRITTER_D);
                    case 39:
                        return achtelfinalisten.get(Platz.DRITTER_E);
                    case 40:
                        return achtelfinalisten.get(Platz.DRITTER_C);
                    case 41:
                        return achtelfinalisten.get(Platz.DRITTER_F);
                }
                break;
        }

        return new Mannschaft();
    }

    private String getGewinnerOfSpiel(Spiel spiel)
    {
        if( spiel.getTore1() > spiel.getTore2() )
        {
            return spiel.getNation1();
        }
        else if ( spiel.getTore1() < spiel.getTore2() )
        {
            return spiel.getNation2();
        }
        else
        {
            return "";
        }
    }
}