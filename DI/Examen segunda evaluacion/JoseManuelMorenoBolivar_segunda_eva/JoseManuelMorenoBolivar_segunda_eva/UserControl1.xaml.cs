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

namespace JoseManuelMorenoBolivar_segunda_eva
{
    /// <summary>
    /// Lógica de interacción para UserControl1.xaml
    /// </summary>
    public partial class UserControl1 : UserControl, INotifyPropertyChanged
    {
        /*
         * DEPENDENCY PROPERTY DE LOS ELEMENTOS ENTRADA, SALIDA Y TASA
         */
        public static readonly DependencyProperty LabelTextEntradaProperty = DependencyProperty.Register(nameof(LabelTextEntrada), typeof(string), typeof(UserControl1), 
                                                                                                        new PropertyMetadata(LabelTextEntradaPropertyChanged));
        public static readonly DependencyProperty LabelTextSalidaProperty = DependencyProperty.Register(nameof(LabelTextSalida), typeof(string), typeof(UserControl1),
                                                                                                        new PropertyMetadata(LabelTextSalidaPropertyChanged));
        public static readonly DependencyProperty LabelTextTasaProperty = DependencyProperty.Register(nameof(LabelTextTasa), typeof(string), typeof(UserControl1),
                                                                                                        new PropertyMetadata(LabelTextTasaPropertyChanged));

        public UserControl1()
        {
            InitializeComponent();
            DataContext = this; // ALMACENA EL CONTEXTO ACTUAL
        }

        private string cambioText;

        // EVENTO CUANDO CAMBIA UNA PROPIEDAD DEL COMPONENTE
        public event PropertyChangedEventHandler PropertyChanged;

        public string CambioText 
        {
            get
            {
                return cambioText;
            }
            set
            {
                cambioText = value;
                OnPropertyChanged(nameof(CambioMoneda));
            }
        }

        private string cambioMoneda;
        public string CambioMoneda
        {
            get
            {
                if (cambioText != null)
                {
                    var cambio = double.Parse(cambioText) * double.Parse(LabelPathTasa.Text);
                    cambioMoneda = cambio.ToString();
                }
                return cambioMoneda;
            }
            set
            {
            }
        }

        private void OnPropertyChanged(string propertyName)
        {
            PropertyChanged?.Invoke(this, new PropertyChangedEventArgs(propertyName = null));
        }


        public string LabelTextTasa
        {
            get
            {
                return (string)GetValue(LabelTextTasaProperty);
            }
            set
            {
                SetValue(LabelTextTasaProperty, value);
            }
        }

        public string LabelTextEntrada { 
            get 
            {
                return (string)GetValue(LabelTextEntradaProperty);
            }
            set 
            {
                SetValue(LabelTextEntradaProperty, value);
            }
        }
        public string LabelTextSalida
        {
            get
            {
                return (string)GetValue(LabelTextSalidaProperty);
            }
            set
            {
                SetValue(LabelTextSalidaProperty, value);
            }
        }

        /*
         * PROPERTY CHANGED DE LOS ELEMENTOS TASA, ENTRADA Y SALIDA
         */
        private static void LabelTextTasaPropertyChanged(DependencyObject d, DependencyPropertyChangedEventArgs e)
        {
            var userControlPath = (UserControl1)d;
            userControlPath.LabelPathTasa.Text = e.NewValue.ToString();
        }
        private static void LabelTextEntradaPropertyChanged(DependencyObject d, DependencyPropertyChangedEventArgs e)
        {
            var userControlPath = (UserControl1)d;
            userControlPath.LabelPathEntrada.Content = e.NewValue.ToString();
        }
        private static void LabelTextSalidaPropertyChanged(DependencyObject d, DependencyPropertyChangedEventArgs e)
        {
            var userControlPath = (UserControl1)d;
            userControlPath.LabelPathSalida.Content = e.NewValue.ToString();
        }
    }
}
