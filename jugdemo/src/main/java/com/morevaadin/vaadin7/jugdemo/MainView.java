package com.morevaadin.vaadin7.jugdemo;

import static com.vaadin.ui.Alignment.MIDDLE_RIGHT;

import java.util.Properties;

import com.vaadin.Application;
import com.vaadin.data.Container;
import com.vaadin.data.util.sqlcontainer.SQLContainer;
import com.vaadin.data.util.sqlcontainer.connection.JDBCConnectionPool;
import com.vaadin.data.util.sqlcontainer.connection.SimpleJDBCConnectionPool;
import com.vaadin.data.util.sqlcontainer.query.QueryDelegate;
import com.vaadin.data.util.sqlcontainer.query.TableQuery;
import com.vaadin.navigator.View;
import com.vaadin.ui.Button;
import com.vaadin.ui.Button.ClickEvent;
import com.vaadin.ui.Button.ClickListener;
import com.vaadin.ui.CustomComponent;
import com.vaadin.ui.HorizontalLayout;
import com.vaadin.ui.Label;
import com.vaadin.ui.Root;
import com.vaadin.ui.Table;
import com.vaadin.ui.TextField;
import com.vaadin.ui.VerticalLayout;

@SuppressWarnings("serial")
public class MainView extends CustomComponent implements View {

	private TextField text = new TextField("", "JUG");

	private Label label = new Label();

	public MainView() {

		HorizontalLayout topBar = new HorizontalLayout();

		topBar.setWidth("100%");

		Label userLabel = new Label();

		userLabel.setValue(Application.getCurrent().getUser());

		Button logoutButton = new Button("Logout");

		logoutButton.addListener(new ClickListener() {

			public void buttonClick(ClickEvent event) {

				((DemoRoot) Root.getCurrent()).logout();
			}
		});

		topBar.addComponent(userLabel);
		topBar.addComponent(logoutButton);
		topBar.setComponentAlignment(logoutButton, MIDDLE_RIGHT);

		VerticalLayout layout = new VerticalLayout();

		layout.setMargin(true);
		layout.setSpacing(true);

		layout.addComponent(topBar);

		Table table = new Table();

		table.setWidth("100%");

		layout.addComponent(table);

		setCompositionRoot(layout);

		Root.getCurrent().getPage().setTitle("Welcome to Vaadin JUG Demo");

		Properties props = new Properties();

		try {

			props.load(getClass().getClassLoader().getResourceAsStream("database.properties"));

			JDBCConnectionPool pool = new SimpleJDBCConnectionPool(props.getProperty("db.driver"),
					props.getProperty("db.url"), props.getProperty("db.user"),
					props.getProperty("db.password"));

			QueryDelegate query = new TableQuery("PERSON", pool);

			Container container = new SQLContainer(query);

			table.setContainerDataSource(container);

			table.setVisibleColumns(new String[] { "LAST_NAME", "FIRST_NAME", "MAIL", "BIRTHDATE" });

			table.addGeneratedColumn("BIRTHDATE", new BirthdateColumnGenerator());
			table.addGeneratedColumn("MAIL", new EmailColumnGenerator());

		} catch (Exception e) {

			throw new RuntimeException(e);
		}
	}

	public void navigateTo(String fragmentParameters) {
	}

	public void sayHello() {

		String value = text.getValue();

		label.setValue("Hello " + value + "!");
	}
}
