package com.example.application.views.about;

import com.example.application.views.MainLayout;
import com.vaadin.flow.component.Component;
import com.vaadin.flow.component.Unit;
import com.vaadin.flow.component.board.Board;
import com.vaadin.flow.component.button.Button;
import com.vaadin.flow.component.html.H2;
import com.vaadin.flow.component.html.Image;
import com.vaadin.flow.component.html.Label;
import com.vaadin.flow.component.html.Paragraph;
import com.vaadin.flow.component.notification.Notification;
import com.vaadin.flow.component.orderedlayout.FlexComponent;
import com.vaadin.flow.component.orderedlayout.HorizontalLayout;
import com.vaadin.flow.component.orderedlayout.VerticalLayout;
import com.vaadin.flow.component.textfield.TextField;
import com.vaadin.flow.router.PageTitle;
import com.vaadin.flow.router.Route;
import java.util.ArrayList;
import java.util.List;
import java.util.Locale.Category;
import java.util.stream.Collectors;

@PageTitle("AboutCopy")
@Route(value = "aboutCopy", layout = MainLayout.class)
public class AboutCopyView extends HorizontalLayout {

//    public AboutCopyView() {
//        setSpacing(false);
//
//
//        Image img = new Image("images/empty-plant.png", "placeholder plant");
//        img.setWidth("200px");
//        add(img);
//
//        add(new H2("This place intentionally left empty"));
//        add(new Paragraph("It’s a place where you can grow your own UI 🤗"));
////
//        setSizeFull();
//        setJustifyContentMode(JustifyContentMode.CENTER);
//        setDefaultHorizontalComponentAlignment(Alignment.CENTER);
//        getStyle().set("text-align", "center");
////        addClassName("dashboard-view");
////
////        Board board = new Board();
////        board.addRow(createComponent1(), createComponent2());
////        add(board);
//    }


    private TextField name;
    private Button sayHello;
    private List<Lifter> lifters;

    public AboutCopyView() {

        List.of("Draw", "Lifter", "Club", "Birthyear", "Bodyweight", "Category", "1", "2","3","Best", "1", "2","3","Best", "Total", "Sinclair", "Elite")
            .stream()
            .forEach(title -> add(new Label(title)));

        lifters = new ArrayList<>();
        lifters.add(Lifter.builder().id(1).lot(245).birthYear(2000).name("Anatoli Pisarenko").build());
        lifters.add(Lifter.builder().id(2).lot(7).birthYear(1987).name("John Potoli").build());

        setWidthFull();
        setMargin(true);
//        name = new TextField("Your name");
//        sayHello = new Button("Say hello");
//        add(name, sayHello);
//        setVerticalComponentAlignment(Alignment.END, name, sayHello);
//        sayHello.addClickListener(e -> {
//            Notification.show("Hello " + name.getValue());
//        });

    }

}
