/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package utfpr.rivolli.posjava;

import com.vaadin.flow.component.grid.ColumnTextAlign;
import com.vaadin.flow.component.grid.Grid;
import com.vaadin.flow.component.html.H1;
import com.vaadin.flow.component.html.H2;
import com.vaadin.flow.component.orderedlayout.VerticalLayout;
import com.vaadin.flow.router.Route;

@Route("grid/")
public class GridView extends VerticalLayout {
    
    public GridView() {
        H2 selecionado = new H2();
        selecionado.setVisible(false);
        
        Grid<Cidade> grid = new Grid<>(Cidade.class);
        grid.setItems(Cidade.lista());
        grid.setColumns("id", "nome", "estado");
        grid.removeColumnByKey("id");
        
        grid.getColumnByKey("estado")
                .setHeader("UF")
                .setTextAlign(ColumnTextAlign.CENTER)
                .setWidth("100px");
        
        grid.setSelectionMode(Grid.SelectionMode.SINGLE);
        grid.addSelectionListener(event -> {
            Cidade cidade = event.getFirstSelectedItem().get();
            if (cidade == null) {
                selecionado.setVisible(false);
            } else {
                selecionado.setText(cidade.toString());
                selecionado.setVisible(true);
            }
        });
        
        add(new H1("Lista de cidades"));
        add(grid, selecionado);
    }
}
