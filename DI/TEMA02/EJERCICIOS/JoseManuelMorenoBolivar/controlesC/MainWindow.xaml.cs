using System.Windows;
using System.Windows.Controls;
using System.Windows.Media;

namespace controlesC
{
    /// <summary>
    /// Lógica de interacción para MainWindow.xaml
    /// </summary>
    public partial class MainWindow : Window
    {
        public MainWindow()
        {
            InitializeComponent();
            crearBotones();
        }

        private void crearBotones()
        {
            for (int i = 1; i <= 36; i++)
            {
                if (i % 2 == 0)
                {
                    Button boton = new Button();
                    boton.HorizontalAlignment = HorizontalAlignment.Center;
                    boton.VerticalAlignment = VerticalAlignment.Center;

                    // Fuerzo el tamaño a 30x30 para que se vea que esta alineado su interior en el centro
                    boton.Width = 30;
                    boton.Height = 30;

                    boton.Content = i;
                    boton.Style = (Style)FindResource("botonUniformGrid");
                    boton.MouseRightButtonDown += cambioColor;
                    contenedorBotones.Children.Add(boton);                    
                }
            }
        }

        private void cambioColor(object sender, RoutedEventArgs e)
        {
            Button cambio = (Button)sender;
            cambio.Background = Brushes.BlueViolet;
        }
    }
}
