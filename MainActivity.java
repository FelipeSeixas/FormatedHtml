package com.example.htmlformatado;

import android.app.ActionBar;
import android.content.Context;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.text.method.LinkMovementMethod;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;
import androidx.core.text.HtmlCompat;
import androidx.fragment.app.DialogFragment;
import androidx.fragment.app.FragmentManager;

import org.jsoup.*;
import org.jsoup.nodes.Document;

public class MainActivity extends AppCompatActivity{

    TextView textView1;
    ImageView imgTop;

    Button linkButton;
    Button quitButton;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        textView1 = findViewById(R.id.MeuTexto);
        imgTop = findViewById(R.id.image1);

        String htmlTextUnformatted = "Prezado cliente! " +
                "<br> Informamos que a partir do " +
//                Itálico
                "<i>mês de janeiro</i> os pedidos de " +

                "XXXXXX deverão ser ingressados " +
                "na\nplataforma\nXXXXXXXX, para" +
                " que possamos prestar " +
//                Negrito comum
                "<b>atendimento</b> na xxxxxxxxxxxx e " +

//                Negrito Strong
                "<strong>suporte logístico</strong>." +
                "\nLocalize o GT da sua região\n" +
                "para te auxiliar na YYYYYYYYYYYYYYYYYYYYYY." +
                "<br> " +
                "<br>" +
                "\n" +
                "Obs: No momento essa regra não se aplica aos clientes</br>" +
                "\n do YYYYYYYYY. <br>\\n" +
                "<a href=\"https://www.globoesporte.com\">Clique Aqui</a>" +
                " para saber\nmais.\n<br>\n<a href=\"https://drive.google.com\">\n" +
                "  <img src=\"https://SSSSSSSSSSSSSSSSSS.png\"\n        height=\\\"600\\\" width=\\\"500\\\">\n</a>\"";

        String htmlFormatted1 = htmlTextUnformatted.replace("\\n", "").replace("\\t", "").replace("\\r", "");
        Document htmlFormatted2 = Jsoup.parse(htmlFormatted1);
        String imageHtml = htmlFormatted2.select("img").remove().toString();

//        Atualização do texto
        textView1.setText(HtmlCompat.fromHtml(String.valueOf(htmlFormatted2),HtmlCompat.FROM_HTML_MODE_LEGACY));
        textView1.setMovementMethod(LinkMovementMethod.getInstance());

        imgTop.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Toast.makeText(getApplicationContext(),"Click realizado",Toast.LENGTH_LONG).show();
                openDialog();
            }
        });

    private void openDialog() {
        ImageFragment modal1 = new ImageFragment();
        modal1.show(getSupportFragmentManager(),"testeModal");
    }
}