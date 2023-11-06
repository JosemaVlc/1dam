using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;
using System.Threading.Tasks;

namespace EJERCICIOSTEMA2
{
    public class Asociado : Club
    {
        public Asociado() : base("", 0)
        {
            Console.WriteLine("Introduce Nombre de asociado");
            base.Nombre = Console.ReadLine();
            Console.WriteLine("Introduce antiguedad");
            base.Antiguedad = int.Parse(Console.ReadLine());
        }          
        public string ToString()
        {
            return $"El asociado {base.Nombre} con una antigüedad de {base.Antiguedad} años, tiene una id {base.Id}";
        }
    }
}
