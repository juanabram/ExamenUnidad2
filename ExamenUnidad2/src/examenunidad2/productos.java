package examenunidad2;

import java.util.ArrayList;
import java.util.Iterator ;

public class productos {
    private ArrayList <producto> liproducto ;
    
    public productos () {
        this.liproducto = new ArrayList<> () ;
    }
    
    public ArrayList <producto> getLiproducto (  ) {
        return this.liproducto ;
    }
    
    public void add ( producto nodo ) {
        this.liproducto.add ( nodo ) ;
    }
    
    public boolean existe ( String codigo ) {
        Iterator lista = this.liproducto.iterator() ;
        while( lista.hasNext() ) {
            if ( ((producto) lista.next()).getID().compareTo(codigo.trim()) == 0 )
                return true ;
        }
        return false ;
    }
    
    public producto encontrar ( String codigo ) {
        Iterator lista = this.liproducto.iterator() ;
        while( lista.hasNext() ) {
            producto nodo_actual = (producto) lista.next();
            if ( nodo_actual.getID().compareTo(codigo.trim()) == 0 )
                return nodo_actual ;
        }
        return null ;
    }
    
    public String MostrarLista (  ) {
        return toString() ;
    }
    
    public void ModificarValores ( String codigo , producto nodo ) {
        Iterator lista = this.liproducto.iterator() ;
        int pos = -1 ;
        while ( lista.hasNext (  ) ) {
            pos ++;
            if ( ((producto) lista.next()).getID().compareTo(codigo.trim()) == 0 )
                this.liproducto.set(pos, nodo) ;
        }

    }
    
    @Override public String toString() {
        String salida = "";
        // Cambiar a Iterator
        Iterator lista = this.liproducto.iterator() ;
        while ( lista.hasNext (  ) ) {
            producto nodo = (producto) lista.next() ;
            salida = salida.concat(nodo.MostrarProducto() + "\n"); 
        }
        return salida ;
    }
    
}
