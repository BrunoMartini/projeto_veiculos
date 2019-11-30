/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ferramentas;

/**
 *
 * @author Bruno Martini
 */
public class Criptografia {
    
    private static String table = " !\"#$%&\\'()*+,-./6853420719:;<=>?@XAOCDENUGHIPJLMNBQSTFVWRKYZ[\\\\]^_`qfbcwrdsemgjklnoptauvhyzix{|}~";
    private static int key = 7; //Escolha um número de 2 a 10

    private static String limparTexto(String text) {
        text = text.replaceAll("\n", "");

        for (int x = 0; x < text.length(); x++) {
            int position = table.indexOf(text.charAt(x));

            if (position == -1) {
                text = text.replace(text.charAt(x), ' ');
            }
        }
        return text;
    }
    
    public static String Encriptar(String text) {
        String cleaned_text = limparTexto(text);

        String encrypted = "";

        for (int i = 0; i < cleaned_text.length(); i++) {
            int position = table.indexOf(cleaned_text.charAt(i));

            if ((position + key) < table.length()) {
                encrypted += table.charAt(position + key);
            } else {
                encrypted += table.charAt((position + key) - table.length());
            }
        }
        return encrypted;
    }
    
    public static String Decriptar(String text) {
        String cleaned_text = limparTexto(text);

        String decrypted = "";

        for (int x = 0; x < cleaned_text.length(); x++) {
            int position = table.indexOf(cleaned_text.charAt(x));

            if ((position - key) < 0) {
                decrypted += table.charAt((position - key) + table.length());
            } else {
                decrypted += table.charAt(position - key);
            }
        }
        return decrypted;
    }
    
}
