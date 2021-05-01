/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.gmail.adriano;

import com.vaadin.flow.component.Key;
import com.vaadin.flow.component.button.Button;
import com.vaadin.flow.component.checkbox.Checkbox;
import com.vaadin.flow.component.html.H1;
import com.vaadin.flow.component.html.Span;
import com.vaadin.flow.component.orderedlayout.HorizontalLayout;
import com.vaadin.flow.component.orderedlayout.VerticalLayout;
import com.vaadin.flow.component.textfield.TextField;
import com.vaadin.flow.router.Route;

@Route("todo/completo")
public class TodoView2 extends VerticalLayout {
    
    public TodoView2(){
        VerticalLayout todosList = new VerticalLayout();
        VerticalLayout todosDone = new VerticalLayout(); // (1)
        TextField taskField = new TextField();
        Button addButton = new Button("Adicionar");
        addButton.addClickShortcut(Key.ENTER);
        addButton.addClickListener(click -> {
          Checkbox checkbox = new Checkbox(taskField.getValue());
          todosList.add(checkbox);
          checkbox.addClickListener(check -> {
              Span obj = new Span(checkbox.getLabel()); // (2)
              todosDone.add(obj);                       // (3)
              todosList.remove(checkbox);
              taskField.focus();
          });
          taskField.setValue("");
          taskField.focus();
        });
        add( // (6)
          new H1("lista de Tarefas"),
          new HorizontalLayout(
            taskField,
            addButton
          ),
          todosList,
          new H1("Tarefas resolvidas"),
          todosDone
        );
    }
}
