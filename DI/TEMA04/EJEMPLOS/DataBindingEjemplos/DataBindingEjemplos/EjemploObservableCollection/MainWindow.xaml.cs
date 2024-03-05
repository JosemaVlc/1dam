using System;
using System.Collections.Generic;
using System.Collections.ObjectModel;
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

namespace EjemploObservableCollection
{
    /// <summary>
    /// Interaction logic for MainWindow.xaml
    /// </summary>
    public partial class MainWindow : Window
    {
        // Propiedad
        public ObservableCollection<Employee> Employees
        {
            get { return (ObservableCollection<Employee>)GetValue(EmployeesProperty); }
            set { SetValue(EmployeesProperty, value); }
        }

        // Dependencia de la propiedad
        public static readonly DependencyProperty EmployeesProperty =
            DependencyProperty.Register("Employees", typeof(ObservableCollection<Employee>), typeof(MainWindow), new PropertyMetadata(null));


        public MainWindow()
        {
            InitializeComponent();

            Employees = new ObservableCollection<Employee>
            {
                new Employee
                {
                    FirstName = "Michael", 
                    LastName ="Washington",
                    Department="Software Division"
                },

                new Employee
                {
                    FirstName = "John", 
                    LastName ="Strokes",
                    Department="Finance Department"
                },
            };

            Employee otherEmployee = new Employee
            {
                FirstName = "Francisco",
                LastName = "Lifante",
                Department = "IT"
            };

            Employees.Add(otherEmployee);

            dataGrid.ItemsSource = Employees;
        }
    }
}
