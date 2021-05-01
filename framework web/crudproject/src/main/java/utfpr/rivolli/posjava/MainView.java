package utfpr.rivolli.posjava;

import com.vaadin.flow.component.Key;
import com.vaadin.flow.component.button.Button;
import com.vaadin.flow.component.button.ButtonVariant;
import com.vaadin.flow.component.dependency.CssImport;
import com.vaadin.flow.component.grid.Grid;
import com.vaadin.flow.component.notification.Notification;
import com.vaadin.flow.component.orderedlayout.HorizontalLayout;
import com.vaadin.flow.component.orderedlayout.VerticalLayout;
import com.vaadin.flow.component.textfield.TextField;
import com.vaadin.flow.data.value.ValueChangeMode;
import com.vaadin.flow.router.Route;
import com.vaadin.flow.server.PWA;
import com.vaadin.flow.shared.Registration;
import org.springframework.beans.factory.annotation.Autowired;
import utfpr.rivolli.posjava.forms.ClienteForm;
import utfpr.rivolli.posjava.model.Cliente;
import utfpr.rivolli.posjava.model.ClienteRepository;

/**
 * A sample Vaadin view class.
 * <p>
 * To implement a Vaadin view just extend any Vaadin component and
 * use @Route annotation to announce it in a URL as a Spring managed
 * bean.
 * Use the @PWA annotation make the application installable on phones,
 * tablets and some desktop browsers.
 * <p>
 * A new instance of this class is created for every new user and every
 * browser tab/window.
 */
@Route
@PWA(name = "Exemplo de CRUD",
     shortName = "CRUD App",
     description = "Este é um exemplo de CRUD completo.",
     enableInstallPrompt = false)
public class MainView extends VerticalLayout {

    private final ClienteRepository repository;
    private Grid<Cliente> grid = new Grid<>(Cliente.class);
    private TextField filterText = new TextField();
    Button novoBtn = new Button("Novo cliente");
    
    private ClienteForm form;
    
    public MainView(@Autowired ClienteRepository repository) {
        this.repository = repository;
        
        // 1
        form = new ClienteForm(this, repository);
        form.setCliente(null);
        
        // 2
        grid.setColumns("primeiroNome", "sobrenome", "status");
        grid.setSizeFull();
        grid.asSingleSelect().addValueChangeListener(e -> selecionar());
        atualizarLista();
        
        // 3
        filterText.setPlaceholder("Filtrar por nome...");
        filterText.setClearButtonVisible(true);
        filterText.setValueChangeMode(ValueChangeMode.EAGER);
        filterText.addValueChangeListener(e -> atualizarLista());
        
        // 4
        novoBtn.addClickListener(e -> adicionarNovo());
        
        // 5
        HorizontalLayout mainContent = new HorizontalLayout(grid, form);
        mainContent.setSizeFull();
        add(new HorizontalLayout(filterText, novoBtn), mainContent);
        setSizeFull();
    }
    
    public void atualizarLista() {
        if (filterText.getValue().isEmpty()) {
            grid.setItems(repository.findAll());
        } else {
            grid.setItems(repository.findByNome(filterText.getValue()));
        }
    }
    
    public void selecionar() {
        form.setCliente(grid.asSingleSelect().getValue());
    }

    private void adicionarNovo() {
        grid.asSingleSelect().clear();
        form.setCliente(new Cliente());
    }

}
