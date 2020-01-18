
package internetpaketi.model;

import java.util.ArrayList;
import javafx.beans.property.IntegerProperty;
import javafx.beans.property.ObjectProperty;
import javafx.beans.property.SimpleIntegerProperty;
import javafx.beans.property.SimpleObjectProperty;
import javafx.beans.property.SimpleStringProperty;
import javafx.beans.property.StringProperty;

public class Prodaja {
    
    private final ObjectProperty brzina = new SimpleObjectProperty<>(this,"brzina");
    private final StringProperty protok = new SimpleStringProperty(this,"protok");
    private final ObjectProperty <Ugovor> trajanjeUg = new SimpleObjectProperty(this,"trajanjeUg");
    private final StringProperty imePrezime = new SimpleStringProperty(this,"imePrezime");
    private final StringProperty adresa = new SimpleStringProperty(this,"adresa");  
    private final IntegerProperty idProdaje = new SimpleIntegerProperty(this,"idProdaje");
    private static int brojacProdaje=1;
  
    
    public Prodaja(){
   
    }
    
    public Prodaja(int brzina,String protok,Ugovor trajanjeUg,String imePrezime,String adresa){

    this.idProdaje.set(brojacProdaje);
    brojacProdaje++;
    this.brzina.set(brzina);
    this.protok.set(protok);
    this.trajanjeUg.set(trajanjeUg);
    this.imePrezime.set(imePrezime);
    this.adresa.set(adresa);
    }

    
     public Object getBrzina(){
      return brzina.get();
     }    
     
     public void setBrzina(Integer brzina){
      this.brzina.set(brzina);
     }
     
     public ObjectProperty<Integer> brzinaProperty(){
     return brzina;
     }
     
      public String getProtok(){
      return protok.get();
     }    
     
     public void setProtok(String protok){
      this.protok.set(protok);
     }
     
     public StringProperty protokProperty(){
     return protok;
     }
     
      public Ugovor getTrajanjeUg(){
      return trajanjeUg.get();
     }    
     
     public void setTrajanjeUg(Ugovor trajanjeUg){
      this.trajanjeUg.set(trajanjeUg);
     }
     
     public ObjectProperty<Ugovor> trajanjeUgProperty(){
     return trajanjeUg;
     }
     
      public String getImePrezime(){
      return imePrezime.get();
     }    
     
     public void setImePrezime(String imePrezime){
      this.imePrezime.set(imePrezime);
     }
     
     public StringProperty imePrezimeProperty(){
     return imePrezime;
     }
     
      public String getAdresa(){
      return adresa.get();
     }    
     
     public void setAdresa(String adresa){
      this.adresa.set(adresa);
     }
     
     public StringProperty adresaProperty(){
     return adresa;
     }
     
     public int getIdProdaje(){
     return idProdaje.get();}
     
     public IntegerProperty idProdajeProperty(){
     return idProdaje;
     }
    
     
     private final ObjectProperty<ArrayList<String>> errorList = new SimpleObjectProperty<>(this,"errorList",new ArrayList<>());
     
      public ObjectProperty<ArrayList<String>> errorsProperty()
    {
	return errorList;
    }
     
      public boolean isValid(){
     
          boolean isValid = true;
          
      if(brzina.getValue()==null) {
	    errorList.getValue().add("Molimo izaberite brzinu paketa!");
	    isValid = false;
	  }
      if(protok.get()==null){
	    errorList.getValue().add("Molimo izaberite protok paketa!");
	    isValid = false;
	}
    
      if(imePrezime.get().equals("")){
	    errorList.getValue().add("Molimo upišite ime i prezime korisnika!");
	    isValid = false;
	}
      if(adresa.get().equals("")){
	    errorList.getValue().add("Molimo upišite adresu korisnika!");
	    isValid = false;
	}
      return isValid;
     
  }

}
