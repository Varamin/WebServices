package com.greensquid.Webportal.ui;


import com.github.appreciated.app.layout.behaviour.AppLayout;
import com.github.appreciated.app.layout.behaviour.Behaviour;
import com.github.appreciated.app.layout.builder.AppLayoutBuilder;
import com.github.appreciated.app.layout.builder.interfaces.NavigationElementContainer;
import com.github.appreciated.app.layout.component.appbar.AppBarBuilder;
import com.github.appreciated.app.layout.component.appmenu.MenuHeaderComponent;
import com.github.appreciated.app.layout.component.appmenu.left.LeftClickableComponent;
import com.github.appreciated.app.layout.component.appmenu.left.LeftNavigationComponent;
import com.github.appreciated.app.layout.component.appmenu.left.builder.LeftAppMenuBuilder;
import com.github.appreciated.app.layout.component.appmenu.left.builder.LeftSubMenuBuilder;
import com.github.appreciated.app.layout.notification.DefaultNotificationHolder;
import com.github.appreciated.app.layout.notification.component.AppBarNotificationButton;
import com.github.appreciated.app.layout.router.AppLayoutRouterLayout;
import com.greensquid.Webportal.ui.views.HomeView;
import com.greensquid.Webportal.ui.views.ServersView;
import com.vaadin.flow.component.Component;
import com.vaadin.flow.component.icon.VaadinIcon;
import com.vaadin.flow.component.page.Push;
import com.vaadin.flow.router.PageTitle;

import static com.github.appreciated.app.layout.entity.Section.FOOTER;
import static com.github.appreciated.app.layout.entity.Section.HEADER;

@Push()
@PageTitle("Web-portal")
public class MainView extends AppLayoutRouterLayout {
    private DefaultNotificationHolder notifications;

    public MainView() {
    }

    public AppLayout createAppLayoutInstance() {

        notifications = new DefaultNotificationHolder(newStatus -> {
        });

        Component appBar = AppBarBuilder
                .get()
                .add(new AppBarNotificationButton(VaadinIcon.BELL, notifications))
                .build();
        NavigationElementContainer appMenu = LeftAppMenuBuilder
                .get()
                .addToSection(new MenuHeaderComponent("МЕНЮ",
                        "",
                        "\\frontend\\images\\logo.png"
                ), HEADER)
                .add(new LeftNavigationComponent("Home", VaadinIcon.HOME.create(), HomeView.class))
                .add(LeftSubMenuBuilder
                        .get("Tools", VaadinIcon.PLUS.create())
                        .add(new LeftNavigationComponent("Servers", VaadinIcon.SERVER.create(), ServersView.class))
                        .build())
                .withStickyFooter()
                .addToSection(new LeftClickableComponent("Настройки",
                        VaadinIcon.COG.create(),
                        clickEvent -> {

                        }
                ), FOOTER)
                .build();

        return AppLayoutBuilder
                .get(Behaviour.LEFT_HYBRID)
                .withTitle("WEB-Portal")
                .withAppBar(appBar)
                .withAppMenu(appMenu)
                .build();

    }
}
