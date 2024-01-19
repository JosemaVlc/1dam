using System;
using System.Collections.Generic;
using System.Collections.ObjectModel;
using System.Linq;
using System.Text;
using System.Threading.Tasks;
using System.Windows.Media.Imaging;

namespace FurgolApp
{
    internal class Jugador
    {
        // Variables estáticas
        private static bool inicializado = false;
        private static ObservableCollection<Jugador> listaJugadores = new ObservableCollection<Jugador>();

        // Variables
        public string Nombre { get; set; }
        public string Apellidos { get; set;}
        public string Apodo { get; set;}
        public int Edad { get; set;}
        public int Dorsal { get; set;}
        public string Nacionalidad { get; set; }
        public string Equipo { get; set;}
        public BitmapImage Imagen { get; set;}

        /*----------------------------------
        CONSTRUCTORES
        -----------------------------------*/

        public Jugador(string nombre, string apellidos, string apodo, int edad, int dorsal, string nacionalidad, string equipo, BitmapImage imagen)
        {
            this.Nombre = nombre;
            this.Apellidos = apellidos;
            this.Apodo = apodo;
            this.Edad = edad;
            this.Dorsal = dorsal;
            this.Nacionalidad = nacionalidad;
            this.Equipo = equipo;
            this.Imagen = imagen;

            listaJugadores.Add(this);
        }
        public Jugador(string nombre, string apellidos, string apodo, int edad, string nacionalidad, BitmapImage imagen)
        {
            this.Nombre = nombre;
            this.Apellidos = apellidos;
            this.Apodo = apodo;
            this.Edad = edad;
            this.Nacionalidad = nacionalidad;
            this.Imagen = imagen;

            listaJugadores.Add(this);
        }

        /*----------------------------------
        GETTERS
        -----------------------------------*/

        public static bool getInicializado()
        {
            return inicializado;
        }
        public static ObservableCollection<Jugador> getJugadores()
        {
            return listaJugadores;
        }

        /*----------------------------------
        SETTERS
        -----------------------------------*/

        public static void setBorrar(Jugador jugador_a_borrar)
        {
            listaJugadores.Remove(jugador_a_borrar);
        }
        public static void setInicializado(bool estado)
        {
            inicializado = estado;
        }
    }
}
