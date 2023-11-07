using System.Drawing;
using System.Reflection;
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
        // Inicialización de variables globales
        private int segundosTranscurridos = 0;
        private DispatcherTimer timer;
        private List<Casillas> casillas = new List<Casillas>();
        private int nClicks = 0;
        private int filas = 9;
        private int columnas = 9;
        private int nBombas = 10;

        public MainWindow()
        {
            InitializeComponent();

            /* Se llama a la función preparar tablero con el argumento de reinicio en false 
             * para que se dibuje el tablero necesario.*/
            PrepararTablero(false);

            // Suscribe el evento ResetearTablero al Border Carita.
            Carita.MouseLeftButtonDown += ResetearTablero;
        }


        // Inicializa los elementos necesarios para una partida.
        private void PrepararTablero(bool reinicio)
        {
            // Creacion de un DispatcherTimer
            timer = new DispatcherTimer();
            timer.Interval = TimeSpan.FromSeconds(1); // Establece el intervalo en 1 segundo
            timer.Tick += Timer_Tick; // Llama a la función Timer_Tick por cada intervalo

            // Reestablece a cero el TextBlock numeroBombas
            numeroBombas.Text = nBombas.ToString();


            CrearCasillas();
            ColocarBombas();
            ContarBombasAlrededor();
            if (!reinicio)
            {
                DibujarTablero();
            }
            RellenarTablero();
            HabilitarBotones();
        }

        // Reinicia el tablero para dejarlo preparado para otra partida
        private void ResetearTablero(object sender, MouseButtonEventArgs e)
        {
            nClicks = 0;
            DetenerReloj();
            ResetearReloj();
            LimpiarTablero();
            PrepararTablero(true);
            Carita.Background = new SolidColorBrush(Colors.Yellow);
            CaritaTexto.Text = ":-)";
            
        }

        // Genera las casillas y las añade a la arraylist
        private void CrearCasillas()
        {
            for (int i = 0; i < filas; i++)
            {
                for (int j = 0; j < columnas; j++)
                {                    
                    Casillas casilla = new Casillas(i, j);
                    casillas.Add(casilla);
                }
            }
        }

        // Coloca las bombas en casillas aleatorias
        private void ColocarBombas()
        {
            Random random = new Random();

            // Bucle para colocar X numero de bombas. 
            for (int i = 0; i < nBombas; i++)
            {
                /* Coloca una bomba en una casilla aleatoria, si ya contiene bomba 
                 * intentará colocarla en otra casilla aleatoria, así hasta que encuentre 
                 * una casilla que no tenga bomba*/
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
        private void ContarBombasAlrededor()
        {
            // Recorre las casillas
            foreach (Casillas casilla in casillas)
            {
                int bombasAlrededor = 0;

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

                casilla.bombasAlrededor = bombasAlrededor;
            }
        }

        // Genera el numero de filas y columnas y las añade al gridTablero
        private void DibujarTablero()
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


        // Genera y coloca los botones dentro del gridTablero
        private void RellenarTablero() { 

            // Recorre las filas y columnas y coloca los botones
            for (int i = 0; i < filas; i++)
            {
                for (int j = 0; j < columnas; j++)
                {
                    
                    // Crea un Boton cuadrado por cada posición del gridTablero
                    Button cuadrado = new Button
                    {
                        Width = 50, // Ancho
                        Height = 50, // Alto
                        Background = new SolidColorBrush(Colors.LightGreen), // Fondo verde claro
                        BorderBrush = new SolidColorBrush(Colors.Black), // Borde color negro
                        BorderThickness = new Thickness(1), // Grosor del borde 1
                        HorizontalAlignment = HorizontalAlignment.Center, // Centra horizontalmente
                        VerticalAlignment = VerticalAlignment.Center, // Centra verticalmente 
                    };

                    // Busca la casilla correspondiente a la fila y columna
                    Casillas casilla = casillas.Find(c => c.Fila == i && c.Columna == j);

                    // Suscribe los eventos del Click izquierdo y derecho sobre el cuadrado.
                    cuadrado.Click += (sender, e) => ClickIzquierdo(cuadrado, casilla);
                    cuadrado.MouseRightButtonDown += (sender, e) => ClickDerecho(cuadrado, casilla);

                    // Agregar el botón al Grid
                    Grid.SetRow(cuadrado, i);
                    Grid.SetColumn(cuadrado, j);
                    gridTablero.Children.Add(cuadrado);
                }
            }
        }

        // Función que realiza cuando se pulsa click derecho sobre un botón
        private void ClickIzquierdo(Button cuadrado, Casillas casilla)
        {
            // Inicia el contador de segundos cuando se hace el primer clic en el tablero
            if (nClicks == 0)
            {
                IniciarReloj(); 
            }

            // Si la casilla es tiene una bomba
            if (casilla.Bomba)
            {                
                MostrarBombas(); // Muestra todas las bombas

                // Setea la carita a roja y la pone triste
                CaritaTexto.Text = ":-("; 
                Carita.Background = new SolidColorBrush(Colors.Red);
                
                // El fondo del botón con bomba clicado se pone de color negro
                cuadrado.Background = new SolidColorBrush(Colors.Black);
                
                // Detiene el reloj, bloquea botones y muestra el mensaje de derrota
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

                cuadrado.Background = new SolidColorBrush(Colors.LightBlue);
                SolidColorBrush color = ColorNumeros(casilla.bombasAlrededor);
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
        }

        private void ClickDerecho(Button cuadrado, Casillas casilla)
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
                if (nBombas > 0)
                {
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
        }


        // Segun el numero de bombas adyacente se pondran de un color u otro.
        private SolidColorBrush ColorNumeros(int numero)
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

        // Muestra todas las bombas
        private void MostrarBombas()
        {
            // Recorre todas las casillas
            foreach (Casillas casilla in casillas)
            {
                if (casilla.Bomba)
                {
                    // Busca el primer botón que corresponda a la fila y columna de la casilla concreta
                    Button cuadrado = gridTablero.Children.Cast<Button>().FirstOrDefault(b => Grid.GetRow(b) == casilla.Fila && Grid.GetColumn(b) == casilla.Columna);

                    // Le introduce los valores correspondiente
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
                                    SolidColorBrush color = ColorNumeros(casillaAdyacente.bombasAlrededor);
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
