/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package utfpr.rivolli.posjava;

import com.vaadin.flow.component.button.Button;
import com.vaadin.flow.component.html.Span;
import com.vaadin.flow.component.orderedlayout.HorizontalLayout;
import com.vaadin.flow.component.orderedlayout.VerticalLayout;
import com.vaadin.flow.router.BeforeEvent;
import com.vaadin.flow.router.HasUrlParameter;
import com.vaadin.flow.router.OptionalParameter;
import com.vaadin.flow.router.Route;
import com.vaadin.flow.router.RouterLink;
import com.vaadin.flow.router.WildcardParameter;

@Route("introducao")
public class IntroducaoView extends VerticalLayout implements HasUrlParameter<String> {
    Span label;
    
    public IntroducaoView() {
        label = new Span("Olá Mundo!");
         
        // Definindo um id para o Label
        label.setId("meu-componente");

//        label.setVisible(false);
//        Button btnMostrar = new Button("Mostrar", evt -> {
//            label.setVisible(true);
//        });

        Button btnEsconder = new Button("Esconder");
        Button btnMostrar = new Button("Mostrar", evt -> {
            this.setVisible(false);
            System.out.println(!btnEsconder.isVisible());
            btnEsconder.setVisible(!btnEsconder.isVisible());
        });
        
        RouterLink voltar = new RouterLink("Início", MainView.class);
        
        Button btnFazer = new Button("Fazer algo", click -> {
            // Executa alguma rotina
            // ...
            
            // Redireciona para alguma visão
            getUI().ifPresent(ui -> ui.navigate(MainView.class));
        });
        
        HorizontalLayout links = new HorizontalLayout();
        links.add(voltar, btnFazer);
        
        add(btnMostrar, label, links, btnEsconder);
    }
    
    @Override
    public void setParameter(BeforeEvent event, @WildcardParameter String parameter) {
        if (!parameter.isEmpty()) {
            String params[] = parameter.split("/");
            if (params.length == 1) {
                label.setText("Olá " + parameter + "!");
            } else if (params.length == 3) {
                label.setText("Olá " + params[0] + " - Código: "+ params[1] +"!");
                if ("visualizar".equals(params[2])) {
                    label.setVisible(true);
                }
            }
        }
    }
}
