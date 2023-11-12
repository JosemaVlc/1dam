namespace buscaminas
{
    public class Casillas
    {
        public bool Bomba { get; set; }
        public bool Bandera { get; set; }
        public int bombasAlrededor { get; set; }
        public int Fila { get; set; }
        public int Columna { get; set; }
        public bool Descubierta { get; internal set; }

        public Casillas(int fila, int columna)
        {
            Fila = fila;
            Columna = columna;
            Descubierta = false;
            Bandera = false;
        }
    }
}
