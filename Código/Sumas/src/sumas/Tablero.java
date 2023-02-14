//Martin Rilo - 236209
//Joaquin Calvo - 203832
package sumas;

public class Tablero {

    private Ficha[][] matriz;
    private String formaVisualizacion;
    private String colorTurno;

    public Tablero() {
        matriz = new Ficha[8][9];
        formaVisualizacion = "VERN";
        colorTurno = "ROJO";
    }

    public String getColorTurno() {
        return colorTurno;
    }

    public void setColorTurno(String colorTurno) {
        this.colorTurno = colorTurno;
    }

    public Ficha[][] getMatriz() {
        return matriz;
    }

    public void setMatriz(int posicionFila, int posicionColumna, Ficha ficha) {
        this.matriz[posicionFila][posicionColumna] = ficha;
    }

    public void reiniciarMatriz() {
        this.matriz = new Ficha[8][9];
    }

    public String getFormaVisualizacion() {
        return formaVisualizacion;
    }

    public void setFormaVisualizacion(String formaVisualizacion) {
        this.formaVisualizacion = formaVisualizacion;
    }

}
