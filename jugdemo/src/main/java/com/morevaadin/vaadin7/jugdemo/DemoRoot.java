package com.morevaadin.vaadin7.jugdemo;

import static com.vaadin.ui.Notification.TYPE_ERROR_MESSAGE;

import com.vaadin.Application;
import com.vaadin.navigator.Navigator.SimpleViewDisplay;
import com.vaadin.terminal.WrappedRequest;
import com.vaadin.ui.Notification;
import com.vaadin.ui.Root;

@SuppressWarnings("serial")
public class DemoRoot extends Root {

	private SimpleViewDisplay display = new SimpleViewDisplay();

	@Override
	protected void init(WrappedRequest request) {

		display.showView(new LoginView());

		setContent(display);

		Application.getCurrent().setLogoutURL(".");
	}

	void login(String login, String password) {

		if ("juguser".equals(login)) {

			Application.getCurrent().setUser("JUG User");

			display.showView(new MainView());

		} else {

			Notification.show("Authentication error", TYPE_ERROR_MESSAGE);
		}
	}

	void logout() {

		Application.getCurrent().close();
	}
}
