using Microsoft.Win32;
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

namespace MenuContextual
{
    /// <summary>
    /// Interaction logic for MainWindow.xaml
    /// </summary>
    public partial class MainWindow : Window
    {
        public MainWindow()
        {
            InitializeComponent();
        }

        private void Abrir_Click(object sender, RoutedEventArgs e)
        {
            OpenFileDialog openFileDialog = new OpenFileDialog();
            if (openFileDialog.ShowDialog() == true)
            {
                textBox.Text = System.IO.File.ReadAllText(openFileDialog.FileName);
            }
        }

        private void Guardar_Click(object sender, RoutedEventArgs e)
        {
            SaveFileDialog saveFileDialog = new SaveFileDialog();
            if (saveFileDialog.ShowDialog() == true)
            {
                System.IO.File.WriteAllText(saveFileDialog.FileName, textBox.Text);
            }
        }

        private void Salir_Click(object sender, RoutedEventArgs e)
        {
            Application.Current.Shutdown();
        }

        private void Deshacer_Click(object sender, RoutedEventArgs e)
        {
            textBox.Undo();
        }

        private void Rehacer_Click(object sender, RoutedEventArgs e)
        {
            textBox.Redo();
        }

        private void Cortar_Click(object sender, RoutedEventArgs e)
        {
            textBox.Cut();
        }

        private void Copiar_Click(object sender, RoutedEventArgs e)
        {
            textBox.Copy();
        }

        private void Pegar_Click(object sender, RoutedEventArgs e)
        {
            textBox.Paste();
        }
    }


}

