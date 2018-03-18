package org.bookstore.jmock;

import static org.mockito.Mockito.verifyNoMoreInteractions;

import java.util.List;

import org.jmock.Expectations;
import org.jmock.Mockery;
import org.jmock.integration.junit4.JUnit4Mockery;
import org.junit.Test;
import org.mockito.ArgumentCaptor;

public class PublisherTest {
	Mockery context = new JUnit4Mockery();

	@Test
	public void oneSubscriberReceivesAMessage() {
		// set up
		final Subscriber subscriber = context.mock(Subscriber.class);

		Publisher publisher = new Publisher();
		publisher.add(subscriber);

		final String message = "message";

		// expectations
		context.checking(new Expectations() {
			{
				oneOf(subscriber).receive(message);
			}
		});

		context.checking(new Expectations() {

		});
		
		ArgumentCaptor<Publisher> forClass = ArgumentCaptor.forClass(Publisher.class);
		List<Publisher> allValues = forClass.getAllValues();
		for (Publisher p : allValues) {
			System.out.println("[   " +p);
		}
		
		Publisher capture = forClass.capture();
		
		verifyNoMoreInteractions(capture);
		System.out.println(capture);
		// execute
		publisher.publish(message);
	}
}
