package ch.todesstern.emspielplanapp;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.Spinner;
import android.widget.TextView;

import java.util.ArrayList;

import ch.todesstern.emspielplanapp.util.Flaggen;
import ch.todesstern.emspielplanapp.util.Spielarten;

public class SpielDetailActivity extends AppCompatActivity
{
    Spiel spiel;
    DbConnection conn;
    Spinner spnTore1;
    Spinner spnTore2;
    String gruppe;

    @Override
    protected void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.spiel_detail_activity);

        final Bundle extras = getIntent().getExtras();
        int spielId = extras.getInt(GruppeOverviewActivity.SPIEL_ID);
        gruppe = extras.getString(MainActivity.GRUPPE);

        if( gruppe.equals(Spielarten.FINALE) )
        {
            FinalBuilder finalBuilder = new FinalBuilder();
            finalBuilder.updateFinale(this);
        }

        conn = DbConnection.getInstance(this);
        spiel = conn.getSpiel(this, spielId);

        ImageView imgNat1 = (ImageView) findViewById(R.id.imgNat1Detail);
        ImageView imgNat2 = (ImageView) findViewById(R.id.imgNat2Detail);

        spnTore1 = (Spinner) findViewById(R.id.spnTore1);
        spnTore2 = (Spinner) findViewById(R.id.spnTore2);

        TextView txtDatum = (TextView) findViewById(R.id.txtDatum);
        TextView txtUhrzeit = (TextView) findViewById(R.id.txtUhrzeit);
        TextView txtStadion = (TextView) findViewById(R.id.txtStadion);
        TextView txtNat1 = (TextView) findViewById(R.id.txtNat1Detail);
        TextView txtNat2 = (TextView) findViewById(R.id.txtNat2Detail);

        Integer flagNat1 = Flaggen.getFlag(spiel.getNation1());
        Integer flagNat2 = Flaggen.getFlag(spiel.getNation2());

        try
        {
            imgNat1.setImageResource(flagNat1);
        }
        catch (Exception ex)
        {
            imgNat1.setImageResource(R.drawable.this_is_sparta);
        }

        try
        {
            imgNat2.setImageResource(flagNat2);
        }
        catch (Exception ex)
        {
            imgNat2.setImageResource(R.drawable.this_is_sparta);
        }

        txtDatum.setText(spiel.getDatum().substring(0, 10) + "2016");
        txtUhrzeit.setText(spiel.getDatum().substring(13) + " Uhr");
        txtStadion.setText(spiel.getStadion());
        txtNat1.setText(spiel.getNation1());
        txtNat2.setText(spiel.getNation2());

        ArrayList<Integer> tore = new ArrayList<>();
        for(int i = -1; i < 100; i++)
        {
            tore.add(i);
        }

        ArrayAdapter<Integer> adapter = new ArrayAdapter<Integer>(this, android.R.layout.simple_spinner_item, tore);
        int tore1 = spiel.getTore1();
        spnTore1.setAdapter(adapter);
        spnTore1.setSelection(tore1 + 1);
        int tore2 = spiel.getTore2();
        spnTore2.setAdapter(adapter);
        spnTore2.setSelection(tore2 + 1);
    }

    public void onClickSpeichern(View button)
    {
        Intent intent;
        if( gruppe.equals(Spielarten.FINALE) )
        {
            intent = new Intent(this, MainActivity.class);
        }
        else
        {
            intent = new Intent(this, GruppeOverviewActivity.class);
        }
        int tore1 = Integer.parseInt(spnTore1.getSelectedItem().toString());
        int tore2 = Integer.parseInt(spnTore2.getSelectedItem().toString());

        intent.putExtra(MainActivity.GRUPPE, gruppe);

        spiel.setTore1(tore1);
        spiel.setTore2(tore2);

        conn.update(this, spiel);
        startActivity(intent);
    }
}
