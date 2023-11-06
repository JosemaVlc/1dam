using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;
using System.Threading.Tasks;
using System.Timers;

namespace EJERCICIOSTEMA2
{
    public class ejercicio04
    {
        public static void ejercicio04Init()
        {
            int lado1, lado2, lado3;
            Inicializacion(out lado1, out lado2, out lado3);
            tipo_de_triangulo(lado1, lado2, lado3);
            area_triangulo(lado1, lado2, lado3);
        }
        private static void Inicializacion(out int lado1, out int lado2, out int lado3)
        {   
            Console.WriteLine("Necesitamos que nos digas todos los lados del triangulo");
            Console.WriteLine("Introduce lado 1:");
            lado1 = int.Parse(Console.ReadLine());
            Console.WriteLine("Introduce lado 2:");
            lado2 = int.Parse(Console.ReadLine());
            Console.WriteLine("Introduce lado 3:");
            lado3 = int.Parse(Console.ReadLine());
        }
        private static void tipo_de_triangulo(int lado1, int lado2, int lado3) 
        {   
            string tipo = "null";
            if (lado1 == lado2 && lado2 == lado3 & lado3 == lado1) 
            {
                tipo = "Equilátero";
            }
            else if (lado1 == lado2 || lado2 == lado3 || lado3 == lado1) 
            {
                tipo = "Isósceles";
            }
            else
            {
                tipo = "Escaleno";
            }
            Console.WriteLine("El tipo de triangulo es {0}", tipo);
        }
        private static void area_triangulo(int lado1, int lado2, int lado3) 
        {
            double area_triangulo = 0;

            double semiperimetro = (lado1 + lado2 + lado3) / 2;
            area_triangulo = Math.Sqrt(semiperimetro * (semiperimetro-lado1) * (semiperimetro-lado2) * (semiperimetro-lado3));
            
            Console.WriteLine("El triangulo tiene un area de {0}", area_triangulo);
        }
    }
}
