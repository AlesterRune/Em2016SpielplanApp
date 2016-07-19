package ch.todesstern.emspielplanapp;

import android.app.Activity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.ArrayList;

import ch.todesstern.emspielplanapp.util.Flaggen;

/**
 * Created by kutt on 27.06.2016.
 */
public class SpieleListItem extends ArrayAdapter<Spiel>
{
    private final Activity context;
    private ArrayList<Spiel> spiele;

    public SpieleListItem(Activity context, ArrayList<Spiel> spiele)
    {
        super(context, R.layout.spiele_list_item, spiele);
        this.context = context;
        this.spiele = spiele;
    }

    @Override
    public View getView(int position, View view, ViewGroup parent)
    {
        LayoutInflater inflater = context.getLayoutInflater();
        View rowView = inflater.inflate(R.layout.spiele_list_item, null, true);
        TextView txtDatumOrt = (TextView) rowView.findViewById(R.id.txtDatumOrt);
        TextView txtNat1 = (TextView) rowView.findViewById(R.id.txtNat1);
        TextView txtNat2 = (TextView) rowView.findViewById(R.id.txtNat2);
        TextView txtResult = (TextView) rowView.findViewById(R.id.txtResult);
        ImageView imgNat1 = (ImageView) rowView.findViewById(R.id.imgNat1);
        ImageView imgNat2 = (ImageView) rowView.findViewById(R.id.imgNat2);

        Spiel spiel = spiele.get(position);
        String datumOrt = spiel.getDatum() + " - " + spiel.getStadion();
        String nation1 = spiel.getNation1();
        String nation2 = spiel.getNation2();
        String resultat;
        if( 0 > spiel.getTore1() )
        {
            resultat = "-:-";
        }
        else
        {
            resultat = spiel.getTore1() + ":" + spiel.getTore2();
        }
        Integer flagNat1 = Flaggen.getFlag(nation1);
        Integer flagNat2 = Flaggen.getFlag(nation2);

        txtDatumOrt.setText(datumOrt);
        txtNat1.setText(nation1);
        txtNat2.setText(nation2);
        txtResult.setText(resultat);
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

        return rowView;
    }
}