package ch.todesstern.emspielplanapp;

import java.util.ArrayList;

/**
 * Created by kutt on 27.06.2016.
 */
public class SpielTable
{
    public static final String SQL_CREATE = "CREATE TABLE IF NOT EXISTS tbl_spiele (" +
            "id INTEGER PRIMARY KEY AUTOINCREMENT," +
            "nation1 TEXT," +
            "nation2 TEXT," +
            "tore1 INTEGER," +
            "tore2 INTEGER," +
            "tipp1 INTEGER," +
            "tipp2 INTEGER," +
            "datum TEXT," +
            "stadion TEXT," +
            "penalty INTEGER," +
            "spielart TEXT);";

    public static final String SQL_DROP = "DROP TABLE tbl_spiele";

    private static ArrayList<String> sqlInitialData = null;

    public static ArrayList<String> getSqlInitialData()
    {
        if( null == sqlInitialData )
        {
            sqlInitialData = new ArrayList<String>();
            sqlInitialData.add("INSERT INTO tbl_spiele (nation1, nation2, tore1, tore2, datum, stadion, spielart) VALUES ('Frankreich', 'Rumaenien', -1, -1, 'Fr. 10.06. - 21:00', 'St. Denis / Paris', 'a');");
            sqlInitialData.add("INSERT INTO tbl_spiele (nation1, nation2, tore1, tore2, datum, stadion, spielart) VALUES ('Albanien', 'Schweiz', -1, -1, 'Sa. 11.06. - 15:00', 'Lens', 'a');");
            sqlInitialData.add("INSERT INTO tbl_spiele (nation1, nation2, tore1, tore2, datum, stadion, spielart) VALUES ('Rumaenien', 'Schweiz', -1, -1, 'Mi. 15.06. - 18:00', 'Paris', 'a');");
            sqlInitialData.add("INSERT INTO tbl_spiele (nation1, nation2, tore1, tore2, datum, stadion, spielart) VALUES ('Frankreich', 'Albanien', -1, -1, 'Mi. 15.06. - 21:00', 'Marseille', 'a');");
            sqlInitialData.add("INSERT INTO tbl_spiele (nation1, nation2, tore1, tore2, datum, stadion, spielart) VALUES ('Schweiz', 'Frankreich', -1, -1, 'So. 19.06. - 21:00', 'Lille', 'a');");
            sqlInitialData.add("INSERT INTO tbl_spiele (nation1, nation2, tore1, tore2, datum, stadion, spielart) VALUES ('Rumaenien', 'Albanien', -1, -1, 'So. 19.06. - 21:00', 'Lyon', 'a');");
            sqlInitialData.add("INSERT INTO tbl_spiele (nation1, nation2, tore1, tore2, datum, stadion, spielart) VALUES ('Wales', 'Slowakei', -1, -1, 'Sa. 11.06. - 18:00', 'Bordeaux', 'b');");
            sqlInitialData.add("INSERT INTO tbl_spiele (nation1, nation2, tore1, tore2, datum, stadion, spielart) VALUES ('England', 'Russland', -1, -1, 'Sa. 11.06. - 21:00', 'Marseille', 'b');");
            sqlInitialData.add("INSERT INTO tbl_spiele (nation1, nation2, tore1, tore2, datum, stadion, spielart) VALUES ('Russland', 'Slowakei', -1, -1, 'Mi. 15.06. - 15:00', 'Lille', 'b');");
            sqlInitialData.add("INSERT INTO tbl_spiele (nation1, nation2, tore1, tore2, datum, stadion, spielart) VALUES ('England', 'Wales', -1, -1, 'Do. 16.06. - 15:00', 'Lens', 'b');");
            sqlInitialData.add("INSERT INTO tbl_spiele (nation1, nation2, tore1, tore2, datum, stadion, spielart) VALUES ('Slowakei', 'England', -1, -1, 'Mo. 20.06. - 21:00', 'St. Etienne', 'b');");
            sqlInitialData.add("INSERT INTO tbl_spiele (nation1, nation2, tore1, tore2, datum, stadion, spielart) VALUES ('Russland', 'Wales', -1, -1, 'Mo. 20.06. - 21:00', 'Toulouse', 'b');");
            sqlInitialData.add("INSERT INTO tbl_spiele (nation1, nation2, tore1, tore2, datum, stadion, spielart) VALUES ('Polen', 'Nordirland', -1, -1, 'So. 12.06. - 18:00', 'Nizza', 'c');");
            sqlInitialData.add("INSERT INTO tbl_spiele (nation1, nation2, tore1, tore2, datum, stadion, spielart) VALUES ('Deutschland', 'Ukraine', -1, -1, 'So. 12.06. - 21:00', 'Lille', 'c');");
            sqlInitialData.add("INSERT INTO tbl_spiele (nation1, nation2, tore1, tore2, datum, stadion, spielart) VALUES ('Ukraine', 'Nordirland', -1, -1, 'Do. 16.06. - 18:00', 'Lyon', 'c');");
            sqlInitialData.add("INSERT INTO tbl_spiele (nation1, nation2, tore1, tore2, datum, stadion, spielart) VALUES ('Deutschland', 'Polen', -1, -1, 'Do. 16.06. - 21:00', 'St. Denis / Paris', 'c');");
            sqlInitialData.add("INSERT INTO tbl_spiele (nation1, nation2, tore1, tore2, datum, stadion, spielart) VALUES ('Ukraine', 'Polen', -1, -1, 'Di. 21.06. - 18:00', 'Marseille', 'c');");
            sqlInitialData.add("INSERT INTO tbl_spiele (nation1, nation2, tore1, tore2, datum, stadion, spielart) VALUES ('Nordirland', 'Deutschland', -1, -1, 'Di. 21.06. - 18:00', 'Paris', 'c');");
            sqlInitialData.add("INSERT INTO tbl_spiele (nation1, nation2, tore1, tore2, datum, stadion, spielart) VALUES ('Tuerkei', 'Kroatien', -1, -1, 'So. 12.06. - 15:00', 'Paris', 'd');");
            sqlInitialData.add("INSERT INTO tbl_spiele (nation1, nation2, tore1, tore2, datum, stadion, spielart) VALUES ('Spanien', 'Tschechien', -1, -1, 'Mo. 13.06. - 15:00', 'Toulouse', 'd');");
            sqlInitialData.add("INSERT INTO tbl_spiele (nation1, nation2, tore1, tore2, datum, stadion, spielart) VALUES ('Tschechien', 'Kroatien', -1, -1, 'Fr. 17.06. - 18:00', 'St. Etienne', 'd');");
            sqlInitialData.add("INSERT INTO tbl_spiele (nation1, nation2, tore1, tore2, datum, stadion, spielart) VALUES ('Spanien', 'Tuerkei', -1, -1, 'Fr. 17.06. - 21:00', 'Nizza', 'd');");
            sqlInitialData.add("INSERT INTO tbl_spiele (nation1, nation2, tore1, tore2, datum, stadion, spielart) VALUES ('Kroatien', 'Spanien', -1, -1, 'Di. 21.06. - 21:00', 'Bordeaux', 'd');");
            sqlInitialData.add("INSERT INTO tbl_spiele (nation1, nation2, tore1, tore2, datum, stadion, spielart) VALUES ('Tschechien', 'Tuerkei', -1, -1, 'Di. 21.06. - 21:00', 'Lens', 'd');");
            sqlInitialData.add("INSERT INTO tbl_spiele (nation1, nation2, tore1, tore2, datum, stadion, spielart) VALUES ('Irland', 'Schweden', -1, -1, 'Mo. 13.06. - 18:00', 'St. Denis / Paris', 'e');");
            sqlInitialData.add("INSERT INTO tbl_spiele (nation1, nation2, tore1, tore2, datum, stadion, spielart) VALUES ('Belgien', 'Italien', -1, -1, 'Mo. 13.06. - 21:00', 'Lyon', 'e');");
            sqlInitialData.add("INSERT INTO tbl_spiele (nation1, nation2, tore1, tore2, datum, stadion, spielart) VALUES ('Italien', 'Schweden', -1, -1, 'Fr. 17.06. - 15:00', 'Toulouse', 'e');");
            sqlInitialData.add("INSERT INTO tbl_spiele (nation1, nation2, tore1, tore2, datum, stadion, spielart) VALUES ('Belgien', 'Irland', -1, -1, 'Sa. 18.06. - 15:00', 'Bordeaux', 'e');");
            sqlInitialData.add("INSERT INTO tbl_spiele (nation1, nation2, tore1, tore2, datum, stadion, spielart) VALUES ('Italien', 'Irland', -1, -1, 'Mi. 22.06. - 21:00', 'Lille', 'e');");
            sqlInitialData.add("INSERT INTO tbl_spiele (nation1, nation2, tore1, tore2, datum, stadion, spielart) VALUES ('Schweden', 'Belgien', -1, -1, 'Mi. 22.06. - 21:00', 'Nizza', 'e');");
            sqlInitialData.add("INSERT INTO tbl_spiele (nation1, nation2, tore1, tore2, datum, stadion, spielart) VALUES ('Oesterreich', 'Ungarn', -1, -1, 'Di. 14.06. - 18:00', 'Bordeaux', 'f');");
            sqlInitialData.add("INSERT INTO tbl_spiele (nation1, nation2, tore1, tore2, datum, stadion, spielart) VALUES ('Portugal', 'Island', -1, -1, 'Di. 14.06. - 21:00', 'St. Etienne', 'f');");
            sqlInitialData.add("INSERT INTO tbl_spiele (nation1, nation2, tore1, tore2, datum, stadion, spielart) VALUES ('Island', 'Ungarn', -1, -1, 'Sa. 18.06. - 18:00', 'Marseille', 'f');");
            sqlInitialData.add("INSERT INTO tbl_spiele (nation1, nation2, tore1, tore2, datum, stadion, spielart) VALUES ('Portugal', 'Oesterreich', -1, -1, 'Sa. 18.06. - 21:00', 'St. Denis / Paris', 'f');");
            sqlInitialData.add("INSERT INTO tbl_spiele (nation1, nation2, tore1, tore2, datum, stadion, spielart) VALUES ('Ungarn', 'Portugal', -1, -1, 'Mi. 22.06. - 18:00', 'Lyon', 'f');");
            sqlInitialData.add("INSERT INTO tbl_spiele (nation1, nation2, tore1, tore2, datum, stadion, spielart) VALUES ('Island', 'Oesterreich', -1, -1, 'Mi. 22.06. - 18:00', 'Paris', 'f');");
            sqlInitialData.add("INSERT INTO tbl_spiele (nation1, nation2, tore1, tore2, datum, stadion, spielart) VALUES ('Zweiter A', 'Zweiter C', -1, -1, 'Sa. 25.06. - 15:00', 'St. Etienne', '8');");
            sqlInitialData.add("INSERT INTO tbl_spiele (nation1, nation2, tore1, tore2, datum, stadion, spielart) VALUES ('Sieger B', 'Dritter A/C/D', -1, -1, 'Sa. 25.06. - 18:00', 'Paris', '8');");
            sqlInitialData.add("INSERT INTO tbl_spiele (nation1, nation2, tore1, tore2, datum, stadion, spielart) VALUES ('Sieger D', 'Dritter B/E/F', -1, -1, 'Sa. 25.06. - 21:00', 'Lens', '8');");
            sqlInitialData.add("INSERT INTO tbl_spiele (nation1, nation2, tore1, tore2, datum, stadion, spielart) VALUES ('Sieger A', 'Dritter C/D/E', -1, -1, 'So. 26.06. - 15:00', 'Lyon', '8');");
            sqlInitialData.add("INSERT INTO tbl_spiele (nation1, nation2, tore1, tore2, datum, stadion, spielart) VALUES ('Sieger C', 'Dritter A/B/F', -1, -1, 'So. 26.06. - 18:00', 'Lille', '8');");
            sqlInitialData.add("INSERT INTO tbl_spiele (nation1, nation2, tore1, tore2, datum, stadion, spielart) VALUES ('Sieger F', 'Zweiter E', -1, -1, 'So. 26.06. - 21:00', 'Toulouse', '8');");
            sqlInitialData.add("INSERT INTO tbl_spiele (nation1, nation2, tore1, tore2, datum, stadion, spielart) VALUES ('Sieger E', 'Zweiter D', -1, -1, 'Mo. 27.06. - 18:00', 'St. Denis / Paris', '8');");
            sqlInitialData.add("INSERT INTO tbl_spiele (nation1, nation2, tore1, tore2, datum, stadion, spielart) VALUES ('Zweiter B', 'Zweiter F', -1, -1, 'Mo. 27.06. - 21:00', 'Nizza', '8');");
            sqlInitialData.add("INSERT INTO tbl_spiele (nation1, nation2, tore1, tore2, datum, stadion, spielart) VALUES ('Sieger AF 1', 'Sieger AF 3', -1, -1, 'Do. 30.06. - 21:00', 'Marseille', '4');");
            sqlInitialData.add("INSERT INTO tbl_spiele (nation1, nation2, tore1, tore2, datum, stadion, spielart) VALUES ('Sieger AF 2', 'Sieger AF 6', -1, -1, 'Fr. 01.07. - 21:00', 'Lille', '4');");
            sqlInitialData.add("INSERT INTO tbl_spiele (nation1, nation2, tore1, tore2, datum, stadion, spielart) VALUES ('Sieger AF 5', 'Sieger AF 7', -1, -1, 'Sa. 02.07. - 21:00', 'Bordeaux', '4');");
            sqlInitialData.add("INSERT INTO tbl_spiele (nation1, nation2, tore1, tore2, datum, stadion, spielart) VALUES ('Sieger AF 4', 'Sieger AF 8', -1, -1, 'So. 03.07. - 21:00', 'St. Denis / Paris', '4');");
            sqlInitialData.add("INSERT INTO tbl_spiele (nation1, nation2, tore1, tore2, datum, stadion, spielart) VALUES ('Sieger VF 1', 'Sieger VF 2', -1, -1, 'Mi. 06.07. - 21:00', 'Lyon', '2');");
            sqlInitialData.add("INSERT INTO tbl_spiele (nation1, nation2, tore1, tore2, datum, stadion, spielart) VALUES ('Sieger VF 3', 'Sieger VF 4', -1, -1, 'Do. 07.07. - 21:00', 'Marseille', '2');");
            sqlInitialData.add("INSERT INTO tbl_spiele (nation1, nation2, tore1, tore2, datum, stadion, spielart) VALUES ('Sieger HF 1', 'Sieger HF 2', -1, -1, 'So. 10.07. - 21:00', 'St. Denis / Paris', '1');");
        }

        return sqlInitialData;
    }
}
