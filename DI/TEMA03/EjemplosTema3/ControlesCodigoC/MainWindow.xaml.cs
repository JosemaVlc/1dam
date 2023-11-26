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

namespace ControlesCodigoC
{
    /// <summary>
    /// Interaction logic for MainWindow.xaml
    /// </summary>
    public partial class MainWindow : Window
    {
        public MainWindow()
        {
            InitializeComponent();

            Grid miGrid = new Grid();
            
            this.Content = miGrid;

            Button miboton = new Button();
            miboton.Width = 150;
            miboton.Height = 75;
            miboton.Background = Brushes.Yellow;

            WrapPanel miWrap = new WrapPanel();
            
            TextBlock miTextBlock1 = new TextBlock();
            miTextBlock1.Background = Brushes.Pink;
            miTextBlock1.Foreground = Brushes.Green;
            miTextBlock1.Text = "Click";
            miWrap.Children.Add(miTextBlock1);

            TextBlock miTextBlock2 = new TextBlock();
            miTextBlock2.Text = "Enviar";
            miWrap.Children.Add(miTextBlock2);

            TextBlock miTextBlock3 = new TextBlock();
            miTextBlock3.Text = "Cancelar";
            miWrap.Children.Add(miTextBlock3);

            miboton.Content = miWrap;
            miGrid.Children.Add(miboton);
        }

    }
}
