package tech.rpairo.energyseries.adapters;

import android.content.Context;
import android.view.View;

import com.bumptech.glide.Glide;

import java.util.ArrayList;
import java.util.List;

import tech.rpairo.energyseries.R;
import tech.rpairo.energyseries.model.Temporada;

/**
 * Created by Raul on 27/6/16.
 */
public class AdapterRecyclerInfoTemporadas extends AdapterRecyclerSeries {

    //region Variables
    private List<Temporada> temporadas;
    //endregion

    //region Constructores
    public AdapterRecyclerInfoTemporadas(List<Temporada> items, Context context) {
        super(null, context);

        this.temporadas = items;
    }

    @Override
    public void onBindViewHolder(final ViewHolderSeries viewHolderSeries, final int i) {

        Glide.with(this.context)
                .load(this.temporadas.get(i).getPoster())
                .override(350, 400)
                .into(viewHolderSeries.poster);

        String temporada = this.temporadas.get(i).getNumberSeason();

        temporada = temporada.equals("0") ?
                this.context.getResources().getString(R.string.especial) :
                this.context.getResources().getString(R.string.temporada) + " " + this.temporadas.get(i).getNumberSeason();


        viewHolderSeries.titulo.setText(temporada);

        viewHolderSeries.poster.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                launchActivity(i);
            }
        });
    }
    //endregion

    //region Funciones del Adapter
    @Override
    public int getItemCount() {
        return this.temporadas.size();
    }
    //endregion

    //region Funciones auxiliares
    @Override
    protected void launchActivity(int position) {

    }

    public void addAllTemporadas(ArrayList<Temporada> temporadas) {
        if (temporadas == null)
            throw new NullPointerException("No puedes pasar una lista nula");

        this.temporadas.addAll(temporadas);
        this.notifyDataSetChanged();
    }
    //endregion
}