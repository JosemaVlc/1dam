package ed.p1t5_netbeans;

/**
 * Ejemplo simple de comentarios en JavaDoc
 * 
 * @version 1.0
 * @author Jose Manuel Moreno Bolivar
 * <br> <a href="mailto:j.moreno.bolivar@gmail.com">j.moreno.bolivar@gmail.com</a>
 */
public class Circulo {
    private double centroX;
    private double centroY;
    private double radio;
    
    /**
     * Constructor con 3 parámetros
     * 
     * @param cx centro coordenada x
     * @param cy centro coordenada y
     * @param r radio
     */
    public Circulo(double cx, double cy, double r){
        centroX = cx;
        centroY = cy;
        radio = r;
    }
 
    /**
     * Método Getter
     * 
     * @return coordenada x
     */
    public double getCentroX(){
        return centroX;
    }

    /**
     * Calcula la longitud de la circunferencia (perímetro del circulo).
     * 
     * @return circunferencia
     */
    public double getCircunferencia(){
        return 2 * Math.PI * radio;
    }

    /**
     * Desplaza el circulo a otro lugar.
     * 
     * @param deltaX movimiento en el eje x
     * @param deltaY movimiento en el eje y 
     */
    public void mueve( double deltaX, double deltaY){
        centroX = centroX + deltaX;
        centroY = centroY + deltaY;
    }
    
    /**
     * Escala el circulo(cambia su radio).
     * 
     * @param s factor de escala
     */
    public void escala(double s){
        radio = radio * s;
    }
}    

