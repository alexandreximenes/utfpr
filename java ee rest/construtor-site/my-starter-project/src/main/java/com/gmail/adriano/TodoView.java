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
import com.vaadin.flow.component.orderedlayout.HorizontalLayout;
import com.vaadin.flow.component.orderedlayout.VerticalLayout;
import com.vaadin.flow.component.textfield.TextField;
import com.vaadin.flow.router.Route;

@Route("todo")
public class TodoView extends VerticalLayout {
    
    public TodoView(){
        VerticalLayout todosList = new VerticalLayout(); // (1)
        TextField taskField = new TextField(); // (2)
        Button addButton = new Button("Adicionar"); // (3)
        addButton.addClickShortcut(Key.ENTER);
        addButton.addClickListener(click -> {
          // (4)
          Checkbox checkbox = new Checkbox(taskField.getValue());
          todosList.add(checkbox);
          checkbox.addClickListener(check -> {
              // (5)
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
          todosList
        );
    }
}
