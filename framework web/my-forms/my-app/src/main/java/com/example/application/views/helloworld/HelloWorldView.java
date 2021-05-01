package com.example.application.views.helloworld;

import com.example.application.model.Cidade;
import com.example.application.model.Usuario;
import com.example.application.services.FormService;
import com.example.application.views.main.MainView;
import com.vaadin.flow.component.button.Button;
import com.vaadin.flow.component.checkbox.Checkbox;
import com.vaadin.flow.component.datepicker.DatePicker;
import com.vaadin.flow.component.dependency.CssImport;
import com.vaadin.flow.component.formlayout.FormLayout;
import com.vaadin.flow.component.grid.Grid;
import com.vaadin.flow.component.notification.Notification;
import com.vaadin.flow.component.orderedlayout.HorizontalLayout;
import com.vaadin.flow.component.select.Select;
import com.vaadin.flow.component.textfield.EmailField;
import com.vaadin.flow.component.textfield.PasswordField;
import com.vaadin.flow.component.textfield.TextArea;
import com.vaadin.flow.component.textfield.TextField;
import com.vaadin.flow.router.PageTitle;
import com.vaadin.flow.router.Route;
import com.vaadin.flow.router.RouteAlias;
import org.springframework.beans.factory.annotation.Autowired;

@Route(value = "formulario", layout = MainView.class)
@RouteAlias(value = "", layout = MainView.class)
@PageTitle("Hello World")
@CssImport("./views/helloworld/hello-world-view.css")
public class HelloWorldView extends HorizontalLayout {

    @Autowired
    private FormService service;

    private TextField nome, sobreNome, telefone;
    DatePicker aniversario;
    private EmailField email;
    private Button button;
    TextArea perfil;

    private Usuario usuario;

    public HelloWorldView() {
        addClassName("hello-world-view");

        usuario = new Usuario();

        FormLayout layout = new FormLayout();
        FormLayout gridLayout = new FormLayout();

        nome = new TextField("Seu nome");
        nome.setLabel("Nome");
        nome.setPlaceholder("Nome completo");
        nome.setAutoselect(true);
        nome.setClearButtonVisible(true);

        sobreNome = new TextField("Sobrenome");
        sobreNome.setLabel("Sobrenome");
        sobreNome.setPlaceholder("sobrenome");
        sobreNome.setAutoselect(true);
        sobreNome.setClearButtonVisible(true);
        telefone = new TextField();

        aniversario = new DatePicker();
        Checkbox checkboxNaoLigar = new Checkbox("Não ligar");

        perfil = new TextArea("Descrição");
        perfil.getStyle().set("maxHeight", "250px").set("minHeight", "150px");

        button = new Button("enviar");
        email = new EmailField("E-mail");
        email.setErrorMessage("Informe um e-mail válido");

        PasswordField password = new PasswordField();
        password.setLabel("Informe sua senha");
        password.setPlaceholder("A senha deve ter letras e números");
        password.setRevealButtonVisible(false);

        Select<Cidade> listaCidades = new Select<>();
        listaCidades.setLabel("Lista de cidades");
        listaCidades.setItemLabelGenerator(Cidade::getNome);
        listaCidades.setItems(Cidade.getCidades());

        Checkbox checkboxtTermos = new Checkbox();
        checkboxtTermos.setLabel("Aceita os termos de uso");
        checkboxtTermos.setValue(false);

        layout.addFormItem(nome, "Nome");
        layout.addFormItem(sobreNome, "Sobrenome");
        layout.addFormItem(aniversario, "Data de aniversario");
        layout.addFormItem(email, "E-mail");
        layout.addFormItem(password, "Senha");
        layout.addFormItem(perfil, "Perfil");
        layout.addFormItem(checkboxtTermos, "Aceita os termos de uso");
        layout.addFormItem(listaCidades, "Lista de cidades");
        layout.addFormItem(button, "Salvar");

        FormLayout.FormItem telefoneItem = layout.addFormItem(telefone, "Telefone");
        telefoneItem.add(checkboxNaoLigar);


        Grid<Usuario> grid = new Grid<>(Usuario.class);
        grid.setItems(Usuario.lista());
        grid.setColumns("nome", "sobrenome", "telefone", "aniversario", "email", "password", "idade", "perfil", "cidade");

        add(layout);
        add(button);
        gridLayout.add(grid);
        add(gridLayout);

        button.addClickListener(e -> {
            try {

                //Faz validação
                service.validationField(nome.getValue(), nome.getLabel());
                service.validationField(sobreNome.getValue(), sobreNome.getLabel());
                service.validationField(aniversario.getValue(), aniversario.getLabel());
                service.validationField(perfil.getValue(), perfil.getLabel());
                service.validationField(email.getValue(), email.getValue());
                service.validationField(password.getValue(), password.getValue());
                service.validationField(checkboxtTermos);
                service.validationField(listaCidades, listaCidades.getLabel());

                usuario.setNome(nome.getValue());
                usuario.setSobrenome(sobreNome.getValue());
                usuario.setAniversario(aniversario.getValue());
                usuario.setPerfil(perfil.getValue());
                usuario.setEmail(email.getValue());
                usuario.setPassword(password.getValue());
                usuario.setCidade(listaCidades.getValue());
                usuario.setAceiteOsTermos(checkboxtTermos.getValue());

                Notification.show("Olá " + nome.getValue() + ", seu cadastro foi realizado com sucesso!");

                Usuario.add(usuario);
                grid.setItems(Usuario.lista());

                System.out.println(usuario);
            }catch (Exception err){
                Notification.show(err.getMessage());
            }
        });
    }
}
