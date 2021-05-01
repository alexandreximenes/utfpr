package com.example.application.views.cadastro;

import com.example.application.ConfirmationDialog;
import com.example.application.model.Status;
import com.example.application.model.Usuario;
import com.example.application.repository.UsuarioRepository;
import com.example.application.views.main.MainView;
import com.vaadin.flow.component.button.ButtonVariant;
import com.vaadin.flow.component.combobox.ComboBox;
import com.vaadin.flow.component.datepicker.DatePicker;
import com.vaadin.flow.component.formlayout.FormLayout;
import com.vaadin.flow.component.orderedlayout.HorizontalLayout;
import com.vaadin.flow.component.textfield.EmailField;
import com.vaadin.flow.data.binder.Binder;

import java.awt.*;
import java.util.Locale;

public class UsuarioForm extends FormLayout {

    private MainView mainView;
    private ConfirmationDialog confirmationDialog = new ConfirmationDialog();
    private Binder<Usuario> binder = new Binder<>(Usuario.class);
    private UsuarioRepository repository;

    private TextField nome = new TextField("Nome");
    private TextField sobrenome = new TextField("Sobrenome");
    private ComboBox<Status> status = new ComboBox<>("Status");
    private DatePicker nascimento = new DatePicker("Data de nascimento");
    private EmailField email = new EmailField("E-mail");

    private com.vaadin.flow.component.button.Button btSalvar = new com.vaadin.flow.component.button.Button("Salvar");
    private com.vaadin.flow.component.button.Button btExcluir = new com.vaadin.flow.component.button.Button("Excluir");


    public UsuarioForm(UsuarioRepository repository, MainView mainView) {
        this.mainView = mainView;
        this.repository = repository;
        binder.bindInstanceFields(this);
        status.setItems(Status.values());

        nascimento.setLocale(new Locale("pt", "BR"));

        HorizontalLayout btns = new HorizontalLayout(btSalvar, btExcluir);

        btSalvar.addClickListener(event -> salvar());
        btExcluir.addClickListener(event -> excluir());

        HorizontalLayout buttons = new HorizontalLayout(btSalvar, btExcluir);
        btSalvar.addThemeVariants(ButtonVariant.LUMO_PRIMARY);

        add(nome, sobrenome, email, status, nascimento, buttons);
    }

    public void setUsuario(Usuario usuario) {
        binder.setBean(usuario);

        if (usuario == null) {
            setVisible(false);
        } else {
            setVisible(true);
            if (binder.getBean().isPersisted()) {
                btExcluir.setVisible(true);
            } else {
                btExcluir.setVisible(false);
            }
            nome.requestFocus();
        }
    }

    private void salvar() {
        Usuario usuario = binder.getBean();
        repository.save(usuario);
        mainView.atualizar();
        setUsuario(null);
    }

    private void excluir() {
        Usuario usuario = binder.getBean();
        confirmationDialog.setQuestion("Deseja realmente excluir a/o cliente '" + usuario.toString() + "'?");
        confirmationDialog.open();
        confirmationDialog.addConfirmationListener(evt -> {
            repository.delete(usuario);
            mainView.atualizar();
            setUsuario(null);
        });
    }
}
