package ch.todesstern.emspielplanapp.util;

import java.util.HashMap;

import ch.todesstern.emspielplanapp.R;

/**
 * Created by kutt on 27.06.2016.
 * Utility Klasse
 * Gibt Flaggen ID (Ressource) anhand eines Nationsnamens zurück.
 */
public class Flaggen
{
    private static final HashMap<String, Integer> flagMap;
    static
    {
        flagMap = new HashMap<String, Integer>();
        flagMap.put("Albanien", R.drawable.albania);
        flagMap.put("Belgien", R.drawable.belgium);
        flagMap.put("Deutschland", R.drawable.germany);
        flagMap.put("England", R.drawable.england);
        flagMap.put("Frankreich", R.drawable.france);
        flagMap.put("Irland", R.drawable.ireland);
        flagMap.put("Island", R.drawable.iceland);
        flagMap.put("Italien", R.drawable.italy);
        flagMap.put("Kroatien", R.drawable.croatia);
        flagMap.put("Nordirland", R.drawable.northern_ireland);
        flagMap.put("Oesterreich", R.drawable.austria);
        flagMap.put("Polen", R.drawable.poland);
        flagMap.put("Portugal", R.drawable.portugal);
        flagMap.put("Rumaenien", R.drawable.romania);
        flagMap.put("Russland", R.drawable.russia);
        flagMap.put("Schweden", R.drawable.sweden);
        flagMap.put("Schweiz", R.drawable.switzerland);
        flagMap.put("Slowakei", R.drawable.slovakia);
        flagMap.put("Spanien", R.drawable.spain);
        flagMap.put("Tschechien", R.drawable.czech_republic);
        flagMap.put("Tuerkei", R.drawable.turkey);
        flagMap.put("Ukraine", R.drawable.ukraine);
        flagMap.put("Ungarn", R.drawable.hungary);
        flagMap.put("Wales", R.drawable.wales);
    }


    public static Integer getFlag(String key)
    {
        return flagMap.get(key);
    }
}
