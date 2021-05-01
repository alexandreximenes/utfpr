/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package utfpr.rivolli.posjava;

import com.vaadin.flow.component.dependency.CssImport;
import com.vaadin.flow.component.html.Div;
import com.vaadin.flow.component.html.H1;
import com.vaadin.flow.component.html.H2;
import com.vaadin.flow.component.html.Span;
import com.vaadin.flow.component.orderedlayout.FlexLayout;
import com.vaadin.flow.component.orderedlayout.HorizontalLayout;
import com.vaadin.flow.component.orderedlayout.VerticalLayout;
import com.vaadin.flow.router.Route;

@Route("container")
@CssImport("./styles/extra.css")
public class Container extends Div {
    
    public Container() {
        add(new H1("Lista de Containers"));
        
        HorizontalLayout hlay = new HorizontalLayout();
        Div aux = new Div();
        aux.add("3");
        hlay.add(new H2("Horizontal layout"), new Span("1"), new Span("2"), aux);
        hlay.addClassName("bordas-internas");
        
        
        VerticalLayout vlay = new VerticalLayout();
        aux = new Div();
        aux.add("3");
        vlay.add(new H2("Vertical layout"), new Span("1"), new Span("2"), aux);
        vlay.addClassName("bordas-internas");
        
        add(hlay, vlay);
        
        FlexLayout flay = new FlexLayout();
        aux = new Div();
        aux.add("3");
        flay.add(new H2("Flex layout"), new Span("1"), new Span("2"), aux);
        flay.addClassName("bordas-internas");
        
        Div dlay = new Div();
        aux = new Div();
        aux.add("3");
        dlay.add(new H2("Div"), new Span("1"), new Span("2"), aux);
        dlay.addClassName("bordas-internas");
        
        add(hlay, vlay, flay, dlay);
    }
}
