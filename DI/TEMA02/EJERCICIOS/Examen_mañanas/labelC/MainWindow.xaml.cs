using System;
using System.Collections.Generic;
using System.Linq;
using System.Runtime.Remoting.Channels;
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

namespace labelC
{
    /// <summary>
    /// Lógica de interacción para MainWindow.xaml
    /// </summary>
    public partial class MainWindow : Window
    {
        public MainWindow()
        {
            InitializeComponent();
            crear_controles();
        }

        private void crear_controles()
        {
            for (int i = 0; i < 25; i++)
            {
                Label label = new Label();
                label.Content = i+5;
                label.MouseLeftButtonDown += (Sender, e) => cambiaColor(label);
                UniformGrid.Children.Add(label);
            }
        }

        private void cambiaColor(Label label)
        {
            label.Foreground = new SolidColorBrush(Colors.DarkGreen);
        }
    }
}
