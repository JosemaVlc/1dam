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
    public partial class Ventana_Equipos : Window
    {
        public Ventana_Equipos()
        {
            InitializeComponent();
            vistaEquipos.ItemsSource = Equipo.getEquipos();
        }

        private void Volver_Click(object sender, RoutedEventArgs e)
        {
            // Instancia a ventana Jugadores
            MainWindow mainWindow = new MainWindow();
            // Mostrar la ventana Jugadores
            mainWindow.Show();
            // Cierra ventana
            Close();
        }
        private void Crear_Click(object sender, RoutedEventArgs e)
        {
            // Instancia a ventana Jugadores
            Nuevo_Equipo nuevoEquipo = new Nuevo_Equipo();
            // Mostrar la ventana Jugadores
            nuevoEquipo.Show();
            // Cierra ventana
            Close();
        }
        private void Modificar_Click(object sender, RoutedEventArgs e)
        {
            // Obtiene el jugador seleccionado
            Equipo equipoSeleccionado = (Equipo)vistaEquipos.SelectedItem;
            if (equipoSeleccionado != null)
            {
                // Instancia a ventana Jugadores
                Nuevo_Equipo nuevoEquipo = new Nuevo_Equipo(equipoSeleccionado);
                // Mostrar la ventana Jugadores
                nuevoEquipo.Show();
                // Cierra ventana
                Close();
            }
        }

        private void Borrar_Click(object sender, RoutedEventArgs e)
        {
            // Obtiene el jugador seleccionado
            Equipo equipoSeleccionado = (Equipo)vistaEquipos.SelectedItem;

            // Verifica si hay un jugador seleccionado
            if (equipoSeleccionado != null)
            {
                // Elimina el jugador de la colección
                Equipo.setBorrar(equipoSeleccionado);
            }
        }

    }
}

