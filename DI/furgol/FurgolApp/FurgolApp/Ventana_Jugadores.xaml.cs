using System;
using System.Collections.Generic;
using System.Collections.ObjectModel;
using System.Linq;
using System.Text;
using System.Threading.Tasks;
using System.Windows;
using System.Windows.Controls;
using System.Windows.Data;
using System.Windows.Documents;
using System.Windows.Input;
using System.Windows.Media;
using System.Windows.Media.Imaging;
using System.Windows.Shapes;

namespace FurgolApp
{
    /// <summary>
    /// Lógica de interacción para Window1.xaml
    /// </summary>
    public partial class Ventana_Jugadores : Window
    {
        // Constructor de la ventana
        public Ventana_Jugadores()
        {
            InitializeComponent();
            vistaJugadores.ItemsSource = Jugador.getJugadores();
        }

        // Evento para el botón Volver
        private void Volver_Click(object sender, RoutedEventArgs e)
        {
            // Instancia a ventana Jugadores
            MainWindow mainWindow = new MainWindow();
            // Mostrar la ventana Jugadores
            mainWindow.Show();
            // Cierra ventana
            Close();
        }

        // Evento para el botón Crear Jugador
        private void Crear_Click(object sender, RoutedEventArgs e)
        {
            // Instancia a ventana Jugadores
            Nuevo_Jugador nuevoJugador = new Nuevo_Jugador();
            // Mostrar la ventana Jugadores
            nuevoJugador.Show();
            // Cierra ventana
            Close();
        }

        // Evento para el botón Modificar Jugador
        private void Modificar_Click(object sender, RoutedEventArgs e)
        {
            // Obtiene el jugador seleccionado
            Jugador jugadorSeleccionado = (Jugador)vistaJugadores.SelectedItem;
            if (jugadorSeleccionado != null )
            {
                // Instancia a ventana Jugadores
                Nuevo_Jugador nuevoJugador = new Nuevo_Jugador(jugadorSeleccionado);
                // Mostrar la ventana Jugadores
                nuevoJugador.Show();
                // Cierra ventana
                Close();
            }
        }

        // Evento para el botón Asociar Jugador a Equipo
        private void jugadorClub_Click(object sender, RoutedEventArgs e)
        {
            // Obtiene el jugador seleccionado
            Jugador jugadorSeleccionado = (Jugador)vistaJugadores.SelectedItem;
            if (jugadorSeleccionado != null)
            {
                // Instancia a ventana Jugadores
                Asignacion_Club nuevaAsignacion = new Asignacion_Club(jugadorSeleccionado);
                // Mostrar la ventana Jugadores
                nuevaAsignacion.ShowDialog();
                // Deseleccionar
                vistaJugadores.SelectedIndex = -1;
                // Seleccionar al jugador que estaba seleccionado para actualizar datos
                vistaJugadores.SelectedIndex = vistaJugadores.Items.IndexOf(jugadorSeleccionado);
            }
        }

        // Evento para el botón Borrar
        private void Borrar_Click(object sender, RoutedEventArgs e)
        {
            // Obtiene el jugador seleccionado
            Jugador jugadorSeleccionado = (Jugador)vistaJugadores.SelectedItem;

            // Verifica si hay un jugador seleccionado
            if (jugadorSeleccionado != null)
            {
                // Elimina el jugador de la colección
                Jugador.setBorrar(jugadorSeleccionado);
            }
        }

    }
}
