using System.Windows;
using System.Windows.Controls;
using System.Windows.Input;
using System.Windows.Media;
using System.Windows.Media.Imaging;
using System.Windows.Threading;

namespace buscaminas
{
    /// <summary>
    /// Interaction logic for MainWindow.xaml
    /// </summary>
    public partial class MainWindow : Window
    {
        // Inicialización de variables globales
        private static int segundosTranscurridos = 0;
        private static DispatcherTimer timer;
        private static List<Casillas> casillas = new List<Casillas>();
        private static int nClicks = 0;
        private static int filas = 9;
        private static int columnas = 9;
        private static int nBombas = 10;
        private static int nBanderas = nBombas;

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
            numeroBombas.Text = nBanderas.ToString();


            CrearCasillas();
            ColocarBombas();
            ContarBombasAlrededor();
            RellenarTablero();
            HabilitarBotones();
        }

        // Reinicia el tablero para dejarlo preparado para otra partida
        private void ResetearTablero(object sender, MouseButtonEventArgs e)
        {
            nClicks = 0;
            nBanderas = nBombas;
            DetenerReloj();
            ResetearReloj();
            LimpiarTablero();
            PrepararTablero(true);
            Carita.Source = new BitmapImage(new Uri("./img/smiley.png", UriKind.Relative));


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
                while (true)
                {
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

        // Genera y coloca los botones dentro del gridTablero
        private void RellenarTablero()
        {

            // Recorre las filas y columnas y coloca los botones
            for (int i = 0; i < filas; i++)
            {
                for (int j = 0; j < columnas; j++)
                {

                    // Crea un Boton cuadrado por cada posición del gridTablero
                    Button cuadrado = new Button
                    {
                        Style = (Style)FindResource("EstiloBotonPersonalizado")
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

        // Función que realiza cuando se pulsa click izquierdo sobre un botón
        private void ClickIzquierdo(Button cuadrado, Casillas casilla)
        {

            // Inicia el contador de segundos cuando se hace el primer clic en el tablero
            if (nClicks == 0)
            {
                IniciarReloj();
            }

            // Suma un click
            nClicks++;

            // Si la casilla es tiene una bomba
            if (casilla.Bomba)
            {
                MostrarBombas(); // Muestra todas las bombas

                // Setea la carita a enfadada
                Carita.Source = new BitmapImage(new Uri("./img/enfadado.png", UriKind.Relative));

                // El fondo del botón con bomba clicado se pone de color negro
                Image imgExplotar = cuadrado.Content as Image;
                imgExplotar = new Image
                {
                    Source = new BitmapImage(new Uri("./img/explotar.png", UriKind.Relative)),
                };
                cuadrado.Content = imgExplotar;
                cuadrado.Background = new SolidColorBrush(Colors.Black);

                // Detiene el reloj, bloquea botones y muestra el mensaje de derrota
                MostrarDatos(false);
            }
            else
            {                
                casilla.Descubierta = true;
                if (cuadrado.Content is Image)
                {
                    nBanderas++;
                    numeroBombas.Text = nBanderas.ToString();
                    cuadrado.Content = "";
                }

                cuadrado.Style = (Style)FindResource("EstiloBotonAbierto");
                SolidColorBrush color = ColorNumeros(casilla.bombasAlrededor);
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
                if (cuadrado.Content is Image)
                {
                    nBanderas++;
                    numeroBombas.Text = nBanderas.ToString();
                }

                // Verifica la condición de victoria después de cada clic
                if (VerificarVictoria())
                {
                    MostrarDatos(true);
                }
            }
        }

        // Función que realiza cuando se pulsa click derecho sobre un botón
        private void ClickDerecho(Button cuadrado, Casillas casilla)
        {
            if (cuadrado.Content is Image)
            {
                cuadrado.Content = "";
                nBanderas++;
                numeroBombas.Text = nBanderas.ToString();
                casilla.Bandera = false; // Actualiza el estado de la casilla en el ArrayList
            }
            else
            {
                if (nBanderas > 0)
                {
                    Image imgBandera = cuadrado.Content as Image;
                    imgBandera = new Image
                    {
                        Source = new BitmapImage(new Uri("./img/bandera.png", UriKind.Relative)),
                        Width = 35,
                        Height = 35,
                    };
                    cuadrado.Content = imgBandera;
                    nBanderas--;
                    numeroBombas.Text = nBanderas.ToString();
                    casilla.Bandera = true; // Actualiza el estado de la casilla en el ArrayList
                }
                // Verifica la condición de victoria después de cada clicDerecho
                if (VerificarVictoria())
                {
                    MostrarDatos(true);
                }
            }
        }


        // Segun el numero de bombas adyacente se pondrán de un color u otro.
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
                Button cuadrado = gridTablero.Children.Cast<Button>().FirstOrDefault(b => Grid.GetRow(b) == casilla.Fila && Grid.GetColumn(b) == casilla.Columna);
                if (casilla.Bomba)
                {
                    // Busca el primer botón que corresponda a la fila y columna de la casilla concreta
                    if (cuadrado.Content is not Image)
                    {
                        // Le introduce los valores correspondiente
                        Image imgBomba = cuadrado.Content as Image;
                        imgBomba = new Image
                        {
                            Source = new BitmapImage(new Uri("./img/bomba.png", UriKind.Relative)),
                            Width = 35,
                            Height = 35,
                        };
                        cuadrado.Content = imgBomba;
                    }
                    cuadrado.Style = (Style)FindResource("EstiloBombaCerrada");
                }
                else
                {
                    if (cuadrado.Content is Image)
                    {
                        Image imgEquis = cuadrado.Content as Image;
                        imgEquis = new Image
                        {
                            Source = new BitmapImage(new Uri("./img/equis.png", UriKind.Relative)),
                            Width = 30,
                            Height = 30,
                        };
                        cuadrado.Content = imgEquis;
                    }
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

                                if (cuadrado.Content is Image)
                                {
                                    nBanderas++;
                                    numeroBombas.Text = nBanderas.ToString();
                                }
                                cuadrado.Style = (Style)FindResource("EstiloBotonAbierto");

                                if (casillaAdyacente.bombasAlrededor != 0)
                                {
                                    cuadrado.Content = casillaAdyacente.bombasAlrededor.ToString();
                                    SolidColorBrush color = ColorNumeros(casillaAdyacente.bombasAlrededor);
                                    cuadrado.Foreground = color;
                                }
                                else
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

        private void MostrarDatos(bool estado)
        {
            // Muestra un mensaje emergente indicando que has ganado
            BloquearBotones();
            DetenerReloj();
            if(estado)
            {
                MessageBox.Show("¡Has ganado el juego!\n\nHas realizado " + nClicks + " clicks \nEn " + segundosTranscurridos + " segundos", "Victoria");
            }
            else
            {
                MessageBox.Show("¡Has perdido el juego!\n\nHas realizado " + nClicks + " clicks \nEn " + segundosTranscurridos + " segundos", "Derrota");
            }
            
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
                    button.IsHitTestVisible = false; // Desactiva la interacción con el botón, pero conserva su apariencia
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
            segundosTranscurridos = 0;

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
