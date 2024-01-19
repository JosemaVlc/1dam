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
        internal Asignacion_Club(Jugador jugadorSeleccionado)
        {
            InitializeComponent();
            itemBox.ItemsSource = Equipo.getEquipos();
            jugador = jugadorSeleccionado;
            Rellenar_Formulario();

        }
        private void Rellenar_Formulario()
        {
            string equipoActual = jugador.Equipo;
            ObservableCollection<Equipo> listaEquipos = Equipo.getEquipos();
            int indice = -1;

            foreach (Equipo equipo in listaEquipos)
            {
                if (equipo.Nombre == equipoActual) 
                {
                    indice = itemBox.Items.IndexOf(equipo);
                }
            }
            itemBox.SelectedIndex = indice;

            campoDorsal.Dato = jugador.Dorsal.ToString();
        }
        private void Guardar_Click(object sender, RoutedEventArgs e)
        {
            Equipo equipoSeleccionado = (Equipo)itemBox.SelectedItem;

            if (!int.TryParse(campoDorsal.Text, out int dorsal))
            {
                MessageBox.Show("* Campo dorsal debe ser un numero entero\n", "Error");
            }
            else
            {
                if (equipoSeleccionado != null)
                {
                    jugador.Equipo = equipoSeleccionado.Nombre;
                }
                else
                {
                    jugador.Equipo = "";
                }

                if (campoDorsal.Text != "")
                {
                    jugador.Dorsal = dorsal;
                }
                else
                { 
                    jugador.Dorsal = 0; 
                }

                // Cierra ventana
                Close();
            }
        }
        private void Cerrar_Click(object sender, RoutedEventArgs e)
        {
            // Cierra ventana
            Close();
        }

        private void Limpiar_Click(object sender, RoutedEventArgs e)
        {
            itemBox.SelectedIndex = -1;
            campoDorsal.Clear();
        }
    }
}
