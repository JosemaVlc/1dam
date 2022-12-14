/**
 * Clase Empleado Contiene información de cada empleado
 * 
 * @version 1.9
 * @author Jose Manuel Moreno
 *
 *
 */
public class Empleado {
	private String nombre;
	private String apellido;
	private int edad;
	private double salario;
	
	
	/**
	 * Suma un plus de 86 euros al salario del empleado si el empleado tiene más de 36 años.
	 * 
	 * @param sueldoPlus cantidad en euros que se suma al salario.
	 * @return <ul>
	 * 			<li>true: se suma el plus al sueldo.</li>
	 * 			<li>false: no se suma el plus al sueldo.</li>
	 * 		   	</ul>
	 */
	public boolean plus (double sueldoPlus) {
		boolean aumento = false;
		if (edad > 40 && compruebaNombre()) {
			salario += sueldoPlus;
			aumento = true;
		}
		return aumento;
	}
	
	
	/**
	 * Prueba que el nombre no esté vacio
	 * 
	 * @return <ul>
	 * 			<li>true: Si el valor nombre no está vacio</li>
	 * 			<li>false: Si el valor nombre está vacio</li>
	 * 		   	</ul>
	 */
	private boolean compruebaNombre() {
		if (nombre.equals(" ")) {
			return false;
		}
		return true;
	}
	
	
	/**
	 * Constructor por defecto
	 */
	public Empleado() {
		this( "", "" , 0, 0);
	}
	
	/**
	 * Constructor con 4 parametros
	 * 
	 * @param nombre nombre del empleado
	 * @param apellido apellido del empleado
	 * @param edad edad del empleado
	 * @param salario salario del empleado
	 */
	public Empleado(String nombre, String apellido, int edad, double salario) {
		this.nombre = nombre;
		this.apellido = apellido;
		this.edad = edad;
		this.salario = salario;
	}
}
