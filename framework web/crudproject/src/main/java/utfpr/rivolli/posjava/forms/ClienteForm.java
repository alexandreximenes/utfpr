/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package utfpr.rivolli.posjava.forms;

import com.vaadin.flow.component.button.Button;
import com.vaadin.flow.component.button.ButtonVariant;
import com.vaadin.flow.component.combobox.ComboBox;
import com.vaadin.flow.component.datepicker.DatePicker;
import com.vaadin.flow.component.formlayout.FormLayout;
import com.vaadin.flow.component.orderedlayout.HorizontalLayout;
import com.vaadin.flow.component.textfield.EmailField;
import com.vaadin.flow.component.textfield.TextField;
import com.vaadin.flow.data.binder.Binder;
import java.util.Locale;
import utfpr.rivolli.posjava.ConfirmationDialog;
import utfpr.rivolli.posjava.MainView;
import utfpr.rivolli.posjava.model.Cliente;
import utfpr.rivolli.posjava.model.ClienteRepository;
import utfpr.rivolli.posjava.model.ClienteStatus;

/**
 *
 * @author rivolli
 */
public class ClienteForm extends FormLayout {
    private TextField primeiroNome = new TextField("Primeiro nome");
    private TextField sobrenome = new TextField("Sobrenome");
    private ComboBox<ClienteStatus> status = new ComboBox<>("Status");
    private DatePicker dataNascimento = new DatePicker("Data de nascimento");
    private EmailField email = new EmailField("E-mail");
    
    private Button salvarButton = new Button("Salvar");
    private Button excluirButton = new Button("Excluir");
    
    private MainView mainView;
    private ConfirmationDialog confirmationDialog = new ConfirmationDialog();
    
    private Binder<Cliente> binder = new Binder<>(Cliente.class);
    private ClienteRepository repository;
        
    public ClienteForm(MainView mainView, ClienteRepository repository) {
        this.mainView = mainView;
        this.repository = repository;
        binder.bindInstanceFields(this);
        status.setItems(ClienteStatus.values());
        
        dataNascimento.setLocale(new Locale("pt", "BR"));

        HorizontalLayout btns = new HorizontalLayout(salvarButton, excluirButton);
        salvarButton.addThemeVariants(ButtonVariant.LUMO_PRIMARY);
        salvarButton.addClickListener(event -> salvar());
        excluirButton.addClickListener(event -> excluir());
        
        add(primeiroNome, sobrenome, email, status, dataNascimento, btns);
    }
    
    public void setCliente(Cliente cliente) {
        binder.setBean(cliente);

        if (cliente == null) {
            setVisible(false);
        } else {
            setVisible(true);
            if (binder.getBean().isPersisted()) {
                excluirButton.setVisible(true);
            } else {
                excluirButton.setVisible(false);
            }
            primeiroNome.focus();
        }
    }

    private void salvar() {
        Cliente cliente = binder.getBean();
        repository.save(cliente);
        mainView.atualizarLista();
        setCliente(null);
    }
    
    private void excluir() {
        Cliente cliente = binder.getBean();
        confirmationDialog.setQuestion("Deseja realmente excluir a/o cliente '"+ cliente.toString() + "'?");
        confirmationDialog.open();
        confirmationDialog.addConfirmationListener(evt -> {
            repository.delete(cliente);
            mainView.atualizarLista();
            setCliente(null);
        });
    }
    
}
