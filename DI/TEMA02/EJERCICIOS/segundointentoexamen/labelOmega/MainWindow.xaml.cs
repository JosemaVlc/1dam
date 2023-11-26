using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;
using System.Threading.Tasks;
using System.Windows;
using System.Windows.Controls;
using System.Windows.Controls.Primitives;
using System.Windows.Data;
using System.Windows.Documents;
using System.Windows.Input;
using System.Windows.Media;
using System.Windows.Media.Imaging;
using System.Windows.Navigation;
using System.Windows.Shapes;

namespace labelOmega
{
    /// <summary>
    /// Lógica de interacción para MainWindow.xaml
    /// </summary>
    public partial class MainWindow : Window
    {
        public MainWindow()
        {
            InitializeComponent();
            addPatatas();
        }

        private void addPatatas()
        {
            for (int i = 0; i < 25; i++) 
            {
                Label labelPatata = new Label {
                    Content = (i+5).ToString()
                };
                labelPatata.Style = (Style)FindResource("colorespatata");
                labelPatata.MouseLeftButtonDown += cambiaTuColor;
                Patatasfritas.Children.Add(labelPatata);
            }
        }

        private void cambiaTuColor(object sender, RoutedEventArgs e)
        {
            Label labelpatata = (Label)sender;
            labelpatata.Foreground = Brushes.DarkGreen;
        }
    }
}
