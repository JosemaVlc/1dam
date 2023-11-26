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
using System.Windows.Navigation;
using System.Windows.Shapes;

namespace EventosBoton
{
    /// <summary>
    /// Interaction logic for MainWindow.xaml
    /// </summary>
    public partial class MainWindow : Window
    {
        private const int Filas = 9;
        private const int Columnas = 9;
        public MainWindow()
        {
            InitializeComponent();
            CrearTablero();
        }

        private void CrearTablero()
        {
            for (int i = 0; i < Filas; i++)
            {
                for (int j = 0; j < Columnas; j++)
                {
                    Button boton = new Button();
                    boton.Name = $"btn_{i}_{j}";
                    boton.Content = "";

                    // Asignamos eventos a click izquierdo y derecho
                    boton.Click += Casilla_Click;
                    boton.MouseRightButtonDown += Casilla_ClickDerecho;

                    // Establecemos posicion de los botones
                    Grid.SetRow(boton, i);
                    Grid.SetColumn(boton, j);
                    // Agregamos los botones al uniformGrid
                    gameGrid.Children.Add(boton);
                }
            }
        }

        private void botonReinicio_Click(object sender, RoutedEventArgs e)
        {
            MessageBox.Show("Boton de reinicio pulsado", "Boton reiniciar");
        }

        private void Casilla_ClickDerecho(object sender, MouseButtonEventArgs e)
        {
            Button myButton = (Button)sender;
            if ((String) myButton.Content == "")
            {
                myButton.Content = "🚩";
            } else
            {
                myButton.Content = "";
            }
            
        }

        private void MiBoton_Click(object sender, RoutedEventArgs e)
        {
            Button boton = (Button)sender; // Convierte el sender a tipo Button
            string contenido = boton.Content.ToString(); // Accede al contenido del botón
        }

        private void Casilla_Click(object sender, RoutedEventArgs e)
        {
            Button myButton = (Button)sender;
            myButton.Content = "1";
            //myButton.Background = Brushes.White;

            // al hacer click izquierdo, abrimos la casilla, por tanto, cambiamos el estilo
            myButton.Style = (Style)FindResource("CasillaAbierta");
        }
    }
}
