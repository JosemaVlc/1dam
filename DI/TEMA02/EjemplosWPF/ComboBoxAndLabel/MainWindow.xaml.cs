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

namespace ComboBoxAndLabel
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

        private void ComboBox_SelectionChanged(object sender, SelectionChangedEventArgs e)
        {

        }

        private void miBoton_Click(object sender, RoutedEventArgs e)
        {
            MessageBox.Show("Hello World");
        }

        private void OnAddItemClicked(object sender, RoutedEventArgs e)
        {
            var itemsCount = myListBox.Items.Count;
            var newItem = new ListBoxItem { Content = "Item " + (itemsCount + 1) };

            myListBox.Items.Add(newItem);
            myListBox.ScrollIntoView(newItem);
            myListBox.SelectedItem = newItem;
        }

        private void OnDeleteItemClicked(object sender, RoutedEventArgs e)
        {
            var selectedItem = myListBox.SelectedItem;
            if (selectedItem != null)
            {
                myListBox.Items.Remove(selectedItem);
                myListBox.SelectedIndex = 0;
            }
        }
    }
}
