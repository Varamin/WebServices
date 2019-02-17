package com.greensquid.Webportal.ui.views;


import com.greensquid.DevServers.model.Servers;
import com.greensquid.DevServers.service.ServersService;
import com.greensquid.Webportal.ui.MainView;
import com.vaadin.flow.component.grid.Grid;
import com.vaadin.flow.component.html.Div;

import com.vaadin.flow.data.provider.DataProvider;
import com.vaadin.flow.router.Route;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;


@Route(value = "servers", layout = MainView.class)
public class ServersView extends Div {

    @Autowired
    private ServersService serversService;
    private Grid grid = new Grid<>(Servers.class);

    public ServersView() {

        DataProvider<Servers, Void> dataProvider = DataProvider.fromCallbacks(
                // First callback fetches items based on a query
                query -> {
                    // The index of the first item to load
                    int offset = query.getOffset();
                    // The number of items to load
                    int limit = query.getLimit();
                    List<Servers> persons =  serversService.getAllServers();
                    return persons.stream();
                },
                // Second callback fetches the number of items for a query
                query -> Math.toIntExact(serversService.getCountServers())
        );
        grid.setDataProvider(dataProvider);
        add(grid);

    }
}
