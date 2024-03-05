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

namespace ListBox
{
    /// <summary>
    /// Interaction logic for MainWindow.xaml
    /// </summary>
    public partial class MainWindow : Window
    {
        public MainWindow()
        {
            InitializeComponent();

            List<Poblaciones> listaPob = new List<Poblaciones>();

            listaPob.Add(new Poblaciones() { Poblacion1="Madrid", Poblacion2="Valencia", Temperatura1= 15, Temperatura2= 20, DiferenciaTemp = 5});
            listaPob.Add(new Poblaciones() { Poblacion1 = "Alicante", Poblacion2 = "Barcelona", Temperatura1 = 25, Temperatura2 = 22, DiferenciaTemp = 3});
            listaPob.Add(new Poblaciones() { Poblacion1 = "Sevilla", Poblacion2 = "Bilbao", Temperatura1 = 30, Temperatura2 = 12, DiferenciaTemp = 18});
            listaPob.Add(new Poblaciones() { Poblacion1 = "Castellon", Poblacion2 = "Zaragoza", Temperatura1 = 25, Temperatura2 = 10, DiferenciaTemp = 15});
            listaPoblaciones.ItemsSource = listaPob;
        }

        private void Button_Click(object sender, RoutedEventArgs e)
        {
            if(listaPoblaciones.SelectedItem != null)
            {
                MessageBox.Show(((Poblaciones)listaPoblaciones.SelectedItem).Poblacion1 + " " +
                    ((Poblaciones)listaPoblaciones.SelectedItem).Temperatura1 + " ºC " + " - " +
                    ((Poblaciones)listaPoblaciones.SelectedItem).Poblacion2 + " " +
                    ((Poblaciones)listaPoblaciones.SelectedItem).Temperatura2 + " ºC ", "Información ListBox");
            } else
            {
                MessageBox.Show("Selecciona algún elemento");
            }
        }

        private void ProgressBar_PreviewMouseDown(object sender, MouseButtonEventArgs e)
        {
            if (listaPoblaciones.SelectedItem != null)
            {
                MessageBox.Show(((Poblaciones)listaPoblaciones.SelectedItem).Poblacion1 + " " +
                ((Poblaciones)listaPoblaciones.SelectedItem).Temperatura1 + " ºC " + " - " +
                ((Poblaciones)listaPoblaciones.SelectedItem).Poblacion2 + " " +
                ((Poblaciones)listaPoblaciones.SelectedItem).Temperatura2 + " ºC ", "Información ListBox");
            }
        }
    }
}
