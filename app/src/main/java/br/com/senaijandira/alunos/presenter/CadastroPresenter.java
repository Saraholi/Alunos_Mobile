package br.com.senaijandira.alunos.presenter;

import br.com.senaijandira.alunos.model.Aluno;
import br.com.senaijandira.alunos.model.ApiResult;
import br.com.senaijandira.alunos.service.AlunoService;
import br.com.senaijandira.alunos.view.CadastroView;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class CadastroPresenter {
    CadastroView view;
    AlunoService service;


    public CadastroPresenter(CadastroView view, AlunoService service) {
        this.view = view;
        this.service = service;
    }


    public void CadastrarAluno(Aluno aluno){

        service.cadastrarAluno(aluno).enqueue(new Callback<ApiResult>() {
            @Override
            public void onResponse(Call<ApiResult> call, Response<ApiResult> response) {

                ApiResult result = response.body();
                if (result.isSucesso()){
                    view.showMessage ("Sucesso", "Cadastro com Sucesso");
                }else {
                   view.showMessage ("Erro", "Erro ao Cadastrar");
                }
            }










            @Override
            public void onFailure(Call<ApiResult> call, Throwable t) {

                t.printStackTrace();

            }
        });
    }
}
