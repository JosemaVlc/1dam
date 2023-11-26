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

namespace nuevoProyectoEjemplos
{
    /// <summary>
    /// Lógica de interacción para MainWindow.xaml
    /// </summary>
    public partial class MainWindow : Window
    {
        public MainWindow()
        {
            InitializeComponent();
        }

        private void click_boton(object sender, RoutedEventArgs e)
        {
            Button boton = (Button)sender;
            boton.Style = (Style)FindResource("despuesDeClicar");
            MessageBox.Show("hola", "mierderventana");
        }

        private void funcion2(object sender, RoutedEventArgs e)
        {
            RadioButton grupo = (RadioButton)sender;
            if (grupo.Name.Equals("tumadreesputa")){
                texto.Text = "disco 1 -> Tu Madre es Puta";
            };
            if (grupo.Name.Equals("ojetecalor"))
            {
                texto.Text = "disco 1 -> Ojete Calor";
            };
            if (grupo.Name.Equals("skap"))
            {
                texto.Text = "disco 1 -> Ska-P";
            };
        }
    }
}
