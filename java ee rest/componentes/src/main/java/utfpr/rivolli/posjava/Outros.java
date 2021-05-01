/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package utfpr.rivolli.posjava;

import com.vaadin.flow.component.Component;
import com.vaadin.flow.component.Text;
import com.vaadin.flow.component.details.Details;
import com.vaadin.flow.component.html.Anchor;
import com.vaadin.flow.component.html.Div;
import com.vaadin.flow.component.html.H3;
import com.vaadin.flow.component.html.Image;
import com.vaadin.flow.component.icon.Icon;
import com.vaadin.flow.component.icon.VaadinIcon;
import com.vaadin.flow.component.notification.Notification;
import com.vaadin.flow.component.orderedlayout.HorizontalLayout;
import com.vaadin.flow.component.orderedlayout.VerticalLayout;
import com.vaadin.flow.component.tabs.Tab;
import com.vaadin.flow.component.tabs.Tabs;
import com.vaadin.flow.router.Route;
import java.io.File;
import java.util.HashMap;
import java.util.Map;
import org.apache.catalina.webresources.FileResource;

@Route("outros")
public class Outros extends VerticalLayout {
    
    public Outros() { 
        Anchor link = new Anchor("http://www.utfpr.edu.br", "UTFPR");
        link.setTarget("_blank");
        
        Details detail = new Details("Veja em detalhes", new Text("Aqui vai todo o texto em detalhes... é possível adicionar qualquer componente aqui."));
        detail.addOpenedChangeListener(e -> Notification.show(e.isOpened() ? "Abriu" : "Fechou"));
                
        Icon edit = new Icon(VaadinIcon.EDIT);
        Icon close = VaadinIcon.CLOSE.create();
        Icon custom = new Icon(VaadinIcon.SMILEY_O);
        custom.setColor("red");
        custom.setSize("70px");
        HorizontalLayout hl = new HorizontalLayout();
        hl.add(new H3("Icones:"), edit, close, custom);
        
        Image image = new Image("img/logo.png", "UTFPR");
        
        Tab tab1 = new Tab("Links");
        Tab tab2 = new Tab("Detalhes");
        Tab tab3 = new Tab("Icones");
        Tab tab4 = new Tab("Imagem");
        Tabs tabs = new Tabs(tab1, tab2, tab3, tab4);
        
        Map<Tab, Component> tabsToPages = new HashMap<>();
        tabsToPages.put(tab1, link);
        tabsToPages.put(tab2, detail);
        tabsToPages.put(tab3, hl);
        tabsToPages.put(tab4, image);

        Div page = new Div();
        page.add(tabsToPages.get(tabs.getSelectedTab()));
        
        tabs.addSelectedChangeListener(event -> {
            page.remove(page.getChildren().findFirst().get()); 
            page.add(tabsToPages.get(tabs.getSelectedTab()));
        });
        
        add(tabs, page);
        
    }
}
