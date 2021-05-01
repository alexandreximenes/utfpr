package com.example.application.views.helloworld;

import com.vaadin.flow.component.button.Button;
import com.vaadin.flow.component.dependency.CssImport;
import com.vaadin.flow.component.notification.Notification;
import com.vaadin.flow.component.orderedlayout.HorizontalLayout;
import com.vaadin.flow.component.orderedlayout.VerticalLayout;
import com.vaadin.flow.component.textfield.TextField;
import com.vaadin.flow.router.PageTitle;
import com.vaadin.flow.router.Route;
import com.example.application.views.main.MainView;
import com.vaadin.flow.router.RouteAlias;
import org.springframework.beans.factory.annotation.Autowired;

@Route(value = "olamundo", layout = MainView.class)
@PageTitle("Hello World")
@CssImport("./views/helloworld/hello-world-view.css")
@RouteAlias(value = "", layout = MainView.class)
public class HelloWorldView extends HorizontalLayout {

    private TextField name, valor;
    private Button button;

    @Autowired
    private HelloWorldService service;

    public HelloWorldView() throws Exception {
        addClassName("hello-world-view");

        name = new TextField("Seu nome");
        valor = new TextField("Numero de repetições");
        button = new Button("Gerar");

        add(name, valor, button);
        setVerticalComponentAlignment(Alignment.END, name, button);

        button.addClickListener(e -> {
            try {

                //Faz validação do nome
                service.validation(name.getValue());

                //Captura n reperição e faz vaildação
                Integer qtde = service.convert(valor.getValue());
                for (int i =0 ; i<qtde; i++){
                    Notification.show("Olá, "+name.getValue());
                }
            }catch (Exception err){
                Notification.show(err.getMessage());
            }
        });
    }
}
