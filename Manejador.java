/**
 * @author Pablo Herrera 
 * @since 22/01/2022
 * @version 1.3
 * 
 * Clase que se encarga de manejar las excpeciones del programa. Verifica sobre todo que el usuario este ingresando datos validos y dentro de los requisitos
 */
public class Manejador {
    Manejador(){}
/**
 * Determina con un valor boolean la entrada para el menu principal
 * @param x cadena de texto que ingresa el usuario
 * @return verdadero si cumple con los requisitos
 */
    public boolean val_menu_entry(String x){
        try{
            int i = Integer.parseInt(x);
            if(i <= 0 || i > 6 ){
                System.out.println("Escoja una opcion en el menu");
                return false;
            }else{
                return true;
            }
        }catch(Exception e){
            System.out.println("Ingrese una opcion valida");
            return false;
        }
    }
/**
 * Determina la validez de la entrada del usuario del menu inicial
 * @param x cadena ingresada por el usuario
 * @return verdadero su cumple con los requisitos
 */
    public boolean MenuConfirmacion(String x){
        try{
            if(Integer.parseInt(x)<0 || Integer.parseInt(x) > 2){
                System.out.println("Ingrese una opcion del menu");
                return false;
            }else{
                return true;
            }
        }catch(Exception e){
            System.out.println("Ingrese un dato valido");
            return false;
        }
    }
/**
 * Determina si el usuario esta ingresando una cantidad determinada para representar a los espacios de memoria
 * @param x cadena que ingresa el usuario
 * @return verdadero si cumple con los requisitos
 */
    public boolean MemoryPositions(String x){
        try{
            if(Integer.parseInt(x)<0 || Integer.parseInt(x) > 6){
                System.out.println("Ingrese un numero entre el 1 y 6");
                return false;
            }else{
                return true;
            }
        }catch(Exception e){
            System.out.println("Ingrese un dato valido");
            return false;
        }
    }
/**
 * da un marco de tiempo antes de que el programa se cierre para que no se sienta brusco para el usuario
 */
public void ShutDownWarning(){
    try {
        Thread.sleep(3500);//muestra el mensaje por 5 segundos
    } catch (InterruptedException e) {
        e.printStackTrace();
    }
}
    
}
