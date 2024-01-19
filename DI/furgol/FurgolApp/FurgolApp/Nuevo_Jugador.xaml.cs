using Microsoft.Win32;
using System;
using System.Collections.Generic;
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
    public partial class Nuevo_Jugador : Window
    {
        Jugador jugador;
        public Nuevo_Jugador()
        {
            InitializeComponent();
            Fotografia.Source = new BitmapImage(new Uri("/img/jugador.png", UriKind.Relative));
        }
        internal Nuevo_Jugador(Jugador jugadorSeleccionado)
        {
            InitializeComponent();
            jugador = jugadorSeleccionado;
            Rellenar_Formulario();
        }


        private void Rellenar_Formulario()
        {
            campoNombre.Dato = jugador.Nombre;
            campoApellidos.Dato = jugador.Apellidos;
            campoApodo.Dato = jugador.Apodo;
            campoEdad.Dato = Convert.ToString(jugador.Edad);
            campoNacionalidad.Dato = jugador.Nacionalidad;
            Fotografia.Source = jugador.Imagen;
        }

        private void Cerrar_Click(object sender, RoutedEventArgs e)
        {
            Ventana_Jugadores ventanaJugadores = new Ventana_Jugadores();
            ventanaJugadores.Show();
            Close();
        }

        private void Limpiar_Click(Object sender, RoutedEventArgs e)
        {
            campoNombre.Clear();
            campoApellidos.Clear();
            campoApodo.Clear();
            campoEdad.Clear();
            campoNacionalidad.Clear();
            // Borra la fotografia
            Fotografia.Source = new BitmapImage(new Uri("/img/jugador.png", UriKind.Relative));
        }

        private void Guardar_Click(Object sender, RoutedEventArgs e)
        {
            String textoError = "";
            if (string.IsNullOrEmpty(campoNombre.Text))
            {
                textoError += "* Falta cumplimentar campo nombre\n";
            }
            if (string.IsNullOrEmpty(campoApellidos.Text))
            {
                textoError += "* Falta cumplimentar campo apellidos\n";
            }
            if (string.IsNullOrEmpty(campoApodo.Text))
            {
                textoError += "* Falta cumplimentar campo apodo\n";
            }
            if (!int.TryParse(campoEdad.Text, out int edad))
            {
                textoError += "* Falta cumplimentar campo Edad o debe ser un numero entero\n";
            }
            if (string.IsNullOrEmpty(campoNacionalidad.Text))
            {
                textoError += "* Falta cumplimentar campo Nacionalidad\n";
            }

            if (!string.IsNullOrEmpty(textoError))
            {
                MessageBox.Show("No se puede guardar por los siguientes motivos:\n\n" + textoError, "Error");
            }
            else
            {
                if (jugador != null)
                {
                    jugador.Nombre = campoNombre.Text;
                    jugador.Apellidos = campoApellidos.Text;
                    jugador.Apodo = campoApodo.Text;
                    jugador.Edad = int.Parse(campoEdad.Text);
                    jugador.Nacionalidad = campoNacionalidad.Text;
                    jugador.Imagen = Fotografia.Source as BitmapImage;
                }
                else 
                {
                    Jugador nuevoJugador = new Jugador(campoNombre.Text, campoApellidos.Text, campoApodo.Text, int.Parse(campoEdad.Text), campoNacionalidad.Text, Fotografia.Source as BitmapImage);                
                }

                // Crea Instancia a ventanaJugadores
                Ventana_Jugadores ventanaJugadores = new Ventana_Jugadores();
                // Mostrar la ventana Jugadores
                ventanaJugadores.Show();
                // Cerrar esta ventana
                Close();                
            }
        }

        private void Seleccionar_Fotografia_Click(object sender, RoutedEventArgs e)
        {
            // Abre el cuadro de diálogo de archivo
            OpenFileDialog openFileDialog = new OpenFileDialog();
            openFileDialog.Filter = "Archivos de Imágenes|*.png;*.jpg;*.jpeg;*.gif;*.bmp|Todos los Archivos|*.*";

            if (openFileDialog.ShowDialog() == true)
            {
                // Obtiene la ruta del archivo seleccionado
                string rutaImagen = openFileDialog.FileName;
                // La incrusta en la imagen fotografía.
                Fotografia.Source = new BitmapImage(new Uri(rutaImagen));
            }
        }
        private void Limpiar_Fotografia_Click(Object sender, RoutedEventArgs e)
        {
            // Borra la fotografia
            Fotografia.Source = new BitmapImage(new Uri("/img/jugador.png", UriKind.Relative));
        }

    }
}

