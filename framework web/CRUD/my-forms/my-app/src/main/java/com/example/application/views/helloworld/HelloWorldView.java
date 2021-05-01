package com.example.application.views.helloworld;

import com.example.application.dialog.ConfirmationDialog;
import com.example.application.model.Status;
import com.example.application.model.Usuario;
import com.example.application.repository.UsuarioRepository;
import com.example.application.services.FormService;
import com.example.application.views.main.MainView;
import com.vaadin.flow.component.button.Button;
import com.vaadin.flow.component.checkbox.Checkbox;
import com.vaadin.flow.component.combobox.ComboBox;
import com.vaadin.flow.component.datepicker.DatePicker;
import com.vaadin.flow.component.dependency.CssImport;
import com.vaadin.flow.component.formlayout.FormLayout;
import com.vaadin.flow.component.grid.Grid;
import com.vaadin.flow.component.notification.Notification;
import com.vaadin.flow.component.textfield.EmailField;
import com.vaadin.flow.component.textfield.PasswordField;
import com.vaadin.flow.component.textfield.TextArea;
import com.vaadin.flow.component.textfield.TextField;
import com.vaadin.flow.data.binder.Binder;
import com.vaadin.flow.router.PageTitle;
import com.vaadin.flow.router.Route;
import com.vaadin.flow.router.RouteAlias;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;
import java.util.Locale;

import static java.util.Objects.nonNull;

@Route(value = "formulario", layout = MainView.class)
@RouteAlias(value = "", layout = MainView.class)
@PageTitle("Hello World")
@CssImport("./views/helloworld/hello-world-view.css")
public class HelloWorldView extends FormLayout {

    @Autowired
    private FormService formService;

    private Long id;
    private TextField nome, sobreNome, telefone;
    private DatePicker aniversario = new DatePicker("Data de aniversario");
    private EmailField email = new EmailField();
    private Button buttonSalvar = new Button("");
    private Button buttonExcluir = new Button();
    private TextArea perfil = new TextArea();
    private ComboBox<Status> status = new ComboBox<>("Status");
    private PasswordField password = new PasswordField();
    private Checkbox checkboxtTermos = new Checkbox();
    private Grid<Usuario> grid = new Grid<>();
    private FormLayout.FormItem telefoneItem;
    private Checkbox checkboxNaoLigar;

    private Usuario usuario = new Usuario();

    private Binder<Usuario> binder = new Binder<>(Usuario.class);

    @Autowired
    private UsuarioRepository repository;

    ConfirmationDialog confirmationDialog = new ConfirmationDialog();

    public HelloWorldView() {

        binder.bindInstanceFields(this);
        binder.setBean(usuario);
        status.setItems(Status.values());
        aniversario.setLocale(new Locale("pt", "BR"));

        confirmationDialog.setTitle("Confirma");
        confirmationDialog.setQuestion("Quer continar com operaçao?");

        addClassName("hello-world-view");

        FormLayout layout = new FormLayout();
        FormLayout gridLayout = new FormLayout();

        nome = new TextField("Seu nome");
        nome.setLabel("Nome");
        nome.setPlaceholder("Nome completo");
        nome.setAutoselect(true);
        nome.setClearButtonVisible(true);
        nome.focus();

        sobreNome = new TextField("Sobrenome");
        sobreNome.setLabel("Sobrenome");
        sobreNome.setPlaceholder("sobrenome");
        sobreNome.setAutoselect(true);
        sobreNome.setClearButtonVisible(true);
        telefone = new TextField();

        aniversario = new DatePicker();
        checkboxNaoLigar = new Checkbox("Não ligar");

        perfil = new TextArea("Descrição");
        perfil.getStyle().set("maxHeight", "250px").set("minHeight", "150px");

        buttonSalvar = new Button("Salvar");
        buttonExcluir = new Button("Excluir");

        email = new EmailField("E-mail");
        email.setLabel("E-mail");

        password = new PasswordField("Senha");
        password.setLabel("Senha");
        password.setPlaceholder("A senha deve ter letras e números");
        password.setRevealButtonVisible(false);

        checkboxtTermos = new Checkbox();
        checkboxtTermos.setLabel("Aceita os termos de uso");
        checkboxtTermos.setValue(false);

        layout.addFormItem(nome, "Nome");
        layout.addFormItem(sobreNome, "Sobrenome");
        layout.addFormItem(aniversario, "Data de aniversario");
        layout.addFormItem(email, "E-mail");
        layout.addFormItem(password, "Senha");
        layout.addFormItem(perfil, "Perfil");

        telefoneItem = layout.addFormItem(telefone, "Telefone");
        telefoneItem.add(checkboxNaoLigar);

        layout.addFormItem(checkboxtTermos, "Aceita os termos de uso");

        layout.add(buttonSalvar);
        layout.add(buttonExcluir);

        grid = new Grid<>(Usuario.class);
        grid.setColumns("nome", "sobrenome", "email");

        add(layout);
        gridLayout.add(grid);
        add(gridLayout);

        grid.asSingleSelect().addValueChangeListener(e -> {
            usuario = grid.asSingleSelect().getValue();

           if(nonNull(usuario)){
               id = usuario.getId();
               nome.setValue(usuario.getNome());
               sobreNome.setValue(usuario.getSobrenome());
               telefone.setValue(usuario.getTelefone());
               aniversario.setValue(usuario.getAniversario());
               email.setValue(usuario.getEmail());
               perfil.setValue(usuario.getPerfil());
               password.setValue(usuario.getPassword());
               checkboxtTermos.setValue(usuario.getAceiteOsTermos());
           }

        });

        buttonSalvar.addClickListener(event -> salvar());
        buttonExcluir.addClickListener(event -> excluir());

    }

