import java.util.LinkedList;

public class HamiltonianPath 
{
    public static void main(String[] args) 
    {
        Graph<Integer> g = new Graph<Integer>();

        g.insertVertex(1, "La plaza de armas (Punto inicial)");
        g.insertVertex(2, "La casa Tristán del pozo");
        g.insertVertex(3, "El museo de santuarios andinos");
        g.insertVertex(4, "La iglesia de la compañía");
        g.insertVertex(5, "El museo casa moral");
        g.insertVertex(6, "La iglesia de san Agustín");
        g.insertVertex(7, "El casino Villa Fortuna");
        g.insertVertex(8, "El palacio de Goyeneche");
        g.insertVertex(9, "El Museo arqueológico de san Agustín");
        g.insertVertex(10, "La iglesia de la Merced");
        g.insertVertex(11, "El museo de arqueología de la UCSM");
        g.insertVertex(12, "La iglesia de santo Domingo");
        g.insertVertex(13, "El parque Duhamel");
        g.insertVertex(14, "El monasterio de Santa Catalina");
        g.insertVertex(15, "El centro cultural Peruano Norteamericano");
        g.insertVertex(16, "El complejo de San Francisco");
        g.insertVertex(17, "El Museo Histórico Municipal Guillermo Zegarra Meneses");
        g.insertVertex(18, "El Templo de la Tercera Orden Franciscana Menor");
        g.insertVertex(19, "El Fundo El Fierro");
        g.insertVertex(20, "La parroquia de Santa Marta");
        g.insertVertex(21, "El convento de Santa Teresa");
        g.insertVertex(22, "El museo PuriqRuna");
        g.insertVertex(23, "El Museo de Arte Contemporáneo");
        g.insertVertex(24, "El museo textil Mitchell Arequipa");
        g.insertVertex(25, "Mundo Alpaca");
        
        int [][] distancias = 
        {
            {0,140,200,140,300,220,260,260,250,400,550,500,550,600,650,500,550,650,650,900,900,2000,700,1900,750},
            {140,0,350,200,280,300,210,450,300,550,600,450,600,450,500,350,400,500,500,750,750,2200,700,1900,700},
            {200,350,0,290,400,300,400,150,180,210,300,500,500,550,850,700,650,800,750,1100,1100,2100,800,2000,850},
            {140,200,290,0,450,350,180,170,160,450,500,270,400,600,650,550,600,700,700,900,900,2100,850,2000,900},
            {300,280,400,450,0,150,500,550,550,600,500,750,900,350,650,500,450,550,500,900,900,1800,600,1800,600},
            {220,300,300,350,150,0,400,450,500,550,350,650,800,500,800,650,600,700,650,1000,1000,2000,750,1900,750},
            {260,210,400,180,500,400,0,350,350,600,700,260,400,650,450,500,600,700,700,700,700,2100,850,2000,900},
            {260,450,150,170,550,450,350,0,29,260,350,450,350,700,800,650,700,800,800,1000,1100,2200,950,2100,1000},
            {250,300,180,160,550,500,350,29,0,270,400,450,350,700,800,650,700,800,800,1100,1100,2200,1000,2100,1000},
            {400,550,210,450,600,550,600,260,270,0,400,700,600,750,1100,900,900,1000,950,1300,1300,2300,1000,2200,1000},
            {550,600,300,500,500,350,700,450,400,400,0,800,700,800,1100,1000,950,1000,1000,1400,1400,2300,1100,2200,1100},
            {500,450,500,270,750,650,260,350,450,700,800,0,250,850,600,750,850,950,950,650,650,2400,1100,2300,1100},
            {550,600,500,400,900,800,400,700,350,600,700,250,0,1000,750,900,1000,1100,1100,700,700,2500,1300,2400,1300},
            {600,450,550,600,350,500,650,800,700,750,800,850,1000,0,550,400,350,450,450,850,800,1800,500,1700,500},
            {650,500,850,650,650,800,450,650,800,1100,1100,600,750,550,0,160,270,350,350,500,240,1800,550,1700,600},
            {500,350,700,550,500,650,500,700,650,900,1000,750,900,400,160,0,110,210,210,650,400,1700,400,1600,400},
            {550,400,650,600,450,600,600,800,700,900,950,850,1000,350,270,110,0,96,95,750,500,1500,280,1400,290},
            {650,500,800,700,550,700,700,800,800,1000,1000,950,1100,450,350,210,96,0,33,850,500,1500,220,1400,220},
            {650,500,750,700,500,650,700,1000,800,950,1000,950,1100,450,350,210,95,33,0,850,550,1400,180,1400,190},
            {900,750,1100,900,900,1000,700,1100,1100,1300,1400,650,700,850,500,650,750,850,850,0,350,2300,1000,2200,1100},
            {900,750,1100,900,900,1000,700,2200,1100,1300,1400,650,700,800,240,400,500,500,550,350,0,1900,650,1800,700},
            {2000,2200,2100,2100,1800,2000,2100,950,2200,2300,2300,2400,2500,1800,1800,1700,1500,1500,1400,2300,1900,0,1300,130,1200},
            {700,700,800,850,600,750,850,950,1000,1000,1100,1100,1300,500,550,400,280,220,180,1000,650,1300,0,1200,110},
            {1900,1900,2000,2000,1800,1900,2000,2100,2100,2200,2200,2300,2400,1700,1700,1600,1400,1400,1400,2200,1800,130,1200,0,1200},
            {750,700,850,900,600,750,900,1000,1000,1000,1100,1100,1300,500,600,400,290,220,190,1100,700,1200,110,1200,0}
        };
        for(int i=0 ; i<distancias.length ; i++)
        {
            for(int j=0 ; j<distancias[i].length ; j++)
            {
                //Insertamos las aristas
                g.insertEdge(i+1, j+1, distancias[i][j]);
            }
        }
        
        
        
        LinkedList<Vertex<Integer>> path;
        System.out.println("_________________________ Camino hamiltoniano, SIN la toma de pesos _________________________");
        path= new LinkedList<Vertex<Integer>>(); 
    	g.hamiltonPath(path, 1);
        
        System.out.println("_________________________ Camino hamiltoniano, CON la toma de pesos _________________________");
        path = new LinkedList<Vertex<Integer>>();
        g.hamiltonPathMenorPeso(path , 1);
    }
}
