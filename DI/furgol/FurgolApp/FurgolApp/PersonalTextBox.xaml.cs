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
        // Constructor
        public PersonalTextBox()
        {
            DataContext = this;
            InitializeComponent();
        }

        // Evento que se dispara cuando una propiedad cambia
        public event PropertyChangedEventHandler? PropertyChanged;

        // Propiedad Etiqueta: la etiqueta asociada al TextBo
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

        // Propiedad Dato: el contenido del TextBox
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

        // Propiedad LargoMaximo: el límite máximo de longitud del TextBox
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

        // Propiedad Text: obtiene o establece el texto del TextBox
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

        // limpia el contenido del TextBox
        public void Clear()
        {
            txtInput.Clear();
        }

        // Evento Click del botón para limpiar el TextBox
        private void btnClear_Click(object sender, RoutedEventArgs e)
        {
            // limpia el contenido del textbox
            txtInput.Clear();
            // pone el foco en el textbox
            txtInput.Focus();
        }

        // Disparador para cuando cambia una propiedad
        private void OnPropertyChanged(string propertyName)
        {
            PropertyChanged?.Invoke(this, new PropertyChangedEventArgs(propertyName));
        }
    }
}