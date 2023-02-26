/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package EMPRESA_I_EMPLEATS;

/**
 *
 * @author jmore
 */
public class Programa {
    public static void main(String[] args) {
        //creacio de empleats
        Empleats administratiu = new Empleats("Francisco", "12234567A", 999.95);
        Empleats directora = new Empleats("Maria","87654321F", 2825.74);
        Empleats dependenta = new Empleats("Luisa", "11115555Q", 1080);
        Empleats magatzemera = new Empleats("Carmen", "88877766M", 2000.55);
        
        //creacio de empresa
        Empreses gransmagatzems = new Empreses("Corte Ingles", "M5274196V");
        Empreses supermercats = new Empreses("Mercadona", "M74185225F");
        
        //afegir empleats a les empreses
        gransmagatzems.afegirEmpleats(dependenta);
        gransmagatzems.afegirEmpleats(magatzemera);
        gransmagatzems.afegirEmpleats(administratiu);
        System.out.println("");
        
        supermercats.afegirEmpleats(directora);
        supermercats.afegirEmpleats(new Empleats("Pepe","52659570N", 2500));
        System.out.println("");
        
        //informe de tots els empleats abans de eliminar a la dependenta
        gransmagatzems.informeTotsEmpleats();
        
        //elimina al empleat dependenta de la seua empresa
        gransmagatzems.eliminarEmpleats(dependenta);
        System.out.println("");
        
        //informe de tots els empleats de les dues empreses
        gransmagatzems.informeTotsEmpleats();
        supermercats.informeTotsEmpleats();
        
        //informe de tots els sous dels empleats
        gransmagatzems.informeSouEmpleats();
        supermercats.informeSouEmpleats();
        
        //suma de tots els sous en brut
        System.out.printf("La suma de tots els sous bruts dels empleats del %s, dona %.2f euros.\n",gransmagatzems.getNom(), gransmagatzems.calculaSousBruts());
        System.out.printf("La suma de tots els sous bruts dels empleats del %s, dona %.2f euros.\n",supermercats.getNom(),supermercats.calculaSousBruts());
        System.out.println("");
        
        //suma de tots els sous en net
        System.out.printf("La suma de tots els sous nets dels empleats del %s, dona %.2f euros.\n",gransmagatzems.getNom(),gransmagatzems.calculaSousNets());
        System.out.printf("La suma de tots els sous nets dels empleats del %s, dona %.2f euros.\n",supermercats.getNom(),supermercats.calculaSousNets());
    }
}