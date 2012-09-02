package com.morevaadin.vaadin7.jugdemo;

import com.vaadin.terminal.WrappedRequest;
import com.vaadin.ui.Button;
import com.vaadin.ui.Button.ClickEvent;
import com.vaadin.ui.Button.ClickListener;
import com.vaadin.ui.HorizontalLayout;
import com.vaadin.ui.Label;
import com.vaadin.ui.UI;
import com.vaadin.ui.TextField;

@SuppressWarnings("serial")
public class DemoUI extends UI {

	@Override
	protected void init(WrappedRequest request) {

		HorizontalLayout layout = new HorizontalLayout();

		final TextField text = new TextField("", "JUG");

		Button button = new Button("Say Hello");

		final Label label = new Label();

		button.addListener(new ClickListener() {

			public void buttonClick(ClickEvent event) {

				String value = text.getValue();

				label.setValue("Hello " + value + "!");
			}
		});

		layout.addComponent(text);
		layout.addComponent(button);
		layout.addComponent(label);

		setContent(layout);
	}
}
