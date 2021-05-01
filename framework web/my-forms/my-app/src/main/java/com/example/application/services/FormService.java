package com.example.application.services;

import com.example.application.model.Cidade;
import com.vaadin.flow.component.checkbox.Checkbox;
import com.vaadin.flow.component.notification.Notification;
import com.vaadin.flow.component.select.Select;
import org.springframework.stereotype.Service;

import java.time.LocalDate;


@Service
public class FormService {

    public void validationField(String value, String label) throws Exception {
        if (value == null || value.isEmpty()) {
            throw new Exception(label + " não preenchido");
        }
    }

    public void validationField(LocalDate date, String label) throws Exception {
        if (date == null) {
            throw new Exception(label + " não preenchido");
        }
    }

    public void validationField(Checkbox checkbox) throws Exception {

        checkbox.addValueChangeListener(evt1 -> {

            if (!evt1.getValue()){
                Notification.show("Aceite os termos de uso");
            }
        });

        Boolean checkboxValue = checkbox.getValue();
        if (!checkboxValue) {
            throw new Exception("Você deve aceitar os termos de uso para prosseguir");
        }


    }

    public void validationField(Select<Cidade> listaCidades, String label) throws Exception  {

        if (listaCidades.getValue() == null) {
            throw new Exception("Nenhuma cidade selecionada");
        }
    }
}
