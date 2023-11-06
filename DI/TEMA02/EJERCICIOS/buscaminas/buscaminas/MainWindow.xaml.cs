using System.Drawing;
using System.Windows;
using System.Windows.Controls;
using System.Windows.Input;
using System.Windows.Media;
using System.Windows.Threading;

namespace buscaminas
{
    /// <summary>
    /// Interaction logic for MainWindow.xaml
    /// </summary>
    public partial class MainWindow : Window
    {
        private int segundosTranscurridos = 0;
        private DispatcherTimer timer;
        private List<Casillas> casillas = new List<Casillas>();
        private int nClicks = 0;

        public MainWindow()
        {
            InitializeComponent();
            IniciarPartida(false);

            // Suscribe el evento al Border Carita
            Carita.MouseLeftButtonDown += Carita_ClickIzquierdo;
        }


        // Inicializa los elementos necesarios para una partida
        private void IniciarPartida(bool reinicio)
        {
            int filas = 9;
            int columnas = 9;
            int nBombas = 10;
            nClicks = 0;

            // Crea un DispatcherTimer
            timer = new DispatcherTimer();
            timer.Interval = TimeSpan.FromSeconds(1); // Establece el intervalo en 1 segundo
            timer.Tick += Timer_Tick;

            numeroBombas.Text = nBombas.ToString();
            CrearMatriz(filas, columnas, casillas);
            ColocarBombas(casillas, nBombas);
            ContarBombasAlrededor(casillas, filas, columnas);
            if (!reinicio)
            {
                DibujarTablero(filas, columnas);
            }
            RellenarTablero(filas, columnas, casillas, nBombas);
            HabilitarBotones();
        }

        private void CrearMatriz(int filas, int columnas, List<Casillas>casillas)
        {
            // creo todas las casillas en una matriz
            for (int i = 0; i < filas; i++)
            {
                for (int j = 0; j < columnas; j++)
                {
                    // Crea el objeto casilla y lo añade a la matriz
                    Casillas casilla = new Casillas(i, j);
                    casillas.Add(casilla);
                }
            }
        }

        // Coloca las bombas aleatoriamente
        private void ColocarBombas(List<Casillas> casillas, int numeroBombas)
        {
            Random random = new Random();

            for (int i = 0; i < numeroBombas; i++)
            {
                while (true) { 
                    int numeroRandom = random.Next(casillas.Count);
                    Casillas casilla = casillas[numeroRandom];
                    if (casilla.Bomba == false)
                    {
                        casilla.Bomba = true;
                        break;
                    }
                }
            }
        }

        // Cuenta las bombas que hay alrededor y almacena la cifra.
        private void ContarBombasAlrededor(List<Casillas> casillas, int filas, int columnas)
        {
            
            foreach (Casillas casilla in casillas)
            {
                int bombasAlrededor = 0;

                if (casilla.Bomba == true)
                {
                    // Si la casilla actual es una bomba, no es necesario contar las bombas
                    bombasAlrededor = 10;
                }
                else
                {
                    // Verificar las casillas de alrededor
                    for (int i = casilla.Fila - 1; i <= casilla.Fila + 1; i++)
                    {
                        for (int j = casilla.Columna - 1; j <= casilla.Columna + 1; j++)
                        {
                            if (i >= 0 && i < filas && j >= 0 && j < columnas)
                            {
                                // Asegurarse de no salirse de los límites del tablero
                                Casillas casillaAdyacente = casillas.Find(c => c.Fila == i && c.Columna == j);
                                if (casillaAdyacente?.Bomba == true)
                                {
                                    bombasAlrededor++;
                                }
                            }
                        }
                    }
                }

                casilla.bombasAlrededor = bombasAlrededor;
            }
        }

