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
    /// Lógica de interacción para Asignacion_Club.xaml
    /// </summary>
    public partial class Asignacion_Club : Window
    {
        Jugador jugador;

        // Constructor de la clase Asignacion_Club
        internal Asignacion_Club(Jugador jugadorSeleccionado)
        {
            InitializeComponent();
            // Configuración del ComboBox con la lista de equipos
            itemBox.ItemsSource = Equipo.getEquipos();
            // Almacena el jugador seleccionado
            jugador = jugadorSeleccionado;
            // Rellena el formulario con los datos actuales del jugador
            Rellenar_Formulario();

        }

        // Método para rellenar el formulario con los datos actuales del jugador
        private void Rellenar_Formulario()
        {
            string NombreEquipo = jugador.Equipo;

            ObservableCollection<Equipo> listaEquipos = Equipo.getEquipos();
            int indice = -1;

            // Busca el índice del equipo actual en la lista de equipos
            foreach (Equipo equipo in listaEquipos)
            {
                if (equipo.Nombre == NombreEquipo) 
                {
                    indice = itemBox.Items.IndexOf(equipo);
                }
            }

            // Establece el índice del ComboBox
            itemBox.SelectedIndex = indice;

            // Establece el valor del campo de dorsal
            campoDorsal.Dato = jugador.Dorsal.ToString();
        }

        // Evento para el botón "Guardar"
        private void Guardar_Click(object sender, RoutedEventArgs e)
        {
            // Obtiene el equipo seleccionado del ComboBox
            Equipo equipoSeleccionado = (Equipo)itemBox.SelectedItem;

            // Valida que el campo dorsal sea un número entero
            if (!int.TryParse(campoDorsal.Text, out int dorsal))
            {
                MessageBox.Show("* Campo dorsal debe ser un numero entero\n", "Error");
            }
            else
            {
                // Asigna el equipo al jugador, If en una sola línea. Recordar: (A==B ? True : False)
                jugador.Equipo = equipoSeleccionado != null ? equipoSeleccionado.Nombre : null;

                // Asigna el dorsal al jugador. If en una sola línea. 
                jugador.Dorsal = campoDorsal.Text != "" ? dorsal : 0;

                // Cierra ventana
                Close();
            }
        }

        // Evento para el botón "Cancelar"
        private void Cerrar_Click(object sender, RoutedEventArgs e)
        {
            // Cierra ventana
            Close();
        }

        // Evento para el botón "Limpiar"
        private void Limpiar_Click(object sender, RoutedEventArgs e)
        {
            // Desselecciona el ComboBox.
            itemBox.SelectedIndex = -1;

            // Limpia campo dorsal.
            campoDorsal.Clear();
        }
    }
}
