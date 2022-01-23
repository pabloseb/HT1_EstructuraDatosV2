/**
 * @author Pablo Herrera, Pedro Marroquin & Jose Auyon
 * @since 22/01/2022
 * @version 2.0
 * 
 * Esta es la clase que lleva la logica del programa.
 */
import java.math.BigDecimal;
import java.math.RoundingMode;

public class Radio_Object implements Radio{

    Radio_Object(){}
    private boolean RadioOn = false; //inicialmente la radio se encuentra apagada
    private boolean Frequency = false;//falso para modulacion AM, Verdadero para Modulacion FM
    private double AmStation = 530;
    private double FmStation = 87.9;
    private double CurrentStation;
    private double[] FavoriteStations = {530,530,530,530,530,530,87.9,87.9,87.9,87.9,87.9,87.9};

/**
 * Regresa estado Actual de la Radio
 */
    @Override
    public boolean isOn() {
        return RadioOn;
    }
/**
 * Cambia el estado Actual de La radio
 */
    @Override
    public void turnOnOff() {
        if(RadioOn == false){
            RadioOn = true;
        }else{
            RadioOn = false;
        }
    }
/**
 * Avanza a la siguiene emisora dependiendo de la modulacion Am/Fm
 */
    @Override
    public void nextStation(boolean frequency) {
        if(frequency == false){
            AmStation = AmStation+10;
            if(AmStation > 1610){
                AmStation = 530;
            }
        }else{
            double emisora_siguiente = FmStation;
            emisora_siguiente = emisora_siguiente + 0.2;
            double Emisora = new BigDecimal(emisora_siguiente).setScale(1,RoundingMode.HALF_EVEN).doubleValue();
            FmStation = Emisora;
            if(FmStation > 107.9){
                FmStation = 87.9;
            }
        }
    }
/**
 * Regresa a la Estacion Anterior
 */
    @Override
    public void prevStation(boolean frequency) {
        if(frequency == false){
            AmStation = AmStation-10;
            if(AmStation < 530){
            }
        }else{
            double emisora_siguiente = FmStation;
            emisora_siguiente = emisora_siguiente - 0.2;
            double Emisora = new BigDecimal(emisora_siguiente).setScale(1,RoundingMode.HALF_EVEN).doubleValue();
            FmStation = Emisora;
            if(FmStation < 87.9){
                FmStation = 107.9;
            }
        }
    }

/**
 * Se obtiene la emisora dependiendo de la Modulacion en la que se encuentra AM/FM
 */
    @Override
    public double getStation() {
        if(Frequency == false){
            CurrentStation = AmStation;
        }else{
            CurrentStation = FmStation;
        }
        return CurrentStation;
    }
/**
 * Guarda una estacion dependiendo de la modulacion y la emisora que suena
 */
    @Override
    public void saveStation(int position, double station) {
        if(Frequency == false){
            switch(position){
                case 1:
                FavoriteStations[0] = station;
                break;
                case 2:
                FavoriteStations[1] = station;
                break;
                case 3:
                FavoriteStations[2] = station;
                break;
                case 4:
                FavoriteStations[3] = station;
                break;
                case 5:
                FavoriteStations[4] = station;
                break;
                case 6:
                FavoriteStations[5] = station;
                break;
            }//escoge una posicion
        }//se encuentra en AM
        else{
            switch(position){
                case 1:
                FavoriteStations[6] = station;
                break;
                case 2:
                FavoriteStations[7] = station;
                break;
                case 3:
                FavoriteStations[8] = station;
                break;
                case 4:
                FavoriteStations[9] = station;
                break;
                case 5:
                FavoriteStations[10] = station;
                break;
                case 6:
                FavoriteStations[11] = station;
                break;
            }
        }//usuario se encuentra en FM
    }
/**
 * Obtiene las emisoras Favoritas guardads
 */
    @Override
    public double getSavedStation(int position) {
        if(Frequency == false){
            switch(position){
                case 1:
                AmStation = FavoriteStations[0];
                break;
                case 2:
                AmStation = FavoriteStations[1];
                break;
                case 3:
                AmStation = FavoriteStations[2];
                break;
                case 4:
                AmStation = FavoriteStations[3];
                break;
                case 5:
                AmStation = FavoriteStations[4];
                break;
                case 6:
                AmStation = FavoriteStations[5];
                break;
            }
            CurrentStation = AmStation;
        }//se encuentra en AM
        if(Frequency == true){
            if(position==1){
                FmStation = FavoriteStations[6];
            }
            if(position==2){
                FmStation = FavoriteStations[7];
            }
            if(position==3){
                FmStation = FavoriteStations[8];
            }
            if(position==4){
                FmStation = FavoriteStations[9];
            }
            if(position==5){
                FmStation = FavoriteStations[10];
            }
            if(position==6){
                FmStation = FavoriteStations[11];
            }
            CurrentStation = FmStation;
        }//se encuentra en FM
        return CurrentStation;
    }
/**
 * Obtiene la modulacion en la que se encuentra la radio
 */
    @Override
    public boolean getFrequency() {
        return Frequency;
    }
/**
 * Cambia de modulacion dependiendo de la modulacion actual
 */
    @Override
    public void switchAMFM() {
        if(Frequency == false){
            Frequency = true;
        }else{
            Frequency = false;
        }
        
    }

}