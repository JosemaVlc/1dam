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

namespace WpfApp1
{
    /// <summary>
    /// Lógica de interacción para MainWindow.xaml
    /// </summary>
    public partial class MainWindow : Window
    {

        public MainWindow()
        {
            InitializeComponent();
            DataContext = this;
        }

        public event PropertyChangedEventHandler PropertyChanged;

        private string nombre;

        public string Nombre
        { 
            get { return nombre; } 
            set 
            { 
                nombre = value; 
                OnPropertyChanged(nameof(Nombre));
                OnPropertyChanged(nameof(nombreCompleto));
            } 
        }


        private string apellido;

        public string Apellido
        {
            get { return apellido; }
            set
            {
                apellido = value;
                OnPropertyChanged(nameof(Apellido));
                OnPropertyChanged(nameof(nombreCompleto));
            }
        }

        private void OnPropertyChanged(string propertyName)
        {
            PropertyChanged?.Invoke(this, new PropertyChangedEventArgs(propertyName));
        }

        public string nombreCompleto { 
            get 
            {
                return $"{Nombre} {Apellido}";
            } 
        }
    }
}
