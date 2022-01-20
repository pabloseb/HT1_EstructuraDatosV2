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
        
        double[] FmStations =  new double[6];
        FmStations[0] = 87.9;
        FmStations[1] = 87.9;
        FmStations[2] = 87.9;
        FmStations[3] = 87.9;
        FmStations[4] = 87.9;
        FmStations[5] = 87.9;

        double[] AmStations = new double[6];
        AmStations[0] = 530;
        AmStations[1] = 540;
        AmStations[2] = 550;
        AmStations[3] = 560;
        AmStations[4] = 570;
        AmStations[5] = 580;

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
                    if(RadioUsuario.getFrequency() == false){
                        System.out.println("Actualmente se encuentra en "+RadioUsuario.getAmStation()+" AM");
                    }else{
                        System.out.println("Actualmente se encuentra en "+RadioUsuario.getFmStation()+" FM");
                    }
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
                    //si se encuentra en AM
                    if(RadioUsuario.getFrequency() == false){
                        System.out.println("Mis Emisoras Favoritas");
                        int opcion = 1;
                        for(int i=0;i<AmStations.length;i++){
                            System.out.println(opcion+". "+AmStations[i]+" AM");
                            opcion++;
                        }
                        System.out.println("Escoja una Emisora para que suene");
                        do{
                            user_entry = scanner.nextLine();
                            val_entry = manejador.MemoryPositions(user_entry);
                        }while(val_entry == false);
                        option_chosen = Integer.parseInt(user_entry);
                        if(option_chosen == 1){
                            RadioUsuario.setAmStation(AmStations[0]);
                        }
                        if(option_chosen == 2){
                            RadioUsuario.setAmStation(AmStations[1]);
                        }
                        if(option_chosen == 3){
                            RadioUsuario.setAmStation(AmStations[2]);
                        }
                        if(option_chosen == 4){
                            RadioUsuario.setAmStation(AmStations[3]);
                        }
                        if(option_chosen == 5){
                            RadioUsuario.setAmStation(AmStations[4]);
                        }
                        if(option_chosen == 6){
                            RadioUsuario.setAmStation(AmStations[5]);
                        }
                    }//finalizacion AM
                    else{
                        System.out.println("Mis Emisoras Favoritas");
                        int opcion = 1;
                        for(int i=0;i<AmStations.length;i++){
                            System.out.println(opcion+". "+FmStations[i]+" FM");
                            opcion++;
                        }
                        System.out.println("Escoja una Emisora para que suene");
                        do{
                            user_entry = scanner.nextLine();
                            val_entry = manejador.MemoryPositions(user_entry);
                        }while(val_entry == false);
                        option_chosen = Integer.parseInt(user_entry);
                        if(option_chosen == 1){
                            RadioUsuario.setFmStation(FmStations[0]);
                        }
                        if(option_chosen == 2){
                            RadioUsuario.setFmStation(FmStations[1]);
                        }
                        if(option_chosen == 3){
                            RadioUsuario.setFmStation(FmStations[2]);
                        }
                        if(option_chosen == 4){
                            RadioUsuario.setFmStation(FmStations[3]);
                        }
                        if(option_chosen == 5){
                            RadioUsuario.setFmStation(FmStations[4]);
                        }
                        if(option_chosen == 6){
                            RadioUsuario.setFmStation(FmStations[5]);
                        }
                    }//finaliza FM
                    break;

                    case 4:
                    System.out.println("Ingrese un espacio de memoria para agregar la Emisora Actual a Sus Favoritas");
                    if(RadioUsuario.getFrequency() == false){
                        int n = 1;
                        for(int i=0;i<AmStations.length;i++){
                            System.out.println(n+". "+AmStations[i]);
                            n++;
                        }
                        do{
                            user_entry = scanner.nextLine();
                            val_entry = manejador.MemoryPositions(user_entry);
                        }while(val_entry == false);
                        option_chosen = Integer.parseInt(user_entry);

                        if(option_chosen == 1){
                            AmStations[0] = RadioUsuario.getAmStation();
                        }
                        if(option_chosen == 2){
                            AmStations[1] = RadioUsuario.getAmStation();
                        }
                        if(option_chosen == 3){
                            AmStations[2] = RadioUsuario.getAmStation();
                        }
                        if(option_chosen == 4){
                            AmStations[3] = RadioUsuario.getAmStation();
                        }
                        if(option_chosen == 5){
                            AmStations[4] = RadioUsuario.getAmStation();
                        }
                        if(option_chosen == 6){
                            AmStations[5] = RadioUsuario.getAmStation();
                        }
                    }//finaliza AM
                    else{
                        int m = 1;
                        for(int i = 0;i<FmStations.length;i++){
                            System.out.println(m+". "+FmStations[i]);
                            m++;
                        }
                        do{
                            user_entry = scanner.nextLine();
                            val_entry = manejador.MemoryPositions(user_entry);
                        }while(val_entry == false);
                        option_chosen = Integer.parseInt(user_entry);

                        if(option_chosen == 1){
                            FmStations[0] = RadioUsuario.getFmStation();
                        }
                        if(option_chosen == 2){
                            FmStations[1] = RadioUsuario.getFmStation();
                        }
                        if(option_chosen == 3){
                            FmStations[2] = RadioUsuario.getFmStation();
                        }
                        if(option_chosen == 4){
                            FmStations[3] = RadioUsuario.getFmStation();
                        }
                        if(option_chosen == 5){
                            FmStations[4] = RadioUsuario.getFmStation();
                        }
                        if(option_chosen == 6){
                            FmStations[5] = RadioUsuario.getFmStation();
                        }
                    }//finaliza FM
                    System.out.println("Se han Actualizado sus Emisoras Favoritas");
                    break;

                    case 5:
                    RadioUsuario.switchAMFM();
                    break;

                    case 6:
                    System.out.println("Ud Apago la radio y actualmente esta saliendo de la simulacion...");
                    System.exit(0);
                    break;


                }
            }//finaliza loop
                break;

                case 2:
                System.out.println("Ud esta saliendo de la simulacion...");
                System.exit(0);
                break;
            }
        }

    }//method finish
}//class finish
