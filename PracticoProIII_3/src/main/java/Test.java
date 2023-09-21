import java.util.regex.Matcher;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Test {
    private Imagen modelo;
    private final String OPERACION_REGEX =
            "^\\s*([a-zA-Z]+)\\s+([0-9]{1,2}|[a-zA-Z]+)$";
    private String comandoEntrada;

    public Test(Imagen img) {
        modelo = img;
    }

    public void entrada(String linea) {
        comandoEntrada = linea;
    }

    public String procesarSalida() {
        boolean valido = validarEntrada();
        if (!valido) {
            return "ERROR: No entiendo la operacion";
        }

        Pattern patronExpReg = Pattern.compile(OPERACION_REGEX);
        Matcher m = patronExpReg.matcher(comandoEntrada);

        m.find();
        String AvoLap = m.group(1);
        String arg1 = null;
        int arg1int = 0;
        if (AvoLap.equals("Lapiz")) {
            arg1 = m.group(2);
        } else {
             arg1int = Integer.parseInt(m.group(2));
        }

        // int arg1 = Integer.parseInt(m.group(2));
        //int arg2 = Integer.parseInt(m.group(3));

        /*if (AvoLap.equals("Lapiz") && arg1.equals("arriba"))
            modelo.setPintable(true);
        if (AvoLap.equals("Lapiz")&& arg1.equals("abajo"))
            modelo.setPintable(false);
*/
        if (AvoLap.equals("Arriba"))
            modelo.movArriba(arg1int);
       // System.out.println(arg1int+"arriba ");
           // return "Se movio "+arg1int+" arriba ";

        if (AvoLap.equals("Abajo"))
            modelo.movAbajo(arg1int);

           // return "Se movio "+arg1int+" abajo ";
        if (AvoLap.equals("Izquierda"))
            modelo.movIzquierda(arg1int);

            //return "Se movio "+arg1int+" a la izquierda ";
        if (AvoLap.equals("Derecha"))
            modelo.movDerecha(arg1int);

            //return "Se movio "+arg1int+" a la derecha ";
        return null;
    }

    private boolean validarEntrada() {

        if (comandoEntrada.matches(OPERACION_REGEX)) {
            return true;
        }
        return false;
    }
}