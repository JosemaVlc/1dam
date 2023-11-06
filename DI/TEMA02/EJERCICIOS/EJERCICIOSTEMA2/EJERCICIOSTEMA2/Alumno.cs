using System;
using System.Collections.Generic;
using System.Linq;
using System.Runtime.Serialization;
using System.Text;
using System.Threading.Tasks;

namespace EJERCICIOSTEMA2
{
    public class Alumno
    {
        public String Nombre {  get; set; }
        public int Edad {  get; set; }

        public Alumno() 
        {
            Console.WriteLine("Dime nombre: ");
            Nombre = Console.ReadLine();
            Console.WriteLine("Dime edad: ");
            Edad = int.Parse(Console.ReadLine());         
        }

        public void datosAlumno()
        {
            Console.WriteLine("Mi nombre es {0} y mi edad es {1}", Nombre, Edad);
            if (Edad >= 18 ) 
            {
                Console.WriteLine("Así que soy mayor de edad");
            }
            Console.ReadLine();
        }
    }
}
