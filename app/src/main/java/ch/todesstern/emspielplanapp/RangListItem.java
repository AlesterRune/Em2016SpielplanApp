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
public class RangListItem extends ArrayAdapter<Mannschaft>
{
    private final Activity context;
    private ArrayList<Mannschaft> mannschaften;

    public RangListItem(Activity context, ArrayList<Mannschaft> mannschaften)
    {
        super(context, R.layout.spiele_list_item, mannschaften);
        this.context = context;
        this.mannschaften = mannschaften;
    }

    @Override
    public View getView(int position, View view, ViewGroup parent)
    {
        LayoutInflater inflater = context.getLayoutInflater();
        View rowView = inflater.inflate(R.layout.rang_list_item, null, true);
        TextView txtRang = (TextView) rowView.findViewById(R.id.txtRang);
        TextView txtNation = (TextView) rowView.findViewById(R.id.txtNation);
        TextView txtPunkte = (TextView) rowView.findViewById(R.id.txtPunkte);
        ImageView imgFlag = (ImageView) rowView.findViewById(R.id.imgFlag);

        Mannschaft mannschaft = mannschaften.get(position);
        String nation = mannschaft.getName();
        String punkte = "Pkt. " + Integer.toString(mannschaft.getPunkte());
        Integer flag = Flaggen.getFlag(nation);

        txtRang.setText(Integer.toString(position + 1) + ". ");
        txtNation.setText(nation);
        // txtNation.setCompoundDrawablesWithIntrinsicBounds(flag,0,0,0);
        txtPunkte.setText(punkte);

        imgFlag.setImageResource(flag);

        return rowView;
    }
}