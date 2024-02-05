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
    /// Lógica de interacción para PersonalImage.xaml
    /// </summary>
    public partial class PersonalImage : UserControl
    {
        public PersonalImage()
        {
            InitializeComponent();
            DataContext=this;
        }

        // Evento que se dispara cuando una propiedad cambia
        public event PropertyChangedEventHandler? PropertyChanged;

        // Propiedad de dependencia para el bindeo de la imagen 
        public static readonly DependencyProperty PersonalImageProperty = DependencyProperty.Register("Imagen", typeof(BitmapImage), typeof(PersonalImage));

        public BitmapImage Imagen
        {
            get { return (BitmapImage)GetValue(PersonalImageProperty); }
            set { SetValue(PersonalImageProperty, value); }
        }

        // Propiedad ImagePredeterminada: la imagen asociada al cuadro
        private string imagenPredeterminada;
        public string ImagenPredeterminada
        {
            get
            {
                return imagenPredeterminada;
            }
            set
            {
                imagenPredeterminada = value;
                // Se crea un nuevo BitmapImage a partir de la ruta proporcionada y se establece como fuente de ImagenFondo
                BitmapImage bitmapImage = new BitmapImage(new Uri(value, UriKind.Relative));
                ImagenFondo.Source = bitmapImage;
                // Se notifica a los suscriptores que la propiedad ha cambiado
                OnPropertyChanged(nameof(ImagenPredeterminada));                
            }
        }

        // Disparador para cuando cambia una propiedad
        private void OnPropertyChanged(string propertyName)
        {
            PropertyChanged?.Invoke(this, new PropertyChangedEventArgs(propertyName));
        }
    }
}
