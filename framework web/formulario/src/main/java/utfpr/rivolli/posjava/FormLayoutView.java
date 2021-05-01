package utfpr.rivolli.posjava;

import com.vaadin.flow.component.checkbox.Checkbox;
import com.vaadin.flow.component.formlayout.FormLayout;
import com.vaadin.flow.component.formlayout.FormLayout.ResponsiveStep;
import com.vaadin.flow.component.html.H1;
import com.vaadin.flow.component.orderedlayout.VerticalLayout;
import com.vaadin.flow.component.textfield.TextField;
import com.vaadin.flow.router.Route;

@Route("formlayout/")
public class FormLayoutView extends VerticalLayout {
    
    public FormLayoutView() {
        FormLayout form1 = new FormLayout();
        
        TextField campo1 = new TextField();
        campo1.setLabel("Campo 1");
        campo1.setPlaceholder("Exemplo de campo 1");
        TextField campo2 = new TextField();
        campo2.setLabel("Campo 2");
        campo2.setPlaceholder("Exemplo de campo 2");
        TextField campo3 = new TextField();
        campo3.setLabel("Campo 3");
        campo3.setPlaceholder("Exemplo de campo 3");
        TextField campo4 = new TextField();
        campo4.setLabel("Campo 4");
        campo4.setPlaceholder("Exemplo de campo 4");
        TextField campoA = new TextField();
        campoA.setLabel("Campo A");
        campoA.setPlaceholder("Exemplo de campo A");
        TextField campoB = new TextField();
        campoB.setPlaceholder("Exemplo de campo B sem Label");
        TextField campoC = new TextField();
        campoC.setLabel("Campo C");
        campoC.setPlaceholder("Exemplo de campo C");
        
        form1.add(campo1, campo2, campo3, campo4, campoA, campoB);
        form1.setResponsiveSteps(new ResponsiveStep("25em", 1), new ResponsiveStep("32em", 2), new ResponsiveStep("40em", 3));
        form1.setColspan(campoA, 2);
        form1.setColspan(campoB, 3);
        form1.add(campoC, 2);
        
        FormLayout form2 = new FormLayout();
        TextField campo5 = new TextField();
        campo5.setPlaceholder("Exemplo de campo 5");
        TextField campo6 = new TextField();
        campo6.setPlaceholder("Exemplo de campo 6");
        TextField campo7 = new TextField();
        campo7.setPlaceholder("Exemplo de campo 7");
        TextField campo8 = new TextField();
        campo8.setPlaceholder("Exemplo de campo 8");
        TextField campoD = new TextField();
        campoD.setPlaceholder("Exemplo de campo D sem label");
        TextField campoE = new TextField();
        campoE.setPlaceholder("Exemplo de campo E");
        TextField campoF = new TextField();
        campoF.setPlaceholder("Exemplo de campo F");
        
        form2.addFormItem(campo5, "Campo 5");
        form2.addFormItem(campo6, "Campo 6");
        form2.addFormItem(campo7, "Campo 7");
        form2.addFormItem(campo8, "Campo 8");
        form2.addFormItem(campoD, "");
        form2.addFormItem(campoE, "Campo E").add(new Checkbox("Campo conjunto"));
        form2.addFormItem(campoF, "Campo F");
        
        //form2.setResponsiveSteps(new ResponsiveStep("200px", 1), new ResponsiveStep("200px", 2),
        //        new ResponsiveStep("200px", 3), new ResponsiveStep("200px", 4));
        
        add(new H1("Form 1"), form1, new H1("Form 2"), form2);
    }
}
