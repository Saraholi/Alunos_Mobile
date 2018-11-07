package br.com.senaijandira.alunos.presenter;

import br.com.senaijandira.alunos.model.Aluno;
import br.com.senaijandira.alunos.service.AlunoService;
import br.com.senaijandira.alunos.view.VisualizarAlunoView;
import retrofit2.Callback;
import retrofit2.Response;

public class VisualizarPresenter {

    AlunoService service;
    VisualizarAlunoView view;

    public VisualizarPresenter(AlunoService service, VisualizarAlunoView view) {
        this.service = service;
        this.view = view;
    }

    public void carregarAluno(int id){
        service.obterAlunoPorId(id).enqueue(new Callback<Aluno>() {
            @Override
            public void onResponse(retrofit2.Call<Aluno> call, Response<Aluno> response) {
                Aluno aluno = response.body();
                view.mostrarDadosAluno(aluno);
            }

            @Override
            public void onFailure(retrofit2.Call<Aluno> call, Throwable t) {
                t.printStackTrace();

            }
        });


    }
}
