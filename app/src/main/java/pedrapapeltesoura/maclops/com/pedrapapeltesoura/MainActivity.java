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
        String saidaVitoria[] = {"Você ganhou, parabéns!!", "Nossa como você é bom nisso!!", "Wow, você é bom nisso!", "Parabéns campeão!", "Venceu mais uma, parabéns!"};
        String saidaDerrota[] = {"Você perdeu!! muahahahahahaha", "Mais você é muito novatinho", "Menino novo!!", "Tenta de novo na próxima, bonitão", "Ai que dó"};
        String saidaEmpate[] = {"Empatamos, tenta de novo na próxima.", "Nem pra mim, nem pra você!", "Hello world", "Quase, mas na próxima eu ganho!!", "Ah seu espertinho..."};

        int opcao = new Random().nextInt(3);
        int saida = new Random().nextInt(5);
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
            textResultado.setText(saidaDerrota[saida]);
            derrota++;
            textDerrota.setText(""+derrota);
        } else if (escolhaUsuario == "pedra" && escolhaApp == "tesoura" ||
                escolhaUsuario == "tesoura" && escolhaApp == "papel" ||
                escolhaUsuario == "papel" && escolhaApp == "pedra") {
            textResultado.setText(saidaVitoria[saida]);
            vitoria++;
            textVitoria.setText(""+vitoria);
        } else {
            textResultado.setText(saidaEmpate[saida]);
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