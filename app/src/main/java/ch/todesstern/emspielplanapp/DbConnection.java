package ch.todesstern.emspielplanapp;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.util.Log;

import java.util.ArrayList;
import java.util.HashMap;

/**
 * Created by kutt on 27.06.2016.
 */
public class DbConnection extends SQLiteOpenHelper
{
    private static final int DATENBANK_VERSION = 1;
    private static final String DATENBANK_NAME = "emDB";
    private static DbConnection instance;
    private static final Object LOCK = "";

    private DbConnection(Context context)
    {
        super(context, DATENBANK_NAME, null, DATENBANK_VERSION);
    }

    @Override
    public void onCreate(SQLiteDatabase db)
    {
        // erstelle Tabellen falls noch nicht erstellt
        db.execSQL(SpielTable.SQL_CREATE);
        // befülle Tabelle falls leer
        String sql = "SELECT COUNT(*) FROM tbl_Spiele";
        Cursor cur = db.rawQuery(sql, null);
        int count = 0;
        while( cur.moveToNext() )
        {
            count += cur.getInt(0);
            break;
        }
        cur.close();
        if( 1 > count )
        {
            ArrayList<String> inserts = SpielTable.getSqlInitialData();
            for(String s : inserts)
            {
                db.execSQL(s);
            }
        }
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion)
    {
        //TODO: implement logic here
    }

    public static DbConnection getInstance(Context context)
    {
        if( null == instance )
        {
            synchronized( LOCK )
            {
                if( null == instance )
                {
                    instance = new DbConnection(context);
                }
            }
        }

        return instance;
    }

    public Spiel getSpiel(Context context, int id)
    {
        String sql = "SELECT * FROM tbl_spiele WHERE id = " + Integer.toString(id);
        DbConnection conn = getInstance(context);
        SQLiteDatabase db = conn.getReadableDatabase();
        Cursor cur = db.rawQuery(sql, null);
        Spiel spiel = null;
        while( cur.moveToNext() )
        {
            spiel = new Spiel();
            spiel.setId(cur.getInt(0));
            spiel.setNation1(cur.getString(1));
            spiel.setNation2(cur.getString(2));
            spiel.setTore1(cur.getInt(3));
            spiel.setTore2(cur.getInt(4));
            spiel.setTipp1(cur.getInt(5));
            spiel.setTipp2(cur.getInt(6));
            spiel.setDatum(cur.getString(7));
            spiel.setStadion(cur.getString(8));
            spiel.setPenalty(cur.getInt(9));
            spiel.setSpielart(cur.getString(10));
            break;
        }

        cur.close();
        return spiel;
    }

    /**
     * Führt einen SELECT auf der SQLite-Datenbank aus. Ist der SQL-String leer ("")
     * werden alle Spiele der aus tbl_spiele zurückgegeben.
     * @param context
     * @param sql
     * @return  ArrayList<Spiel>
     */
    public ArrayList<Spiel> getSpiele(Context context, String sql)
    {
        if(sql.length() == 0)
        {
            sql = "SELECT * FROM tbl_spiele;";
        }
        DbConnection conn = getInstance(context);
        SQLiteDatabase db = conn.getReadableDatabase();
        Cursor cur = db.rawQuery(sql, null);
        ArrayList<Spiel> spiele = new ArrayList<Spiel>();
        while( cur.moveToNext() )
        {
            Spiel spiel = new Spiel();
            spiel.setId(cur.getInt(0));
            spiel.setNation1(cur.getString(1));
            spiel.setNation2(cur.getString(2));
            spiel.setTore1(cur.getInt(3));
            spiel.setTore2(cur.getInt(4));
            spiel.setTipp1(cur.getInt(5));
            spiel.setTipp2(cur.getInt(6));
            spiel.setDatum(cur.getString(7));
            spiel.setStadion(cur.getString(8));
            spiel.setPenalty(cur.getInt(9));
            spiel.setSpielart(cur.getString(10));
            spiele.add(spiel);

        }
        return spiele;
    }

    public ArrayList<Spiel> getSpieleOfGruppe(Context context, String gruppe)
    {
        String sql = "SELECT * FROM tbl_spiele WHERE spielart = '" + gruppe + "';";
        ArrayList<Spiel> spiele = getSpiele(context, sql);
        return spiele;
    }

    public HashMap<String, Mannschaft> getPunkteTable(Context context, String gruppe)
    {
        String sql = "SELECT DISTINCT nation1 FROM tbl_spiele WHERE spielart = '" + gruppe + "';";
        DbConnection conn = getInstance(context);
        SQLiteDatabase db = conn.getReadableDatabase();
        Cursor cur = db.rawQuery(sql, null);
        HashMap<String, Mannschaft> punkteTable = new HashMap<String, Mannschaft>();
        while( cur.moveToNext() )
        {
            Mannschaft mannschaft = new Mannschaft();
            String nation = cur.getString(0);
            mannschaft.setName(nation);
            mannschaft.setGruppe(gruppe);
            punkteTable.put(nation, mannschaft);
        }

        return punkteTable;
    }

    /**
     * Aendert ein Datensatz
     * @param context auf die Activity
     * @param spiel Die Klasse Spiel
     * @return true, wenn es funktioniert hat.
     */
    public boolean update(Context context, Spiel spiel)
    {
        DbConnection conn = getInstance(context);
        SQLiteDatabase db = null;
        try
        {
            db = conn.getWritableDatabase();

            ContentValues values = new ContentValues();
            values.put("nation1", spiel.getNation1());
            values.put("nation2", spiel.getNation2());
            values.put("tore1", spiel.getTore1());
            values.put("tore2", spiel.getTore2());
            values.put("penalty", spiel.getPenalty());
            values.put("spielart", spiel.getSpielart());
            values.put("tipp1", spiel.getTipp1());
            values.put("tipp2", spiel.getTipp2());
            values.put("datum", spiel.getDatum());
            values.put("stadion", spiel.getStadion());

            db.update("tbl_spiele", values, "id" + "= ?", new String[]
                    {
                            String.valueOf(spiel.getId())
                    });
            return  true;
        }
        catch (Exception ex)
        {
            Log.d("AZO", "DB-Write-Error: update(): " + ex.getMessage());
            return false;
        }
        finally
        {
            if (db != null) db.close();
        }
    }
}

