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
using System.Windows.Shapes;

namespace DataBindingEjemplos
{
    /// <summary>
    /// Interaction logic for NuevaTareaForm.xaml
    /// </summary>
    public partial class NuevaTareaForm : Window
    {
        public Tarea NuevaTarea { get; private set; }

        public NuevaTareaForm()
        {
            InitializeComponent();
        }

        private void Aceptar_Click(object sender, RoutedEventArgs e)
        {
            // Crea una nueva tarea con los datos ingresados
            NuevaTarea = new Tarea
            {
                Titulo = txtTitulo.Text,
                Descripcion = txtDescripcion.Text
            };

            // Cierra el formulario
            DialogResult = true;
            Close();
        }

        private void Cancelar_Click(object sender, RoutedEventArgs e)
        {
            // Cierra el formulario sin agregar la tarea
            DialogResult = false;
            Close();
        }
    }
}
