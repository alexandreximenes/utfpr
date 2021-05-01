package utfpr.rivolli.posjava;

import com.vaadin.flow.component.html.H1;
import com.vaadin.flow.component.orderedlayout.VerticalLayout;
import com.vaadin.flow.router.Route;
import com.vaadin.flow.router.RouterLink;

@Route
public class MainView extends VerticalLayout {

    public MainView() {
        add(new H1("Formulários"));
        
        add(new RouterLink("Componentes", ComponenteView.class)); 
        add(new RouterLink("Form Layout", FormLayoutView.class)); 
        add(new RouterLink("Grid", GridView.class));
    }

}
