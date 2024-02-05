using System.Collections.ObjectModel;
using System.Text;
using System.Windows;
using System.Windows.Controls;
using System.Windows.Data;
using System.Windows.Documents;
using System.Windows.Input;
using System.Windows.Media;
using System.Windows.Media.Imaging;
using System.Windows.Navigation;
using System.Windows.Shapes;

namespace FurgolApp
{
    // Clase principal del proyecto
    public partial class MainWindow : Window
    {        
        public MainWindow()
        {
            InitializeComponent();
            // Si se acaba de abrir la aplicación introduce jugadores de muestra.
            if (Jugador.getInicializado() == false)
            {
                introducir_info_base();
                Jugador.setInicializado(true);
            }
        }

        // Función destinada a crear jugadores y equipos cuando abre la aplicación.
        public void introducir_info_base()
        {
            BitmapImage palop = new BitmapImage(new Uri("/img/andrespalop.jpg", UriKind.Relative));
            BitmapImage illie = new BitmapImage(new Uri("/img/adrianillie.jpg", UriKind.Relative));
            BitmapImage acuna = new BitmapImage(new Uri("/img/toroacuna.jpg", UriKind.Relative));

            Jugador jugador_Palop = new Jugador("Andres", "Palop Cervera", "La Pantera de l'Alcudia", 50, "España", palop);
            Jugador jugador_Illie = new Jugador("Adrian", "Bucurel Illie", "La Cobra Illie", 49, 11, "Rumania", "Valencia C.F.", illie);
            Jugador jugador_Acuna = new Jugador("Roberto Miguel", "Acuña Cabello", "El Toro Acuña", 51, 20, "Argentina", "Zaragoza S.A.D.", acuna);

            BitmapImage granada = new BitmapImage(new Uri("/img/escudoGranada.jpg", UriKind.Relative));
            BitmapImage zaragoza = new BitmapImage(new Uri("/img/escudoZaragoza.jpg", UriKind.Relative));
            BitmapImage valencia = new BitmapImage(new Uri("/img/escudoValencia.jpg", UriKind.Relative));

            Equipo equipo_Granada = new Equipo("Granada F.C.", "Nuevo Los Carmenes", 1931, granada);
            Equipo equipo_Zaragoza = new Equipo("Zaragoza S.A.D.", "La Romareda", 1932, zaragoza);
            Equipo equipo_Valencia = new Equipo("Valencia C.F.", "Mestalla", 1919, valencia);
        }

        // Evento al hacer Click sobre Administrar Jugadores.
        // Instancia y lanza la Ventana Jugadores y cierra la actual.
        private void Ventana_Jugadores_Click(object sender, RoutedEventArgs e)
        {
            // Crea Instancia a ventanaJugadores
            Ventana_Jugadores ventanaJugadores = new Ventana_Jugadores();
            // Mostrar la ventana Jugadores
            ventanaJugadores.Show();
            // Cierra ventana
            Close();
        }

        // Evento al hacer Click sobre Administrar Equipos.
        // Instancia y lanza la Ventana Equipos y cierra la actual.
        private void Ventana_Equipos_Click(object sender, RoutedEventArgs e)
        {
            // Crea Instancia a ventanaJugadores
            Ventana_Equipos ventanaEquipos = new Ventana_Equipos();
            // Mostrar la ventana Jugadores
            ventanaEquipos.Show();
            // Cierra ventana
            Close();
        }

        // Evento al hacer Click sobre Acerca de.
        // Lanza un MessageBox con la información.
        private void Acerca_de_Click(object sender, EventArgs e)
        {
            MessageBox.Show("Aplicación creada para la asignatura de Desarrollo de Interfaces\nPor Jose Manuel Moreno Bolivar en 2024\n\n* Imagenes realizadas por la IA de StableDiffusion\n* Fotografias de jugadores extraidas de Transfermarkt.es\n* Iconos basados en diseños de Flaticon.es\n\n@JosemaVlc", "Acerca de");
        }

        // Evento al hacer Click sobre Salir.
        // Cierra la aplicación.
        private void Salir_Click(object sender, EventArgs e)
        {
            Close();
        }
    }
}