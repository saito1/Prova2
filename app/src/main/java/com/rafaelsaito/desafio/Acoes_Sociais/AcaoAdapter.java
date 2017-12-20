package com.rafaelsaito.desafio.Acoes_Sociais;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.rafaelsaito.desafio.Entity.AcaoEntity;
import com.rafaelsaito.desafio.R;
import com.squareup.picasso.Picasso;

import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;

/**
 * Created by Rafael Saito on 18/12/2017.
 */

public class AcaoAdapter extends RecyclerView.Adapter<AcaoAdapter.ViewHolder> {

    private List<AcaoEntity> acaoList;
    OnRecyclerViewSelected onRecyclerViewSelected;
    private Context context;

    //Construtor que recebe a lista
    AcaoAdapter(List<AcaoEntity> acaoList, Context context) {
        this.acaoList = acaoList;
        this.context = context;
    }

    //infla o componente view
    @Override
    public ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View v = LayoutInflater.from(parent.getContext()).inflate(R.layout.acao_item_list, parent, false);
        return new ViewHolder(v);
    }

    //seta os dados nas views
    @Override
    public void onBindViewHolder(ViewHolder holder, int position) {
        AcaoEntity acaoEntity = acaoList.get(position);
        holder.txMovieName.setText(acaoEntity.getName());
        Picasso.with(context)
                .load(acaoEntity.getCoverImageUrl())
                .centerCrop()
                .fit()
                .into(holder.imgBackgroud);
    }

    //retorna o tamanho da lista
    @Override
    public int getItemCount() {
        return acaoList.size();
    }

    //mapeamento dos componentes da view
    public class ViewHolder extends RecyclerView.ViewHolder {

        @BindView(R.id.tx_acao_name)
        TextView txMovieName;

        @BindView(R.id.image_view_background)
        ImageView imgBackgroud;

        public ViewHolder(View itemView) {
            super(itemView);
            ButterKnife.bind(this, itemView);
        }

        //seta o clique rápido
        @OnClick(R.id.container)
        void onItemClick(View view) {
            if (onRecyclerViewSelected != null)
                onRecyclerViewSelected.onClick(view, getAdapterPosition());
        }
    }

    public void setOnRecyclerViewSelected(OnRecyclerViewSelected onRecyclerViewSelected){
        this.onRecyclerViewSelected = onRecyclerViewSelected;
    }
}
