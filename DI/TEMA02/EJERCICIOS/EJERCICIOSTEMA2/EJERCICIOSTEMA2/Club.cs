using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;
using System.Threading.Tasks;

namespace EJERCICIOSTEMA2
{
    public class Club
    {
        public static int contador = 0;
        public string Nombre { get; set; }
        public int Id {  get; set; } = 0;
        public int Antiguedad {  get; set; }

        public Club(string nombre, int antiguedad) 
        {
            this.Nombre = nombre;
            this.Antiguedad = antiguedad;
            contador++;
            this.Id = contador;
        }
    }
}
