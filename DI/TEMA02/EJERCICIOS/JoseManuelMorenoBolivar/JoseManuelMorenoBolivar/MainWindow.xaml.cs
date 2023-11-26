using System;
using System.Windows;

namespace JoseManuelMorenoBolivar
{
    /// <summary>
    /// Lógica de interacción para MainWindow.xaml
    /// </summary>
    public partial class MainWindow : Window
    {
        public MainWindow()
        {
            InitializeComponent();
        }

        private void acercaDe(object sender, EventArgs e)
        {
            MessageBox.Show("Esta aplicación ha sido desarrollada por Jose Manuel Moreno Bolivar", "Acerca de");
        }
    }
}
