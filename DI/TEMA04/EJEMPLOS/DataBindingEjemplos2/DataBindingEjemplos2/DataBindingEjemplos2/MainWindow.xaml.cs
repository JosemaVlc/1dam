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

namespace DataBindingEjemplos2
{
    /// <summary>
    /// Interaction logic for MainWindow.xaml
    /// </summary>
    public partial class MainWindow : Window
    {
        public MainWindow()
        {
            InitializeComponent();
        }


        /* Eventos para prueba de OneWay*/
        private void btnSmallOneWay_Click(object sender, RoutedEventArgs e)
        {
            sliderFontSizeOneWay.Value = 8;

        }

        private void btnNormalOneWay_Click(object sender, RoutedEventArgs e)
        {
            sliderFontSizeOneWay.Value = 16;

        }

        private void btnLargeOneWay_Click(object sender, RoutedEventArgs e)
        {
            // Estamos modificando en lugar del valor del slider, el valor del textBlock, por eso no se actualiza el slider al pulsar este botón, porque tenemos el binding en OneWay
            //sliderFontSizeOneWay.Value = 30;
            lblSampleTextOneWay.FontSize = 30;
        }

        /* Eventos para prueba de TwoWay*/
        private void btnSmall_Click(object sender, RoutedEventArgs e)
        {
            sliderFontSize.Value = 8;
        }

        private void btnNormal_Click(object sender, RoutedEventArgs e)
        {
            sliderFontSize.Value = 16;
        }

        private void btnLarge_Click(object sender, RoutedEventArgs e)
        {
            // Aquí vemos el efecto del TwoWay, ya que estamos modificando el textblock lblSampleText en lugar del slider y vemos que afecta también al tamaño del slider debido al binding TwoWay
            //sliderFontSize.Value = 30;
            lblSampleText.FontSize = 30;
        }
    }
}
