package br.com.senaijandira.alunos.activity;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;
import android.widget.ProgressBar;

import java.util.List;

import br.com.senaijandira.alunos.presenter.MainPresenter;
import br.com.senaijandira.alunos.view.MainView;
import br.com.senaijandira.alunos.R;
import br.com.senaijandira.alunos.adapter.AlunoAdapter;
import br.com.senaijandira.alunos.model.Aluno;
import br.com.senaijandira.alunos.service.ServiceFactory;

public class MainActivity
        extends AppCompatActivity
        implements MainView,
        AdapterView.OnItemClickListener

{

    ListView listView;
    AlunoAdapter adapter;

    ProgressBar progressBar;

    MainPresenter presenter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        progressBar = findViewById(R.id.progressBar);

        listView = findViewById(R.id.listView);

        //instanciar o Adapter
        adapter = new AlunoAdapter(this);

        //plugar o adapter na lista
        listView.setAdapter(adapter);


        listView.setOnItemClickListener(this);

        //config presenter
        presenter = new MainPresenter(this,
                ServiceFactory.create());



    }


    @Override
    protected void onResume() {
        super.onResume();
        presenter.carregarAlunos();
    }

    @Override
    public void exibirBarraProgresso(){
        progressBar.setVisibility(View.VISIBLE);
        listView.setVisibility(View.GONE);
    }

    @Override
    public void esconderBarraProgresso(){
        progressBar.setVisibility(View.GONE);
        listView.setVisibility(View.VISIBLE);
    }

    @Override
    public void preencherLista(List<Aluno> lstAlunos){
        adapter.clear();
        adapter.addAll(lstAlunos);
    }

    public void abrirTelaCadastro(View view) {

        startActivity(new Intent(this,CadastroActivity.class));

    }

    @Override
    public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
        Aluno alunoClicado = adapter.getItem(position);

        Intent intent = new Intent(this, VizualizarActivity.class);
        intent.putExtra("idAluno", alunoClicado.getId());

        startActivity(intent);

    }
}
