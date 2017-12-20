package com.rafaelsaito.desafio.Acoes_Sociais;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.DividerItemDecoration;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.LinearLayout;
import android.widget.Toast;

import com.rafaelsaito.desafio.Acao_Detail.AcaoDetailActivity;
import com.rafaelsaito.desafio.Entity.AcaoEntity;
import com.rafaelsaito.desafio.R;

import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;

public class AcaoActivity extends AppCompatActivity implements AcaoView{

    @BindView(R.id.rv_acoes) RecyclerView rvAcoes;
    @BindView(R.id.linear_layout_loading) LinearLayout loadingLayout;

    AcaoPresenter acaoPresenter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_acao);

        ButterKnife.bind(this);
        acaoPresenter = new AcaoPresenter(this);
        acaoPresenter.updateList();
    }

    @Override
    public void updateList(final List<AcaoEntity> acaoList) {
        //seta o adapter
        final AcaoAdapter acaoAdapter = new AcaoAdapter(acaoList, this);
        acaoAdapter.setOnRecyclerViewSelected(new OnRecyclerViewSelected() {
            @Override
            public void onClick(View view, int position) {
                Intent intent = new Intent(AcaoActivity.this, AcaoDetailActivity.class);
                AcaoEntity acaoEntity = acaoPresenter.getAcaoId(position);
                intent.putExtra("acao", acaoEntity);
                startActivity(intent);
            }
        });

        rvAcoes.setAdapter(acaoAdapter);

        // criação do gerenciador de layouts
        LinearLayoutManager layoutManager = new LinearLayoutManager(this);
        DividerItemDecoration dividerItemDecoration = new DividerItemDecoration(this, layoutManager.getOrientation());

        rvAcoes.setLayoutManager(layoutManager);
        rvAcoes.addItemDecoration(dividerItemDecoration);
    }

    @Override
    public void showMessage(String msg) {
        Toast.makeText(this, msg, Toast.LENGTH_SHORT).show();
    }

    @Override
    public void showLoading() {
        loadingLayout.setVisibility(View.VISIBLE);
    }

    @Override
    public void hideLoading() {
        loadingLayout.setVisibility(View.GONE);
    }
}
