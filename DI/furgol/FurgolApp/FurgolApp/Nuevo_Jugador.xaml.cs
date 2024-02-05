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

        // Constructor para crear un nuevo jugador
        public Nuevo_Jugador()
        {
            InitializeComponent();
        }
        
        // Constructor para editar un jugador existente
        internal Nuevo_Jugador(Jugador jugadorSeleccionado)
        {
            InitializeComponent();
            jugador = jugadorSeleccionado;
            Rellenar_Formulario();
        }

        // Método para rellenar el formulario con los datos del jugador existente
        private void Rellenar_Formulario()
        {
            campoNombre.Dato = jugador.Nombre;
            campoApellidos.Dato = jugador.Apellidos;
            campoApodo.Dato = jugador.Apodo;
            campoEdad.Dato = Convert.ToString(jugador.Edad);
            campoNacionalidad.Dato = jugador.Nacionalidad;
            Fotografia.Imagen = jugador.Imagen;
        }

        // Evento para el botón Cancelar
        private void Cerrar_Click(object sender, RoutedEventArgs e)
        {
            Ventana_Jugadores ventanaJugadores = new Ventana_Jugadores();
            ventanaJugadores.Show();
            Close();
        }

        // Evento para el botón Limpiar.
        private void Limpiar_Click(Object sender, RoutedEventArgs e)
        {
            // Limpia los campos de texto y restablece la imagen predeterminada
            campoNombre.Clear();
            campoApellidos.Clear();
            campoApodo.Clear();
            campoEdad.Clear();
            campoNacionalidad.Clear();
            Fotografia.Imagen = null;
        }

        // Evento para el botón Guardar
        private void Guardar_Click(Object sender, RoutedEventArgs e)
        {
            // Almacena mensaje de error
            String textoError = "";

            // Valida los campos
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

            // Muestra el mensaje de error almacenado.
            if (!string.IsNullOrEmpty(textoError))
            {
                MessageBox.Show("No se puede guardar por los siguientes motivos:\n\n" + textoError, "Error");
            }
            else
            {
                if (jugador != null)
                {
                    // Si se está editando un equipo se almacenan los campos
                    jugador.Nombre = campoNombre.Text;
                    jugador.Apellidos = campoApellidos.Text;
                    jugador.Apodo = campoApodo.Text;
                    jugador.Edad = int.Parse(campoEdad.Text);
                    jugador.Nacionalidad = campoNacionalidad.Text;
                    jugador.Imagen = Fotografia.Imagen as BitmapImage;
                }
                else 
                {
                    // Si es un nuevo equipo, crea el objeto
                    Jugador nuevoJugador = new Jugador(campoNombre.Text, campoApellidos.Text, campoApodo.Text, int.Parse(campoEdad.Text), campoNacionalidad.Text, Fotografia.Imagen as BitmapImage);                
                }

                // Crea Instancia a ventanaJugadores
                Ventana_Jugadores ventanaJugadores = new Ventana_Jugadores();

                // Mostrar la ventana Jugadores
                ventanaJugadores.Show();

                // Cerrar esta ventana
                Close();                
            }
        }

        // Evento para el botón seleccionar fotografía
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
                Fotografia.Imagen = new BitmapImage(new Uri(rutaImagen));
            }
        }

        // Evento para el botón de limpiar fotografía
        private void Limpiar_Fotografia_Click(Object sender, RoutedEventArgs e)
        {
            // Restablece la imagen predeterminada
            Fotografia.Imagen = null;
        }

    }
}

