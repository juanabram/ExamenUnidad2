package examenunidad2;
public class producto {
    private String id ;
    private String descripcion ;
    private String precio ;
    private String cantidad ;

    public String RellenarEspacios(String dato, int tamano) { 
	return String.format("%1$-" + tamano + "s", dato); 
    }
    
    public producto ( String id , String descripcion , String precio , String cantidad ) {
        this.id = id ;
        this.descripcion = descripcion ;
        this.precio = precio ;
        this.cantidad = cantidad ;
    }
    
    public producto (  ) {
        this.id = "" ;
        this.descripcion = "" ;
        this.precio = "" ;
        this.cantidad = "" ;
    }
    
    public String getID (  ) {
        return this.id ;
    }
    
    public String getDescripcion (  ) {
        return this.descripcion ;
    }
    
    public String getPrecio (  ) {
        return this.precio ;
    }
    
    public String getCantidad (  ) {
        return this.cantidad ;
    }
    
    public void setID ( String id ) {
        this.id = id ;
    }
    
    public void setDescripcion ( String descripcion ) {
        this.descripcion = descripcion ;
    }
    
    public void setPrecio ( String precio ) {
        this.precio = precio ;
    }
    
    public void setCantidad ( String cantidad ) {
        this.cantidad = cantidad ;
    }
    
    public String MostrarProducto(  ) { 
        return toString() ;
    }
    
    @Override public String toString() {
        String codigo = RellenarEspacios( this.id , 5); 
        String producto = RellenarEspacios( this.descripcion , 30); 
        String precio = RellenarEspacios( this.precio , 10); 
        String cantidad =RellenarEspacios( this.cantidad , 10);
        String cadena = codigo.concat(producto+precio+cantidad); 
        return cadena; 
    }
}
