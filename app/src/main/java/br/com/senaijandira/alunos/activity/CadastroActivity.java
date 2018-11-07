package br.com.senaijandira.alunos.activity;

import android.app.DatePickerDialog;
import android.app.Dialog;
import android.content.DialogInterface;
import android.os.Bundle;
import android.support.v4.app.DialogFragment;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.DatePicker;
import android.widget.EditText;

import java.util.Calendar;

import br.com.senaijandira.alunos.R;
import br.com.senaijandira.alunos.model.Aluno;
import br.com.senaijandira.alunos.presenter.CadastroPresenter;
import br.com.senaijandira.alunos.service.AlunoService;
import br.com.senaijandira.alunos.service.ServiceFactory;
import br.com.senaijandira.alunos.util.DateUtil;
import br.com.senaijandira.alunos.view.CadastroView;

public class CadastroActivity extends AppCompatActivity implements CadastroView {

    AlunoService service = ServiceFactory.create();

    static EditText txtNome, txtDtNascimento , txtMatricula, txtCpf;

    CadastroPresenter presenter;

    @Override
    protected void onCreate(Bundle savedInstanceState){

        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_cadastro);
        presenter = new CadastroPresenter(this,service);


        txtNome = findViewById(R.id.txtNome);
        txtDtNascimento = findViewById(R.id.txtDtNascimento);
        txtMatricula = findViewById(R.id.txtMatricula);
        txtCpf = findViewById(R.id.txtCpf);
    }

    public void cadastrarAluno(View view) {

        String nome = txtNome.getText().toString();
        String dtNascimento = txtDtNascimento.getText().toString();
        String Matricula = txtMatricula.getText().toString();
        String Cpf = txtCpf.getText().toString();

        int dataConvertida = new DateUtil().coverteToInt(dtNascimento);

        Aluno aluno = new Aluno();
        aluno.setNome(nome);
        aluno.setMatricula(Integer.parseInt(Matricula));
        aluno.setDataNascimento(dataConvertida);
        aluno.setCpf(Cpf);

        presenter.CadastrarAluno(aluno);

    }


    @Override
    public void showMessage(String titulo,String mensagem){
        AlertDialog.Builder alert = new AlertDialog.Builder(this);
        alert.setTitle(titulo);
        alert.setMessage(mensagem);
        alert.setPositiveButton("ok", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {
                finish();
            }
        });


        alert.show();

    }

    public void abrirCalendario(View view) {

        DialogFragment newFragment = new DatePickerFragment();
        newFragment.show(getSupportFragmentManager(), "datePicker");



    }

    public static class DatePickerFragment extends DialogFragment
            implements DatePickerDialog.OnDateSetListener {

        @Override
        public Dialog onCreateDialog(Bundle savedInstanceState) {
            // Use the current date as the default date in the picker
            final Calendar c = Calendar.getInstance();
            int year = c.get(Calendar.YEAR);
            int month = c.get(Calendar.MONTH);
            int day = c.get(Calendar.DAY_OF_MONTH);

            // Create a new instance of DatePickerDialog and return it
            return new DatePickerDialog(getActivity(), this, year, month, day);
        }

        public void onDateSet(DatePicker view, int year, int month, int day) {
            // Do something with the date chosen by the user
            String data = String.format("%02d/%02d/%d",day,month+1,year);


            txtDtNascimento.setText(data);

        }
    }


}
