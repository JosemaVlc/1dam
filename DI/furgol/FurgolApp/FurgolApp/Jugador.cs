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

        // Variables de instancia
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

        // Constructor para un jugador con equipo y dorsal
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

            // Agrega el jugador a la ObservableCollection de jugadores
            listaJugadores.Add(this);
        }

        // Constructor para un jugador sin equipo ni dorsal
        public Jugador(string nombre, string apellidos, string apodo, int edad, string nacionalidad, BitmapImage imagen)
        {
            this.Nombre = nombre;
            this.Apellidos = apellidos;
            this.Apodo = apodo;
            this.Edad = edad;
            this.Nacionalidad = nacionalidad;
            this.Imagen = imagen;

            // Agrega el jugador a la ObservableCollection de jugadores
            listaJugadores.Add(this);
        }

        /*----------------------------------
        GETTERS
        -----------------------------------*/

        // Getter para saber si se ha poblado lista de jugadores
        public static bool getInicializado()
        {
            return inicializado;
        }

        // Getter para obtener la lista de jugadores
        public static ObservableCollection<Jugador> getJugadores()
        {
            return listaJugadores;
        }

        /*----------------------------------
        SETTERS
        -----------------------------------*/

        // Setter para establecer el estado de la lista de jugadores(poblada o no).
        public static void setInicializado(bool estado)
        {
            inicializado = estado;
        }

        // Setter para borrar un jugador de la lista
        public static void setBorrar(Jugador jugador_a_borrar)
        {
            listaJugadores.Remove(jugador_a_borrar);
        }
    }
}
