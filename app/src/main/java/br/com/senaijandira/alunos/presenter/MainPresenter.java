package br.com.senaijandira.alunos.presenter;

import android.util.Log;

import java.util.List;

import br.com.senaijandira.alunos.model.Aluno;
import br.com.senaijandira.alunos.service.AlunoService;
import br.com.senaijandira.alunos.view.MainView;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

/**
 * Created by sn1041520 on 29/10/2018.
 */

public class MainPresenter {

    MainView mainView;
    AlunoService service;

    public MainPresenter(MainView mainView,AlunoService service){
        this.mainView = mainView;
        this.service = service;
    }

    public void carregarAlunos() {

        //Objeto de chamada a API de alunos
        Call<List<Aluno>> call = service.obterAlunos();

        mainView.exibirBarraProgresso();

        //Efetuar a chamada a API
        call.enqueue(new Callback<List<Aluno>>() {
            @Override
            public void onResponse(Call<List<Aluno>> call, Response<List<Aluno>> response) {

                //Lista de alunos retornada pelo servidor
                List<Aluno> alunos = response.body();

                //Exibe os alunos na tela
                mainView.preencherLista(alunos);

                mainView.esconderBarraProgresso();
            }

            @Override
            public void onFailure(Call<List<Aluno>> call, Throwable t) {
                Log.e("ERRO_API", t.getMessage());
            }
        });

    }

}
