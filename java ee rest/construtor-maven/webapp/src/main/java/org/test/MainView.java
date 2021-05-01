package org.test;

import com.vaadin.flow.component.button.Button;
import com.vaadin.flow.component.notification.Notification;
import com.vaadin.flow.component.orderedlayout.VerticalLayout;
import com.vaadin.flow.server.PWA;
import com.vaadin.flow.router.Route;

/**
 * The main view contains a button and a click listener.
 */
@Route()
public class MainView extends VerticalLayout {

    public MainView() {
        Button button = new Button("Diga oie",
                event -> Notification.show("Olá Mundo!"));
        add(button);
    }
}
