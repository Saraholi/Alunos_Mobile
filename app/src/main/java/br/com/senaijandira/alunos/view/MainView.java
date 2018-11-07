package br.com.senaijandira.alunos.view;

import java.util.List;

import br.com.senaijandira.alunos.model.Aluno;

/**
 * Created by sn1041520 on 29/10/2018.
 */

public interface MainView {

    void exibirBarraProgresso();

    void esconderBarraProgresso();

    void preencherLista(List<Aluno> lstAlunos);

}
