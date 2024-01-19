using System;
using System.Collections.Generic;
using System.Collections.ObjectModel;
using System.Linq;
using System.Text;
using System.Threading.Tasks;
using System.Windows.Media.Imaging;

namespace FurgolApp
{
    internal class Equipo
    {
        // Variables estáticas
        private static bool inicializado = false;
        private static ObservableCollection<Equipo> listaEquipos = new ObservableCollection<Equipo>();

        // Variables de clase
        public string Nombre { get; set; }
        public string Estadio { get; set; }
        public int Fundacion { get; set; }
        public BitmapImage Escudo {  get; set; }

        /*----------------------------------
        CONSTRUCTORES
        -----------------------------------*/

        public Equipo(string nombre, string estadio, int fundacion, BitmapImage escudo){
            Nombre = nombre;
            Estadio = estadio;
            Fundacion = fundacion;
            Escudo = escudo;

            listaEquipos.Add(this);
        }

        /*----------------------------------
        GETTERS
        -----------------------------------*/

        public static bool getEstado()
        {
            return inicializado;
        }
        public static ObservableCollection<Equipo> getEquipos()
        {
            return listaEquipos;
        }

        /*----------------------------------
        SETTERS
        -----------------------------------*/

        public static void setEstado(bool estado)
        {
            inicializado = estado;
        }
        public static void setBorrar(Equipo equipo_a_borrar)
        {
            listaEquipos.Remove(equipo_a_borrar);
        }
    }    
}
