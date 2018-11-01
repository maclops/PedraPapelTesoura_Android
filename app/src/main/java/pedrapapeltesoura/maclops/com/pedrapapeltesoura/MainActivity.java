package pedrapapeltesoura.maclops.com.pedrapapeltesoura;

import android.app.Activity;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.Random;

public class MainActivity extends Activity {

    private TextView textVitoria;
    private TextView textDerrota;
    private TextView textEmpate;
    private TextView textTotal;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        textVitoria = findViewById(R.id.textVitoria);
        textDerrota = findViewById(R.id.textDerrota);
        textEmpate = findViewById(R.id.textEmpate);
        textTotal = findViewById(R.id.textTotal);

    }

    public void selecionarPedra(View view) {
        this.opcaoSelecionada("pedra");
    }

    public void selecionarPapel(View view) {
        this.opcaoSelecionada("papel");
    }

    public void selecionarTesoura(View view) {
        this.opcaoSelecionada("tesoura");
    }

    public void opcaoSelecionada(String escolhaUsuario) {

        ImageView imagemResultado = findViewById(R.id.imageResultado);
        TextView textResultado = findViewById(R.id.textResultado);

        String opcoes[] = {"pedra", "papel", "tesoura"};
        int opcao = new Random().nextInt(3);
        int vitoria = Integer.parseInt(textVitoria.getText().toString());
        int derrota = Integer.parseInt(textDerrota.getText().toString());
        int empate = Integer.parseInt(textEmpate.getText().toString());
        int total = Integer.parseInt(textTotal.getText().toString());

        String escolhaApp = opcoes[opcao];

        switch (escolhaApp) {
            case "pedra":
                imagemResultado.setImageResource(R.drawable.pedra);
                break;
            case "papel":
                imagemResultado.setImageResource(R.drawable.papel);
                break;
            case "tesoura":
                imagemResultado.setImageResource(R.drawable.tesoura);
                break;
        }

        if (escolhaApp == "pedra" && escolhaUsuario == "tesoura" ||
                escolhaApp == "tesoura" && escolhaUsuario == "papel" ||
                escolhaApp == "papel" && escolhaUsuario == "pedra") {
            textResultado.setText("Você perdeu!! muahahahahahaha");
            derrota++;
            textDerrota.setText(""+derrota);
        } else if (escolhaUsuario == "pedra" && escolhaApp == "tesoura" ||
                escolhaUsuario == "tesoura" && escolhaApp == "papel" ||
                escolhaUsuario == "papel" && escolhaApp == "pedra") {
            textResultado.setText("Você ganhou, parabéns!!");
            vitoria++;
            textVitoria.setText(""+vitoria);
        } else {
            textResultado.setText("Empatamos, tenta de novo na próxima.");
            empate++;
            textEmpate.setText(""+empate);
        }
        total++;
        textTotal.setText(""+total);
    }
}
/*
    public void calcular() {
        double valorDigitado = Double.parseDouble(editValor.getText().toString());

        double gorjeta = valorDigitado * (porcentagem/100);
        double total = gorjeta + valorDigitado;

        textGorjeta.setText("R$ "+ Math.round(gorjeta));
        textTotal.setText("R$ "+total);
    }
 */