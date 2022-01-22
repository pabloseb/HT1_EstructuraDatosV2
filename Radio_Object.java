import java.math.BigDecimal;
import java.math.RoundingMode;

public class Radio_Object implements Radio{

    Radio_Object(){}
    boolean RadioOn = false; //inicialmente la radio se encuentra apagada
    boolean Frequency = false;//falso para modulacion AM, Verdadero para Modulacion FM
    double AmStation = 530;
    double FmStation = 87.9;
    double[] FmStations = {87.9,87.9,87.9,87.9,87.9,87.9};
    double[] AmStations = {530,530,530,530,530,530};
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
                System.out.println("No hay mas emisoras, regresando a la emisora inicial");
                AmStation = 530;
            }
        }else{
            double emisora_siguiente = FmStation;
            emisora_siguiente = emisora_siguiente + 0.2;
            double Emisora = new BigDecimal(emisora_siguiente).setScale(1,RoundingMode.HALF_EVEN).doubleValue();
            FmStation = Emisora;
            if(FmStation > 107.9){
                System.out.println("No hay mas emisoras, regresando a la emisora Inicial");
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
                System.out.println("No hay mas emisoras, regresando a la emisora inicial");
                AmStation = 1610;
            }
        }else{
            double emisora_siguiente = FmStation;
            emisora_siguiente = emisora_siguiente - 0.2;
            double Emisora = new BigDecimal(emisora_siguiente).setScale(1,RoundingMode.HALF_EVEN).doubleValue();
            FmStation = Emisora;
            if(FmStation < 87.9){
                System.out.println("No hay mas emisoras, regresando a la emisora Inicial");
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
            return AmStation;
        }else{
            return FmStation;
        }
    }
/**
 * Guarda una estacion dependiendo de la modulacion y la emisora que suena
 */
    @Override
    public void saveStation(int position, double station) {
        if(87.9<=station && station<=107.9){
            FmStations[position] = station;
        }
        if(530<=station && station <=1610){
            AmStations[position] = station;
        }
        else{
            System.out.println("No se pudo agregar su emisora a alguna lista");
        }
    }
/**
 * Obtiene las emisoras Favoritas guardads
 */
    @Override
    public double getSavedStation(int position) {
        double SavedStation;
        if(Frequency == false){
            SavedStation = AmStations[position];
        }else{
            SavedStation = FmStations[position];
        }
        return SavedStation;
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
//-----------Getters---------------/
public double getAmStation() {
    return AmStation;
}
public double[] getAmStations() {
    return AmStations;
}
public double getFmStation() {
    return FmStation;
}
public double[] getFmStations() {
    return FmStations;
}
//setters
public void setAmStation(double amStation) {
    AmStation = amStation;
}
public void setFmStation(double fmStation) {
    FmStation = fmStation;
}

}