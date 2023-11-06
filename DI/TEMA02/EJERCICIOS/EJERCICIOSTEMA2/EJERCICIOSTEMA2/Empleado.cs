using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;
using System.Threading.Tasks;

namespace EJERCICIOSTEMA2
{
    public class Empleado
    {
        public string Nombre {  get; set; }
        public double Salario { get; set; }

        public Empleado() 
        {
            Console.WriteLine("Introduce nombre del empleado");
            Nombre = Console.ReadLine();
            Console.WriteLine("Introduce salario del empleado");
            Salario = double.Parse(Console.ReadLine());
        }

        public void datosEmpleado()
        {
            Console.WriteLine("El empleado {0} tiene un salario {1}€", Nombre, Salario);
            if (Salario > 2000) 
            {
                Console.WriteLine("Por lo que tiene que pagar impuestos");
            }
            Console.ReadLine();
        }
    }
}
