package com.alten.vts;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

import org.vaadin.crudui.crud.impl.GridCrud;
import org.vaadin.crudui.layout.impl.VerticalCrudLayout;

import com.alten.vts.dto.VehicleDTO;
import com.alten.vts.service.Services;
import com.vaadin.flow.component.ReconnectDialogConfiguration;
import com.vaadin.flow.component.UI;
import com.vaadin.flow.component.html.H2;
import com.vaadin.flow.component.html.Image;
import com.vaadin.flow.component.notification.Notification;
import com.vaadin.flow.component.orderedlayout.VerticalLayout;
import com.vaadin.flow.router.Route;

@Route("")
public class TrackingUIView extends VerticalLayout {
	private static final long serialVersionUID = 1L;

	private GridCrud<VehicleDTO> crud = new GridCrud<>(VehicleDTO.class, new VerticalCrudLayout());

    public TrackingUIView() {
        ReconnectDialogConfiguration configuration = UI.getCurrent().getReconnectDialogConfiguration();
        configuration.setDialogText("Please wait...");
        configuration.setReconnectInterval(1000);
        
        Image logo = new Image("http://www.reseauravi.fr/wp-content/uploads/2016/09/alten-logo-2.jpg", "App logo");
        logo.addClassName("header-logo");

        H2 title = new H2("Vehicle Tracking System");

        crud.getGrid().setColumns("vin", "registrationNo", "custId", "lastUpdated", "status");
        crud.getCrudFormFactory().setVisibleProperties("vin", "registrationNo", "custId", "lastUpdated", "status");
        crud.getCrudFormFactory().setUseBeanValidation(true);
        crud.setClickRowToUpdate(false);
        crud.setUpdateOperationVisible(false);
        crud.setDeleteOperationVisible(false);
        crud.setFindAllOperation(this::findAll);
        crud.setAddOperation(vehicle -> Services.getVehicleService().add(vehicle));
        crud.setUpdateOperation(vehicle -> Services.getVehicleService().update(vehicle.getId(), vehicle));
        crud.setDeleteOperation(vehicle -> Services.getVehicleService().delete(vehicle.getId()));

        add(logo, title, crud);
        setMargin(false);
        setHeight(null);
    }

    private Collection<VehicleDTO> findAll() {
        List<VehicleDTO> resources = Services.getVehicleService().findAll();
        List<VehicleDTO> vehicles = new ArrayList<VehicleDTO>();
        
        if (resources != null) {
            vehicles.addAll(resources);
            if (!vehicles.isEmpty()) {
                crud.getGrid().setHeightByRows(true);
            }
        } else {
            Notification.show("An error occurred. Please try again later.");
        }

        return vehicles;
    }
}