        private void DibujarTablero(int filas, int columnas)
        {
            // genera filas
            for (int i = 0; i < filas; i++)
            {
                RowDefinition rowDefinition = new RowDefinition
                {
                    Height = new GridLength(1, GridUnitType.Star) // '*' en Height
                };
                gridTablero.RowDefinitions.Add(rowDefinition);
            }
            // genera columnas
            for (int i = 0; i < columnas; i++)
            {
                ColumnDefinition columnDefinition = new ColumnDefinition
                {
                    Width = new GridLength(1, GridUnitType.Star) // '*' en Width
                };
                gridTablero.ColumnDefinitions.Add(columnDefinition);
            }
        }
        private void RellenarTablero(int filas, int columnas, List<Casillas> casillas, int nBombas) { 

            // dibuja el tablero
            for (int i = 0; i < filas; i++)
            {
                for (int j = 0; j < columnas; j++)
                {
                    Casillas casilla = casillas.FirstOrDefault(c => c.Fila == i && c.Columna == j);
                    
                    // Crear un contenedor StackPanel para el cuadrado y el TextBlock
                    Button cuadrado = new Button
                    {
                        Width = 50,
                        Height = 50,
                        Background = new SolidColorBrush(Colors.LightGreen),
                        BorderBrush = new SolidColorBrush(Colors.Black),
                        BorderThickness = new Thickness(1),
                        HorizontalAlignment = HorizontalAlignment.Center, // Centra el texto horizontalmente
                        VerticalAlignment = VerticalAlignment.Center,
                    };

                    // Evento Click para mostrar el contenido del botón al hacer clic
                    cuadrado.Click += (sender, e) =>
                    {
                        if (segundosTranscurridos == 0)
                        {
                            IniciarReloj(); // Inicia el contador de segundos cuando se hace el primer clic en el tablero
                        }
                        if (casilla.Bomba == true)
                        {
                            Carita.Background = new SolidColorBrush(Colors.Red);
                            CaritaTexto.Text = ":-(";
                            MostrarBombas();
                            cuadrado.Background = new SolidColorBrush(Colors.Black);
                            DetenerReloj();
                            BloquearBotones();
                            MessageBox.Show("¡Has perdido!", "Derrota");
                        }
                        else
                        {
                            nClicks++;
                            casilla.Descubierta = true;
                            if (cuadrado.Content == "🏴")
                            {
                                nBombas++;
                                numeroBombas.Text = nBombas.ToString();
                            }

                            cuadrado.Background = new SolidColorBrush (Colors.LightBlue);
                            SolidColorBrush color = colorNumeros(casilla.bombasAlrededor);
                            cuadrado.FontWeight = FontWeights.Bold;
                            cuadrado.Foreground = color;

                            if (casilla.bombasAlrededor != 0)
                            {
                                cuadrado.Content = casilla.bombasAlrededor.ToString();
                            }
                            cuadrado.IsHitTestVisible = false; // Desactiva la interacción con el botón, pero conserva su apariencia 

                            // Si la casilla tiene 0 bombas alrededor, descubre las casillas adyacentes
                            if (casilla.bombasAlrededor == 0)
                            {
                                DescubrirCasillasAdyacentes(casillas, filas, columnas, casilla.Fila, casilla.Columna, nBombas);
                            }
                            if (cuadrado.Content == "🏴")
                            {
                                nBombas++;
                                numeroBombas.Text = nBombas.ToString();
                            }

                            // Verifica la condición de victoria después de cada clic
                            if (VerificarVictoria())
                            {
                                MostrarVictoria();
                            }
                        }
                    };
                    cuadrado.MouseRightButtonDown += (sender, e) =>
                    {
                        if (cuadrado.Content == "🏴")
                        {
                            cuadrado.Content = "";                            
                            nBombas++;
                            numeroBombas.Text = nBombas.ToString();
                            casilla.Bandera = false; // Actualiza el estado de la casilla en el ArrayList
                        }
                        else
                        {
                            if (nBombas > 0) {
                                cuadrado.Content = "🏴";
                                nBombas--;
                                numeroBombas.Text = nBombas.ToString();
                                casilla.Bandera = true; // Actualiza el estado de la casilla en el ArrayList
                            }
                            // Verifica la condición de victoria después de cada clicDerecho
                            if (VerificarVictoria())
                            {
                                MostrarVictoria();
                            }
                        }                        
                    };

                    // Agregar el StackPanel al Grid
                    Grid.SetRow(cuadrado, i);
                    Grid.SetColumn(cuadrado, j);
                    gridTablero.Children.Add(cuadrado);
                }
            }
        }

        private SolidColorBrush colorNumeros(int numero)
        {
            SolidColorBrush color;
            switch (numero)
            {
                case 1:
                    color = new SolidColorBrush(Colors.Blue);
                    break;
                case 2:
                    color = new SolidColorBrush(Colors.Green);
                    break;
                case 3:
                    color = new SolidColorBrush(Colors.Red);
                    break;
                case 4:
                    color = new SolidColorBrush(Colors.DarkBlue);
                    break;
                case 5:
                    color = new SolidColorBrush(Colors.DarkRed);
                    break;
                default:
                    color = new SolidColorBrush(Colors.DarkGreen);
                    break;
            }
            return color;
        }

        private void MostrarBombas()
        {
            foreach (Casillas casilla in casillas)
            {
                if (casilla.Bomba)
                {
                    Button cuadrado = gridTablero.Children.Cast<Button>().FirstOrDefault(b => Grid.GetRow(b) == casilla.Fila && Grid.GetColumn(b) == casilla.Columna);

                    cuadrado.Content = "🧨";
                    cuadrado.FontWeight = FontWeights.Bold;
                    cuadrado.Foreground = new SolidColorBrush(Colors.Red);
                    cuadrado.Background = new SolidColorBrush(Colors.Green);
                }
            }
        }

