package com.example.application.views.main;

import com.example.application.model.Usuario;
import com.example.application.repository.UsuarioRepository;
import com.example.application.views.cadastro.UsuarioForm;
import com.vaadin.flow.component.button.Button;
import com.vaadin.flow.component.dependency.CssImport;
import com.vaadin.flow.component.dependency.JsModule;
import com.vaadin.flow.component.grid.Grid;
import com.vaadin.flow.component.orderedlayout.HorizontalLayout;
import com.vaadin.flow.component.orderedlayout.VerticalLayout;
import com.vaadin.flow.component.textfield.TextField;
import com.vaadin.flow.data.value.ValueChangeMode;
import com.vaadin.flow.router.Route;
import com.vaadin.flow.server.PWA;
import org.springframework.beans.factory.annotation.Autowired;

@Route
@PWA(name = "My App", shortName = "My App", enableInstallPrompt = false)
@JsModule("./styles/shared-styles.js")
@CssImport("./views/main/main-view.css")
public class MainView extends VerticalLayout {

    private final UsuarioRepository repository;
    private Grid<Usuario> grid = new Grid<>(Usuario.class);
    private TextField filterText = new TextField();
    Button novoBtn = new Button("Novo cliente");

    private UsuarioForm form;

    public MainView(@Autowired UsuarioRepository repository) {
        this.repository = repository;

        form = new UsuarioForm(repository, this);
        form.setUsuario(null);

        grid.setColumns("primeiroNome", "sobrenome", "status");
        grid.setSizeFull();
        grid.asSingleSelect().addValueChangeListener(e -> selecionar());
        atualizar();

        filterText.setPlaceholder("Filtrar por nome...");
        filterText.setClearButtonVisible(true);
        filterText.setValueChangeMode(ValueChangeMode.EAGER);
        filterText.addValueChangeListener(e -> atualizar());

        novoBtn.addClickListener(e -> adicionarNovo());

        // 5
        HorizontalLayout mainContent = new HorizontalLayout(grid, form);
        mainContent.setSizeFull();
        add(new HorizontalLayout(filterText, novoBtn), mainContent);
        setSizeFull();
    }

    public void atualizar() {
        if (filterText.getValue().isEmpty()) {
            grid.setItems(repository.findAll());
        } else {
            grid.setItems(repository.findByNome(filterText.getValue()));
        }
    }

    public void selecionar() {
        form.setUsuario(grid.asSingleSelect().getValue());
    }

    private void adicionarNovo() {
        grid.asSingleSelect().clear();
        form.setUsuario(new Usuario());
    }
}
