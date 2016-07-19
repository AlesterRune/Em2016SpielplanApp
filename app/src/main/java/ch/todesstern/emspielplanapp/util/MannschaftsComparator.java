package ch.todesstern.emspielplanapp.util;

import java.util.Comparator;

import ch.todesstern.emspielplanapp.Mannschaft;

/**
 * Created by kutt on 27.06.2016.
 */
public class MannschaftsComparator implements Comparator<Mannschaft>
{
    public static final int ASC = 1;
    public static final int DESC = -1;
    private final int ORIENTATION;
    public MannschaftsComparator(int orientation)
    {
        this.ORIENTATION = orientation;
    }

    @Override
    public int compare(Mannschaft m1, Mannschaft m2)
    {
        // Mannschaft 1 Attribute
        Integer pkt1 = m1.getPunkte();
        Integer tDiff1 = m1.getTorDiff();
        Integer tor1 = m1.getTorSumme();

        // Mannschaft 2 Attribute
        Integer pkt2 = m2.getPunkte();
        Integer tDiff2 = m2.getTorDiff();
        Integer tor2 = m2.getTorSumme();

        int pktComp = pkt1.compareTo(pkt2);
        if( 0 == pktComp )
        {
            int winComp = getWinState(m1, m2);
            if( 0 == winComp )
            {
                int tDiffComp = tDiff1.compareTo(tDiff2);
                if( 0 == tDiffComp )
                {
                    int torComp = tor1.compareTo(tor2);
                    return torComp * ORIENTATION;
                }
                return tDiffComp * ORIENTATION;
            }
            return winComp * ORIENTATION;
        }
        return pktComp * ORIENTATION;
    }

    /**
     * Prüft ob Mannschaft 1 gegen Mannschaft 2 gewonnen hat.
     * Gibt 1 zurueck für GEWONNEN, -1 für VERLOREN und 0 für UNENTSCHIEDEN.
     * @param m1 Mannschaft 1
     * @param m2 Mannschaft 2
     * @return Gewinnstatus int
     */
    private int getWinState(Mannschaft m1, Mannschaft m2)
    {
        if( m1.gewonnen.contains(m2.getName()) )
        {
            return 1;
        }
        else if( m2.gewonnen.contains(m1.getName()) )
        {
            return -1;
        }
        else
        {
            return 0;
        }
    }
}

