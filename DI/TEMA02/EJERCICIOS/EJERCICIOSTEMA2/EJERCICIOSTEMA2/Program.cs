using EJERCICIOSTEMA2;
using System.Collections;

namespace Tema02 {
    internal class Program
    {   
        static void Main()
        {
            ArrayList empleados = new ArrayList();
            ArrayList alumnos = new ArrayList();
            ArrayList asociados = new ArrayList();

            while (true)
            {
                Console.WriteLine(@"
***********************************************************************
Introduce opción:

    0. Salir del programa.

    1. Recorre los números del 1 al 200. Utiliza un bucle for.

    2. Recorre los números del 1 al 200. Utiliza un bucle while.

    3. Recorre los números del 1 al 200. Muestra los números pares 
        e impares por separado. Usar el tipo de bucle que quieras.

    4. Implementa un programa que pida los tres lados de un triángulo 
    al usuario. Tienes que implementar los siguientes métodos: 
    inicialización (en el cual se consigue la información); 
    tipo_de_triángulo, que dependiendo de la medida de los lados nos 
    diga si es equilátero, isósceles o escaleno; area_triángulo que 
    nos va a informar de la medida del área del triángulo.

    5. Implementad una clase Alumno y definid como atributos su 
    nombre y su edad. Definid otros dos métodos para imprimir los 
    datos que se han ingresado y un mensaje indicando si es mayor 
    de edad o no (edad >=18).

    6. Crea una clase que represente a los empleados de una empresa. 
    Establece su nombre y salario como atributos. Carga los atributos 
    en el constructor, luego imprime sus datos en otro método y 
    finalmente imprime un mensaje si tiene que pagar impuestos (si el 
    salario supera los 2000 €).

    7. En esta actividad debes implementar una clase llamada operación. 
    Hay que cargar dos valores enteros en el constructor y a 
    continuación, calcular su suma, resta, multiplicación y división, 
    cada una en un método. A continuación, imprimir dichos resultados.

    8. Crea una clase llamada club y otra clase llamada asociado. La 
    clase asociado ha de tener los siguientes atributos privados: nombre 
    y antigüedad en el club (en años). En el constructor de la clase 
    debes pedir el nombre y su antigüedad. La clase Club debe tener 3 
    objetos de la clase asociado como atributos. Define un método que 
    imprima el nombre del asociado del club con el mayor tiempo de 
    antigüedad.

***********************************************************************
Escoge opción: 
                ");
                string? opc = Console.ReadLine();
                Console.WriteLine("");
                switch (opc)
                {
                    case "0":
                        Console.WriteLine("Adios");
                        Environment.Exit(0);
                        break;
                    case "1":
                        ejerciciosTema2.ejercicio01();
                        break;
                    case "2":
                        ejerciciosTema2.ejercicio02();
                        break;
                    case "3":
                        ejerciciosTema2.ejercicio03();
                        break;
                    case "4":
                        ejercicio04.ejercicio04Init();
                        break;
                    case "5":
                        Alumno alumno = new Alumno();
                        alumno.datosAlumno();
                        alumnos.Add(alumno);
                        break;
                    case "6":
                        Empleado empleado = new Empleado();
                        empleado.datosEmpleado();                        
                        empleados.Add(empleado);
                        break;
                    case "7":
                        Operacion operacion = new Operacion();
                        Console.WriteLine(operacion.ToString());
                        Console.ReadLine();
                        break;
                    case "8":
                        Asociado asociado1 = new Asociado();
                        Asociado asociado2 = new Asociado();
                        Asociado asociado3 = new Asociado();
                        asociados.Add(asociado1);
                        asociados.Add(asociado2);   
                        asociados.Add(asociado3);
                        int antiguedad = 0;
                        string datos = "";
                        foreach ( Asociado i in asociados){
                            if (i.Antiguedad > antiguedad)
                            {
                                antiguedad = i.Antiguedad;
                                datos = i.ToString();
                            }
                        }
                        Console.WriteLine(datos);
                        break;


                    case "null":
                        Console.WriteLine("Ingresa opción valida");
                        break;
                }
            }
        }
    }

    internal class ejerciciosTema2
    { 
        internal static void ejercicio01()
        {
            Console.WriteLine("Bucle con for:");
            for (int i = 1; i <= 200; i++)
            {
                Console.WriteLine(i);
            }
            Console.ReadLine();
        }
        internal static void ejercicio02()
        {
            Console.WriteLine("Bucle con While");
            int i = 0;
            while (i < 200)
            {
                i++;
                Console.WriteLine(i);
            }
            Console.ReadLine();
        }
        internal static void ejercicio03()
        {
            List<int> iEven = new List<int>();
            List<int> iOdd = new List<int>();
            for(int i = 1; i < 200; i++)
            {
                if (i%2 == 0)
                {
                    iEven.Add(i);
                }
                else
                {
                    iOdd.Add(i);
                }                
            }
            Console.WriteLine("Lista de pares: ");
            foreach(int i in iEven)
            {
                Console.WriteLine(i);
            }
            Console.WriteLine("Lista de impares");
            foreach (int i in iOdd)
            {
                Console.WriteLine(i);
            }
            Console.ReadLine();
        }
    }
}
