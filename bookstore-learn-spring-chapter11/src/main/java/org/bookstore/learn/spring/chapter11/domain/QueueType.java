package org.bookstore.learn.spring.chapter11.domain;

import java.util.Iterator;
import java.util.Map;

import org.hibernate.HibernateException;
import org.hibernate.collection.spi.PersistentCollection;
import org.hibernate.engine.spi.SessionImplementor;
import org.hibernate.persister.collection.CollectionPersister;
import org.hibernate.usertype.UserCollectionType;

public class QueueType implements UserCollectionType {

	@Override
	public PersistentCollection instantiate(SessionImplementor session, CollectionPersister persister)
			throws HibernateException {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public PersistentCollection wrap(SessionImplementor session, Object collection) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Iterator getElementsIterator(Object collection) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public boolean contains(Object collection, Object entity) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public Object indexOf(Object collection, Object entity) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Object replaceElements(Object original, Object target, CollectionPersister persister, Object owner,
			Map copyCache, SessionImplementor session) throws HibernateException {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Object instantiate(int anticipatedSize) {
		// TODO Auto-generated method stub
		return null;
	}

}
