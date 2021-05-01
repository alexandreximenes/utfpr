package utfpr.rivolli.posjava;

import com.vaadin.flow.component.checkbox.Checkbox;
import com.vaadin.flow.component.checkbox.CheckboxGroup;
import com.vaadin.flow.component.checkbox.CheckboxGroupVariant;
import com.vaadin.flow.component.combobox.ComboBox;
import com.vaadin.flow.component.datepicker.DatePicker;
import com.vaadin.flow.component.html.H1;
import com.vaadin.flow.component.html.H3;
import com.vaadin.flow.component.html.Span;
import com.vaadin.flow.component.icon.VaadinIcon;
import com.vaadin.flow.component.notification.Notification;
import com.vaadin.flow.component.orderedlayout.HorizontalLayout;
import com.vaadin.flow.component.orderedlayout.VerticalLayout;
import com.vaadin.flow.component.select.Select;
import com.vaadin.flow.component.textfield.Autocapitalize;
import com.vaadin.flow.component.textfield.EmailField;
import com.vaadin.flow.component.textfield.IntegerField;
import com.vaadin.flow.component.textfield.NumberField;
import com.vaadin.flow.component.textfield.PasswordField;
import com.vaadin.flow.component.textfield.TextArea;
import com.vaadin.flow.component.textfield.TextField;
import com.vaadin.flow.component.timepicker.TimePicker;
import com.vaadin.flow.router.Route;
import java.time.Duration;
import java.time.LocalDate;
import java.time.LocalTime;
import java.util.Arrays;
import java.util.HashSet;
import java.util.Locale;

@Route("componente/")
public class ComponenteView extends VerticalLayout {

    public ComponenteView() {
        add(new H1("Componentes"));
        
        //Textos
        add(new H3("Textos"));
        
        TextField labelField = new TextField();
        labelField.setLabel("Nome");
        labelField.setPlaceholder("Nome completo");
        labelField.setAutoselect(true);
        labelField.setClearButtonVisible(true);
        
        TextArea textArea = new TextArea("Descrição");
        textArea.getStyle().set("maxHeight", "250px")
                .set("minHeight", "150px");
        
        PasswordField passwordField = new PasswordField();
        passwordField.setLabel("Senha");
        passwordField.setPlaceholder("A senha deve ter letras e números");
        
        EmailField emailField = new EmailField("E-mail");
        emailField.setErrorMessage("Informe um e-mail válido");
        
        IntegerField numberField = new IntegerField("Número da sorte");
        numberField.setHasControls(true);
        numberField.setStep(2);
        numberField.setMin(0);
        numberField.setMax(10);
        
        add(new HorizontalLayout(labelField, textArea, passwordField, emailField, numberField));

        NumberField numberField2 = new NumberField("Valor");
        numberField2.setPrefixComponent(VaadinIcon.DOLLAR.create());
        numberField2.setSuffixComponent(new Span(",00"));
        
        TextField labelField2 = new TextField("Maiúsculas");
        labelField2.addValueChangeListener(event -> {
            labelField2.setValue(event.getValue().toUpperCase());
        });
        add(new HorizontalLayout(numberField2, labelField2));
        
        add(new H3("Data e Hora"));
        
        DatePicker labelDatePicker = new DatePicker();
        labelDatePicker.setLabel("Data");
        labelDatePicker.setAutoOpen(true);
        labelDatePicker.setMin(LocalDate.now());
        labelDatePicker.setMax(LocalDate.now().plusDays(30));
        
        TimePicker timePicker = new TimePicker("Hora");
        timePicker.setLocale(Locale.CANADA_FRENCH);
        timePicker.setMinTime(LocalTime.of(8, 0, 0));
        timePicker.setMaxTime(LocalTime.of(18, 0, 0));
        timePicker.setStep(Duration.ofMinutes(15));
                
        add(new HorizontalLayout(labelDatePicker, timePicker));
        
        //Checkbox
        add(new H3("Checkbox"));
        
        Checkbox checkbox1 = new Checkbox();
        checkbox1.setLabel("Opção 1");
        checkbox1.setValue(true);
        
        Checkbox checkbox2 = new Checkbox("Opção 2");
        add(new HorizontalLayout(checkbox1, checkbox2));
        
        CheckboxGroup<String> checkboxGroup = new CheckboxGroup<>();
        checkboxGroup.setLabel("Items");
        checkboxGroup.setItems("Item 1", "Item 2", "Item 3", "Item 4");
        checkboxGroup.setValue(new HashSet<>(Arrays.asList("Item 2", "Item 3")));
        checkboxGroup.addThemeVariants(CheckboxGroupVariant.LUMO_VERTICAL);
        add(checkboxGroup);
        
        checkbox1.addValueChangeListener(evt1 -> {
            if (evt1.getValue()) {
                Notification.show("Selecionado");
            } else {
                Notification.show("Desmarcado!");
            }
        });
        
        checkboxGroup.addValueChangeListener(evt2 -> {
            if (evt2.getValue().isEmpty()) {
                Notification.show("Nenhum item selecionado");
            } else {
                Notification.show("Selecionado: " + evt2.getValue());
            }
        });
        
        // Combobox
        add(new H3("ComboBox e Select"));
        ComboBox<String> comboBox = new ComboBox<>();
        comboBox.setItems("Opção 1", "Opção 2", "Opção 3", "Opção 4", "Nenhuma opção");
        comboBox.setLabel("ComboBox");
        comboBox.setPlaceholder("Qual a opção?");
        comboBox.setValue("Opção 4");
        comboBox.setAllowCustomValue(false);
        comboBox.setClearButtonVisible(true);
        comboBox.setRequired(true);
        comboBox.setPreventInvalidInput(true);
        
        Select<String> select = new Select<>();
        select.setItems("Item 1", "Item 2", "item N");
        select.setPlaceholder("Selecione um item");
        select.setLabel("Select");
        
        select.addValueChangeListener(event -> {
            if (event.getValue() == null) {
                Notification.show("Nenhuma opção selecionada");
            } else {
                Notification.show("Valor selecionado: " + event.getValue() + " / Valor anterior: " + event.getOldValue());
            }
        });
        
        Select<Cidade> listaCidades = new Select<>();
        listaCidades.setLabel("Lista de cidades");
        listaCidades.setItemLabelGenerator(Cidade::getNome);
        listaCidades.setItems(Cidade.lista());
        
        
        
        add(new HorizontalLayout(comboBox, select, listaCidades));
    }

}
