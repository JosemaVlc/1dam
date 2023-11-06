using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;
using System.Threading.Tasks;

namespace EJERCICIOSTEMA2
{
    internal class Operacion
    {
        public int Entero1 {  get; set; }
        public int Entero2 { get; set; }
        public int s { get; set; }
        public int r {  get; set; }
        public int m { get; set; }
        public int d { get; set; }

        public Operacion() 
        {
            Console.WriteLine("Introduce un entero");
            Entero1 = int.Parse(Console.ReadLine());
            Console.WriteLine("Introduce un segundo entero");
            Entero2 = int.Parse( Console.ReadLine());
            suma();
            resta();
            multiplicacion();
            division();
        }

        public int suma()
        {
            s = Entero1 + Entero2;
            return s;
        }

        public int resta()
        {
            r = Entero1 - Entero2;
            return r;
        }

        public int multiplicacion()
        {
            m = Entero1 * Entero2;
            return m;
        }

        public double division()
        {
            d = Entero1 / Entero2;
            return d;
        }

        public override string ToString()
        {
            return $"La suma da {s}, la resta da {r}, la multiplicación da {m} y la división da {d}";
        }
    }
}
