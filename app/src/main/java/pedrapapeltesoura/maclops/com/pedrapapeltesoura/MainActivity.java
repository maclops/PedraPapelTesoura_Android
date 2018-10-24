package pedrapapeltesoura.maclops.com.pedrapapeltesoura;

import android.app.Activity;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.Random;

public class MainActivity extends Activity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
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
        String escolhaApp = opcoes[opcao];

        switch (escolhaApp) {
            case "pedra" :
                imagemResultado.setImageResource(R.drawable.pedra);
                break;
            case "papel" :
                imagemResultado.setImageResource(R.drawable.papel);
                break;
            case "tesoura" :
                imagemResultado.setImageResource(R.drawable.tesoura);
                break;
        }

        if (escolhaApp=="pedra" && escolhaUsuario=="tesoura"||
            escolhaApp=="tesoura" && escolhaUsuario=="papel"||
            escolhaApp=="papel" && escolhaUsuario=="pedra") {
            textResultado.setText("Você perdeu!! muahahahahahaha");
        } else if (escolhaUsuario=="pedra" && escolhaApp=="tesoura"||
                escolhaUsuario=="tesoura" && escolhaApp=="papel"||
                escolhaUsuario=="papel" && escolhaApp=="pedra") {
            textResultado.setText("Você ganhou, parabéns!!");
        } else {
            textResultado.setText("Empatamos, tenta de novo na próxima.");
        }

    }

}
