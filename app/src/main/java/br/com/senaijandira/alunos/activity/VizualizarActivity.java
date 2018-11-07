package br.com.senaijandira.alunos.activity;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.widget.TextView;

import br.com.senaijandira.alunos.R;
import br.com.senaijandira.alunos.model.Aluno;
import br.com.senaijandira.alunos.presenter.VisualizarPresenter;
import br.com.senaijandira.alunos.service.ServiceFactory;
import br.com.senaijandira.alunos.view.VisualizarAlunoView;

public class VizualizarActivity
        extends AppCompatActivity
        implements VisualizarAlunoView{


    TextView txtNome,txtMatricula,txtCpf,txtDtNascimento,txtMedia;

    VisualizarPresenter presenter;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_vizualizar);

        presenter = new VisualizarPresenter( ServiceFactory.create(),this);

        txtNome = findViewById(R.id.txtNome);
        txtMatricula =  findViewById(R.id.txtMatricula);
        txtCpf = findViewById(R.id.txtCpf);
        txtDtNascimento = findViewById(R.id.txtDtNascimento);
        txtMedia = findViewById(R.id.txtMedia);


        int idAluno = getIntent().getIntExtra("idAluno",0);
        Log.d("ID_ALUNO",idAluno+"");

        presenter.carregarAluno(idAluno);
    }




    @Override
    public void mostrarDadosAluno(Aluno aluno){
        // O simbolo +" é de concatenação do dado que vai vir inteiro para string.

    txtNome.setText(aluno.getNome());
    txtDtNascimento.setText(aluno.getDataNascimento() + "");
    txtMatricula.setText(aluno.getMatricula() + "");
    txtCpf.setText(aluno.getCpf());
    //txtMedia.setText(aluno.getMedia());

    }




}
