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

namespace GridInC_
{
    /// <summary>
    /// Interaction logic for MainWindow.xaml
    /// </summary>
    public partial class MainWindow : Window
    {
        public MainWindow()
        {
            InitializeComponent();

            // Crear un nuevo Grid
            Grid grid = new Grid();

            // Definir columnas y filas
            grid.ColumnDefinitions.Add(new ColumnDefinition());
            grid.ColumnDefinitions.Add(new ColumnDefinition());
            grid.RowDefinitions.Add(new RowDefinition());
            grid.RowDefinitions.Add(new RowDefinition());
            grid.RowDefinitions.Add(new RowDefinition());

            // Añadir componentes al Grid
            Label label1 = new Label { Content = "Nombre:" };
            TextBox textBox1 = new TextBox();
            Label label2 = new Label { Content = "Edad:" };
            TextBox textBox2 = new TextBox();
            Button button = new Button { Content = "Aceptar" };

            // Establecer posición en el Grid
            Grid.SetColumn(label1, 0);
            Grid.SetRow(label1, 0);
            Grid.SetColumn(textBox1, 1);
            Grid.SetRow(textBox1, 0);

            Grid.SetColumn(label2, 0);
            Grid.SetRow(label2, 1);
            Grid.SetColumn(textBox2, 1);
            Grid.SetRow(textBox2, 1);

            Grid.SetColumn(button, 0);
            Grid.SetRow(button, 2);
            Grid.SetColumnSpan(button, 2);

            // Añadir componentes al Grid
            grid.Children.Add(label1);
            grid.Children.Add(textBox1);
            grid.Children.Add(label2);
            grid.Children.Add(textBox2);
            grid.Children.Add(button);

            // Asignar el Grid como el contenido de la ventana
            this.Content = grid;
        }
    }
}
