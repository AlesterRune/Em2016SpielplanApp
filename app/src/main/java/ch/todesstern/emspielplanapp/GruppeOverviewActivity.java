package ch.todesstern.emspielplanapp;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.HashMap;

import ch.todesstern.emspielplanapp.util.Platz;
import ch.todesstern.emspielplanapp.util.RanglistenGenerator;
import ch.todesstern.emspielplanapp.util.Spielarten;

public class GruppeOverviewActivity extends AppCompatActivity
{
    public static final String SPIEL_ID = "id";

    ArrayList<Spiel> spiele;
    ArrayList<Mannschaft> rangliste;
    DbConnection conn;
    ListView listSpiele;
    ListView listRang;
    String gruppe;

    @Override
    protected void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.gruppe_overview_activity);

        final Bundle extras = getIntent().getExtras();

        gruppe = extras.getString(MainActivity.GRUPPE);

        final TextView txtGrpName = (TextView) findViewById(R.id.txtGrpName);
        conn = DbConnection.getInstance(this);
        RanglistenGenerator rangGen = new RanglistenGenerator();
        FinalBuilder finalBuilder = new FinalBuilder();

        switch( gruppe )
        {
            case Spielarten.GRUPPE_A:
            case Spielarten.GRUPPE_B:
            case Spielarten.GRUPPE_C:
            case Spielarten.GRUPPE_D:
            case Spielarten.GRUPPE_E:
            case Spielarten.GRUPPE_F:
                txtGrpName.setText("Spiele Gruppe " + gruppe.toUpperCase());

                rangliste = rangGen.generateRangliste(this, gruppe);

                RangListItem rangAdapter = new RangListItem(this, rangliste);
                listRang = (ListView) findViewById(R.id.livRang);
                listRang.setAdapter(rangAdapter);
                break;
            case Spielarten.ACHTEL_FINALE:
                txtGrpName.setText("Achtelfinale");

                finalBuilder.updateAchtelfinale(this);

                break;
            case Spielarten.VIERTEL_FINALE:
                txtGrpName.setText("Viertelfinale");

                finalBuilder.updateViertelfinale(this);

                break;
            case Spielarten.HALB_FINALE:
                txtGrpName.setText("Halbfinale");

                finalBuilder.updateHalbfinale(this);

                break;
        }

        spiele = conn.getSpieleOfGruppe(this, gruppe);
        SpieleListItem spielAdapter = new SpieleListItem(this, spiele);
        listSpiele = (ListView) findViewById(R.id.livSpiele);
        listSpiele.setAdapter(spielAdapter);
        listSpiele.setOnItemClickListener(new AdapterView.OnItemClickListener()
        {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id)
            {
                Intent intent = new Intent(GruppeOverviewActivity.this, SpielDetailActivity.class);
                Spiel spiel = spiele.get(position);
                intent.putExtra(SPIEL_ID, spiel.getId());
                intent.putExtra(MainActivity.GRUPPE, gruppe);
                startActivity(intent);
            }
        });
    }
}
