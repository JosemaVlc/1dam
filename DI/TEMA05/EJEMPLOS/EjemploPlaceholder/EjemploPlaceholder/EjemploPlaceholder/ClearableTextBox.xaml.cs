using System;
using System.Collections.Generic;
using System.ComponentModel;
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

namespace EjemploPlaceholder
{
    /// <summary>
    /// Lógica de interacción para ClearableTextBox.xaml
    /// </summary>
    public partial class ClearableTextBox : UserControl
    {
        public ClearableTextBox()
        {
            DataContext = this;
            InitializeComponent();
        }
        
        private string placeholder;

        public event PropertyChangedEventHandler? PropertyChanged;

        public string Placeholder
        {
            get { return placeholder; }
            set 
            { 
                placeholder = value;
                tbPlaceholder.Text = placeholder;
                OnPropertyChanged(nameof(Placeholder));
            }
        }

        private void btnClear_Click(object sender, RoutedEventArgs e)
        {
            // limpiamos el contenido del textbox
            txtInput.Clear();
            // ponemos el foco en el textbox
            txtInput.Focus();
        }

        private void txtInput_TextChanged(object sender, TextChangedEventArgs e)
        {
            if(string.IsNullOrEmpty(txtInput.Text))
                tbPlaceholder.Visibility = Visibility.Visible;
            else 
                tbPlaceholder.Visibility = Visibility.Hidden;
        }

        private void OnPropertyChanged(string propertyName)
        {
            PropertyChanged?.Invoke(this, new PropertyChangedEventArgs(propertyName));
        }
    }
}
