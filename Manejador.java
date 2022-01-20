public class Manejador {
    Manejador(){}

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

    
}
