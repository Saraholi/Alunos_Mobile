package br.com.senaijandira.alunos.service;

import java.util.List;

import br.com.senaijandira.alunos.model.Aluno;
import br.com.senaijandira.alunos.model.ApiResult;
import retrofit2.Call;
import retrofit2.http.Body;
import retrofit2.http.GET;
import retrofit2.http.POST;
import retrofit2.http.Path;

public interface AlunoService {

    String URL_BASE = "http://10.0.2.2:5001/";

    @GET("/alunos")
    Call<List<Aluno>> obterAlunos();

    @GET("/aluno/{id}")
    Call<Aluno> obterAlunoPorId(@Path("id") int id);

    @POST("/novo")
    Call<ApiResult> cadastrarAluno(@Body Aluno aluno);

}
