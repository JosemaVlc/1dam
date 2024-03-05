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

namespace ObservableCollection
{
    /// <summary>
    /// Lógica de interacción para MainWindow.xaml
    /// </summary>
    public partial class MainWindow : Window
    {
        private ObservableCollection<Employee> Employees 
        {
            get { 
                return (ObservableCollection<Employee>)GetValue(EmployeesProperty); 
            }
            set
            {
                SetValue(EmployeesProperty, value);
            } 
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
                    Nombre = "Michael"
                },

                new Employee
                {
                    Nombre = "John"
                },
            };

            Employee nuevoEmpleado = new Employee
            {
                Nombre = "Josema"
            };

            Employees.Add(nuevoEmpleado);

            dataGrid.ItemsSource = Employees;
        }
    }
}
