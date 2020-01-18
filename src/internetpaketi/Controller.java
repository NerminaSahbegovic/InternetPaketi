
package internetpaketi;


import internetpaketi.model.Prodaja;
import internetpaketi.model.Ugovor;
import java.net.URL;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.ResourceBundle;
import javafx.application.Platform;
import javafx.beans.value.ChangeListener;
import javafx.beans.value.ObservableValue;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.ChoiceBox;
import javafx.scene.control.Label;
import javafx.scene.control.RadioButton;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.control.Toggle;
import javafx.scene.control.ToggleGroup;
import javafx.scene.control.cell.PropertyValueFactory;

public class Controller implements Initializable{

   
    @FXML private ChoiceBox brzina;
    @FXML private ChoiceBox protok;
    
    ObservableList<Integer> brzine = FXCollections.observableArrayList(2,5,10,20,50,100);
    ObservableList<String> protoci = FXCollections.observableArrayList("Flat","1GB","5GB","10GB","100GB");
   
   
    @FXML private ToggleGroup trajanjeUg;
    @FXML private RadioButton godinaBtn;
    @FXML private RadioButton dvijeBtn;
   
    
    @FXML private Label idProdajeLbl;
   
    @FXML private TextField imePrezime;
    
    @FXML private TextField adresa;
    
    @FXML private Button dodaj;
    
    @FXML private Button obrisi;
    
    @FXML private Button pregled; 
   
    @FXML private Button zatvoriFormu;
    
    @FXML private Button ocisti;
    
  
     @FXML TableView<Prodaja> tabela = new TableView<>();
     @FXML private TableColumn<Prodaja,Integer> idColumn;
     @FXML private TableColumn<Prodaja,String> imePrezimeColumn;
     @FXML private TableColumn<Prodaja,String> adresaColumn;
     @FXML private TableColumn <Prodaja,Integer>brzinaColumn;
     @FXML private TableColumn <Prodaja,String>protokColumn;
     @FXML private TableColumn <Prodaja,Ugovor>trajanjeColumn;
     
     ObservableList<Prodaja> prodaje = FXCollections.observableArrayList();
     Prodaja prodaja;

     
    public Controller()
    {
    }  
    

    @Override
    public void initialize(URL location, ResourceBundle resources) {
        
        brzina.setItems(brzine);
        protok.setItems(protoci); 
    
    
        idColumn.setCellValueFactory(new PropertyValueFactory<>("idProdaje"));
        imePrezimeColumn.setCellValueFactory(new PropertyValueFactory<>("imePrezime"));
        adresaColumn.setCellValueFactory(new PropertyValueFactory<>("adresa"));
        brzinaColumn.setCellValueFactory(new PropertyValueFactory<>("brzina"));
        protokColumn.setCellValueFactory(new PropertyValueFactory<>("protok"));
        trajanjeColumn.setCellValueFactory(new PropertyValueFactory<>("trajanjeUg"));
     
   
    prodaja = new Prodaja();
  
        brzina.valueProperty().bindBidirectional(prodaja.brzinaProperty());
        protok.valueProperty().bindBidirectional(prodaja.protokProperty());
        imePrezime.textProperty().bindBidirectional(prodaja.imePrezimeProperty());
        adresa.textProperty().bindBidirectional(prodaja.adresaProperty());

  
    trajanjeUg.selectedToggleProperty().addListener(new ChangeListener<Toggle>(){
    
     @Override
     public void changed(ObservableValue<? extends Toggle> observable, Toggle oldValue, Toggle newValue)
	    {
		if(newValue != null)
		{
		    RadioButton selected = (RadioButton) newValue;
                    switch(selected.getId())
		    {
			case "godina":
			    prodaja.trajanjeUgProperty().set(Ugovor.GODINA);
			    break;
			case "dvije":
			    prodaja.trajanjeUgProperty().set(Ugovor.DVIJE);
			    break;
		    }
		}
	    }
    });
    }
    
    @FXML
    protected void dodajProdaju(ActionEvent event)throws SQLException {
        
     
        if(prodaja.isValid()){
            
        prodaje = tabela.getItems();
        RadioButton selected = (RadioButton) trajanjeUg.getSelectedToggle();
	  
        switch(selected.getId())
	    {
		case "godinaBtn":
                   prodaje.add(new Prodaja((int) brzina.getValue(), protok.getValue().toString(), Ugovor.GODINA ,imePrezime.getText(),adresa.getText()));
		
		    break;
		case "dvijeBtn":
		   prodaje.add(new Prodaja((int) brzina.getValue(), protok.getValue().toString(), Ugovor.DVIJE ,imePrezime.getText(),adresa.getText()));
		    break;
	    }
	    tabela.setItems(prodaje);
         
        }else{
        
        StringBuilder errMsg = new StringBuilder();

	    ArrayList<String> errList = prodaja.errorsProperty().get();
	    for(String errList1 : errList)
		errMsg.append(errList1);

	    Alert alert = new Alert(Alert.AlertType.ERROR);
	    alert.setTitle("Prodaja ne može biti spašena!");
	    alert.setHeaderText(null);
	    alert.setContentText(errMsg.toString());
	    alert.showAndWait();
	    errList.clear();
        }
   
    }
    
    @FXML
    private void clear()
    {
	prodaja.brzinaProperty().set(null);
	prodaja.protokProperty().set(null);
	prodaja.imePrezimeProperty().set("");
        prodaja.adresaProperty().set("");
	
	if(trajanjeUg.getSelectedToggle() != null)
	    trajanjeUg.getSelectedToggle().setSelected(false);
    }

 
    @FXML
    private void obrisiProdaju()
    {
	prodaje = tabela.getItems();
	int index = tabela.selectionModelProperty().getValue().getSelectedIndex();
	prodaje.remove(index);
	tabela.setItems(prodaje);
    }
    
    @FXML
    private void zatvoriFormu()
    {
	Platform.exit();
    }
       
    }





      
    
    
    
    
    
    
    /*



}


    
    
   
    ObservableList<Prodaja> prodaje = FXCollections.<Prodaja>observableArrayList();
    Prodaja prodaja;

    
   @FXML
   private TableView<Prodaja> tabela ;
   @FXML private TableColumn<Prodaja, Long> idColumn ;
   @FXML private TableColumn<Prodaja, String> imePrezimeCol ;
   @FXML private TableColumn<Prodaja, String> adresaCol ;
   @FXML private TableColumn<Prodaja, Integer> brzinaCol ;
   @FXML private TableColumn<Prodaja, Object> protokCol ;
    
    
   
    
    public Controller()
    {
    }
    
    
     */
    
   
      
    

