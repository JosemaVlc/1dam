using DataGridSort;
using System;
using System.Collections.Generic;
using System.Collections.ObjectModel;
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

namespace DataGridSort
{
    /// <summary>
    /// Interaction logic for MainWindow.xaml
    /// </summary>
    public partial class MainWindow : Window
    {
        public ObservableCollection<Employee> Employees
        {
            get { return (ObservableCollection<Employee>)GetValue(EmployeesProperty); }
            set { SetValue(EmployeesProperty, value); }
        }

        public static readonly DependencyProperty EmployeesProperty =
            DependencyProperty.Register("Employees", typeof(ObservableCollection<Employee>), typeof(MainWindow), new PropertyMetadata(null));

        public MainWindow()
        {
            InitializeComponent();


            Employees = new ObservableCollection<Employee>
            {
                new Employee
                {
                    ID = "EMP0001",
                    FirstName = "Kunal", LastName = "Chowdhury",
                    Department = "Software Division"
                },

                new Employee
                {
                    ID = "EMP0002",
                    FirstName = "Michael", LastName = "Washington",
                    Department = "Software Division"
                },

                new Employee
                {
                    ID = "EMP0003",
                    FirstName = "John",
                    LastName = "Strokes",
                    Department = "Finance Department"
                },

                new Employee
                {
                    ID = "EMP0004",
                    FirstName = "Ramesh",
                    LastName = "Shukla",
                    Department = "Finance Department"
                }
            };

            dataGrid.ItemsSource = Employees;
        }

        private void OnSortByDepartment(object sender, RoutedEventArgs e)
        {
            var cvs = CollectionViewSource.GetDefaultView(dataGrid.ItemsSource);
            if (cvs != null && cvs.CanSort)
            {
                cvs.SortDescriptions.Clear();

                if (sortByDepartment.IsChecked == true)
                {
                    cvs.SortDescriptions.Add(new SortDescription("Department", ListSortDirection.Ascending));
                }
            }
        }
    }
}
