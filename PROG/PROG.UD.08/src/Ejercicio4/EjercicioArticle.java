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
        
        System.out.printf("\n%s - Preu:%.2fe - IVA:%.0f%% - PVP:%.2fe\n", article_1.getNom(), article_1.getPreu(), (article_1.getIva()-1)*100, article_1.getPreu()*article_1.getIva());        
        
        article_1.setNom("Pijama a cuadros");
        article_1.setPreu(10.50);
        article_1.setIva(21);
        article_1.setStock(3);
        
        System.out.printf("\nLa modificacion es la siguiente: %s - Preu:%.2fe - IVA:%.0f%% - PVP:%.2fe\n", article_1.getNom(), article_1.getPreu(), (article_1.getIva()-1)*100, article_1.getPreu()*article_1.getIva());        
        System.out.println("Precio con descuento del 10% es "+article_1.getPVPDescompte(10)+"e");
        System.out.println("El precio sin descuento con IVA es "+article_1.getPVP()+"e");
        article_1.vendre(2);
        article_1.emmagatzema(3);
        article_1.imprimeix();
        
        
        article_1.vendre(1);
        article_1.setNom("Pijama a rombos");
        article_1.setIva(30);
        article_1.imprimeix();
        
    }
}
