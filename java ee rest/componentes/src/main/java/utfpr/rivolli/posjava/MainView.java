package utfpr.rivolli.posjava;

import com.vaadin.flow.component.dependency.CssImport;
import com.vaadin.flow.component.orderedlayout.HorizontalLayout;
import com.vaadin.flow.component.orderedlayout.VerticalLayout;
import com.vaadin.flow.router.Route;
import com.vaadin.flow.router.RouterLink;
import com.vaadin.flow.server.PWA;

@Route
@PWA(name = "Vaadin Componentes",
        shortName = "Vaadin Componentes",
        enableInstallPrompt = false)
@CssImport("./styles/shared-styles.css")
@CssImport(value = "./styles/vaadin-text-field-styles.css", themeFor = "vaadin-text-field")
public class MainView extends VerticalLayout {

    public MainView() {
        HorizontalLayout intro = new HorizontalLayout();
        intro.add(new RouterLink("Ver Exemplos da Introdução", IntroducaoView.class));
        intro.add(new RouterLink("Com 1 parâmetro", IntroducaoView.class, "Aluno"));
        intro.add(new RouterLink("Com múltiplos parâmetros", IntroducaoView.class, "Aluno/123/visualizar"));
        
        RouterLink cont = new RouterLink("Containers", Container.class);
        RouterLink outros = new RouterLink("Outros componentes", Outros.class);
                
        add(intro, cont, outros);
    }

}
