package br.com.marcioviana.calculadoradenotas;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    private EditText nota1, nota2, nota3, nota4, numeroDeFaltas;
    private Button btCalcular;
    private TextView txtResultado;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        nota1 = findViewById(R.id.nota1);
        nota2 = findViewById(R.id.nota2);
        nota3 = findViewById(R.id.nota3);
        nota4 = findViewById(R.id.nota4);
        numeroDeFaltas = findViewById(R.id.numeroFaltas);
        btCalcular = findViewById(R.id.bt_calcular);
        txtResultado = findViewById(R.id.txt_resultado);

        btCalcular.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                int n1 = Integer.parseInt(nota1.getText().toString());
                int n2 = Integer.parseInt(nota2.getText().toString());
                int n3 = Integer.parseInt(nota3.getText().toString());
                int n4 = Integer.parseInt(nota4.getText().toString());
                int numero_faltas = Integer.parseInt(numeroDeFaltas.getText().toString());
                int media = (n1 + n2 + n3 + n4) / 4;

                if (media >= 5 && numero_faltas <= 20 ){
                    txtResultado.setText("Aluno foi APROVADO! \n " + "Média Final: " + media);
                    txtResultado.setTextColor(getColor(R.color.green));
                }else if (numero_faltas > 20){
                    txtResultado.setText("Aluno REPROVADO por faltas. \n " + "Média Final: " + media);
                    txtResultado.setTextColor(getColor(R.color.red));
                }else{
                    txtResultado.setText("O Aluno foi REPROVADO por notas. \n " + "Média Final: " + media);
                }

            }
        });
    }
}