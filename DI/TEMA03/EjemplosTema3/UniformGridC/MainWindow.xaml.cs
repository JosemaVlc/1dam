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

namespace UniformGridC
{
    /// <summary>
    /// Interaction logic for MainWindow.xaml
    /// </summary>
    public partial class MainWindow : Window
    public partial class MainWindow : Window
    {
        private const int Filas = 9;
        private const int Columnas = 9;
        public MainWindow()
        {
            InitializeComponent();
            CrearTablero();
        }

        private void CrearTablero()
        {
            for (int i = 0; i < Filas; i++)
            {
                for (int j = 0; j < Columnas; j++)
                {
                    Button boton = new Button();
                    boton.Name = $"btn_{i}_{j}";
                    boton.Content = "";

                    boton.Click += Casilla_Click;
                    boton.MouseRightButtonDown += Casilla_ClickDerecho;

                    Grid.SetRow(boton, i);
                    Grid.SetColumn(boton, j);

                    gameGrid.Children.Add(boton);
                }
            }
        }

        private void Casilla_ClickDerecho(object sender, MouseButtonEventArgs e)
        {
            Button myButton = sender;
        }

        private void Casilla_Click(object sender, RoutedEventArgs e)
        {
            throw new NotImplementedException();
        }
    }
}
