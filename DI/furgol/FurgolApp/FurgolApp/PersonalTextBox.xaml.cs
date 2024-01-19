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

namespace FurgolApp
{
    /// <summary>
    /// Lógica de interacción para PersonalTextBox.xaml
    /// </summary>
    public partial class PersonalTextBox : UserControl
    {
        public PersonalTextBox()
        {
            DataContext = this;
            InitializeComponent();
        }


        public event PropertyChangedEventHandler? PropertyChanged;

        private string etiqueta;
        public string Etiqueta
        {
            get 
            { 
                return etiqueta; 
            }
            set
            {
                etiqueta = value;
                tbEtiqueta.Text = etiqueta;
                OnPropertyChanged(nameof(Etiqueta));
            }
        }

        private string dato;
        public string Dato
        {
            get
            {
                return dato;
            }
            set
            {
                dato = value;
                txtInput.Text = dato;
                OnPropertyChanged(nameof(Dato));
            }
        }
        private int largoMaximo;
        public int LargoMaximo
        {
            get
            {
                return largoMaximo;
            }
            set
            {
                largoMaximo = value;
                txtInput.MaxLength = largoMaximo;
                OnPropertyChanged(nameof(LargoMaximo));
            }
        }

        public string Text
        {
            get
            {
                return txtInput.Text;
            }
            set
            {
            }
        }
        public void Clear()
        {
            txtInput.Clear();
        }


        private void btnClear_Click(object sender, RoutedEventArgs e)
        {
            // limpiamos el contenido del textbox
            txtInput.Clear();
            // ponemos el foco en el textbox
            txtInput.Focus();
        }

        private void OnPropertyChanged(string propertyName)
        {
            PropertyChanged?.Invoke(this, new PropertyChangedEventArgs(propertyName));
        }
    }
}