        private void DescubrirCasillasAdyacentes(List<Casillas> casillas, int filas, int columnas, int fila, int columna, int nBombas)
        {
            // Verificar las casillas de alrededor
            for (int i = fila - 1; i <= fila + 1; i++)
            {
                for (int j = columna - 1; j <= columna + 1; j++)
                {
                    if (i >= 0 && i < filas && j >= 0 && j < columnas)
                    {
                        Casillas casillaAdyacente = casillas.Find(c => c.Fila == i && c.Columna == j);
                        if (casillaAdyacente != null)
                        {
                            // Solo descubre casillas si aún no se han descubierto
                            if (!casillaAdyacente.Descubierta)
                            {
                                casillaAdyacente.Descubierta = true;

                                // Actualiza la apariencia de la casilla
                                Button cuadrado = gridTablero.Children.Cast<Button>()
                                    .FirstOrDefault(b => Grid.GetRow(b) == casillaAdyacente.Fila && Grid.GetColumn(b) == casillaAdyacente.Columna);

                                if (cuadrado.Content == "🏴")
                                {
                                    nBombas++;
                                    numeroBombas.Text = nBombas.ToString();
                                }
                                cuadrado.Background = new SolidColorBrush(Colors.LightBlue);
                                cuadrado.FontWeight = FontWeights.Bold;

                                if (casillaAdyacente.bombasAlrededor != 0)
                                {
                                    cuadrado.Content = casillaAdyacente.bombasAlrededor.ToString();
                                    SolidColorBrush color = colorNumeros(casillaAdyacente.bombasAlrededor);
                                    cuadrado.Foreground = color;
                                } else
                                {
                                    cuadrado.Content = "";
                                }

                                cuadrado.IsHitTestVisible = false; // Desactiva la interacción con el botón, pero conserva su apariencia

                                // Si la casilla adyacente tiene 0 bombas alrededor, continúa descubriendo casillas adyacentes
                                if (casillaAdyacente.bombasAlrededor == 0)
                                {
                                    DescubrirCasillasAdyacentes(casillas, filas, columnas, i, j, nBombas);
                                }
                            }
                        }
                    }
                }
            }
        }

        // devuelve si es una victoria
        private bool VerificarVictoria()
        {
            // Verifica si todas las casillas sin bombas están descubiertas
            bool todasDescubiertas = casillas.Where(casilla => !casilla.Bomba).All(casilla => casilla.Descubierta);

            // Verifica si todas las bombas están marcadas con banderas
            bool todasMarcadas = casillas.Where(casilla => casilla.Bomba).All(casilla => casilla.Bandera);

            // Devuelve true si ambas condiciones se cumplen
            return todasDescubiertas || todasMarcadas;
        }

        private void MostrarVictoria()
        {
            // Muestra un mensaje emergente indicando que has ganado
            BloquearBotones();
            DetenerReloj();
            MessageBox.Show("¡Has ganado el juego!\n\nHas realizado "+ nClicks +" clicks \nEn "+segundosTranscurridos + " segundos", "Victoria");
        }


        // Cuando clicas sobre la carita reinicia partida y setea de nuevo los colores de carita
        private void Carita_ClickIzquierdo(object sender, MouseButtonEventArgs e)
        {
            DetenerReloj();
            ResetearReloj();
            LimpiarTablero();
            IniciarPartida(true);
            Carita.Background = new SolidColorBrush(Colors.Yellow);
            CaritaTexto.Text = ":-)";
            
        }

        private void HabilitarBotones()
        {
            // Recorre todos los elementos en el grid
            foreach (UIElement element in gridTablero.Children)
            {
                if (element is Button)
                {
                    Button button = (Button)element;
                    button.IsHitTestVisible = true; // activa la interacción con el botón, pero conserva su apariencia
                }
            }
        }

        private void BloquearBotones()
        {
            // Recorre todos los elementos en el grid
            foreach (UIElement element in gridTablero.Children)
            {
                if (element is Button)
                {
                    Button button = (Button)element;
                    button.IsHitTestVisible= false; // Desactiva la interacción con el botón, pero conserva su apariencia
                }
            }
        }

        private void LimpiarTablero()
        {
            // Elimina todos los botones del grid
            gridTablero.Children.Clear();
            // Limpia la lista de casillas
            casillas.Clear();
        }

        private void Timer_Tick(object sender, EventArgs e)
        {
            segundosTranscurridos++;

            // Actualiza el contenido del Border con los segundos transcurridos
            BorderDerecho.Child = new TextBlock
            {
                Text = segundosTranscurridos.ToString(),
                FontSize = 50,
                VerticalAlignment = VerticalAlignment.Center,
                HorizontalAlignment = HorizontalAlignment.Center
            };
        }

        private void IniciarReloj()
        {
            timer.Start(); // Inicia el DispatcherTimer para contar los segundos
        }


        private void DetenerReloj()
        {
            timer.Stop(); // Detiene el DispatcherTimer
        }
        private void ResetearReloj()
        {
            segundosTranscurridos=0;

            // Actualiza el contenido del Border con los segundos transcurridos
            BorderDerecho.Child = new TextBlock
            {
                Text = segundosTranscurridos.ToString(),
                FontSize = 50,
                VerticalAlignment = VerticalAlignment.Center,
                HorizontalAlignment = HorizontalAlignment.Center
            };
        }
    }
}
