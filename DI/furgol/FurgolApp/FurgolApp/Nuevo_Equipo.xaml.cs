using Microsoft.Win32;
using System;
using System.Collections.Generic;
using System.Diagnostics;
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
    /// Lógica de interacción para Nuevo_Jugador.xaml
    /// </summary>
    public partial class Nuevo_Equipo : Window
    {
        Equipo equipo;

        // Constructor para crear un nuevo equipo
        public Nuevo_Equipo()
        {
            InitializeComponent();
        }

        // Constructor para editar un equipo existente
        internal Nuevo_Equipo(Equipo equipoSeleccionado)
        {
            InitializeComponent();
            equipo = equipoSeleccionado;
            Rellenar_Formulario();
        }


        // Método para llenar el formulario cuando se está editando un equipo
        private void Rellenar_Formulario()
        {
            campoNombre.Dato = equipo.Nombre;
            campoEstadio.Dato = equipo.Estadio;
            campoFundacion.Dato = Convert.ToString(equipo.Fundacion);
            Escudo.Imagen = equipo.Escudo;
        }

        // Evento para el botón "Cerrar"
        private void Cerrar_Click(object sender, RoutedEventArgs e)
        {
            // Crea una instancia de la ventana de equipos
            Ventana_Equipos ventanaEquipos = new Ventana_Equipos();

            // Muestra la ventana de equipos
            ventanaEquipos.Show();

            // Cierra la ventana actual
            Close();
        }

        // Evento para el botón "Limpiar"
        private void Limpiar_Click(Object sender, RoutedEventArgs e)
        {
            // Limpia los campos de texto y restablece la imagen del escudo predeterminado
            campoNombre.Clear();
            campoEstadio.Clear();
            campoFundacion.Clear();
            Escudo.Imagen = null;
        }

        // Evento para el botón "Guardar"
        private void Guardar_Click(Object sender, RoutedEventArgs e)
        {
            // Variable para almacenar mensajes de error
            String textoError = "";

            // Valida de campos obligatorios
            if (string.IsNullOrEmpty(campoNombre.Text))
            {
                textoError += "* Falta cumplimentar campo nombre\n";
            }
            if (string.IsNullOrEmpty(campoEstadio.Text))
            {
                textoError += "* Falta cumplimentar campo Estadio\n";
            }
            if (!int.TryParse(campoFundacion.Text, out int fundacion))
            {
                textoError += "* Falta cumplimentar campo Fundación o debe ser un numero entero\n";
            }

            // Muestra mensaje de error si faltan datos
            if (!string.IsNullOrEmpty(textoError))
            {
                MessageBox.Show("No se puede guardar por los siguientes motivos:\n\n" + textoError, "Error");
            }
            else
            {
                if (equipo != null)
                {
                    // Si se está editando un equipo se almacenan los campos
                    equipo.Nombre = campoNombre.Text;
                    equipo.Estadio = campoEstadio.Text;
                    equipo.Fundacion = fundacion;
                    equipo.Escudo = Escudo.Imagen as BitmapImage;
                }
                else
                {
                    // Si es un nuevo equipo, crea el objeto
                    Equipo nuevoEquipo = new Equipo(campoNombre.Text, campoEstadio.Text, fundacion, Escudo.Imagen as BitmapImage);
                }

                // Crea Instancia a ventanaJugadores
                Ventana_Equipos ventanaEquipos = new Ventana_Equipos();

                // Mostrar la ventana Jugadores
                ventanaEquipos.Show();

                // Cerrar esta ventana
                Close();

            }
        }

        // Evento para el botón "Seleccionar Escudo"
        private void Seleccionar_Escudo_Click(object sender, RoutedEventArgs e)
        {
            // Abre el cuadro de diálogo de archivo
            OpenFileDialog openFileDialog = new OpenFileDialog();
            openFileDialog.Filter = "Archivos de Imágenes|*.png;*.jpg;*.jpeg;*.gif;*.bmp|Todos los Archivos|*.*";

            if (openFileDialog.ShowDialog() == true)
            {
                // Obtiene la ruta del archivo seleccionado
                string rutaImagen = openFileDialog.FileName;
                // La incrusta en la imagen fotografía.
                Escudo.Imagen = new BitmapImage(new Uri(rutaImagen));
            }
        }

        // Evento para el botón "Limpiar Escudo"
        private void Limpiar_Escudo_Click(Object sender, RoutedEventArgs e)
        {
            // Restablece la imagen del escudo predeterminado
            Escudo.Imagen = null;
        }
    }
}
