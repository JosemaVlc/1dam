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

        // Variables de instancia
        public string Nombre { get; set; }
        public string Estadio { get; set; }
        public int Fundacion { get; set; }
        public BitmapImage Escudo {  get; set; }

        /*----------------------------------
        CONSTRUCTORES
        -----------------------------------*/

        // Constructor de la clase Equipo
        public Equipo(string nombre, string estadio, int fundacion, BitmapImage escudo){
            Nombre = nombre;
            Estadio = estadio;
            Fundacion = fundacion;
            Escudo = escudo;

            // Almacena equipo en la ObservableCollection
            listaEquipos.Add(this);
        }

        /*----------------------------------
        GETTERS
        -----------------------------------*/

        // Getter para saber si se ha poblado lista de equipos
        public static bool getEstado()
        {
            return inicializado;
        }

        // Getter para obtener la lista de equipos
        public static ObservableCollection<Equipo> getEquipos()
        {
            return listaEquipos;
        }

        /*----------------------------------
        SETTERS
        -----------------------------------*/

        // Setter para establecer el estado de la lista de equipos(poblada o no).
        public static void setEstado(bool estado)
        {
            inicializado = estado;
        }

        // Setter para borrar un equipo de la lista
        public static void setBorrar(Equipo equipo_a_borrar)
        {
            listaEquipos.Remove(equipo_a_borrar);
        }
    }    
}
