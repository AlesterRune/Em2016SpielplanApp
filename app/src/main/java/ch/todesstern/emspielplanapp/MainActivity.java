package ch.todesstern.emspielplanapp;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;

import ch.todesstern.emspielplanapp.util.Spielarten;

public class MainActivity extends AppCompatActivity
{
    public static final String GRUPPE = "grp";
    public static final int FINAL_ID = 51;

    @Override
    protected void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.main_activity);
    }

    public void onClickGruppe(View button)
    {
        Button clicked = (Button) button;
        String grp = null;
        grp = clicked.getText().toString();
        final Intent intent = new Intent(this, GruppeOverviewActivity.class);

        switch(grp)
        {
            case "Gruppe A":
                intent.putExtra(GRUPPE, Spielarten.GRUPPE_A);
                break;
            case "Gruppe B":
                intent.putExtra(GRUPPE, Spielarten.GRUPPE_B);
                break;
            case "Gruppe C":
                intent.putExtra(GRUPPE, Spielarten.GRUPPE_C);
                break;
            case "Gruppe D":
                intent.putExtra(GRUPPE, Spielarten.GRUPPE_D);
                break;
            case "Gruppe E":
                intent.putExtra(GRUPPE, Spielarten.GRUPPE_E);
                break;
            case "Gruppe F":
                intent.putExtra(GRUPPE, Spielarten.GRUPPE_F);
                break;
            case "Achtel\nFinale":
                intent.putExtra(GRUPPE, Spielarten.ACHTEL_FINALE);
                break;
            case "Viertel\nFinale":
                intent.putExtra(GRUPPE, Spielarten.VIERTEL_FINALE);
                break;
            case "Halb\nFinale":
                intent.putExtra(GRUPPE, Spielarten.HALB_FINALE);
                break;
        }

        startActivity(intent);
    }

    public void onClickFinale(View button)
    {
        final Intent intent = new Intent(this, SpielDetailActivity.class);
        intent.putExtra(GRUPPE, Spielarten.FINALE);
        intent.putExtra(GruppeOverviewActivity.SPIEL_ID, FINAL_ID);
        startActivity(intent);
    }
}
