/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Ejercicio4;

/**
 *
 * @author jmore
 */
public class EjercicioArticle {
    public static void main(String[] args) {
        Article article_1 = new Article("Pijama", 10, 4,4);
        
        System.out.printf("\n%s - Preu:%.2fe - IVA:%.0f%% - PVP:%.2fe", article_1.nom, article_1.preu, (article_1.iva-1)*100, article_1.preu*article_1.iva);
        
    }
}
