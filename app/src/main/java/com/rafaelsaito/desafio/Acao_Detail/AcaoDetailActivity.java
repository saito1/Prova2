package com.rafaelsaito.desafio.Acao_Detail;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import android.widget.Toast;

import com.rafaelsaito.desafio.Entity.AcaoEntity;
import com.rafaelsaito.desafio.R;
import com.squareup.picasso.Picasso;

import butterknife.BindView;
import butterknife.ButterKnife;

public class AcaoDetailActivity extends AppCompatActivity implements AcaoDetailView{

    @BindView(R.id.image_view_header) ImageView imgHeader;
    @BindView(R.id.text_view_description) TextView tvDescription;
    @BindView(R.id.text_view_site2) TextView tvSite;
    @BindView(R.id.linear_layout_loading) LinearLayout loadingLayout;

    AcaoDetailPresenter acaoDetailPresenter;

    AcaoEntity acaoEntity;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_acao_detail);

        //insere opção Up Action na ActionBar
        if (getSupportActionBar() != null) {
            getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        }

        ButterKnife.bind(this);

        Intent intent = getIntent();
        acaoEntity = (AcaoEntity) getIntent().getSerializableExtra("acao");

        acaoDetailPresenter = new AcaoDetailPresenter(this);
        acaoDetailPresenter.getAcaoDetails(acaoEntity);
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.menu_download, menu);
        return super.onCreateOptionsMenu(menu);
    }

    @Override
    public void showDetail(AcaoEntity acaoDetailEntity) {
        tvDescription.setText(acaoDetailEntity.getDescription());
        tvSite.setText(acaoDetailEntity.getSite());
        Picasso.with(this)
                .load(acaoDetailEntity.getCoverImageUrl())
                .centerCrop()
                .fit()
                .into(imgHeader);
        setTitle(acaoDetailEntity.getName());
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        switch (item.getItemId()) {
            case android.R.id.home:
                onBackPressed();
                return true;

            default:
                return super.onOptionsItemSelected(item);
        }
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