    private void excluir() {


        if (nonNull(id)) {
//            confirmationDialog.setQuestion("Deseja realmente excluir a/o cliente '" + usuario.getNome() + "'?");
//            confirmationDialog.open();
//            confirmationDialog.addConfirmationListener(evt -> {
                repository.delete(usuario);
                this.atualizarLista();

//            });

            id = null;
            limparCampos();
        }
    }


    private synchronized void salvar() {

//        confirmationDialog.open();
//

//        confirmationDialog.addConfirmationListener(evt -> {
            try {

                //Faz validação
                formService.validationField(nome.getValue(), nome.getLabel());
                formService.validationField(sobreNome.getValue(), sobreNome.getLabel());
                formService.validationField(aniversario.getValue(), "Data de aniversario");
                formService.validationField(email.getValue(), "E-mail");
                formService.validationField(password.getValue(), "Senha");
                formService.validationField(perfil.getValue(), perfil.getLabel());
                formService.validationField(telefone.getValue(), "Telefone");
                formService.validationField(checkboxtTermos);

                usuario.setId(id);
                usuario.setNome(nome.getValue());
                usuario.setSobrenome(sobreNome.getValue());
                usuario.setAniversario(aniversario.getValue());
                usuario.setPerfil(perfil.getValue());
                usuario.setEmail(email.getValue());
                usuario.setTelefone(telefone.getValue());
                usuario.setPassword(password.getValue());
                usuario.setAceiteOsTermos(checkboxtTermos.getValue());

                Notification.show("Olá " + nome.getValue() + ", seu cadastro foi realizado com sucesso!");

                repository.save(usuario);

                this.atualizarLista();

                System.out.println(usuario);

                usuario.setId(null);
                id = null;



            } catch (Exception err) {
                Notification.show(err.getMessage());
            }

//        });
        grid.asSingleSelect().clear();
        limparCampos();
    }

    private void limparCampos() {
        nome.clear();
        sobreNome.clear();
        telefone.clear();
        aniversario.setValue(null);
        email.clear();
        perfil.clear();
        password.clear();
        checkboxtTermos.clear();
        checkboxNaoLigar.clear();
        nome.focus();
    }

    public void setUsuario(Usuario usuario) {
        binder.setBean(usuario);

        if (usuario == null) {
            setVisible(false);
        } else {
            setVisible(true);
            if (binder.getBean().isPersisted()) {
                buttonExcluir.setVisible(true);
            } else {
                buttonExcluir.setVisible(false);
            }
            nome.focus();
        }
    }


    private void atualizarLista() {
        List<Usuario> items = repository.findAll();
        grid.setItems(items);
    }

}
