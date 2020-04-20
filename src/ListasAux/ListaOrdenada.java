package ListasAux;


public class ListaOrdenada extends ListaEnlazada{
    

    public ListaOrdenada() {
        super();
    }
   
    public void insertar(int dato){
        Nodo nuevo = new Nodo(dato);
        if(nuevo == null){
            nuevo = primero;
        }else if(dato < (int)primero.getDato()){
          nuevo.setReferencia(primero);
          primero = nuevo;
        }else{
           Nodo anterior , actual;
           anterior = actual = primero;
          while((actual.getReferencia() != null)  && (dato > (int)actual.getDato())){
            anterior = actual;
              actual =actual.getReferencia();        
          }
          if(dato > (int)actual.getDato()){
              anterior = actual;   
            }
           nuevo.setReferencia(anterior.getReferencia());
           anterior.setReferencia(nuevo);
   
        }      
    }
    
}
