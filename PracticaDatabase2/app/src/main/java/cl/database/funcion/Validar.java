package cl.database.funciones;

public class Validar {

    public boolean validarCampoVacio(int code_article, String name_article, String description_article)
    {
        if (code_article == 0 || name_article.isEmpty() || description_article.isEmpty()) {
            return true;
        }
        return false;
    }

    public boolean validarCodigo(int code_article)
    {
        if (code_article == 0) {
            return true;
        }
        return false;
    }
}