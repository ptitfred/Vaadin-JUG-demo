package com.morevaadin.vaadin7.jugdemo;

import com.vaadin.terminal.WrappedRequest;
import com.vaadin.ui.Button;
import com.vaadin.ui.Button.ClickEvent;
import com.vaadin.ui.HorizontalLayout;
import com.vaadin.ui.Label;
import com.vaadin.ui.UI;
import com.vaadin.ui.TextField;

@SuppressWarnings("serial")
public class DemoUI extends UI {

	private TextField text = new TextField("", "JUG");

	private Label label = new Label();

	@Override
	protected void init(WrappedRequest request) {

		HorizontalLayout layout = new HorizontalLayout();

		Button button = new Button("Say Hello");

		button.addListener(ClickEvent.class, this, "sayHello");

		layout.addComponent(text);
		layout.addComponent(button);
		layout.addComponent(label);

		setContent(layout);
	}

	public void sayHello() {

		String value = text.getValue();

		label.setValue("Hello " + value + "!");
	}
}
