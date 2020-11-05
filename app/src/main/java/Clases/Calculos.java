package Clases;

import android.speech.SpeechRecognizer;

public class Calculos {

    private int x;
    private int y;
    private int prestamoTotal;

    public Calculos(int x, int y)
    {
        this.x = x;
        this.y = y;
    }

    public int x()
    {
        return x;
    }
    public int y()
    {
        return y;
    }
    public int getPrestamoTotal()
    {
        return prestamoTotal;
    }
    public void setPrestamoTotal(int prestamoTotal)
    {
        this.prestamoTotal = prestamoTotal;
    }



    public String CalcularPrestamos()
    {
        prestamoTotal=x+y;
        String resultadoFinal = String.valueOf(prestamoTotal);
        return resultadoFinal;
    }


    public String CalcularDeudas()
    {
      String resultadoPrestamo;
      if(y == 1000000)
      {
          resultadoPrestamo = String.valueOf((prestamoTotal/12)+1);
          return resultadoPrestamo;
      }
      else
      {
          resultadoPrestamo = String.valueOf((prestamoTotal/8)+1);
          return resultadoPrestamo;
      }
    }

}
