package examenunidad2;


import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.text.SimpleDateFormat;
import java.util.Date;

public class ExamenUnidad {
    static productos lista ;
    
    public static String MostrarMenu(String[] opciones) {             
        String cadena = ""; 
        for (String info : opciones) { 
            cadena = cadena + info + "\n"; 
        }
        return cadena; 
    }
    public static boolean EsNumeroEntero(String dato) {
        for (char c : dato.toCharArray()) {
            if (!Character.isDigit(c)) {
                return false;
            }
        }
        return true;
    }
    public static boolean EsNumeroDouble(String dato) {
        boolean valido = false;
            for (char c : dato.toCharArray()) {
		if (!Character.isDigit(c)) {
		    if (c == '.' && !valido)
                        valido = true;
                    else
			return false;
		}
            }
        return valido;
    }
    public static boolean EvaluarNumerico(String dato, int tipo) {
        boolean valido = false;
	switch (tipo) {
            case 1: valido = EsNumeroEntero(dato); break;
            case 2: valido = EsNumeroDouble(dato); break;
        }
        return valido;
    }
    public static String Dialogo(String texto) throws IOException { 
        String cadena; 
        System.out.println(texto + " : "); 
        BufferedReader lectura = new BufferedReader(new InputStreamReader(System.in)); 
        cadena = lectura.readLine(); 
        return cadena; 
    }
    public static String Leer(String texto) throws IOException { 
	String cadena = ""; 
	cadena = Dialogo(texto); 
        if (cadena != null) { 
            cadena = cadena.trim(); 
            if (cadena.isEmpty())
                cadena=null;
	}
	else
            cadena = null; 
	return cadena; 
    }
    public static String DesplegarMenu(String Titulo1, String[] menu) throws IOException { 
	String cadena; 
	cadena=Titulo1 + "\n" + "\n"; 
	cadena=cadena+MostrarMenu(menu);
	cadena = cadena +"\n Que opcion deseas "; 
	return  cadena = Dialogo(cadena);
    }
    public static String RellenarEspacios(String dato, int tamano) { 
	return String.format("%1$-" + tamano + "s", dato); 
    }
    public static String Fecha() {
	Date fecha = new Date();
	SimpleDateFormat formatodia = new SimpleDateFormat("dd-MM-yyyy");
	return formatodia.format(fecha);
    }
    public static String IdTicketSiguiente(String idticket) {
	String idticketnext = "";
	int num = Integer.parseInt(idticket) + 1;
	if (num < 10)
            idticketnext = "00" + String.valueOf(num).trim();	 
	else    if ((num > 9) && (num < 100))  idticketnext = "0" + String.valueOf(num).trim(); 
                else
                    idticketnext = String.valueOf(num).trim(); 
	return idticketnext;
    }
    public static void CargarProductos( productos lista ) {
        lista.add ( new producto ( "001", "Arroz 1kg", "35","10" ) ) ;
        lista.add ( new producto ( "002", "Azúcar 1kg", "25","10" ) ) ;
        lista.add ( new producto ( "003", "Harina 1kg", "28","10" ) ) ;
        lista.add ( new producto ( "004", "Aceite 1L", "50","10" ) ) ;
        lista.add ( new producto ( "005", "Leche 1L", "35","10" ) ) ;
        lista.add ( new producto ( "006", "Huevos 12 unidades", "45","10" ) ) ;
        lista.add ( new producto ( "007", "Fideos 500g", "20" ,"10" ) ) ;
        lista.add ( new producto ( "008", "Sal 1kg", "15","10" ) ) ;
        lista.add ( new producto ( "009", "Pasta de tomate 400g", "25","10" ) ) ;
        lista.add ( new producto ( "010", "Atún lata 170g", "35","10" ) ) ;
    }
    public static void main(String[] args) throws IOException {
        lista = new productos (  ) ;
        CargarProductos( lista ) ;
        MenuPrincipal( lista );
    }
    public  static void MenuPrincipal( productos lista ) throws IOException {  
        String[] datosmenuprincipal = { "1.-Productos ", "2.-Punto de Venta ","3.- Inventario",  "5.-Salida " }; 
	String opcion = "0"; 
	do {
            opcion = DesplegarMenu("Menu de Punto de Tienda de Abarrotes la Pequeña", 
            datosmenuprincipal); 
            if (opcion == null) 
                    System.out.println("opcion incorrecta ");
            else 
                switch (opcion) { 
                    case "1": MenuProductos(lista); break; 
                    case "2": MenuPuntoVenta("000"); break; 
                    case "3": MenuInventario(lista); break;  
                    case "5": System.out.println("Salida del Sistema "); break; 
                    default: System.out.println("No existe esta opcion "); break; 
                } 
	} while (opcion.compareTo("5") != 0); 
    }
    public  static void MenuProductos ( productos lista ) throws IOException {
        String[] datosmenuproductos = { "1.-Modificar ", "2.-Listado ",  "3.-Salida " }; 
        String opcion = "0"; 
        do {
            opcion = DesplegarMenu("Opciones de Productos",
            datosmenuproductos); 
            if (opcion == null) 
                    System.out.println("opcion incorrecta ");
            else 
                switch (opcion) { 
                    case "1": ModificarProducto(lista); break; 
                    case "2": System.out.println(lista.MostrarLista()); break; 
                    case "3": System.out.println("Salida del Sistema "); break; 
                    default: System.out.println("No existe esta opcion "); break; 
                } 
        } while (opcion.compareTo("3") != 0); 
    }
    public static void MenuPuntoVenta(String idticket) throws IOException {
	String opcion, membrete; 
	Boolean pago = false; 
	idticket = IdTicketSiguiente(idticket);
 	String fechadia = Fecha();
	membrete = "Fecha del Dia " + fechadia + " Ticket No " + 	idticket; 
	membrete = membrete + "\n-----------------------------------------------------\n"; 
	String[] datosmenu = { "1.-Agregar  ", "2.-Eliminar ", "3.-Listado ", "4.-Pagar ", "5.-Salida " }; 
 	do { 
            opcion = DesplegarMenu(membrete + "\n Menu de Punto de Venta",datosmenu); 
            if (opcion == null) System.out.println("dato incorrecto introducido"); 
            else 
            switch (opcion) { 
                case "1": System.out.println("Agregar Articulo al Ticket "); break; 
                case "2": System.out.println("Eliminar Articulo del Ticket "); break; 
                case "3": System.out.println("Listado de Articulos del Ticket "); break; 
                case "4": System.out.println("Pagar Ticket y salir"); opcion = "5"; pago = true; break;
                case "5": System.out.println("Salida del Ventas "); 
                    if (!pago) { 
                        System.out.println("No pago el ticket ");
                        System.out.println("eliminando tickte" + idticket); 
                    } break; 
                default: System.out.println("No existe esta opcion"); break;
            } 
	} while (opcion.compareTo("5") != 0); 
    }
    public static void MenuInventario(productos lista) throws IOException {
	String[] datosmenuinventario = { "1.-Listado ", "2.-Agregar ", "3.-Salida " };
        String opcion = "0";
	do {
            opcion = DesplegarMenu("Opciones de Inventarios", datosmenuinventario);
            if (opcion == null)
		System.out.println("opcion incorrecta ");
            else 
		switch (opcion) {
                    case "1": System.out.println(lista.MostrarLista()); break;
                    case "2": AgregarStock(lista); break;
                    case "3": System.out.println("Salida del Sistema "); break;
                    default: System.out.println("No existe esta opcion "); break;
		}		
	} while (opcion.compareTo("3") != 0);
    }
    public static void ModificarProducto(productos lista) throws IOException {
        String codigo, precio;
        String info = lista.MostrarLista();
        codigo = Leer(info + "\nIntroduce el codigo del producto a modificar");
        if (codigo != null) {
            if ( lista.existe( codigo ) ) {
                producto nodo = lista.encontrar(codigo);
                precio = Leer("\nIntroduce el precio de " + nodo.MostrarProducto() ) ;
                if (precio != null) {
                    if (EvaluarNumerico(precio, 2) || EvaluarNumerico(precio, 1)){
                       nodo.setPrecio ( precio ) ;
                       lista.ModificarValores(codigo, nodo);
                    }
                    else
                        System.out.println("no es un valor numerico");  
                } 
                else
                    System.out.println(" dato nulo"); } 
            else
                System.out.println("no existe el codigo") ; } 
        else
            System.out.println(" dato nulo");
    }
    public static void AgregarStock(productos lista) throws IOException {
        String codigo, cantidad;
        int posicion;
	String info = lista.MostrarLista();
        codigo = Leer(info + "\nIntroduce el codigo del producto a modificar");
        if (codigo != null) {
            if (lista.existe( codigo )) {
                producto nodo = lista.encontrar(codigo);
                cantidad = Leer("\nIntroduce la Cantidad de Stock a Agregar" + nodo.MostrarProducto() + " ");
                if (cantidad != null) {
                    if (EvaluarNumerico(cantidad, 2) || EvaluarNumerico(cantidad, 1)) {
                        String nuevacantidad = String.valueOf((Integer.valueOf(cantidad) + Integer.valueOf(nodo.getCantidad())));
                        nodo.setCantidad ( nuevacantidad ) ;
                        lista.ModificarValores(codigo, nodo);
                    }
                    else {
                        System.out.println("no es un valor numerico");
                    }
                } 
                else System.out.println(" dato nulo");
            } 
            else System.out.println("no existe el codigo");
        }
        else System.out.println(" dato nulo");
    }
    
}
