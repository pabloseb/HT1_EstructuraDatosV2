import java.util.Scanner;
public class Controlador {
    Controlador(){}
    Scanner scanner = new Scanner(System.in);
    Manejador manejador = new Manejador();
    Radio_Object RadioUsuario = new Radio_Object();

    public void ProgramLogic(){
        String user_entry;//para que el usuario ingrese informacion
        int option_chosen;//castear los datos string a int para los menus
        boolean val_entry;//valida la entrada del usuario
        boolean RunRadio = true;//mantiene vivo el loop

        if(RadioUsuario.isOn() == false){
            System.out.println("La radio actualmente se encuentra apagada, desea encenderla para iniciar con la simulacion?");
            System.out.println("1.Si, deseo encenderla");
            System.out.println("2.No, deseo salir de la simulacion");
//verifica la entrada del usuario de acuerdo a las opciones anteriores
            do{
                user_entry = scanner.nextLine();
                val_entry = manejador.MenuConfirmacion(user_entry);
            }while(val_entry == false);
            option_chosen = Integer.parseInt(user_entry);
//enciende la radio y permite navegar por el menu dependiendo de la modulacion
            switch(option_chosen){
                case 1:
                System.out.println("Bienvenido a La Radio");
                while(RunRadio == true){
                //si el usuario se encuentra en modulacion AM puede hacer las siguientes opciones

                    System.out.println("-------------------------Informacion Actual------------------------");
                    System.out.println("Actualmente usted se encuentra en "+RadioUsuario.getStation());
                    System.out.println("-------------------------Menu de Opciones--------------------------");
                    System.out.println("Escoja una opcion del menu si lo desea\n");
                    System.out.println("1.Siguiente Emisora");
                    System.out.println("2.Emisora Anterior");
                    System.out.println("3.Acceder a Mis Emisoras Favoritas para esta modulacion");
                    System.out.println("4.Agregar Emisora Actual a Favoritas");
                    if(RadioUsuario.getFrequency() == false){
                        System.out.println("5.Cambiarme a FM");
                    }
                    else{
                        System.out.println("5.Cambiarme a AM");
                    }
                    System.out.println("6.Apagar Radio y Finalizar Simulacion");

                //se valida la entrada del usuario para el menu anterior
                do{
                    user_entry = scanner.nextLine();
                    val_entry = manejador.val_menu_entry(user_entry);
                }while(val_entry == false);
                option_chosen = Integer.parseInt(user_entry);
                //Inician Casos del Menu de Opciones
                switch(option_chosen){
                    //siguiene emisora
                    case 1:
                    RadioUsuario.nextStation(RadioUsuario.getFrequency());
                    break;

                    case 2:
                    RadioUsuario.prevStation(RadioUsuario.getFrequency());
                    break;

                    case 3:
                    System.out.println("Por favor, ingrese el espacio de memoria que ocupa su Emisora Favorita que desea escuchar");
                    do{
                        user_entry = scanner.nextLine();
                        val_entry = manejador.MemoryPositions(user_entry);
                    }while(val_entry == false);
                    option_chosen = Integer.parseInt(user_entry);
                    RadioUsuario.getSavedStation(option_chosen);
                    break;

                    case 4:
                    System.out.println("Se agregara la emisora actual a tus favoritas\nPor favor en que espacio de memoria lo deseas guardar");
                    do{
                        user_entry = scanner.nextLine();
                        val_entry = manejador.MemoryPositions(user_entry);
                    }while(val_entry == false);
                    option_chosen = Integer.parseInt(user_entry);
                    RadioUsuario.saveStation(option_chosen, RadioUsuario.getStation());
                    System.out.println("Se ha agregado la emisora a sus favoritas");
                    break;

                    case 5:
                    RadioUsuario.switchAMFM();
                    break;

                    case 6:
                    System.out.println("Ud Apago la radio y actualmente esta saliendo de la simulacion...");
                    manejador.ShutDownWarning();
                    System.exit(0);
                    break;


                }
            }//finaliza loop
                break;

                case 2:
                System.out.println("Ud esta saliendo de la simulacion...");
                try {
                    Thread.sleep(3500);//muestra el mensaje por 5 segundos
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                System.exit(0);
                break;
            }
        }

    }//method finish
}//class finish
