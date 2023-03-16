package com.example.htmlformatado

import android.text.Html
import android.text.Spanned
import android.text.method.LinkMovementMethod
import android.widget.TextView
import androidx.core.text.HtmlCompat

open class Html {

    /**
     * Returns a [Spanned] from parsing this string as HTML.
     *
     * @param flags Additional option to set the behavior of the HTML parsing. Default is set to
     * [Html.FROM_HTML_MODE_LEGACY] which was introduced in API 24.
     * @param imageGetter Returns displayable styled text from the provided HTML string.
     * @param tagHandler Notified when HTML tags are encountered a tag the parser does
     * not know how to interpret.
     *
     * @see Html.fromHtml
     */

    var textView1: TextView? = null


//        String htmlText = "Texto \\n em <b>negrito</b>";
    /*String htmlText1 = "<h1>Heading 1</h1>" +
                "<h2>Heading 2</h2>" +
                "<p>This is some html. Look, here's an <u>underline</u>.</p>" +
                "<p>Look, this is <em>emphasized.</em> And They\\'s some <b>bold</b> and <strong>suporte logístico</strong>.</p>" +
                "<p>Here are UL list items:" +
                "<ul>    " +
                "   <li>One</li>    " +
                "   <li>Two</li>    " +
                "   <li>Three</li>" +
                "</ul>" +
                "<p>Here are OL list items:" +
                "<ol>" +
                "    <li>One</li>" +
                "    <li>T\\nwo</li>" +
                "    <li>Three</li>" +
                "</ol>"

           

    textView1 = findViewById<TextView?>(R.id.MeuTexto)

    var htmlText1 =
        """Prezado cliente! <br> Informamos que a partir do <i>mês de janeiro</i> os produtos deverão ser ingressados na
plataforma para que possamos prestar <b>atendimento</b> na negociação de preços e <strong>suporte logístico</strong>.
Ajudaremos a te auxiliar na negociação de preços e suporte logístico.<br> <br>
Obs: No momento essa regra não se aplica aos clientes xxxxxxx</br>
 <br>\n<a href="https://www.google.com">Clique Aqui</a> para saber
mais.
<br>
<a href="https://drive.google.com/file/d/1pY-yJq0ym9EIORxtEbnqcGwAZbp4JZzZ/view?usp=sharing">
  <img src="https://unsplash.com/pt-br/fotografias/ZoDVqZBf0iU"
        height=\"600\" width=\"500\">
</a>""""

    //FUNCIONOU 100%:
    textView1.setText(HtmlCompat.fromHtml(htmlText1, HtmlCompat.FROM_HTML_MODE_LEGACY))
    textView1.setMovementMethod(LinkMovementMethod.getInstance())


    textView1.setText(HtmlCompat.fromHtml(htmlText1, HtmlCompat.FROM_HTML_MODE_LEGACY))
    textView1.setMovementMethod(LinkMovementMethod.getInstance())

    public inline fun String.parseAsHtml(
        flags: Int = HtmlCompat.FROM_HTML_MODE_LEGACY,
        imageGetter: Html.ImageGetter? = null,
        tagHandler: Html.TagHandler? = null
    ): Spanned = HtmlCompat.fromHtml(this, flags, imageGetter, tagHandler)

 
    public inline fun Spanned.toHtml(
        option: Int = HtmlCompat.TO_HTML_PARAGRAPH_LINES_CONSECUTIVE
    ): String = HtmlCompat.toHtml(this, option)
}