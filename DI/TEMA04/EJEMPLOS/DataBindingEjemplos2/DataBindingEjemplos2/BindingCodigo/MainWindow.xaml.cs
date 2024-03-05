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

namespace BindingCodigo
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
            //sliderFontSize.Value = 30;
            lblSampleText.FontSize = 30;
        }

        private void Window_Loaded(object sender, RoutedEventArgs e)
        {
            /* Realizar un binding mediante código */
            //Binding binding = new Binding();
            //binding.Source = sliderFontSize;
            //binding.Path = new PropertyPath("Value");
            //binding.Mode = BindingMode.TwoWay;
            //lblSampleText.SetBinding(TextBlock.FontSizeProperty, binding);

            /* Limpiar todos los bindings */
            //BindingOperations.ClearAllBindings(lblSampleText);
            
            /* Obtener el elemento que tiene el binding */
            //Binding binding2 = BindingOperations.GetBinding(lblSampleText, TextBlock.FontSizeProperty);
        }


    }
}
