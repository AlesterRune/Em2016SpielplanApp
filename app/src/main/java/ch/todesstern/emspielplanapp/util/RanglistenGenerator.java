package ch.todesstern.emspielplanapp.util;

import android.content.Context;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;

import ch.todesstern.emspielplanapp.DbConnection;
import ch.todesstern.emspielplanapp.Mannschaft;
import ch.todesstern.emspielplanapp.Spiel;

/**
 * Created by kutt on 28.06.2016.
 */
public class RanglistenGenerator
{
    public final int WIN = 3;
    public final int DRAW = 1;
    public final int LOSE = 0;

    private ArrayList<Spiel> spiele;
    private ArrayList<Mannschaft> rangliste;
    private HashMap<String, Mannschaft> punkteTable;
    private DbConnection conn;

    public ArrayList<Mannschaft> generateRangliste(Context context, String gruppe)
    {
        conn = DbConnection.getInstance(context);
        rangliste = new ArrayList<Mannschaft>();
        spiele = conn.getSpieleOfGruppe(context, gruppe);
        punkteTable = conn.getPunkteTable(context, gruppe);

        for(Spiel spiel : spiele)
        {
            String nation1 = spiel.getNation1();
            int tore1 = spiel.getTore1();
            Mannschaft m1 = punkteTable.get(nation1);
            String nation2 = spiel.getNation2();
            int tore2 = spiel.getTore2();
            Mannschaft m2 = punkteTable.get(nation2);

            if( tore1 > tore2 )
            {
                m1.addPunkte(WIN);
                m1.addTore(tore1);
                m1.addTorDiff(tore1 - tore2);
                m1.gewonnen.add(nation2);
                m2.addPunkte(LOSE);
                m2.addTore(tore2);
                m2.addTorDiff(tore2 - tore1);
            }
            else if( tore1 < tore2 )
            {
                m1.addPunkte(LOSE);
                m1.addTore(tore1);
                m1.addTorDiff(tore1 - tore2);
                m2.addPunkte(WIN);
                m2.addTore(tore2);
                m2.addTorDiff(tore2 - tore1);
                m2.gewonnen.add(nation1);
            }
            else
            {
                m1.addPunkte(DRAW);
                m1.addTore(tore1);
                m2.addPunkte(DRAW);
                m2.addTore(tore2);
            }
            punkteTable.put(nation1, m1);
            punkteTable.put(nation2, m2);
        }

        for(HashMap.Entry<String, Mannschaft> entry : punkteTable.entrySet())
        {
            rangliste.add(entry.getValue());
        }

        Collections.sort(rangliste, new MannschaftsComparator(MannschaftsComparator.DESC));
        return rangliste;
    }
}
