package com.greensquid.Webportal.ui.views;

import com.greensquid.Webportal.ui.MainView;
import com.vaadin.flow.component.html.Div;
import com.vaadin.flow.router.Route;

@Route(value = "", layout = MainView.class)
public class HomeView  extends Div {
    public HomeView() {
    }
}
